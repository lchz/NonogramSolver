package solver.domain;

import java.util.List;
import solver.io.IO;

/**
 *
 * @author lchz
 */
public class Nonosolver {

    private IO io;

    public Nonosolver(IO io) {
        this.io = io;
    }

    /**
     * Generates candidates for rows and columns and monitors reduction states.
     *
     * @param rows row data in a list
     * @param columns column data in a list
     */
    public void newPuzzle(List<List<String>> rows, List<List<String>> columns) {
        List<List<String>> rowsCandidates = new Nonoblock().getCandidates(rows, columns.size());
        List<List<String>> columnsCandidates = new Nonoblock().getCandidates(columns, rows.size());

        int numChanged = 1;
        while (numChanged > 0) {
            numChanged = new Nonoreducer(columnsCandidates, rowsCandidates).reduceMutual();

            if (numChanged == -1) {
                io.print("No solution");
                return;
            }
        }
        
        print(rowsCandidates, columnsCandidates);

    }

    /**
     * Prints the results of this puzzle
     * 
     * @param rowsCandidates the final candidates for rows
     * @param columnsCandidates the final candidates for columns
     */
    private void print(List<List<String>> rowsCandidates, List<List<String>> columnsCandidates) {
        for (List<String> row : rowsCandidates) {
            for (int i = 0; i < columnsCandidates.size(); i++) {
                if (row.get(0).split("")[i].equals("1")) {
                    io.printPuzzle("# ");
                } else {
                    io.printPuzzle(". ");
                }
            }
            io.print("");
        }
        io.print("");
    }

}
