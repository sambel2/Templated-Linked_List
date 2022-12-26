/*
	By: Sergio Ambelis Diaz
	CS 342 - Fall 2022
	NetId: sambel2
	UIC Email: sambel2@uic.edu
	Description: Implement an Iterator design pattern; allowing users to access multiple
	custom Iterators for my data structures.
 */


import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {
    GenericList<T>.Node<T> list;

    // Constructor for reverse iterator
    public ReverseGLLIterator(GenericList<T>.Node<T> revElem) {
        this.list = revElem;
        // Do a while that traverses backwards
        while (list.next != null) {
            list = list.next;
        }
    }

    @Override
    public boolean hasNext() {
        if (this.list != null) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        T temp = list.data;
        list = list.prev;
        return temp;
    }
}
