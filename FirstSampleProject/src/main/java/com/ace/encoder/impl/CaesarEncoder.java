/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.encoder.impl;

import com.ace.encoders.abstractions.ITextEncoder;

/**
 *
 * @author catalin
 */
public class CaesarEncoder implements ITextEncoder {

    private String key = "";
     
    
    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }
    
    
    @Override
    public String encode(String text) {
        //
        String encoded = text;
        return encoded;
    }

    @Override
    public String getIdentifier() {
        return "caesar";
    }
    
}
