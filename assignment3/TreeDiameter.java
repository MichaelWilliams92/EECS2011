/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 3
 * Student Name:         Michael Williams
 * Student cse account:  mw1992
 * Student ID number:    211087798
 **********************************************************/
package assignment3;
/**
 * @author Michael Williams
 *
 * This is assignment question 2.
 * In this program, a binary tree is created from user input, which is hard coded in the 
 * tester section. The max diameter of the created tree is then calculated and printed out. 
 * The max diameter refers to the longest distance between two nodes in the created tree. 
 * 
 * The program contains one main recursive method for calculating the maximum diameter and
 * a helper method for adjusting the final value to its appropriate answer.  The recursive 
 * method doing so runs in O(n) time and the helper method runs in O(1) time.
 * 
 * Also included is a tester method to create the binary tree and run the computation to 
 * determine its maximum diameter.
 * 
 * The rest of the coding, being the first set of following methods and classes, are all
 * implementations for the Nodes themselves and the methods to add nodes to the tree, as well 
 * as accessor methods for the needed node information.
 * 
 * 
 * I only provide 1 test case in the coding below, but there are other
 * test cases as well as their results recorded and submitted in the TestCases File, if needed.  
 */
public class TreeDiameter<E>{
	
	/**
	 * private class to create the specifics of the node itself, as well as its constructor
	 */
	private static class TreeNode<E>{    
		                                        
		private E element;
		private TreeNode<E> left;
		private TreeNode<E> right;
		
		public TreeNode(E e, TreeNode<E> leftNode, TreeNode<E> rightNode){
			
			element = e;
			left = leftNode;
			right = rightNode;
			
		}//Node constructor
	}//private TreeNode Class
	
	
	private TreeNode<E> nodeRoot;
	
	/**
	 * instantiates the root of the binary tree
	 * 
	 * @param e    The element of the node
	 * @return     Returns the Root added
	 */
	public TreeNode<E> addRoot(E e){
		
		nodeRoot = new TreeNode<E>(e, null, null);
		return nodeRoot;
		
	}//addRoot method
	
	/**
	 * creates the left child node of the given parent
	 * 
	 * @param parent  The parent node
	 * @param e       The element of the new node
	 * @return        Returns the newly created node
	 */
	public TreeNode<E> addLeft(TreeNode<E> parent, E e){
		
		TreeNode<E> leftNode = new TreeNode<E>(e, null, null);
		parent.left = leftNode;
		return leftNode;
		
	}//addLeft Method
	
	/**
	 * creates the right child node of the given parent
	 * 
	 * @param parent  The parent node
	 * @param e       The element of the new node
	 * @return        Returns the newly created node
	 */
	public TreeNode<E> addRight(TreeNode<E> parent, E e){
		
		TreeNode<E> rightNode = new TreeNode<E>(e, null, null);
		parent.right = rightNode;
		return rightNode;
		
	}//addRight Method
	
	//The following are the accessor methods
	
	/**
	 * Gets the element from the given node
	 * 
	 * @param node  The node being accessed
	 * @return      returns the node's element
	 */
	public E getElement(TreeNode<E> node){
		
		return node.element;
		
	}//getElement accessor method
	
	/**
	 * Gets the left child node
	 * 
	 * @param node  The node being accessed
	 * @return      Returns the left child Node
	 */
	public TreeNode<E> leftNode(TreeNode<E> node){
		
		return node.left;
		
	}//leftNode accessor method
	
	/**
	 * Gets the right child node
	 * 
	 * @param node  The node being accessed
	 * @return      Returns the right child node
	 */
	public TreeNode<E> rightNode(TreeNode<E> node){
		
		return node.right;
		
	}//rightNode Accessor method
	
	/**
	 * Gets the root of the tree
	 * 
	 * @return  The root node
	 */
	public TreeNode<E> root(){ 
		
		return nodeRoot;
		
	}//root Accessor method
	
	
	//main method below
	
	/**
	 * This recursive method finds the maximum diameter in the created binary tree.  To do this,
	 * an array is first created to contain both the current max diameter and current height.
	 * This will allow the height to be constantly tracked and prevent further recursive calls 
	 * from being made every time the height variable is needed.  More so, it will keep track of
	 * the longest diameter as the tree makes it way back to the root.
	 * 
	 * The method itself is quite simple.  It first recursively makes its way down to the lowest
	 * level, left most node in the tree.  From there, the recursion simulates a  post order 
	 * traversal, where it visits all nodes, children first, and stores the needed information into 
	 * the leftChild and RightChild arrays for use by the parent node, when the traversal reaches
	 * that point. This needed information is the current max diameter and height at that point.
	 * 
	 *  This information is pushed further and further up the tree and updated every time a node is 
	 *  visited, until the root is finally reached and the max diameter and height is calculated one
	 *  last time, giving us our near perfect solution.  
	 *  
	 *  In this recursive method, each node is visited only once.  Therefore, it makes n recursive 
	 *  calls and is thus O(n) time.
	 * 
	 * @param   root  the starting of the tree
	 * @return  returns array containing the diameter and height 
	 */
	private int[] diameter(TreeNode<E> root){
		
		int[] values = new int[2];
		
		if (root == null){
			
			return values;
			
		}//if statement
		
		int[] leftChild = diameter(leftNode(root));
		int[] rightChild = diameter(rightNode(root));
		
		int height = Math.max(leftChild[1], rightChild[1]) + 1;
		int rootDiameter = leftChild[1] + rightChild[1] + 1; //calculates the root diameter at the current node
		int leftDiameter = leftChild[0];                   //calculates the diameter of the left subtree
		int rightDiameter = rightChild[0];                 //calculates the diameter of the right subtree
		
		values[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
		values[1] = height;
		
		return values;
		
	}//Diameter method
	
	/**
	 * The Diameter method, unfortunately, does not provide the precise answer specified in the
	 * question.  It gives us the number of nodes that make up the largest diameter, but not
	 * The actual distance BEWTEEN both nodes.  Therefore, this helper method simply reduces
	 * the acquired diameter value by 1, providing the expected result.  We only take the 
	 * diameter value from the array at this point, as the height is no longer important.
	 * 
	 * This helper method runs in O(1) time.
	 * 
	 * @param tree  The binary tree used
	 * @return      Returns the actual distance of the max diameter
	 */
	public int maxDiameter(TreeDiameter<E> tree){
		
		if(tree.root() == null){
			return 0;
		}//if tree itself is empty, simply return 0
		
		else{
		int[] result = diameter(tree.root());  //calls the diameter method
		
		return result[0] - 1;    //diameter size 
		}//return the diameter
		
	}//MaxDiameter helper method
	

	/**
	 * This is the main tester method.  Here, nodes are simply hard-coded and a binary tree is
	 * created, after which, the maxDiameter method is invoked and the correct answer is
	 * returned to the main method, where it is printed out.
	 * 
	 * For neatness sake, only 1 example of input is provided in the coding.  Further input and 
	 * the appropriate output can be seen in the TestCases File.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		TreeDiameter<Character> tree = new TreeDiameter<Character>();
		TreeNode<Character> root = tree.addRoot('r');
		TreeNode<Character> a = tree.addLeft(root, 'a');
		TreeNode<Character> b = tree.addRight(root, 'b');
		TreeNode<Character> c = tree.addLeft(a, 'c');
		TreeNode<Character> d = tree.addRight(a, 'd');
		TreeNode<Character> e = tree.addLeft(b, 'e');
		TreeNode<Character> f = tree.addRight(b, 'f');
		
		int diameter = tree.maxDiameter(tree);
		System.out.println("Max diameter is " + diameter);
		
	}//tester method
	

}//treeDiameter class
