// The base class for all games.

/**
 * @author      Joonas Melanen joonas.melanen@cs.tamk.fi
 * @version     2015.1130
 * @since       1.6
 */
abstract class Game {
 
    /**
     * The game's ID-number.
     */
    public String gameId;
    
    /**
     * The game's name.
     */
    public String gameName;
    
    /**
     * The game's developer.
     */
    public String gameDev;
    
    /**
     * The year the game was published.
     */
    public String gameYear;
    
    /**
     * Creates the object, constructor. Initials to 0, "", "", "".
     */
    public Game() {
        gameId = "";
        gameName = "";
        gameDev = "";
        gameYear = "";
    }
    
    /**
     * Creates the object, constructor.
     *
     * @param idGame    The game's ID-number.
     * @param nameGame  The game's name.
     * @param devGame   The game's developer.
     * @param yearGame  The year the game was published.
     */
    public Game(String idGame,
                String nameGame,
                String devGame,
                String yearGame) {
        gameId = idGame;
        gameName = nameGame;
        gameDev = devGame;
        gameYear = yearGame;
    }
    
    /**
     * Sets the game's ID.
     *
     * @param idGame    The game's ID-number.
     */
    public void setGameId(String idGame) {
        gameId = idGame;
    }
    
    /**
     * Gets the game's ID.
     *
     * @return gameId   Returns the game's ID.
     */
    public String getGameId() {
        return gameId;
    }
    
    /**
     * Sets the game's name.
     *
     * @param nameGame    The game's ID-name.
     */
    public void setGameName(String nameGame) {
        gameName = nameGame;
    }
    
    /**
     * Gets the game's name.
     *
     * @return gameName   Returns the game's name.
     */
    public String getGameName() {
        return gameName;
    }
    
    /**
     * Sets the game's developer.
     *
     * @param devGame    The game's developer.
     */
    public void setGameDev(String devGame) {
        gameDev = devGame;
    }
    
    /**
     * Gets the game's developer.
     *
     * @return gameDev   Returns the game's developer.
     */
    public String getGameDev() {
        return gameDev;
    }
    
    /**
     * Sets the year the game was published.
     *
     * @param yearGame    The year the game was published.
     */
    public void setGameYear(String yearGame) {
        gameYear = yearGame;
    }
    
    /**
     * Gets the year the game was published.
     *
     * @return gameYear   Returns the year the game was published.
     */
    public String getGameYear() {
        return gameYear;
    }
    
    abstract public void printGameInfo();
}
 