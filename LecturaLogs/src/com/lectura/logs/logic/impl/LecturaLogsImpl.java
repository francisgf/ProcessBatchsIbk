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
    public List<Logs> readError() throws Exception {
        File file = new File(returnConfigProperties("path"));
        return Files.readAllLines(file.toPath())
                .stream()
                .map(line -> {
                    String[] array = line.split("\\|");
                    Logs log = new Logs();
                    log.setLine(array[0]);
                    log.setText(array[1]);
                    log.setTypeError(generateTypeError(array[2]));
                    return log;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Logs> filterError(List<String> list) throws Exception {
        boolean isActiveFilter = Boolean.valueOf(returnConfigProperties("activeFilter"));
        if (isActiveFilter) {
            if (list.size() == 1) {
                return readError().stream()
                        .filter(log -> log.getTypeError().getValueName().equalsIgnoreCase(list.get(0)))
                        .collect(Collectors.toList());
            }else{
               return readError();
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
