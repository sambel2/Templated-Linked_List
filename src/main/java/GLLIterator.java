/*
	By: Sergio Ambelis Diaz
	CS 342 - Fall 2022
	NetId: sambel2
	UIC Email: sambel2@uic.edu
	Description: Implement an Iterator design pattern; allowing users to access multiple
	custom Iterators for my data structures.
 */

import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> {
    GenericList<T>.Node<T> head;

    private int index;

    public GLLIterator(GenericList<T>.Node<T> llElem) {
        this.head = llElem;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (this.head != null) {
            return true;
        }
        return false;
    }

    // create method getData() later in GenericList
    @Override
    public T next() {
        T temp = head.data;
        head = head.next;
        return temp;
    }
}
