import java.util.Scanner;
// The class that drives the program.

/**
 * @author      Joonas Melanen joonas.melanen@cs.tamk.fi
 * @version     2016.0318
 * @since       1.6
 */
class BankProgram {
    
    //static Array<BankChanger> ar = new Array<BankChanger>();
    
    public static void main(String[] args) {
        System.out.println("Anna pankkinumero.");
        System.out.print("Pankkinumero: ");
        Scanner userInput = new Scanner(System.in);
        
        String bankNumber = userInput.nextLine();
        System.out.println("");
        
        bankNumber = bankNumber.trim();
        String[] bankArray = bankNumber.split("");
               
        System.out.print("Pankin numero on " );
                
        for (int i = 1; i < bankArray.length; i++) {
            if (i == 6) {
                System.out.print(bankArray[i]);
                System.out.print("-");
            } else if (bankArray[i].equals(" ")) {
                bankArray[i].
                // Listillä remove entry
            }
            
            else System.out.print(bankArray[i]);
        }
        System.out.println("");
                
        int[] parsedBankArray = new int[bankArray.length];
        
        for (int i = 1; i < bankArray.length; i++) {
            parsedBankArray[i] = Integer.parseInt(bankArray[i]);
        }
        
        if (parsedBankArray[1] == 1 || parsedBankArray[1] == 2) {
            System.out.println("Nordea");
        } else if (parsedBankArray[1] == 3 && parsedBankArray[2] == 1) {
            System.out.println("SHB");
        } else if (parsedBankArray[1] == 3 && parsedBankArray[2] == 3) {
            System.out.println("SEB");
        } else if (parsedBankArray[1] == 3 && parsedBankArray[2] == 4) {
            System.out.println("Danske Bank");
        } else if (parsedBankArray[1] == 3 && parsedBankArray[2] == 6) {
            System.out.println("Tapiola");
        } else if (parsedBankArray[1] == 3 && parsedBankArray[2] == 7) {
            System.out.println("DnB NOR");
        } else if (parsedBankArray[1] == 3 && parsedBankArray[2] == 8) {
            System.out.println("Swedbank");
        } else if (parsedBankArray[1] == 3 && parsedBankArray[2] == 9) {
            System.out.println("S-Pankki");
        } else if (parsedBankArray[1] == 4) {
            System.out.println("Sp, PoP sekä Aktia");
        } else if (parsedBankArray[1] == 5) {
            System.out.println("Op, OKO ja Okopankki");
        } else if (parsedBankArray[1] == 6) {
            System.out.println("ÅAB");
        } else if (parsedBankArray[1] == 8) {
            System.out.println("Sampo");
        }
        //BankChanger changerOne = new BankChanger(bankNumber);
    }
    
}