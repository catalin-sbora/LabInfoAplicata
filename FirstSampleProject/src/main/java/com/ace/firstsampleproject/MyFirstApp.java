/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.firstsampleproject;

import com.ace.decoders.abstractions.ITextDecoder;
import com.ace.decoders.impl.Base64TextDecoder;
import com.ace.decoders.impl.CaesarDecoder;
import com.ace.encoder.impl.Base64TextEncoder;
import com.ace.encoder.impl.CaesarEncoder;
import com.ace.encoder.impl.TextStreamEncoder;
import com.ace.encoders.abstractions.ITextEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author catalin
 */
public class MyFirstApp {

   
    private static ITextEncoder base64Encoder = new Base64TextEncoder();
    private static ITextEncoder caesarEncoder = new CaesarEncoder();    
    private static ITextDecoder base64Decoder = new Base64TextDecoder();
    private static ITextDecoder caesarDecoder = new CaesarDecoder();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(" === Encode/Decode utility ====");
        Menu mainMenu = initializeMainMenu();           
        mainMenu.execute();
        
    }
    
    private static Menu initializeMainMenu()
    {
        ArrayList<IMenuItem> mainMenuItems = new ArrayList();
        ArrayList<IMenuItem> decodeMenuItems = new ArrayList();
        ArrayList<IMenuItem> encodeMenuItems = new ArrayList();
        
        
        decodeMenuItems.add(new MenuItem("Decode using Base64", 
                                            1, 
                                            (parameters)->{
                                              
                                                
                                            }));
                
        decodeMenuItems.add(new MenuItem("Decode using Caesar", 
                                            2, 
                                            (parameters)->{
                                              
                                            }));
       
        encodeMenuItems.add(new MenuItem("Encode using Base64", 
                                            1, 
                                            (parameters)->{                                                
                                              encodeUsingBase64();
                                            }));
                
        encodeMenuItems.add(new MenuItem("Encode using Caesar", 
                                            2, 
                                            (parameters)->{
                                                encodeUsingCaesar();
                                            }));
       
        mainMenuItems.add(new Menu("Encode", 1, encodeMenuItems));
        mainMenuItems.add(new Menu("Decode", 2, decodeMenuItems));        
                
        //mainMenuItems.add(new Menu("Decode", 1, ));
        return new Menu("Main Menu", 0, mainMenuItems); 
        
        
    }
    
    private static String readStringWithMessage(String message)
    {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    private static String readInputFile()
    {
       return readStringWithMessage("Enter input file: ");        
    }
    
    private static String readOutputFile()
    {
        return readStringWithMessage("Enter output file: ");      
    }
    
    private static BufferedInputStream initializeInputStream()
    {
        BufferedInputStream retStream = null;
        boolean errorEncountered;
        do
        {
            errorEncountered = false;
            try
            {
                String inputFile = readInputFile();
                retStream = new BufferedInputStream(new FileInputStream(inputFile));        
            }
            catch(Exception e)
            {
                System.out.println("Invalid file provided for input.");
               errorEncountered = true;
            }
        }while(errorEncountered);
        
        return retStream;
    }
    
    private static BufferedOutputStream initializeOutputStream()
    {
        BufferedOutputStream retStream = null;
        boolean errorEncountered;
        do
        {
            errorEncountered = false;
            try
            {
                String outputFile = readOutputFile();
                retStream = new BufferedOutputStream(new FileOutputStream(outputFile));        
            }
            catch(Exception e)
            {
                System.out.println("Unable to open file for writing. " + e.getMessage());
               errorEncountered = true;
            }
        }while(errorEncountered);
        
        return retStream;
    }
    
    private static void encodeTextStream(TextStreamEncoder streamEncoder)
    {
        BufferedInputStream inputStream = null;
        BufferedOutputStream outStream = null;
        try
        {
            inputStream  = initializeInputStream();
            outStream = initializeOutputStream();           
            streamEncoder.encode(inputStream, outStream);
        }
        catch(Exception e)
        {
            System.out.println("Failed to encode file " + e.getMessage());
        }
        finally
        {
            try
            {
                if (inputStream != null)
                    inputStream.close();
                
                if (outStream != null)
                    outStream.close();
            }
            catch(IOException e)
            {
                System.out.println("File already closed");
            }
        }
    }
    private static void encodeUsingBase64()
    {
        encodeTextStream(new TextStreamEncoder(base64Encoder));
    }
    private static void encodeUsingCaesar()
    {
        encodeTextStream(new TextStreamEncoder(caesarEncoder));
    }
    
    
    
}
