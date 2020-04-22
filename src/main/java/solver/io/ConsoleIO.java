package solver.io;

import java.util.Scanner;

/**
 * This class is for reading inputs and print outputs.
 * @author lchz
 */
public class ConsoleIO implements IO {
    
    private Scanner scanner;
    
    public ConsoleIO() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads input from this user.
     * 
     * @return the input this user has passed
     */
    @Override
    public String read() {
        return scanner.nextLine();
    }

    /**
     * Prints the specific content to the console.
     * 
     * @param string string to be printed
     */
    @Override
    public void print(String string) {
        System.out.println(string);
    }

    /**
     * Prints content of a puzzle result.
     * In the content everything is printed in one line.
     * 
     * @param string string to be printed
     */
    @Override
    public void printPuzzle(String string) {
        System.out.print(string);
    }
    
}
