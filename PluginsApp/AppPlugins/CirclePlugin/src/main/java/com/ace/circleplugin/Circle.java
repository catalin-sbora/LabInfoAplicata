/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.circleplugin;

import com.ace.pluginsapplication.interfaces.IShape;

/**
 *
 * @author catalin
 */
public class Circle implements IShape {

    @Override
    public void draw() {
        System.out.println("This is a circle");
    }

    @Override
    public void read() {
       System.out.println("read circle");
    }
    
}
