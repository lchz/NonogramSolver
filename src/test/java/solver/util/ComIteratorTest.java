package solver.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lchz
 */
public class ComIteratorTest {

    private ComList<String> list;

    @Before
    public void setUp() {
        list = new ComList<>();
        list.add("ab");
        list.add("bc");
        list.add("cd");
    }

    @Test
    public void testComIterator() {
        ComIterator<String> it = new ComIterator(list);
        int i = 0;
        while (it.hasNext()) {
            String s = it.next();
            if (s.contains("b")) {
                it.remove(s);
            }
            i++;
        }

        assertEquals(3, i);
        assertEquals(1, list.size());
        assertEquals("cd", list.get(0));

    }

}
