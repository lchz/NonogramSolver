package solver.io;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lchz
 */
public class FileReaderImpTest {

    private FileReader reader;

    public FileReaderImpTest() {
        this.reader = new FileReaderImpl("test5.non.txt");
    }

    @Before
    public void setUp() {
        reader.getData();
    }

    @Test
    public void readingTitleTest() {
        assertEquals("Test 5x5", reader.getName());
    }

    @Test
    public void readingRowsAndColumnsTest() {

        assertEquals(5, reader.getRows().size());
        assertEquals(5, reader.getColumns().size());

    }

}
