package solver.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import solver.util.ComList;

/**
 *
 * @author lchz
 */
public class NonoblockTest {

    private Nonoblock block;
    private ComList<ComList<String>> rows;
    private ComList<ComList<String>> cols;

    public NonoblockTest() {
        this.block = new Nonoblock();
        rows = new ComList<>();
        cols = new ComList<>();
    }

    @Before
    public void setUp() {
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
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);

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
        cols.add(col1);
        cols.add(col2);
        cols.add(col3);
        cols.add(col4);
        cols.add(col5);
    }

    @Test
    public void generate_candidates_sum_correctly1() {

        ComList<ComList<String>> rowCandidates = block.getCandidates(rows, 5);

        assertEquals(4, rowCandidates.get(0).size());
        assertEquals(3, rowCandidates.get(1).size());
        assertEquals(6, rowCandidates.get(2).size());
        assertEquals(6, rowCandidates.get(3).size());
        assertEquals(2, rowCandidates.get(4).size());

    }

    @Test
    public void generate_candidates_sum_correctly2() {

        ComList<ComList<String>> rowCandidates = block.getCandidates(cols, 5);

        assertEquals(4, rowCandidates.get(0).size());
        assertEquals(1, rowCandidates.get(1).size());
        assertEquals(1, rowCandidates.get(2).size());
        assertEquals(4, rowCandidates.get(3).size());
        assertEquals(5, rowCandidates.get(4).size());

    }
}
