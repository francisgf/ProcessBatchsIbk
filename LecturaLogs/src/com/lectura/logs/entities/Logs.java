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

    private String date;
    private String text;
    private TypeError typeError;

    public Logs() {
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public TypeError getTypeError() {
        return typeError;
    }

    public void setDate(String line) {
        this.date = line;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTypeError(TypeError typeError) {
        this.typeError = typeError;
    }
}
