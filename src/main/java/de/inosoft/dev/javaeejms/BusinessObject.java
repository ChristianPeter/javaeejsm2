/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.inosoft.dev.javaeejms;

import java.io.Serializable;

/**
 *
 * @author debiandev
 */
class BusinessObject implements Serializable{
    
    private String text = "TEST";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BusinessObject() {
    }
    
    public BusinessObject(String t) {
        this.text = t;
    }
    
     
}
