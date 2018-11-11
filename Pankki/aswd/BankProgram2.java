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
        
    public static void main(String[] args) {
        System.out.println("Anna tilinumero.");
        System.out.print("Tilinumero: ");
        Scanner userInput = new Scanner(System.in); 
        long tester = 0L;
        String bankNumber = "";
        do {
            try {
                bankNumber = userInput.nextLine();
                tester = Long.parseLong(bankNumber);
                break;
            }
            catch (Exception e) {
                System.out.println("Tilinumero ei voi sisältää kirjaimia tai olla yli 14 merkkiä pitkä.");
                System.out.print("Anna uusi tilinumero:");
            }
        }
        while (true);
        
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

        boolean bankGroupA = true;
        
        if (bankParsed.get(0) == 1 || bankParsed.get(0) == 2) {
            bankGroupA = true;
            System.out.println("Nordea");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 1) {
            bankGroupA = true;
            System.out.println("SHB");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 3) {
            bankGroupA = true;
            System.out.println("SEB");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 4) {
            bankGroupA = true;
            System.out.println("Danske Bank");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 6) {
            bankGroupA = true;
            System.out.println("Tapiola");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 7) {
            bankGroupA = true;
            System.out.println("DnB NOR");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 8) {
            bankGroupA = true;
            System.out.println("Swedbank");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 3 && bankParsed.get(1) == 9) {
            bankGroupA = true;
            System.out.println("S-Pankki");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 4) {
            bankGroupA = false;
            System.out.println("Sp, Pop sekä Aktia");
            System.out.println("Kuuluu ryhmään B.");
        }else if (bankParsed.get(0) == 5) {
            bankGroupA = false;
            System.out.println("Op, OKO ja Okopankki");
            System.out.println("Kuuluu ryhmään B.");
        }else if (bankParsed.get(0) == 6) {
            bankGroupA = true;
            System.out.println("ÅAB");
            System.out.println("Kuuluu ryhmään A.");
        }else if (bankParsed.get(0) == 8) {
            bankGroupA = true;
            System.out.println("Sampo");
            System.out.println("Kuuluu ryhmään A.");
        }
        
        int listSize = bankParsed.size();
        
        if (bankGroupA == true) {
            System.out.println("A totta");
        }else if (bankGroupA == false) {
            System.out.println("B totta");
        }
        
/*         if (bankGroupA = true) {
            while (
        } */

        /* System.out.println("Pankkinumeron pituus on " + listSize + " merkkiä."); */
        System.out.print("Täydennetty tilinumero on " );

        while (listSize < 14) {
            if (bankGroupA == true) {
                bankParsed.add(6, 0);
                listSize++;
            }else {
                bankParsed.add(7,0);
                listSize++;
            }
        }
        
        for (int j: bankParsed) {            
            System.out.print(j);
        }
        
        System.out.println("");
        
        for (int i = 12; i >= 0; i--) {
            
            if (i == 12 || i == 10 || i == 8 || i == 6 || i == 4 || i == 2 || i == 0) {
                bankParsed.set(i, bankParsed.get(i)*2);
                System.out.println(bankParsed.get(i));
            }else {
                bankParsed.set(i, bankParsed.get(i));
                System.out.println(bankParsed.get(i));
            }
        }

        for (int j = 0; j < bankParsed.size() - 1; j++) {            
            System.out.print(bankParsed.get(j));
        }
        
        System.out.println("");
        int sumToCalculate = 0;        
        
        for (int k = 0; k < bankParsed.size() - 1; k++) {

            if (bankParsed.get(k) == 10) {
                bankParsed.set(k, 1);
            }
            else if (bankParsed.get(k) == 12) {
                bankParsed.set(k, 3);
            }
            else if (bankParsed.get(k) == 14) {
                bankParsed.set(k, 5);
            }
            else if (bankParsed.get(k) == 16) {
                bankParsed.set(k, 7);
            }
            else if (bankParsed.get(k) == 18) {
                bankParsed.set(k, 9);
            }
            sumToCalculate += bankParsed.get(k);
        }
                
        for (int j = 0; j < bankParsed.size() - 1; j++) {            
            System.out.print(bankParsed.get(j));
        }
        
        System.out.println("");
        System.out.println(sumToCalculate);
        
        int nearestTen = Math.round((sumToCalculate + 5) / 10) * 10;
        
        if (nearestTen < sumToCalculate) {
            nearestTen = nearestTen + 10;
        }
        
        System.out.println(nearestTen);
        
        int lastNumber = nearestTen - sumToCalculate;
        
        System.out.println(lastNumber);
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