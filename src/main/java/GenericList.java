/*
	By: Sergio Ambelis Diaz
	CS 342 - Fall 2022
	NetId: sambel2
	UIC Email: sambel2@uic.edu
	Description: Implement an Iterator design pattern; allowing users to access multiple
	custom Iterators for my data structures.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class GenericList<T> implements Iterable<T> {
    // Two data fields ✓
    private Node<T> head;
    private int length;
    //    private int index;


    //  Defining inner Note<T> class
    public class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        //  Create constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    } //end of Node Class

    // Prints out data
    public void print() {
        if (head != null) {
            Node<T> temp = head;
            // Check if the is next and iterates to get the next value
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        } else
            System.out.println("Empty List");
    }

    // add value data to our list
    public abstract void add(T data);

    //  Getter for get Head in list
    public Node<T> getHead() {
        return head;
    }

    //  Setter for get Head in list
    public void setHead(Node<T> elem) {
        head = elem;
    }

    //  Getter for get length of the list
    public int getLength() {
        return length;
    }

    //  Setter for length of the list
    public void setLength(int size) {
        length = size;
    }


    @Override
    public Iterator<T> iterator() {
        return new GLLIterator<T>(head);
    }


    /*
            Returns the first value of the list and deletes the node. If the list is
            empty, return null.
     */
    public T delete() {
        Node<T> temp = head;
        int dec = getLength();
        if (temp != null) {
            setLength(dec - 1);
            head = head.next; //    next becomes the head
            temp.next = null; //    then we point head to null (Java automatically collects garbage)
        } else {
            return null;
        }
        return temp.data;
    }

    /*
            This method stores and returns all values currently in
            the list into an ArrayList and returns it. At the end of this method, your list should be
            empty.
     */
    public ArrayList<T> dumpList() {
        ArrayList<T> array = new ArrayList<T>();
        Node<T> temp = head;
        if (temp != null) {
            while (temp != null) {
                array.add(temp.data);
                temp = temp.next;
            }
        } else {
            System.out.println("Empty List");
            return null;
        }
        return array;
    }

    /*
            Returns the value at the specified index or null if the index is
            out of bounds.
     */
    public T get(int index) {
        int count = 0;
        Node<T> temp = head;
        // Search for the index and return value.
        while (temp != null) {
            if (count == index) {
                return temp.data;
            }
            count += 1;
            temp = temp.next;
        }
        // out of bounds or not found.
        return null;
    }

    /*
            Replace the element at specified position in the list
            with the specified element and return the element previously at the specified position.
            Return null if index is out of bounds
     */
    public T set(int index, T element) {
        int count = 0;
        Node<T> temp = head;
        T value;
        // iterates until finds index and returns old element while changing to new element
        // in given position.
        while (temp != null) {
            if (count == index) {
                value = temp.data;
                temp.data = element;
                return value;
            }
            count += 1;
            temp = temp.next;
        }
        // else if no index or out of bounds then return null
        return null;
    }

    /*
           Returns a list-iterator of the elements of
           this list starting at the specified position.
    */
    public ListIterator<T> listIterator(int index) {
        return new GLListIterator<T>(head, index);
    }

    /*
        Returns an iterator over the elements of the
        list in reverse order( tail to head)
    */
    public Iterator<T> descendingIterator(GenericList<Integer>.Node<Integer> head) {
        return new ReverseGLLIterator(this.head);
    }
}
