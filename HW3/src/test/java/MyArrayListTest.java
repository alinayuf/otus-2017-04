import org.junit.Test;

import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;
/**
 * Created by alina on 20.04.17.
 */
public class MyArrayListTest {
    @Test
    public void size()
    {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void isEmpty()
    {
        MyArrayList<Integer> list = new MyArrayList<>();

        assertEquals(true, list.isEmpty());
        list.add(1);
        assertEquals(false, list.isEmpty());
    }


    @Test
    public void contains()
    {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        assertEquals(false, list.contains(0));
        assertEquals(true, list.contains(1));
    }

    @Test
    public void add()
    {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        assertEquals(true, list.contains(1));

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(11, list.size());
    }

    @Test
    public void get()
    {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);

        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    public void indexOf()
    {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);

        assertEquals(0, list.indexOf(1));
        assertEquals(-1, list.indexOf(0));
    }

    @Test
    public void iterator()
    {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        Iterator<Integer> iter = list.iterator();
        assertEquals(Integer.valueOf(1), iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void listiterator()
    {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        ListIterator<Integer> iter = list.listIterator();
        assertEquals(Integer.valueOf(1), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(2), iter.next());
        assertTrue(iter.hasPrevious());
        assertEquals(Integer.valueOf(1), iter.previous());
    }

    @Test
    public void string()
    {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        String toString = list.toString();
        assertEquals(toString, "1 2 ");
    }

    @Test
    public void set()
    {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        list.set(0, 0);

        assertFalse(list.contains(1));
        assertTrue(list.contains(0));
    }
}
