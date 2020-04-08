/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.encoders.abstractions;

/**
 *
 * @author catalin
 */
public interface ITextEncoder {  
    String getIdentifier();
    String encode(String text);
}
