package solver.app;

import solver.io.FileReaderImpl;
import solver.io.ConsoleIO;
import solver.domain.Nonosolver;

/**
 *
 * @author lchz
 */
public class Main {

    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        
        io.print("Please choose a puzzle:");
        String puzzle = io.read();

        FileReaderImpl data = new FileReaderImpl(puzzle);
        data.getData();

        io.print("\nPuzzle " + data.getName());

        Nonosolver solver = new Nonosolver(new ConsoleIO());
        solver.newPuzzle(data.getRows(), data.getColumns());

//================TEST=============================================
//        long total = 0;
//        ConsoleIO io = new ConsoleIO();
//        io.print("Please choose a puzzle:");
//        String puzzle = io.read();
//
//        for (int i = 0; i < 100; i++) {
//            
//            long start = System.nanoTime();
//
//            FileReaderImpl data = new FileReaderImpl(puzzle);
//            data.getData();
//
//            io.print("\nPuzzle " + data.getName());
//
//            Nonosolver solver = new Nonosolver(new ConsoleIO());
//            solver.newPuzzle(data.getRows(), data.getColumns());
//
//            long stop = System.nanoTime();
//            long kesto = stop - start;
//            total += kesto;
//        }
//
//        System.out.println("100 times Average: " + (total / 100));

    }

}
