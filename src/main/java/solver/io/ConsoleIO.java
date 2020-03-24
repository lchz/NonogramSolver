package solver.io;

import java.util.Scanner;

/**
 *
 * @author lchz
 */
public class ConsoleIO implements IO {
    
    private Scanner scanner;
    
    public ConsoleIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void printPuzzle(String string) {
        System.out.print(string);
    }
    
}
