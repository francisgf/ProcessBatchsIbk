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
public class Logs {

    private String line;
    private String text;
    private TypeError typeError;

    public Logs() {
    }
    
    public String getLine() {
        return line;
    }

    public String getText() {
        return text;
    }

    public TypeError getTypeError() {
        return typeError;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTypeError(TypeError typeError) {
        this.typeError = typeError;
    }

    @Override
    public String toString() {
        return "Logs{" + "line=" + getLine() + ", text=" + getText() + ", typeError=" + getTypeError() + '}';
    }

}
