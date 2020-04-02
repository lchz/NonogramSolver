package solver.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import solver.util.ComList;

/**
 *
 * @author lchz
 */
public class NonoreducerTest {

    private ComList<ComList<String>> colCandidates;
    private ComList<ComList<String>> rowCandidates;


    @Test
    public void reduceMutual_correctly() {
        ComList<String> row1 = new ComList<>();
        ComList<String> row2 = new ComList<>();
        ComList<String> row3 = new ComList<>();
        ComList<String> row4 = new ComList<>();
        ComList<String> row5 = new ComList<>();
        row1.add("11000");
        row1.add("01100");
        row1.add("00110");
        row1.add("00011");
        
        row2.add("11100");
        row2.add("01110");
        row2.add("00111");
        
        row3.add("10100");
        row3.add("10010");
        row3.add("10001");
        row3.add("01010");
        row3.add("01001");
        row3.add("00101");
        
        row4.add("10100");
        row4.add("10010");
        row4.add("10001");
        row4.add("01010");
        row4.add("01001");
        row4.add("00101");
        
        row5.add("11110");
        row5.add("01111");
        
        this.rowCandidates = new ComList<>();
        this.rowCandidates.add(row1);
        this.rowCandidates.add(row2);
        this.rowCandidates.add(row3);
        this.rowCandidates.add(row4);
        this.rowCandidates.add(row5);

        ComList<String> col1 = new ComList<>();
        ComList<String> col2 = new ComList<>();
        ComList<String> col3 = new ComList<>();
        ComList<String> col4 = new ComList<>();
        ComList<String> col5 = new ComList<>();
        
        col1.add("11000");
        col1.add("01100");
        col1.add("00110");
        col1.add("00011");
        
        col2.add("11011");
        
        col3.add("11101");
        
        col4.add("11000");
        col4.add("01100");
        col4.add("00110");
        col4.add("00011");
        
        col5.add("10000");
        col5.add("01000");
        col5.add("00100");
        col5.add("00010");
        col5.add("00001");

        
        this.colCandidates = new ComList<>();
        this.colCandidates.add(col1);
        this.colCandidates.add(col2);
        this.colCandidates.add(col3);
        this.colCandidates.add(col4);
        this.colCandidates.add(col5);

        int num = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(20, num);

        int num2 = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(6, num2);

        int num3 = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(0, num3);

    }

    @Test
    public void return_neg1_if_rowCandidates_empty() {
        ComList<String> row1 = new ComList<>();
        ComList<String> row2 = new ComList<>();
        ComList<String> row3 = new ComList<>();
        ComList<String> row4 = new ComList<>();
        ComList<String> row5 = new ComList<>();
        row1.add("11000");
        row1.add("01100");
        row1.add("00110");
        row1.add("00011");
        
        row2.add("11100");
        row2.add("01110");
        row2.add("00111");
        
        row3.add("10100");
        row3.add("10010");
        row3.add("10001");
        row3.add("01010");
        row3.add("01001");
        row3.add("00101");
        
        row4.add("10100");
        row4.add("10010");
        row4.add("10001");
        row4.add("01010");
        row4.add("01001");
        row4.add("00101");
        
        row5.add("11110");
        row5.add("01111");
        
        this.rowCandidates = new ComList<>();
        this.rowCandidates.add(row1);
        this.rowCandidates.add(row2);
        this.rowCandidates.add(row3);
        this.rowCandidates.add(row4);
        this.rowCandidates.add(row5);
        
        ComList<String> col1 = new ComList<>();
        ComList<String> col2 = new ComList<>();
        ComList<String> col3 = new ComList<>();
        ComList<String> col4 = new ComList<>();
        ComList<String> col5 = new ComList<>();
        
        col1.add("11000");
        col1.add("01100");
        col1.add("00110");
        col1.add("00011");
        
        col2.add("11011");
        
        col3.add("11101");
        
        col4.add("11000");
        col4.add("01100");
        col4.add("00110");
        col4.add("00011");
        
        col5.add("11000");
        col5.add("01100");
        col5.add("00110");
        col5.add("00011");
        
        this.colCandidates = new ComList<>();
        this.colCandidates.add(col1);
        this.colCandidates.add(col2);
        this.colCandidates.add(col3);
        this.colCandidates.add(col4);
        this.colCandidates.add(col5);
        
        int num = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(20, num);

        int num2 = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(-1, num2);
    }

    @Test
    public void return_neg1_if_colCandidates_empty() {
        ComList<String> row1 = new ComList<>();
        ComList<String> row2 = new ComList<>();
        ComList<String> row3 = new ComList<>();
        ComList<String> row4 = new ComList<>();
        ComList<String> row5 = new ComList<>();
        row1.add("11000");
        row1.add("01100");
        row1.add("00110");
        row1.add("00011");
        
        row2.add("11100");
        row2.add("01110");
        row2.add("00111");
        
        row3.add("10100");
        row3.add("10010");
        row3.add("10001");
        row3.add("01010");
        row3.add("01001");
        row3.add("00101");
        
        row4.add("10100");
        row4.add("10010");
        row4.add("10001");
        row4.add("01010");
        row4.add("01001");
        row4.add("00101");
        
        row5.add("11111");
        
        this.rowCandidates = new ComList<>();
        this.rowCandidates.add(row1);
        this.rowCandidates.add(row2);
        this.rowCandidates.add(row3);
        this.rowCandidates.add(row4);
        this.rowCandidates.add(row5);

        ComList<String> col1 = new ComList<>();
        ComList<String> col2 = new ComList<>();
        ComList<String> col3 = new ComList<>();
        ComList<String> col4 = new ComList<>();
        ComList<String> col5 = new ComList<>();
        
        col1.add("11000");
        col1.add("01100");
        col1.add("00110");
        col1.add("00011");
        
        col2.add("11011");
        
        col3.add("11101");
        
        col4.add("11000");
        col4.add("01100");
        col4.add("00110");
        col4.add("00011");
        
        col5.add("10000");
        col5.add("01000");
        col5.add("00100");
        col5.add("00010");
        col5.add("00001");

        this.colCandidates = new ComList<>();
        this.colCandidates.add(col1);
        this.colCandidates.add(col2);
        this.colCandidates.add(col3);
        this.colCandidates.add(col4);
        this.colCandidates.add(col5);
        
        int num = new Nonoreducer(this.colCandidates, this.rowCandidates).reduceMutual();
        assertEquals(-1, num);

    }
}
