/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tokobangunan;

/**
 *
 * @author User
 */
public class MyException extends Exception{
    private String message;
    
    public MyException(String message){
        super(message);
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
}
