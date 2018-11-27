import java.util.*;
import java.io.*;
// The class that drives the program.

/**
 * @author      Joonas Melanen joonas.melanen@cs.tamk.fi
 * @version     2015.1130
 * @since       1.6
 */
class GameProgram {
    
    /**
     * Arraylist that contains all the games.
     */
    static ArrayList<FinalGame> al = new ArrayList<FinalGame>();
    
    /**
     * Prints out the contents of the table.
     *
     * @param number    The game that will be printed out.
     */
    public static void readUserInput(int number) {        
        al.get(--number).printGameInfo();                                
    }
    
    /**
     * Reads and prints out the text file of the game.
     *
     * @param number    The game that will be printed out.
     */
    public static void readGameFile(int number) throws IOException{
        String fileX = "./FFX.txt";
        String fileBayo = "./Bayo.txt";
        String fileMGS = "./MGS3.txt";
        String filePersona = "./Persona4.txt";
        
        try {
            if (number == 1) {
                ReadFile file = new ReadFile(fileX);
                String[] aryLines = file.openFile();
                int i;
                
                for (i = 0; i < aryLines.length; i++) {
                    System.out.println(aryLines[i]);
                }
            }
            
            if (number == 2) {
                ReadFile file = new ReadFile(fileBayo);
                String[] aryLines = file.openFile();
                int i;
                
                for (i = 0; i < aryLines.length; i++) {
                    System.out.println(aryLines[i]);
                }
            }
            
            if (number == 3) {
                ReadFile file = new ReadFile(filePersona);
                String[] aryLines = file.openFile();
                int i;
                
                for (i = 0; i < aryLines.length; i++) {
                    System.out.println(aryLines[i]);
                }
            }
            
            if (number == 4) {
                ReadFile file = new ReadFile(fileMGS);
                String[] aryLines = file.openFile();
                int i;
                
                for (i = 0; i < aryLines.length; i++) {
                    System.out.println(aryLines[i]);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Runs the program.
     *
     * @param args  The user's input.
     * @throws  Handles the exceptions.
     */
    public static void main(String[] args) throws MyOwnException, IOException{
        FinalGame game1 = new FinalGame("1", "Final Fantasy X", 
                                    "Square-Enix", "2001", 
                                    "RPG");
        FinalGame game2 = new FinalGame("2", "Bayonetta", 
                                    "Platinum Games", "2010", 
                                    "Action");
        FinalGame game3 = new FinalGame("3", "Persona 4 Golden",
                                        "Atlus", "2012", "RPG");
        FinalGame game4 = new FinalGame("4", "Metal Gear Solid 3",
                                        "Konami", "2004", "Action");
        
        al.add(game1);
        al.add(game2);
        al.add(game3);
        al.add(game4);
        
        System.out.println("There are four games in the table. Please " +  
                            "give the number of the game you want " + 
                            "to learn more of.");
                            
        System.out.print("Give the game's number (from 1 to 4): ");
        Scanner userInput = new Scanner(System.in);
        try {
            int gameNumber = userInput.nextInt();
            
            if (gameNumber < 1 || gameNumber > 4) {
            
                throw new MyOwnException("Number must be from 1 to 4.");
            }
            
            readUserInput(gameNumber);
            readGameFile(gameNumber);
        }
        catch(MyOwnException ex) {
            System.out.println(ex);
        } catch (InputMismatchException ex2) {
            System.out.println(ex2);
        }
    }
}
 