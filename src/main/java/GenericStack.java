/*
	By: Sergio Ambelis Diaz
	CS 342 - Fall 2022
	NetId: sambel2
	UIC Email: sambel2@uic.edu
	Description: Implement an Iterator design pattern; allowing users to access multiple
	custom Iterators for my data structures.
 */

public class GenericStack<T> extends GenericList<T> implements Iterable<T> {

    /*
        This is a traditional reference to the tail of the list.
     */
    private Node<T> tail;


    public GenericStack (T data) {
        Node<T> head = new Node<T>(data);
        setHead(head);
        tail = head;
        setLength(1);
    }

    /*
       Push adds element to the stack from the end/tail of the list
     */
    public void push(T data) {
        Node<T> top = tail;
        // while stack is not null
        if (top != null) {
            add(data);   //    adds the data using the add method
        }
        // out of bounds or not found.
    }

    /*
       Pop removes element from the tail/end of the list
     */
    public T pop() {
        Node<T> top = tail;
        // Iterate to the end
        if (top != null) {
            return removeTail();  //    removes the data using the delete method and returns
        }
        // out of bounds or not found.
        return null;
    }

    /*
       Adds the value to the list. This method is abstract since the
       implementation depends on what the data structure is.
    */
    @Override
    public void add(T data) {
        Node<T> node = new Node<T>(data);
        int inc = getLength();
        if (getHead() == null) {
            tail = node;
            setHead(node);
        } else {
            setLength( inc + 1);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    /*
        Retrieves and removes the tail of the list using the tail data
        member.
    */
    public T removeTail() {
        Node<T> temp = tail;
        int dec = getLength();
        if (temp != null) {
            setLength( dec - 1);
            tail = tail.prev; // previous node becomes the tail
            temp.prev = null; // then we point temp tail to null (Java automatically collects garbage)
            tail.next = null; // tail next points to null
        } else {
            return null;
        }
        return temp.data;
    }

}
