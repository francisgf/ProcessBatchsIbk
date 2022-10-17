/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lectura.logs.logic.impl;

import com.lectura.logs.entities.Logs;
import com.lectura.logs.entities.TypeError;
import com.lectura.logs.logic.LecturaLogsInterface;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 15-AX222LA
 */
public class LecturaLogsImpl implements LecturaLogsInterface {

    @Override
    public List<Logs> readError(String path) throws Exception {
        if (path == null || path == "") {
            path = returnConfigProperties("path");
        }
        File file = new File(path);
        return Files.readAllLines(file.toPath())
                .stream()
                .map(line -> {
                    String[] array = line.replace("\"", "").split("\\|");
                    Logs log = new Logs();
                    log.setDate(array[0].trim());
                    log.setText(array[1].trim());
                    if (array.length < 3) {
                        log.setTypeError(generateTypeError(""));
                    } else {
                        log.setTypeError(generateTypeError(array[2].trim()));
                    }
                    return log;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Logs> filterError(List<String> list, String Path) throws Exception {
        boolean isActiveFilter = Boolean.valueOf(returnConfigProperties("activeFilter"));
        if (isActiveFilter) {
            if (list != null && list.size() == 1) {
                return readError(Path).stream()
                        .filter(log -> log.getTypeError().getValueName().equalsIgnoreCase(list.get(0)))
                        .collect(Collectors.toList());
            } else {
                return readError(Path);
            }
        }
        return null;

    }

    private TypeError generateTypeError(String codeError) {
        switch (codeError) {
            case "8":
            case "4":
                return TypeError.ERROR;
            default:
                return TypeError.INFO;
        }
    }

}
