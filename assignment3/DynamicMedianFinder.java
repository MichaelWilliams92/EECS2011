/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 3
 * Student Name:         Michael Williams
 * Student cse account:  mw1992
 * Student ID number:    211087798
 **********************************************************/
package assignment3;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *@author Michael Williams 
 *
 *This is assignment question 4.
 *In this question a simple Dynamic Median Finder was created.  It takes hard-coded user input
 *from the main tester method and using 2 heaps as its only instance variables, computes the
 *3 methods insert, getMed, and removeMed.  These methods both add to the the heap itself,
 *and remove or simply return the median value amoungst the values in the heap.  The median
 *is depicted as the [n/2]th smallest element in the collection of n elements that make up
 *the heap.  
 *
 *The methods themselves are for the most part quite simple, and run at very efficient times
 *The insert method, which simply inserts an element into the heap, runs at O(log n) time.
 *The getMed method, which returns the median, runs at O(1) time, thanks to the heap's insert
 *implementation that keeps the existing median at the root of the maxHeap.  Lastly, 
 *the removeMed method, which removes and returns the median, runs in O(log n) time, again because
 *of the heap's insert implementation.
 *
 *Also included is the tester method, through which the DynamicMedianFinder class is instantiated, 
 *and the methods are invoked and tested to ensure its correctness.
 *
 *I only provide 1 test case in the coding below, but there are other
 * test cases as well as their results recorded and submitted in the TestCases File, if needed.  
 */
public class DynamicMedianFinder{
	
	private  PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private  PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	
	//maxHeap includes Collections.reverseOrder() to force the reversal of the natural ordering
	 //system of a priority queue.  In other words, this will ensure maxHeap always has the
	//highest values at the top of the heap, whereas minHeap, being a regular Heap, will always 
	//have the smallest value at its top.
	
	/**
	 * This insert method will add a new value to 1 of the 2 heaps, and adjust the heaps
	 * accordingly, so that the median will still be at the top of the maxHeap, while keeping the 2 heaps as 
	 * balanced as possible.  The idea is to store all the values that are greater than or equal
	 * to the current median in the minHeap, and all the values that are less than or equal, in the
	 * maxHeap. This way, the top of maxHeap will always have the median value.  This not only forces the median to remain at the top,
	 * but more so, reassures that the only real balancing that may need doing will just be
	 * in reference to the size of the 2 heaps. 
	 * 
	 * To do this, there are 3 main conditions to consider.  The first, is if the max Heap is
	 * empty.  If it is, we simply add x to it, and the insert method is complete. If not, we 
	 * check the second condition,  being if the minHeap is empty, but the maxHeap isn't.  If this
	 * is the case, we check to see if x is greater then or equal to the top of the maxHeap,
	 * and if so, add x to the minHeap, else we add it to the maxHeap, after taking the top value
	 * of the max heap and placing it in the minHeap.  If neither of these 2 conditions happen, 
	 * a third and final condition is then tested.  That is, if the value x is greater than
	 * or equal to the top value in maxHeap, we add x to the minHeap, and possibly resize the heaps, else
	 * the only possibility left is to add x to the max heap, and then possibly resize the heaps.
	 * 
	 * this process essentially ensures that 1 heap contains the median at its top, and runs at
	 * O(log n) in its worst time, as whenever the heaps are empty, it takes just
	 * O(1) time and whenever we insert to a non-empty heap, we are still only at most accessing
	 * half + 1 of the elements.
	 * 
	 * @param e the value to be inserted into the heap
	 */
	public void insert(int e){
		
		if (maxHeap.isEmpty() == true){
			
			maxHeap.add(e);
		} //1st condition; just add to maxHeap if its already empty
		
		
		else if ((minHeap.isEmpty() == true) && (maxHeap.isEmpty() == false)){
			
			if (e >= (maxHeap.peek())){
				
				minHeap.add(e);
			}
			else{
				
				minHeap.add(maxHeap.poll());
				maxHeap.add(e);
			}
		}//2nd condition; if minHeap is the only empty Heap, then depending on the value
		 //it either goes to the minHeap, or after moving the maxHeap's value, goes to the max heap.
		
		
		else if (e >= (maxHeap.peek())){
			
			minHeap.add(e);
			if (minHeap.size() == maxHeap.size() + 2){
				
				maxHeap.add(minHeap.poll());
			}
		}//3rd condition; if x is greater than or equal to the top value of maxHeap, its added
		 //to minHeap and the heaps are possibly re-balanced.
		else {
			
			maxHeap.add(e);
			if (maxHeap.size() == minHeap.size() + 2){
				
				minHeap.add(maxHeap.poll());
			}
		}//if all else fails, the only possibility is to add x to the maxHeap, and then
		 //possibly re-balance the heaps.
		
	}//insert method
	
	/**
	 * The getMedian method simply returns the median, which thanks to the insert method,
	 * will always be located at the top of the maxHeap, unless of course it is empty, 
	 * in which case, the median does not exist.  
	 * 
	 * Because the only thing being done is having a value returned, the time is O(1) for the 
	 * method.
	 * 
	 * @return  Returns the median value.
	 */
	public Integer getMedian(){
		
		if (maxHeap.isEmpty() == true){
			
			return null;
		}
		
		return maxHeap.peek();
		
	}//getMedian method
	
	/**
	 * the removeMed method removes the median value from the top of the maxHeap, and then 
	 * re-balances the heaps, while keeping the mew median value at the top of the maxHeap.
	 * 
	 * @return  Returns the removed median value.
	 */
	public Integer removeMed()
	{
		Integer median = maxHeap.poll();
		
		if ((maxHeap.isEmpty() == true) & (minHeap.isEmpty() == false)){
		
			maxHeap.add(minHeap.poll());
		}//after removing the median, if there exists an element in minHeap, but none in maxHeap
		// the Top value of the minHeap is added to the maxHeap.
		
		if (minHeap.size() == maxHeap.size() + 2){
			
			maxHeap.add(minHeap.poll());
		}//if the minHeap now contains 2 more elements than the maxHeap, we balance it out by
		//adding the top value of the minHeap to the MaxHeap.
		
		return median;
		
	}//removeMed method
	
	/**
	 * This is the tester method.  Inside, hard-coded values are created and an instance of
	 * the dynamicMedianFinder is made, taking these values and using them as the input for the 
	 * heaps and the methods.
	 * 
	 * For neatness sake, only 1 example of input is provided in the coding.  Further input and 
	 * the appropriate output can be seen in the TestCases File.
	 */
	public static void main(String[] args){
		
		DynamicMedianFinder a = new DynamicMedianFinder();
		
		a.insert(17);
		a.insert(-4);
		a.insert(13);
		a.insert(-7);
		a.insert(-13);
		a.insert(15);
		a.insert(5);
		a.insert(2);
		
		System.out.println(a.getMedian());
		System.out.println(a.removeMed());
		System.out.println(a.maxHeap);
		System.out.println(a.minHeap); 
		
	}//tester method
	
	
}//DynamicMedianFinder class
