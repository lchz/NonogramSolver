package solver.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lchz
 */
public class NonoreducerTest {

    private List<List<String>> colCandidates;
    private List<List<String>> rowCandidates;


    @Test
    public void reduceMutual_correctly() {
        List<String> row1 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> row2 = new java.util.ArrayList<>(Arrays.asList("11100", "01110", "00111"));
        List<String> row3 = new java.util.ArrayList<>(Arrays.asList("10100", "10010", "10001", "01010", "01001", "00101"));
        List<String> row4 = new java.util.ArrayList<>(Arrays.asList("10100", "10010", "10001", "01010", "01001", "00101"));
        List<String> row5 = new java.util.ArrayList<>(Arrays.asList("11110", "01111"));
        this.rowCandidates = new java.util.ArrayList<>(Arrays.asList(row1, row2, row3, row4, row5));

        List<String> col1 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> col2 = new java.util.ArrayList<>(Arrays.asList("11011"));
        List<String> col3 = new java.util.ArrayList<>(Arrays.asList("11101"));
        List<String> col4 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> col5 = new java.util.ArrayList<>(Arrays.asList("10000", "01000", "00100", "00010", "00001"));
        this.colCandidates = new java.util.ArrayList<>(Arrays.asList(col1, col2, col3, col4, col5));

        int num = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(12, num);

        int num2 = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(6, num2);

        int num3 = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(0, num3);

    }

    @Test
    public void return_neg1_if_rowCandidates_empty() {
        List<String> row1 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> row2 = new java.util.ArrayList<>(Arrays.asList("11100", "01110", "00111"));
        List<String> row3 = new java.util.ArrayList<>(Arrays.asList("10100", "10010", "10001", "01010", "01001", "00101"));
        List<String> row4 = new java.util.ArrayList<>(Arrays.asList("10100", "10010", "10001", "01010", "01001", "00101"));
        List<String> row5 = new java.util.ArrayList<>(Arrays.asList("11110", "01111"));
        this.rowCandidates = new java.util.ArrayList<>(Arrays.asList(row1, row2, row3, row4, row5));

        List<String> col1 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> col2 = new java.util.ArrayList<>(Arrays.asList("11011"));
        List<String> col3 = new java.util.ArrayList<>(Arrays.asList("11101"));
        List<String> col4 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> col5 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        this.colCandidates = new java.util.ArrayList<>(Arrays.asList(col1, col2, col3, col4, col5));

        int num = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(12, num);

        int num2 = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(-1, num2);
    }

    @Test
    public void return_neg1_if_colCandidates_empty() {
        List<String> row1 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> row2 = new java.util.ArrayList<>(Arrays.asList("11100", "01110", "00111"));
        List<String> row3 = new java.util.ArrayList<>(Arrays.asList("10100", "10010", "10001", "01010", "01001", "00101"));
        List<String> row4 = new java.util.ArrayList<>(Arrays.asList("10100", "10010", "10001", "01010", "01001", "00101"));
        List<String> row5 = new java.util.ArrayList<>(Arrays.asList("11111"));
        this.rowCandidates = new java.util.ArrayList<>(Arrays.asList(row1, row2, row3, row4, row5));

        List<String> col1 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> col2 = new java.util.ArrayList<>(Arrays.asList("11011"));
        List<String> col3 = new java.util.ArrayList<>(Arrays.asList("11101"));
        List<String> col4 = new java.util.ArrayList<>(Arrays.asList("11000", "01100", "00110", "00011"));
        List<String> col5 = new java.util.ArrayList<>(Arrays.asList("10000", "01000", "00100", "00010", "00001"));
        this.colCandidates = new java.util.ArrayList<>(Arrays.asList(col1, col2, col3, col4, col5));
        
        int num = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(-1, num);

    }
}
