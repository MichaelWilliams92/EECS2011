package assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Question3 {
	
	public static PriorityQueue<Node> H = new PriorityQueue<Node>();
	
	private static class Node<E, K>
	{
		private E name;
		private K element;
		
		public Node(E flyer, K k)
		{
			element = k;
			name = flyer;
		}
	}//this is the private node constructor
	
	public static void topKFlyers(List x){

	
		for (int i = 0; i < x.size(); i++){
			x.add();
		}
		
		System.out.println(H);
		
		
	}//method
	
	
	public static void main(String []args){
		
		Node a = new Node("USA", 0.83);
		Node b = new Node("JAPAN", 0.32);
		Node c = new Node("CANADA", 5.24);
		Node d = new Node("IRAQ", 3.74);
		List<Node> x= new ArrayList<Node>();
		x.add(a);
		x.add(b);
		x.add(c);
		x.add(d);
		
		
		for(int i = 0; i < x.size(); i ++){
			System.out.println(x.get(i));
		}
		
		
		
		System.out.println(a.element);
		//topKFlyers(x);
		
	}//main tester

}