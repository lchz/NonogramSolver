package solver.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.io.StubIO;
import solver.util.ComList;

/**
 *
 * @author lchz
 */
public class NonosolverTest {

    private StubIO io;
    private ComList<ComList<String>> colData;
    private ComList<ComList<String>> rowData;

    @Before
    public void setUp() {
        io = new StubIO();

        ComList<String> col1 = new ComList<>();
        ComList<String> col2 = new ComList<>();
        ComList<String> col3 = new ComList<>();
        ComList<String> col4 = new ComList<>();
        ComList<String> col5 = new ComList<>(); 
        col1.add("2");
        col2.add("2");
        col2.add("2");
        col3.add("3");
        col3.add("1");
        col4.add("2");
        col5.add("1");
        this.colData = new ComList<>();
        this.colData.add(col1);
        this.colData.add(col2);
        this.colData.add(col3);
        this.colData.add(col4);
        this.colData.add(col5);
    }

    @Test
    public void newPuzzle_with_solution_test() {
        ComList<String> row1 = new ComList<>();
        ComList<String> row2 = new ComList<>();
        ComList<String> row3 = new ComList<>();
        ComList<String> row4 = new ComList<>();
        ComList<String> row5 = new ComList<>();
        
        row1.add("2");
        row2.add("3");
        row3.add("1");
        row3.add("1");
        row4.add("1");
        row4.add("1");
        row5.add("4");
        
        this.rowData = new ComList<>();
        rowData.add(row1);
        rowData.add(row2);
        rowData.add(row3);
        rowData.add(row4);
        rowData.add(row5);

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
        
        ComList<String> row1 = new ComList<>();
        ComList<String> row2 = new ComList<>();
        ComList<String> row3 = new ComList<>();
        ComList<String> row4 = new ComList<>();
        ComList<String> row5 = new ComList<>();
        
        row1.add("2");
        row2.add("3");
        row3.add("1");
        row3.add("1");
        row4.add("1");
        row4.add("1");
        row5.add("5");
        
        this.rowData = new ComList<>();
        rowData.add(row1);
        rowData.add(row2);
        rowData.add(row3);
        rowData.add(row4);
        rowData.add(row5);

        Nonosolver solver = new Nonosolver(io);
        solver.newPuzzle(rowData, colData);
        
        assertEquals("No solution", io.getOutput(0));
    }
}
