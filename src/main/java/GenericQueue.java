/*
	By: Sergio Ambelis Diaz
	CS 342 - Fall 2022
	NetId: sambel2
	UIC Email: sambel2@uic.edu
	Description: Implement an Iterator design pattern; allowing users to access multiple
	custom Iterators for my data structures.
 */

public class GenericQueue<T> extends GenericList<T> {
    /*
        This is a traditional reference to the tail of the list.
     */
    private Node<T> tail;

    public GenericQueue (T data) {
        Node<T> head = new Node<T>(data);
        setHead(head);
        tail = head;
        setLength(1);
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
        Adds data to the top/tail of list
     */
    public void enqueue(T data) {
        Node<T> top = tail;

        // Iterate to the end but should be first index
        if (top != null) {

            add(data);   //    adds the data using the add method
        }
    }

    /*
        dequeue removes element at the front/head of the list
     */
    public T dequeue() {
        Node<T> top = tail;
        // Iterate to the end
        if (top != null) {
            delete();  //    removes the data using the delete method
        }
        // out of bounds or not found.
        return null;
    }

    /*
        Retrieves and removes the tail of the list using the tail data
        member.
    */
    public T removeTail() {
        Node<T> temp = tail;
        int dec = getLength();
        int count = 0;
        while (temp != null) {
            if (count == getLength() - 1) {
                temp = tail.prev; //previous node becomes the tail
                temp.prev = null; // then we point temp tail to null (Java automatically collects garbage)
                setLength(dec - 1);  // decrement the length of nodes
                return temp.data;
            }
            temp = tail.prev;
            count += 1;
        }
        return null;
    }
}