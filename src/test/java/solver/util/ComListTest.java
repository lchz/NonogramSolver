package solver.util;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lchz
 */
public class ComListTest {

    private ComList<String> list;

    @Before
    public void setUp() {
        list = new ComList<>();
        list.add("ab");
        list.add("bc");
        list.add("cd");
    }

    @Test
    public void testIsEmpty() {
        ComList<String> l = new ComList<>();
        assertEquals(true, l.isEmpty());
    }

    @Test
    public void testAdd() {
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");
        list.add("gg");
        list.add("qq");
        
        assertEquals(11, list.size());
    }

    @Test
    public void testIsNotEmpty() {
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testGet() {
        assertEquals("ab", list.get(0));
    }

    @Test
    public void testRemove() {
        list.remove("bc");
        assertEquals("ab", list.get(0));
        assertEquals("cd", list.get(1));
        assertEquals(false, list.contains("bc"));
        assertEquals(2, list.size());
    }
    
    @Test
    public void testRemoveNotFound() {
        assertEquals(false, list.remove("qwe"));
    }
    
    @Test
    public void testContains() {
        assertEquals(true, list.contains("ab"));
        assertEquals(false, list.contains("qwer"));
    }
    
    @Test 
    public void testAddAll() {
        ComList<String> l = new ComList<>();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        l.add("dd");
        l.add("ee");
        l.add("ff");
        l.add("gg");
        l.add("hh");
        l.add("ii");
        list.addAll(l);
        assertEquals(12, list.size());
    }
    
    @Test
    public void testIterator() {
        Iterator<String> it = list.iterator();
        
        int i = 0;
        while (it.hasNext()) {
            String s = it.next();
            i++;
        }
        
        assertEquals(3, i);
    }

}
