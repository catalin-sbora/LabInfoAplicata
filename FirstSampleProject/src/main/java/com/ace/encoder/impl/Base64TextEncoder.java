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
public class Base64TextEncoder implements ITextEncoder {

    @Override
    public String encode(String text) {
        return text;
    }

    @Override
    public String getIdentifier() {
        return "base64";
    }
    
}
