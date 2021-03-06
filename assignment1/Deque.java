package assignment1;




/**
* This interface represents the Deque ADT. It is intended to be implemented
* by the class StackDeque.
*
*/

public interface Deque<E> 
{
	/** Returns the number of elements in the deque.*/
	int size();
	
	/** Tests whether the deque is empty.*/
	boolean isEmpty();
	
	/** Returns, but does not remove, the first element of the deque (null if empty).*/
	E first();
	
	/** Returns, but does not remove, the last element of the deque (null if empty).*/
	E last();
	
	/** Insert an element at the front of the deque.*/
	void addFirst(E element);
	
	/** Insert an element at the back of the deque.*/
	void addLast(E element);
	
	/** Removes and returns the first element of the deque (null if empty).*/
	E removeFirst();
	
	/** Removes and returns the last element of the deque (null if empty).*/
	E removeLast();
	
}