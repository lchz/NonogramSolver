package solver.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author lchz
 */
public class NonoblockTest {

    private Nonoblock block;
    private List<List<String>> rows;
    private List<List<String>> cols;

    public NonoblockTest() {
        this.block = new Nonoblock();
    }

    @Before
    public void setUp() {
        List<String> row1 = Arrays.asList("2");
        List<String> row2 = Arrays.asList("3");
        List<String> row3 = Arrays.asList("1", "1");
        List<String> row4 = Arrays.asList("1", "1");
        List<String> row5 = Arrays.asList("4");
        rows = Arrays.asList(row1, row2, row3, row4, row5);

        List<String> col1 = Arrays.asList("2");
        List<String> col2 = Arrays.asList("2", "2");
        List<String> col3 = Arrays.asList("3", "1");
        List<String> col4 = Arrays.asList("2");
        List<String> col5 = Arrays.asList("1");
        cols = Arrays.asList(col1, col2, col3, col4, col5);

    }

    @Test
    public void generate_candidates_sum_correctly1() {

        List<List<String>> rowCandidates = block.getCandidates(rows, 5);

        assertEquals(4, rowCandidates.get(0).size());
        assertEquals(3, rowCandidates.get(1).size());
        assertEquals(6, rowCandidates.get(2).size());
        assertEquals(6, rowCandidates.get(3).size());
        assertEquals(2, rowCandidates.get(4).size());

    }

    @Test
    public void generate_candidates_sum_correctly2() {

        List<List<String>> rowCandidates = block.getCandidates(cols, 5);

        assertEquals(4, rowCandidates.get(0).size());
        assertEquals(1, rowCandidates.get(1).size());
        assertEquals(1, rowCandidates.get(2).size());
        assertEquals(4, rowCandidates.get(3).size());
        assertEquals(5, rowCandidates.get(4).size());

    }
}
