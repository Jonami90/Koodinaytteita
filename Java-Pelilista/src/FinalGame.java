import java.util.*;
// Defining the type of game.

/**
 * @author      Joonas Melanen joonas.melanen@cs.tamk.fi
 * @version     2015.1130
 * @since       1.6
 */
class FinalGame extends Game {
    
    /**
     * The game's type (strategy, action etc.).
     */
    public String gameType;
        
    /**
     * Creates the object, constructor. Inherits the super class.
     *
     * @param idGame        The game's ID-number.
     * @param nameGame      The game's name.
     * @param devGame       The game's developer.
     * @param yearGame      The year the game was published.
     * @param typeGameRPG   The game's type (adventure, character, etc.).
     */
    public FinalGame(String idGame,
                    String nameGame,
                    String devGame,
                    String yearGame,
                    String typeGame) {
        super(idGame, nameGame, devGame, yearGame);
        gameType = typeGame;
    }
    
    /**
     * Sets the game's type.
     *
     * @param typeGameRPG    The game's type.
     */
    public void setGameType(String typeGame) {
        gameType = typeGame;
    }
    
    /**
     * Gets the game's ID.
     *
     * @return gameType Return the game's type.
     */
    public String getGameType() {
        return gameType;
    }
    
    /**
     * Combines the data into an array.
     *
     * @return array    The array to send.
     */
    public String[] combineData() {
        String[] array = new String[5];
        array[0] = gameId;
        array[1] = gameName;
        array[2] = gameDev;
        array[3] = gameYear;
        array[4] = gameType;
        return array;
    }
    
    /**
     * Sets the combined array.
     *
     * @param com The combined array.
     */
    public void setCombine(String[] com) {
        String[] a = combineData();
        a = com;
    }
    
    /**
     * Gets the combined array.
     *
     * @return b    The array to send.
     */
    public String[] getCombine() {
        String[] b = combineData();
        return b;
    }
    
    /**
     * Prints out the additional info.
     */
    @Override
    public void printGameInfo() {
                
        System.out.println("Game " + getGameId());
        System.out.println("Game name:\t\t" + getGameName());
        System.out.println("Game developer:\t\t" + getGameDev());
        System.out.println("Published in:\t\t" + getGameYear());
        System.out.println("Type of game:\t\t" + getGameType());
    }
}
