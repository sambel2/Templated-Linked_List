/*
	By: Sergio Ambelis Diaz
	CS 342 - Fall 2022
	NetId: sambel2
	UIC Email: sambel2@uic.edu
	Description: Implement an Iterator design pattern; allowing users to access multiple
	custom Iterators for my data structures.
 */

public class GLProject {

	public static void main(String[] args) {
		GenericQueue<Integer> q1 = new GenericQueue<Integer>(9);


//		q1.enqueue(4);
//		q1.enqueue(5);
//		q1.enqueue(6);

		GLListIterator<Integer> g1 = new GLListIterator<>(q1.getHead(), 4);
		q1.descendingIterator(q1.getHead());
		System.out.println("Size of list is " + g1.next());



		GenericStack<Integer> g2 = new GenericStack<Integer>(1);
//		g1.enqueue(4);
//		g1.enqueue(5);
//		g1.enqueue(6);
//		g1.getLength();
//		g1.print();
//		System.out.println("Size of list is " + g1.getLength());
////		g1.dequeue();
//		//g1.dequeue();
//		g1.print();
//		System.out.println("Size of list is " + g1.getLength());
//		g1.push(11);
//		g1.push(12);
//		g1.push(13);
//		g1.push(14);
//		g1.push(15);
//		g1.pop();
//		g1.print();
//		System.out.println("Size of list is " + g1.getLength());
//		g1.removeTail();
//		g1.print();
//		System.out.println("Size of list is " + g1.getLength());


	}
}
