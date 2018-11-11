package com.remion;
//Calculates the couplings. Extended from Couplings.

/**
 *
 * @author Joonas Melanen
 */
class FinalCouplings extends Couplings {
    
    /**
     * Calculates the couplings.
     */
    @Override
    public void calculateCouplings() {
        int c1 = getCouplingNumber();
        int[] allTheRest = getRestOfTheNumbers();
        
        if (c1 == 1) {
            boolean[] allValues = new boolean[allTheRest.length];

            for (int i = 0; i < allTheRest.length; i++) {
                if (allTheRest[i] == 1) {
                    allValues[i] = true;
                } else {
                    allValues[i] = false;
                }
            }
            boolean c = (allValues[0] && allValues[1]);     
            boolean d = allValues[2];
            boolean g = (allValues[3] ^ allValues[4]);
            boolean finalTest = (c || d || g);

            System.out.println(finalTest);
        }
        else if (c1 == 2) {
            boolean c,f,g = false;
        
            boolean[] allValues = new boolean[allTheRest.length];

            for (int i = 0; i < allTheRest.length; i++) {
                if (allTheRest[i] == 1) {
                    allValues[i] = true;
                } else {
                    allValues[i] = false;
                }
            }
            c = !(allValues[0] && allValues[1]);
            f = (allValues[2] ^ allValues[3]);    
            g = allValues[4];

            boolean testNumberOne = (c || f);
            boolean testNumberTwo = (f && g);
            System.out.println(testNumberOne + " " + testNumberTwo);
        }
    }
}
