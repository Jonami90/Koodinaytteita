// Handles the exceptions.

/**
 * @author      Joonas Melanen joonas.melanen@cs.tamk.fi
 * @version     2015.1130
 * @since       1.6
 */
class MyOwnException extends Exception {
    
    /**
     * Creates a new exception.
     *
     * @param msg   The string to use.
     */
    public MyOwnException(String msg) {
        super(msg);
    }
}
