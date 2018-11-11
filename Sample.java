package com.remion;
import java.util.Scanner;
import java.io.*;
//The class that drives the program.

/**
 *
 * @author Joonas Melanen
 */
public class Sample {  
    /**
     * Runs the program.
     *
     * @param args  The user's input.
     * @throws      com.remion.MyOwnException
     * @throws      java.io.IOException
     */    
    public static void main(String[] args) throws MyOwnException, IOException{
        FinalCouplings coupling = new FinalCouplings();
        int[] arrayForNumbers = new int[6];
        try {
            if (args.length > 6 || (1 < args.length && 5 > args.length)) {
                throw new MyOwnException("Too few/many numbers.");
            }
        } catch (MyOwnException ex1) {
            System.out.println(ex1);
        }
        if (args.length > 1) {
            for (int i = 0; i < 5; i++) {
                arrayForNumbers[i] = Integer.parseInt(args[i]);
            }
        }
        else {
            System.out.println("Please give a list of integers to run the program.");
            System.out.println("Remember to separate the numbers with spaces.");
            System.out.println("The first integer should be either 1 or 2, to select the coupling to use.");
            System.out.println("After that, give 5 numbers, either 1 or 0");
            
            Scanner userInput = new Scanner(System.in);

            String givenNumbers = userInput.nextLine();
            String[] numbers = givenNumbers.split(" ");
            
            try {
                if (numbers.length > 6 || numbers.length < 5) {
                    throw new MyOwnException("Too few/many numbers");
                }
            } catch (MyOwnException ex2) {
                System.out.println(ex2);
            }
            
            for (int i = 0; i < 5; i++) {
                arrayForNumbers[i] = Integer.parseInt(numbers[i]);
            }
        }
        
        try {
            if (arrayForNumbers[0] < 1 || arrayForNumbers[0] > 2) {
                throw new MyOwnException("Number must be either 1 or 2 for choosing the coupling.");
            }
        }
        catch(MyOwnException ex3) {
            System.out.println(ex3);
        }

        int[] extractFirstNumber = new int[5];
        for (int i = 0; i < arrayForNumbers.length - 1; i++) {
            extractFirstNumber[i] = arrayForNumbers[i + 1];
        }

        try {
            for (int i = 0; i < extractFirstNumber.length; i++) {
                if (extractFirstNumber[i] < 0 || extractFirstNumber[i] > 1) {
                    throw new MyOwnException("The values must be either 0 or 1.");
                }
            }
        }
        catch(MyOwnException ex4) {
            System.out.println(ex4);
        }

        coupling.setCouplingNumber(arrayForNumbers[0]);
        coupling.setRestOfTheNumbers(extractFirstNumber);
        coupling.calculateCouplings();
    }
}
