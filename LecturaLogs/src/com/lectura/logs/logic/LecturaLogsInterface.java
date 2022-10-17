/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lectura.logs.logic;

import com.lectura.logs.entities.Logs;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author 15-AX222LA
 */
public interface LecturaLogsInterface {

    public List<Logs> readError() throws Exception;

    public List<Logs> filterError(List<String> list) throws Exception;

    default public String returnConfigProperties(String key) {
        ResourceBundle properties = ResourceBundle.getBundle("com.lectura.logs.config.config");
        return properties.getString(key);
    }

}
