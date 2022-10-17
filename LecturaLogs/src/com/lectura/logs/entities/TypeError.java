/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lectura.logs.entities;

/**
 *
 * @author 15-AX222LA
 */
public enum TypeError {
    
    WARNING("Warning"),
    ERROR("Error"),
    INFO("Info");

    private TypeError(String valueName) {
        this.valueName = valueName;
    }
    
    String valueName;
    
    public String getValueName(){
        return valueName;
    }
    
    
}
