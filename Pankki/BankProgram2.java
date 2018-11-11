import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
// The class that drives the program.

/**
 * @author      Joonas Melanen joonas.melanen@cs.tamk.fi
 * @version     2016.0318
 * @since       1.6
 */
class BankProgram2 {
    
    //static Array<BankChanger> ar = new Array<BankChanger>();
    
    public static void main(String[] args) {
        System.out.println("Anna pankkinumero.");
        System.out.print("Pankkinumero: ");
        Scanner userInput = new Scanner(System.in);
        
        String bankNumber = userInput.nextLine();
        System.out.println("");
        
        bankNumber = bankNumber.trim();
        String[] bankArray = bankNumber.split("");
        
        ArrayList<String> bankList = new ArrayList<String>(Arrays.asList(bankArray));
        bankList.remove(0);
        
        ArrayList<Integer> bankParsed = new ArrayList<>();
    
        String temp = "";
        
        for (String i : bankList) {
            if ( !i.equals("-") && !i.equals(" ")) {
            
/*                 if (bankList.indexOf(i).equals("0") || bankList.indexOf(i).equals("1")) {
                    temp = temp + i;
                } */
                bankParsed.add(Integer.parseInt(bankList.get(bankList.indexOf(i))));
            }
        }
              
        if (bankParsed.get(0) == 1 || bankParsed.get(0) == 2) {
            System.out.println("Nordea");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 1) {
            System.out.println("SHB");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 3) {
            System.out.println("SEB");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 4) {
            System.out.println("Danske Bank");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 6) {
            System.out.println("Tapiola");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 7) {
            System.out.println("DnB NOR");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 8) {
            System.out.println("Swedbank");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 9) {
            System.out.println("S-Pankki");
        }else if (bankParsed.get(0) == 4) {
            System.out.println("Sp, Pop sekä Aktia");
        }else if (bankParsed.get(0) == 5) {
            System.out.println("Op, OKO ja Okopankki");
        }else if (bankParsed.get(0) == 6) {
            System.out.println("ÅAB");
        }else if (bankParsed.get(0) == 8) {
            System.out.println("Sampo");
        }
        
        System.out.print("Pankin numero on " );        
        for (int j: bankParsed) {            
            System.out.print(j);
        }
        
        System.out.println("");
        
/*         if (bankArray[1] == "1" || bankArray[1] == "2") {
            System.out.println("Nordea");
        }
        
        int[] parsedBankArray = new int[bankArray.length];
        
        for (int i = 1; i < bankArray.length; i++) {
            parsedBankArray[i] = Integer.parseInt(bankArray[i]);
        } */
        
        
        
        //BankChanger changerOne = new BankChanger(bankNumber);
    }
    
}