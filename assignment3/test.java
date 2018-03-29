package assignment3;


import java.util.Collections;
import java.util.PriorityQueue;

public class test
{
	
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	
	public test()
	{
		
	}
	public void insert(int e)
	{
		
		if (maxHeap.isEmpty())
		{
			maxHeap.add(e);
		}
		else if (minHeap.isEmpty() && !maxHeap.isEmpty())
		{
			if (e >= (maxHeap.peek()))
			{
				minHeap.add(e);
			}
			else
			{
				minHeap.add(maxHeap.poll());
				maxHeap.add(e);
			};
		}
		else if (e >= (maxHeap.peek()))
		{
			minHeap.add(e);
			if (minHeap.size() == maxHeap.size() + 2)
			{
				maxHeap.add(minHeap.poll());
			}
		}
		else 
		{
			maxHeap.add(e);
			if (maxHeap.size() == minHeap.size() + 2)
			{
				minHeap.add(maxHeap.poll());
			}
		}
	}
	
	
	public Integer getMedian()
	{
		if (maxHeap.isEmpty())
		{
			return null;
		}
		
		return maxHeap.peek();
	}
	
	public Integer removeMed()
	{
		Integer median = maxHeap.poll();
		
		if (maxHeap.isEmpty() & !minHeap.isEmpty())
		{
			maxHeap.add(minHeap.poll());
		}
		if (minHeap.size() == maxHeap.size() + 2)
		{
			maxHeap.add(minHeap.poll());
		}
		
		return median;
	}
	
	public static void main(String[] args)
	{
		test a = new test();
		a.insert(17);
		a.insert(-4);
		a.insert(13);
		a.insert(-7);
		a.insert(-13);
		a.insert(15);
		a.insert(5);
		a.insert(2);
		/**
		System.out.println(a.getMedian());
		System.out.println(a.removeMed());
		System.out.println(a.maxHeap);
		System.out.println(a.minHeap); 
		**/
			
			System.out.println(a.getMedian());
			System.out.println(a.removeMed());
			System.out.println(a.getMedian());
			a.insert(7);
			System.out.println((a.getMedian()));
			a.insert(-2);
			System.out.println(a.removeMed());
			System.out.println(a.maxHeap);
			System.out.println(a.minHeap);
	
	}
	
	/**8)multiple insert and remove instructions with given elements
	input:  a.insert(-3);
			a.insert(-1);
			a.insert(5);
			a.insert(7);
		    a.insert(12);
			
			System.out.println(a.getMedian());      CONSIDER DELETING THIS EXAMPLE
			System.out.println(a.removeMed());
			System.out.println(a.getMedian());
			a.insert(7);
			System.out.println((a.getMedian()));
			a.insert(-2);
			System.out.println(a.removeMed());
			System.out.println(a.maxHeap);
			System.out.println(a.minHeap);
			
	output: -1
	         5
	         5
	         5
	         [-2, -3]
	         [7, 12, 7] **/
}

	