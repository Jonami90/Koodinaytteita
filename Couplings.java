package com.remion;
//Gets and sets the couplings' data. Is an abstract class.

/**
 *
 * @author Joonas Melanen
 */
abstract class Couplings {
    
    /**
     * The coupling's main number, to decide which will be used.
     */
    private int couplingNumber;
    
    /**
     * The rest of the numbers in the array.
     */
    private int[] restOfTheNumbers;
    
    /**
     * Gets the coupling's main number.
     *
     * @return couplingNumber   Returns the coupling's number.
     */
    public int getCouplingNumber() {
        return couplingNumber;
    }
    
    /**
     * Gets the rest of the numbers in the array.
     *
     * @return restOfTheNumbers   Returns the rest of the numbers in the array.
     */
    public int[] getRestOfTheNumbers() {
        return restOfTheNumbers;
    }
    
    /**
     * Sets the coupling's main number.
     *
     * @param sentCouplingNumber   The coupling's main number.
     */
    public void setCouplingNumber(int sentCouplingNumber) {
        couplingNumber = sentCouplingNumber;
    }
    
    /**
     * Sets the rest of the array's numbers.
     *
     * @param sentRestOfTheNumbers   The rest of the numbers in the array.
     */
    public void setRestOfTheNumbers(int[] sentRestOfTheNumbers) {
        restOfTheNumbers = sentRestOfTheNumbers;
    }
    
    abstract public void calculateCouplings();
}