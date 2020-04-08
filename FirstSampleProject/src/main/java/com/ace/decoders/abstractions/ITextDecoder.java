/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.decoders.abstractions;

/**
 *
 * @author catalin
 */
public interface ITextDecoder {    
    String getIdentifier();
    String decode(String inputToDecode);
    
}
