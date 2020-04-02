package solver.app;

import solver.io.ConsoleIO;
import solver.domain.Nonosolver;

/**
 *
 * @author lchz
 */
public class Main {

    public static void main(String[] args) {
        
        ConsoleIO io = new ConsoleIO();
        
        io.print("Please insert your working directory path "
                + "(on Linux use command '$ pwd' to verify):");
        
        String home = io.read();

        io.print("Please choose a puzzle:");
        String puzzle = io.read();

        FileReaderImpl data = new FileReaderImpl(home, puzzle);
        data.getData();

        io.print("\nPuzzle " + data.getName());

        Nonosolver solver = new Nonosolver(new ConsoleIO());
        solver.newPuzzle(data.getRows(), data.getColumns());
    }

}
