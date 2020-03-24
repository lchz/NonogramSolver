package solver.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.io.StubIO;

/**
 *
 * @author lchz
 */
public class NonosolverTest {

    private StubIO io;
    private List<List<String>> colData;
    private List<List<String>> rowData;

    @Before
    public void setUp() {
        io = new StubIO();

        List<String> col1 = new java.util.ArrayList<>(Arrays.asList("2"));
        List<String> col2 = new java.util.ArrayList<>(Arrays.asList("2", "2"));
        List<String> col3 = new java.util.ArrayList<>(Arrays.asList("3", "1"));
        List<String> col4 = new java.util.ArrayList<>(Arrays.asList("2"));
        List<String> col5 = new java.util.ArrayList<>(Arrays.asList("1"));
        this.colData = new java.util.ArrayList<>(Arrays.asList(col1, col2, col3, col4, col5));
    }

    @Test
    public void newPuzzle_with_solution_test() {
        List<String> row1 = new java.util.ArrayList<>(Arrays.asList("2"));
        List<String> row2 = new java.util.ArrayList<>(Arrays.asList("3"));
        List<String> row3 = new java.util.ArrayList<>(Arrays.asList("1", "1"));
        List<String> row4 = new java.util.ArrayList<>(Arrays.asList("1", "1"));
        List<String> row5 = new java.util.ArrayList<>(Arrays.asList("4"));
        this.rowData = new java.util.ArrayList<>(Arrays.asList(row1, row2, row3, row4, row5));

        Nonosolver solver = new Nonosolver(io);
        solver.newPuzzle(rowData, colData);

        for (int i = 0; i < 25; i++) {
            if (i == 0 || i == 3 || i == 4 || i == 9 || i == 10 || i == 13
                    || i == 15 || i == 16 || i == 18 || i == 20 || i == 22 || i == 24) {
                assertEquals(". ", io.getOutput(i));
            } else if (i == 5 || i == 11 || i == 17 || i == 23 || i == 29) {
                assertEquals("", io.getOutput(i));
            } else {
                assertEquals("# ", io.getOutput(i));
            }
        }
    }

    @Test
    public void newPuzzle_no_solution_test() {
        List<String> row1 = new java.util.ArrayList<>(Arrays.asList("2"));
        List<String> row2 = new java.util.ArrayList<>(Arrays.asList("3"));
        List<String> row3 = new java.util.ArrayList<>(Arrays.asList("1", "1"));
        List<String> row4 = new java.util.ArrayList<>(Arrays.asList("1", "1"));
        List<String> row5 = new java.util.ArrayList<>(Arrays.asList("5"));
        this.rowData = new java.util.ArrayList<>(Arrays.asList(row1, row2, row3, row4, row5));

        Nonosolver solver = new Nonosolver(io);
        solver.newPuzzle(rowData, colData);
        
        assertEquals("No solution", io.getOutput(0));
    }
}
