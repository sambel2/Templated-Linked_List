import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GQTest {

    @BeforeEach
    void setup () {
        expected = new GenericQueue<Integer>(1);
        actual = new GenericQueue<Integer>(1);
    }


    //    private ArrayList<Integer> myList = new ArrayList<Integer> ();
//    private Integer initVal;
    private GenericQueue<Integer> expected;
    private GenericQueue<Integer> actual;
    private ArrayList<Integer> expectArray = new ArrayList<>();
    private ArrayList<Integer> actArray = new ArrayList<>();
    private static int iter;
    private static int iter2;


    @BeforeEach  // runs only once before test, creat diff iter cases
    void init() {
        iter = 0;
        iter2 = 0;
    }

    /*
        Test whether both queues are not equal
     */
    @Test
    void queueEqualTest1() {
        expected = new GenericQueue<Integer>(1);
        actual = new GenericQueue<Integer>(1);
        assertEquals(1, actual.getHead().data, "Queue is not equal");
    }

    /*
         Test whether both queues are not equal
    */
    @Test
    void queueEqualTest2() {

        actual = new GenericQueue<Integer>(2);
        assertEquals(2, actual.getHead().data, "Queue is not equal");
    }

    // Test that we added a value using the add method
    @Test
    void testAdd() {
        expected.add(5);
        assertEquals(5, expected.get(1), "Queue is not equal");
    }

    // Test our Dequeue is null since we remove head in our list
    @Test
    void testDequeue() {
        expected.dequeue();
        assertNull(expected.get(0), "Queue is not equal");
    }

    // Test we enqueue a new value in our list
    @Test
    void testEnqueue() {
        expected.enqueue(5);
        expected.enqueue(6);
        assertEquals(6, expected.get(2), "Queue is not equal");
    }

    // Removes old tail from list and retrieves new tail
    @Test
    void testRemoveFromTail() {
        expected.enqueue(6);
        expected.enqueue(3);
        assertEquals(6, expected.removeTail(), "Queue is not equal");
    }

    // Test listIterator if has next
    @Test
    void testListIterator() {
        assertFalse(expected.listIterator(4).hasNext(), "Queue is not equal");
    }

    // Test listIterator if has previous
    @Test
    void testListIterator2() {
        expected = new GenericQueue<>(1);
        expected.add(3);
        expected.add(5);
        assertFalse(expected.listIterator(1).hasPrevious(), "Queue is not equal");
    }

    // Test listIterator and gets next value
    @Test
    void testListIterator3() {
        expected = new GenericQueue<Integer>(1);
        expected.add(3);
        assertEquals(3, expected.listIterator(2).nextIndex(), "Queue is not equal");
    }

    /*
        Test whether queue can dumpList and matches
     */
    @Test
    void queueArrayEnqueue() {

        actual = new GenericQueue<Integer>(1);
        expected = new GenericQueue<Integer>(1);
        for (; iter < 5; iter++) {
            expected.enqueue(iter);
        }
        for (; iter2 < 5; iter2++) {
            actual.enqueue(iter2);
        }
        expectArray = expected.dumpList();
        actArray = actual.dumpList();
        assertArrayEquals(expectArray.toArray(), actArray.toArray(), "Queue Array is not equal");
    }

    /*
        Test whether queue can Dequeue and print
    */
    @Test
    void queueArrayDequeuePrint() {
        expected = new GenericQueue<Integer>(0);
        actual = new GenericQueue<Integer>(0);

//        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 5);
        for (; iter < 5; iter++) {
            expected.enqueue(iter);
        }
        for (; iter2 < 5; iter2++) {
            actual.enqueue(iter2);
        }
        actual.dequeue();
        actual.dequeue();
        expected.dequeue();
        expected.dequeue();

        expectArray = expected.dumpList();
        actArray = actual.dumpList();
        assertArrayEquals(expectArray.toArray(), actArray.toArray(), "Queue Array is not equal");
        actual.print();
    }

    /*
        Test whether queue has next
    */
    @Test
    void queueHasNext() {
        expected = new GenericQueue<Integer>(0);
        actual = new GenericQueue<Integer>(0);
        for (iter = 1; iter < 5; iter++) {
            expected.enqueue(iter);
        }
        for (iter2 = 1; iter2 < 5; iter2++) {
            actual.enqueue(iter2);
        }
        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 5);
        GLListIterator<Integer> g2 = new GLListIterator<Integer>(actual.getHead(), 5);
        actual.dequeue();
        expected.dequeue();
        assertEquals(g1.hasNext(), g2.hasNext(), "Queue Array is not equal");
    }

    /*
        Test whether queue can previous
    */
    @Test
    void queueHasPrev() {
        expected = new GenericQueue<Integer>(0);
        actual = new GenericQueue<Integer>(0);
        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 1);
        GLListIterator<Integer> g2 = new GLListIterator<Integer>(actual.getHead(), 1);
        assertEquals(g1.hasPrevious(), g2.hasPrevious(), "Queue Array is not equal");
    }

    /*
        Test whether queue can remove from tail
    */
    @Test
    void queueRemoveTail() {
        expected = new GenericQueue<Integer>(0);
        actual = new GenericQueue<Integer>(0);
        for (iter = 1; iter < 5; iter++) {
            expected.enqueue(iter);
        }
        for (iter2 = 1; iter2 < 5; iter2++) {
            actual.enqueue(iter2);
        }
        GLListIterator<Integer> g1 = new GLListIterator<Integer>(expected.getHead(), 5);
        GLListIterator<Integer> g2 = new GLListIterator<Integer>(actual.getHead(), 5);
        actual.removeTail();
        expected.removeTail();
        assertEquals(0, actual.getHead().data, "Queue Array is not equal");
    }

    /*
        Test queue length match
    */
    @Test
    void queueLength() {
//        expected = new GenericQueue<Integer>(1);
//        actual = new GenericQueue<Integer>(1);
        expected.enqueue(2);
        actual.enqueue(5);
        assertEquals(2, actual.getLength(), "Queue Array is not equal");
    }

    /*
        Check whether iterator is not null else return false
     */
    @Test
    void queueIterator() {
        boolean x = false;
        boolean i = false;
        expected = new GenericQueue<Integer>(1);
        actual = new GenericQueue<Integer>(1);
        if (expected.iterator() != null) {
            x = true;
        }
        if (actual.iterator() != null) {
            i = true;
        }
        assertEquals(x,i, "Queue Array is not equal");
    }

    /*
        Check whether the queue is Set with index
     */
    @Test
    void queueSet() {
        boolean x = false;
        boolean i = false;
        expected = new GenericQueue<>(1);
        actual = new GenericQueue<Integer>(1);

        expected.set(1,2);
        actual.set(1,2);

        assertEquals(expected.getHead().data, actual.getHead().data, "Queue is not equal");
    }

    // Test with print from Generic List
    @Test
    void TestPrint() {
        expected.enqueue(2);
        expected.enqueue(5);
        expected.enqueue(8);
        expected.enqueue(23);
        System.out.println("____Testing Print Method_____");
        expected.print();
    }
}
