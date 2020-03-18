package solver.app;

import solver.domain.Nonoblock;
import solver.io.ConsoleIO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lchz
 */
public class Main {

    public static void main(String[] args) {
//        Nonoblock block = new Nonoblock();
//        block.printBlock(Arrays.asList(2,1), 5);
//        System.out.println("");
//        block.printBlock(Arrays.asList(), 5);
//        System.out.println("");
//        block.printBlock(Arrays.asList(8), 10);
//        System.out.println("");
//        block.printBlock(Arrays.asList(2,3,2,3), 15);
//        System.out.println("");
//        block.printBlock(Arrays.asList(2, 3), 5);

        ConsoleIO io = new ConsoleIO();
        
        io.print("Nonogram block solver!");
        io.print("Give the length of the block: ");
        
        int length = Integer.parseInt(io.read());
        
        io.print("Give hints, press q to stop: ");
        
        List<Integer> data = new ArrayList<>();
        
        while(true) {
            String hint = io.read();
            if (hint.equals("q")) {
                break;
            }
            
            try {
                data.add(Integer.parseInt(hint));
            } catch (NumberFormatException error) {
                io.print("Invalid input.");
                io.print("Please insert an integer: ");
            } 
        }
        
        io.print("Solving the puzzle...");
        
        Nonoblock block = new Nonoblock(new ConsoleIO());
        block.printBlock(data, length);
        
    }
    
}

