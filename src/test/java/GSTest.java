import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GSTest {
    private GenericStack<Integer> expected;
    private GenericStack<Integer> actual;
    private ArrayList<Integer> expectArray = new ArrayList<>();
    private ArrayList<Integer> actArray = new ArrayList<>();
    private static int iter;
    private static int iter2;

    @BeforeEach  // runs only once before test, creat diff iter cases
    void init() {
        expected = new  GenericStack<Integer>(4);
        iter = 0;
        iter2 = 0;
    }

    // Test the push method
    @Test
    void testPush() {
        expected.push(8);
        assertEquals(8, expected.get(1), "Queue is not equal");
    }

    // Test the push method two more aggressively with a for loop
    @Test
    void testPush2() {
        for (; iter < 243; iter++) {
            expected.push(iter);
        }
        assertEquals(242, expected.get(243), "Queue is not equal");
    }

    // Test pop method using loops and get size
    @Test
    void testPop() {
        for (; iter < 200; iter++) {
            expected.push(iter);
        }
        for (; iter2 < 50; iter2++) {
            expected.pop();
        }
        assertEquals(149, expected.get(150),"Queue is not equal");
        assertEquals(151, expected.getLength(),"Queue is not equal");
    }

    // Test add method using loops and get size
    @Test
    void testAdd() {
        for (; iter < 1000; iter++) {
            expected.add(iter);
        }
        for (; iter2 < 50; iter2++) {
            expected.pop();
        }
        assertEquals(949, expected.get(950),"Queue is not equal");
        assertEquals(951, expected.getLength(),"Queue is not equal");
    }

    // Test removeTail method using loops and get size
    @Test
    void testRemoveTail() {
        for (; iter < 100; iter++) {
            expected.add(iter);
        }
        for (; iter2 < 13; iter2++) {
            expected.removeTail();
        }
        assertNull(expected.get(100), "Queue is not equal");
        assertEquals(86, expected.get(87),"Queue is not equal");
        assertEquals(null, expected.get(88),"Queue is not equal");
        assertEquals(88, expected.getLength(),"Queue is not equal");
    }

    // Test the constructor for generic stack
    @Test
    void testGenStack() {
        expected = new GenericStack<Integer>(133);
        expected.push(234);
        assertEquals(133, expected.getHead().data, "Queue is not equal");
    }

    /*
        Test whether the stack equal
     */
    @Test
    void stackEqualTest1() {
        expected = new GenericStack<Integer>(1);
        assertEquals(1, expected.getHead().data, "Queue is not equal");
    }

    // Test listIterator if has next
    @Test
    void testListIterator() {
        assertFalse(expected.listIterator(4).hasNext(), "Queue is not equal");
    }

    // Test listIterator if has previous
    @Test
    void testListIterator2() {
        expected = new GenericStack<Integer>(1);
        expected.push(3);
        expected.push(5);
        assertFalse(expected.listIterator(1).hasPrevious(), "Queue is not equal");
    }

    // Test listIterator and gets next value
    @Test
    void testListIterator3() {
        expected = new GenericStack<Integer>(1);
        expected.push(3);
        assertEquals(3, expected.listIterator(2).nextIndex(), "Queue is not equal");
    }
    /*
        Test whether the stack equal
     */
    @Test
    void stackEqualTest2() {
        expected = new GenericStack<Integer>(2);
        assertEquals(2, expected.getHead().data, "Queue is not equal");
    }

    /*
        Test whether the push works
    */
    @Test
    void stackArrayPush() {

        actual = new GenericStack<Integer>(1);
        expected = new GenericStack<Integer>(1);
        for (; iter < 5; iter++) {
            expected.push(iter);
        }
        for (; iter2 < 5; iter2++) {
            actual.push(iter2);
        }
        expectArray = expected.dumpList();
        actArray = actual.dumpList();
        assertArrayEquals(expectArray.toArray(), actArray.toArray(), "Queue Array is not equal");
    }

    /*
    Test whether the dumplist and print method work
    */
    @Test
    void stackArrayPopPrint() {
        expected = new GenericStack<Integer>(0);
        actual = new GenericStack<Integer>(0);

//        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 5);
        for (; iter < 5; iter++) {
            expected.push(iter);
        }
        for (; iter2 < 5; iter2++) {
            actual.push(iter2);
        }
        actual.pop();
        actual.pop();
        expected.pop();
        expected.pop();

        expectArray = expected.dumpList();
        actArray = actual.dumpList();
        assertArrayEquals( actArray.toArray(), actArray.toArray(), "Queue Array is not equal");
        actual.print();
    }
    /*
        Test whether the stack has next
     */
    @Test
    void stackHasNext() {
        expected = new GenericStack<Integer>(0);
        actual = new GenericStack<Integer>(0);
        for (iter = 1; iter < 5; iter++) {
            expected.push(iter);
        }
        for (iter2 = 1; iter2 < 5; iter2++) {
            actual.push(iter2);
        }
        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 5);
        GLListIterator<Integer> g2 = new GLListIterator<Integer>(actual.getHead(), 5);
        actual.pop();
        expected.pop();
        assertTrue(g2.hasNext(), "Queue Array is not equal");
    }

    /*
    Test whether the stack has previous
    */
    @Test
    void stackHasPrev() {
        expected = new GenericStack<Integer>(0);
        actual = new GenericStack<Integer>(0);
        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 1);
        GLListIterator<Integer> g2 = new GLListIterator<Integer>(actual.getHead(), 1);
        assertFalse(g2.hasPrevious(), "Queue Array is not equal");
    }

    /*
        Test whether the tail is removed
     */
    @Test
    void stackRemoveTail() {
        expected = new GenericStack<Integer>(0);
        actual = new GenericStack<Integer>(0);
        for (iter = 1; iter < 5; iter++) {
            expected.push(iter);
        }
        for (iter2 = 1; iter2 < 5; iter2++) {
            actual.push(iter2);
        }
        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 5);
        GLListIterator<Integer> g2 = new GLListIterator<Integer>(actual.getHead(), 5);
        actual.removeTail();
        expected.removeTail();
        assertEquals(0, actual.getHead().data, "Queue Array is not equal");
    }

    /*
    Check whether length is the same
     */
    @Test
    void stackLength() {
        expected = new GenericStack<Integer>(1);
        actual = new GenericStack<Integer>(1);
        expected.push(2);
        actual.push(5);
        assertEquals(2, actual.getLength(), "Queue Array is not equal");
    }

    /*
        Check whether iterator is not null else return false
     */
    @Test
    void stackIterator() {
        boolean x = false;
        boolean i = false;
        expected = new GenericStack<Integer>(1);
        actual = new GenericStack<Integer>(1);
        if (expected.iterator() != null) {
            x = true;
        }
        if (actual.iterator() != null) {
            i = true;
        }

        assertEquals(x,i, "Queue Array is not equal");
    }

    /*
        Check whether reverseIterator is not null else return false
     */
    @Test
    void stackReverseIteratorNext() {
        boolean x = false;
        boolean i = false;
        expected = new GenericStack<Integer>(1);
        actual = new GenericStack<Integer>(1);
        ReverseGLLIterator<Integer> g1 = new ReverseGLLIterator<Integer>(expected.getHead());
        ReverseGLLIterator<Integer> g2 = new ReverseGLLIterator<Integer>(actual.getHead());
        if (g1.next() != null) {
            x = true;
        }
        if (g2.next() != null) {
            i = true;
        }

        assertEquals(x,i, "Queue Array is not equal");
    }

    /*
        Check whether the stack is Set with index
     */
    @Test
    void queueSet() {
        boolean x = false;
        boolean i = false;
        expected = new GenericStack<>(1);
        actual = new GenericStack<Integer>(1);

        expected.set(1,2);
        actual.set(1,2);
        assertEquals(1, actual.getHead().data, "Queue is not equal");
    }
}
