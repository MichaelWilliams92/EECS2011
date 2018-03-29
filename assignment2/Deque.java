/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 2
 * Student Name: 
 * Student cse account:  
 * Student ID number:  
 **********************************************************/

package ASSIGNMENT2;

import java.util.Stack;

public class Deque<E> {

	/********* private fields ************************/
	private Stack<E> head = new Stack<E>(); // the head of the deque
	private Stack<E> tail= new  Stack<E>(); // the tail of the deque

	int counter = 0; // counter used to find the size of the deque

	/** default no-parameter constructor */
	public Deque() {

	}

	/**
	 * 
	 * Returns the number of elements in the deque
	 * 
	 * Runs in O(1) running time.
	 * 
	 * @return the size of the deque
	 */
	public int size(){
		return counter;
	}

	/**
	 * 
	 * Adds an element to the first index of the deque
	 * 
	 * Runs in O(n) running time
	 * 
	 * @param element
	 * 				generic element that can be added in the first index
	 */
	public void addFirst(E e) {
		if (isEmpty()) {
			head.push(e);
			tail.push(e);
			counter++;
			
		} else {
			
			tail.push(e);
			for (int i = 0; i < counter; i++) {
				tail.push(head.pop());

			}
			head.push(e);

			for (int i = 0; i < counter; i++) {
				head.push(tail.pop());

			}
			counter++;
		}
	}

	/**
	 * 
	 * Adds an element to the last index of the deque
	 * 
	 * Runs in O(n) running time
	 * 
	 * @param element
	 * 				generic element that can be added in the last index
	 */
	public void addLast(E e) {
		if (isEmpty()) {
			head.push(e);
			tail.push(e);
			counter++;
			
		} else {
			head.push(e);
			
			for (int i = 0; i < counter; i++) {
				head.push(tail.pop());

			}
			tail.push(e);

			for (int i = 0; i < counter; i++) {
				tail.push(head.pop());

			}
			counter++;
		}
	}

	/**
	 * 
	 * Returns the element at the first index
	 * 
	 * Runs on O(1) running time
	 * 
	 * @return
	 * 			Returns the element in the first index
	 */
	public E first() {
		return tail.peek();
	}

	/**
	 * 
	 * Returns the element at the last index
	 * 
	 * Runs on O(1) running time
	 * 
	 * @return
	 * 			Returns the element in the last index
	 */
	public E last() {
		return head.peek();
	}

	/**
	 * 
	 * Removes the element at the last index and returns it
	 * 
	 * Runs in O(n) running time
	 * 
	 * @return
	 * 			Returns the element that was removed
	 */
	public E removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			E e = head.pop();
			
			for (int i = 0; i < counter - 1; i++) {
				head.push(tail.pop());

			}
			tail.pop();
			counter--;
			
			for (int i = 0; i < counter; i++) {
				tail.push(head.pop());

			}
			return e;
		}
	}

	/**
	 * 
	 * Removes and returns the first element of the deque
	 * (null if empty)
	 * 
	 * Runs in O(n) running time
	 * 
	 * @return
	 * 			Returns the element that was removed
	 */
	public E removeFirst() {
		if (isEmpty()) {
			return null;
			
		} else {
			E e = tail.pop();
			
			for (int i = 0; i < counter - 1; i++) {
				tail.push(head.pop());

			}
			head.pop();
			counter--;
			for (int i = 0; i < counter; i++) {
				head.push(tail.pop());

			}
			
			return e;
		}
	}

	/**
	 * 
	 * Tests whether the deque is empty
	 * 
	 * Runs in O(1) running time
	 * 
	 */
	public boolean isEmpty() {
		return counter == 0;
	}
	/**
	 * 
	 * Returns the deque in a String representation
	 * 
	 * Runs in O(1) running time
	 * 
	 */
	public String toString() {
		return head.toString();
	}

	public static void main(String[] args) {
		Deque<Integer> test = new Deque<Integer>();
		
		test.addLast(5);
		System.out.println(test);
		test.addFirst(3);
		System.out.println(test);
		test.addFirst(7);
		System.out.println(test);
		Integer b = test.first();
		System.out.println(b);
		Integer c = test.removeLast();
		System.out.println(c);
		int d = test.size();
		System.out.println(d);
		int e = test.removeLast();
		System.out.println(e);
		Integer f = test.removeFirst();
		System.out.println(f);
		test.addFirst(6);
		System.out.println(test);
		Integer g = test.last();
		System.out.println(g);
		test.addFirst(8);
		System.out.println(test);
		boolean h = test.isEmpty();
		System.out.println(h);
		Integer i = test.last();
		System.out.println(i);

		System.out.println(test);

	}

}
