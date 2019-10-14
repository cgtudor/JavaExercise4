package uk.ac.tees.basic.username;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * <p>A utility class for writing to, and reading from, text files.</p>
 *
 * Based on work created by Mark Truran </p>
 */
public class FileUtility {

    /** This method appends a single string to a text file.
     * 
     * @param f The file to write to
     * @param entry The string to append
     */
    public static void writeFile(File f, String entry) {
        try {
            final BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
            out.write(entry);
            out.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file");
        }
    }

    /** This method resets the named text file.
     * 
     * @param f The file to reset
     */
    public static void resetFile(File f) {
        try {
            final BufferedWriter out = new BufferedWriter(new FileWriter(f, false));
            out.write("");
            out.close();
        } catch (IOException e) {
            System.err.println("Problem reset the file");
        }
    }

    /** This method reads the contents of a text file.
     * 
     * @param f The file to read from
     * @return the contents of the text file as a single string
     */
    public static String readFile(File f) {
        //Z means: "The end of the input but for the final terminator, if any
        String output = "No final terminator";
        try {
            output = new Scanner(f).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.err.println("Problem reading from file");
        }
        return output;
    }
}