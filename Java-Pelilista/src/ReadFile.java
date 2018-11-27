import java.io.*;
// Reading the text file.

/**
 * @author      Joonas Melanen joonas.melanen@cs.tamk.fi
 * @version     2015.1130
 * @since       1.6
 */
public class ReadFile {
    
    /**
     * The file's location.
     */
    private String path;
    
    /**
     * Constructs a new ReadFile.
     *
     * @param filePath  The file's location.
     */
    public ReadFile(String filePath) {
        path = filePath;
    }
    
    /**
     * Opens the text file and reading the text.
     *
     * @return textData     The text to send.
     * @throws IOException  Handles any exceptions.
     */
    public String[] openFile() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        
        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];
        
        int j;
        
        for (int i = 0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }
        
        textReader.close();
        return textData;
    }
    
    /**
     * Checks how many lines to read.
     *
     * @return numberOfLines    The amount of lines to send.
     * @throws IOException      Handles any exceptions.
     */
    int readLines() throws IOException {
        FileReader fileToRead = new FileReader(path);
        BufferedReader bf = new BufferedReader(fileToRead);
        
        String aLine;
        int numberOfLines = 0;
        
        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        
        bf.close();
        
        return numberOfLines;
    }
}
