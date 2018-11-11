package com.remion;
//Handles the exceptions.

/**
 *
 * @author Joonas Melanen
 */
public class MyOwnException extends Exception {
    
    /**
     * Creates a new exception.
     * 
     * @param msg   The string to use.
     */
    public MyOwnException(String msg) {
        super(msg);
    }
}
