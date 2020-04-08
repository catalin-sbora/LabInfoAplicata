/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.decoders.impl;

import com.ace.decoders.abstractions.ITextDecoder;

/**
 *
 * @author catalin
 */
public class Base64TextDecoder implements ITextDecoder{

    @Override
    public String decode(String inputToDecode) {
        return inputToDecode;
    }

    @Override
    public String getIdentifier() {
       return "base64";
    }
    
}
