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

        ConsoleIO io2 = new ConsoleIO();

        io2.print("Please choose a puzzle:");
        String puzzle2 = io2.read();

        long start2 = System.currentTimeMillis();

        FileReaderImpl data2 = new FileReaderImpl(puzzle2);
        data2.getData();

        io2.print("\nPuzzle " + data2.getName());

        Nonosolver solver2 = new Nonosolver(new ConsoleIO());
        solver2.newPuzzle(data2.getRows(), data2.getColumns());

        long stop2 = System.currentTimeMillis();
        System.out.println("Kesto: " + (stop2 - start2));
//========================================================00
        ConsoleIO io = new ConsoleIO();

        io.print("Please choose a puzzle:");
        String puzzle = io.read();

        long start = System.nanoTime();

        FileReaderImpl data = new FileReaderImpl(puzzle);
        data.getData();

        io.print("\nPuzzle " + data.getName());

        Nonosolver solver = new Nonosolver(new ConsoleIO());
        solver.newPuzzle(data.getRows(), data.getColumns());

        long stop = System.nanoTime();
        System.out.println("Kesto: " + (stop - start));

        //=========================================
//        ConsoleIO io2 = new ConsoleIO();
//
//        io2.print("Please choose a puzzle:");
//        String puzzle2 = io2.read();
//
//        long start2 = System.currentTimeMillis();
//        
//        FileReaderImpl data2 = new FileReaderImpl(puzzle2);
//        data2.getData();
//
//        io2.print("\nPuzzle " + data2.getName());
//
//        Nonosolver solver2 = new Nonosolver(new ConsoleIO());
//        solver2.newPuzzle(data2.getRows(), data2.getColumns());
//        
//        long stop2 = System.currentTimeMillis();
//        System.out.println("Kesto: " + (stop2-start2));
    }

}
