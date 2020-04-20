package test;

import solver.domain.Nonosolver;
import solver.io.ConsoleIO;
import solver.io.FileReaderImpl;


/**
 * This class is for testing the program performance.
 * @author chenhuiz
 */
public class Tester {

    public static void main(String[] args) {
        
        long total = 0;

        ConsoleIO io = new ConsoleIO();
        io.print("Please choose a puzzle:");
        String puzzle = io.read();

        for (int i = 0; i < 100; i++) {

            long start = System.nanoTime();

            FileReaderImpl data = new FileReaderImpl(puzzle);
            data.getData();

            io.print("\nPuzzle " + data.getName());

            Nonosolver solver = new Nonosolver(new ConsoleIO());
            solver.newPuzzle(data.getRows(), data.getColumns());

            long stop = System.nanoTime();
            long kesto = stop - start;
            total += kesto;
        }

        io.print("Average time consumtion for 100 times: " + (total / 100) + " ns");
    }

}
