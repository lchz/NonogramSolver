package solver.domain;

import solver.io.IO;
import solver.util.ComList;

/**
 * This class is for solving Nonogram.
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
    public void newPuzzle(ComList<ComList<String>> rows, ComList<ComList<String>> columns) {
        ComList<ComList<String>> rowsCandidates = new Nonoblock().getCandidates(rows, columns.size());
        ComList<ComList<String>> columnsCandidates = new Nonoblock().getCandidates(columns, rows.size());

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
     * Prints the results of this puzzle.
     * 
     * @param rowsCandidates the final candidates for rows
     * @param columnsCandidates the final candidates for columns
     */
    private void print(ComList<ComList<String>> rowsCandidates, ComList<ComList<String>> columnsCandidates) {
        for (ComList<String> row : rowsCandidates) {
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
