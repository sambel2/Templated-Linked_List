/*
	By: Sergio Ambelis Diaz
	CS 342 - Fall 2022
	NetId: sambel2
	UIC Email: sambel2@uic.edu
	Description: Implement an Iterator design pattern; allowing users to access multiple
	custom Iterators for my data structures.
 */

import java.util.ListIterator;

public class GLListIterator<T>  implements ListIterator<T> {

    GenericList<T>.Node<T> head;
    GenericList<T>.Node<T> tail;
    private int length;
    private int index;

    /*
        Starts iterating through entire list based on given index.
     */
    public GLListIterator(GenericList<T>.Node<T> listElem, int index) {
        this.head = listElem;
        GenericList<T>.Node<T> temp = head;
        int count = 0;
        // Create index
        while (temp != null) {
            count++;
            this.index = count;
            temp = temp.next;
        }

        // Do a while that traverses to index element
        while (head!= null) {
            if(count == index) {
                return;
            }
            head = head.next;
            count++;
        }
    }

    // check for the next value
    @Override
    public boolean hasNext() {
        if (this.head != null) {
            return true;
        }
        return false;
    }
    // grab the next value
    @Override
    public T next() {
        T temp = head.data;
        head = head.next;
        return temp;
    }
    // check for the previous value
    @Override
    public boolean hasPrevious() {
        if (this.tail != null) {
            return true;
        }
        return false;
    }
    // get the previous
    @Override
    public T previous() {
        T temp = tail.data;
        tail = tail.prev;
        return temp;
    }
    // Returns next index of this object
    @Override
    public int nextIndex() {
        if (head != null) {
            this.index += 1;
            return this.index;
        }
        return 0;
    }

    // Returns last index of this object or -1 is null.
    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {
        // keep empty
    }

    @Override
    public void add(T t) {
        // keep empty
    }
}
