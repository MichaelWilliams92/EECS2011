package assignment1;

/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 1: Polygon Hierarchy
 * Student Name:   ?
 * Student cse account:  ?
 * Student ID number:  ? 
 **********************************************************/

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * The class SimplePolygon implements the Polygon interface.
 * 
 * It is intended to be further extended by ConvexPolygon.
 * 
 * @author andy
 */
public class SimplePolygon implements Polygon {

	/********* protected fields ************************/

	protected int n; // number of vertices of the polygon
	protected Point2D.Double[] vertices; // vertices[0..n-1] around the polygon
									// boundary

	/********* protected constructors ******************/

	/**
	 * constructor used in the static factory method getNewPoly()
	 * 
	 * @param size
	 *            number of edges (also vertices) of the polygon
	 */
	protected SimplePolygon(int size) {
		n = size;
		vertices = new Point2D.Double[n]; //will create an array of size n.  This
		                                  //will be the vertices for the polygon
	}

	
	
	/** default no-parameter constructor */
	protected SimplePolygon() {
		// TODO: place your code here
		n = 3; //size is lowest size possible for a polygon
		vertices = new Point2D.Double[n];
		Random m;
		double x;
		double y;
		
		for(int i = 0; i < n; i ++){
			m = new Random();
			x = 10 * m.nextDouble();
			y = 10 * m.nextDouble();
			
			vertices[i] = new Point2D.Double(x, y);
			
		}//for loop to create random x and y points and place them in a vertex.

	}//Default constructor creates a polygon of size 3 as the default.
	/********* public getters & toString ***************/

	/**
	 * static factory method constructs and returns an unverified
	 * simple-polygon, initialized according to user provided input data. Runs
	 * in O(n) time.
	 * 
	 * @return an unverified simple-polygon instance
	 */
	public static SimplePolygon getNewPoly() {
		
		int size = 0;
		Scanner input = new Scanner (System.in);
		System.out.println("Enter your file name with extension");
		String name = input.next();
		File file = new File(name); //file should be inputted by user
		
		try {
	         input = new Scanner(file);

	        while(input.hasNextLine()){                 //assumes the x and y coordinates of 1
	        	                                        //point are on a single line and that 
	        	                                        //the file only contains the coordinates
	        size = size + 1; //each line have the info for a point, ie each line is a point
	        input.nextLine();
	        
	        }//while loop

	    } catch (FileNotFoundException e1) {
	            System.out.println("File not found.  Nice try");
	    }//catch
		
		//the try catch statement above will read the file and determine the size variable
		//remember to consider different types of text files that may cause problems
		//user will input data which we use to determine the size
	
		
		SimplePolygon p = new SimplePolygon(size);
		double x;
		double y;
		
		try {
	         input = new Scanner(file);
            int i = 0;
	        
	        while(input.hasNextLine()){   
	        	
	          x = input.nextDouble();
	          y = input.nextDouble();
	          p.vertices[i] = new Point2D.Double(x, y);
	          i++;
	          
	          if(input.hasNextLine())
	          input.nextLine();
	          
	        	
	        }//while loop

	    } catch (FileNotFoundException e1) {
	            System.out.println("File not found.  Nice try");
	            e1.printStackTrace();
	    }//catch
		
		//The try catch above takes the x and y coordinates in the file and places them into
		//the points of vertices
		
		return p;
		
	}//getNewPoly.  make a try catch exception in case file is not found
	//Also change code so it takes a file from the user, specified by the user.

	/**
	 * 
	 * @return n, the number of edges (equivalently, vertices) of the polygon.
	 */
	public int getSize() {
		return n;
	}


	/**
	 * 
	 * @param i
	 *            index of the vertex.
	 * @return the i-th vertex of the polygon.
	 * @throws IndexOutOfBoundsException
	 *             if {@code i < 0 || i >= n }.
	 */
	public Point2D.Double getVertex(int i){
		try{ return vertices[i];
			
		} catch (IndexOutOfBoundsException e1){
		  System.out.println("Index out of bounds.  Returning null");
		}
		return null;
	}
	
	
	/**
	 * @return a String representation of the polygon in O(n) time.
	 */
	@Override
	public String toString() {
		String string = null;
		
		for(int i = 0; i < this.getSize() - 1; i ++){
			string += vertices[i] + ", ";
			
			//string = vertices[i].getX() + "," + vertices[i].getY();
			
		}//for loop concatening
		
		string += vertices[n-1];
		
		
		return string; // TODO: replace this line with your code
		
		//What exactly is the string representation of the polygon?
	}

	/************** utilities *********************/

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 *            three input points.
	 * @return twice the signed area of the oriented triangle (a,b,c). Runs in
	 *         O(1) time.
	 */
	public static double delta(Point2D.Double a, Point2D.Double b,
			Point2D.Double c) {
		
		double Xa = a.getX();
		double Xb = b.getX();
		double Xc = c.getX();
		double Ya = a.getY();
		double Yb = b.getY();
		double Yc = c.getY();
		double delta = (Xa * (Yb - Yc)) - (Ya * (Xb - Xc)) + ((Xb * Yc) - (Yb * Xc));
		
		return delta;
	}//keep in mind the method is built around the assumption that ur given the ordered
	//sequence of the 3 points, respectively a, b, and then c.

	/**
	 * @param a
	 * @param b
	 *            end points of line-segment (a,b).
	 * @param c
	 * @param d
	 *            end points of line-segment (c,d).
	 * @return true if closed line-segments (a,b) and (c,d) are disjoint. Runs
	 *         in O(1) time.
	 */
	public static boolean disjointSegments(Point2D.Double a, Point2D.Double b,
			Point2D.Double c, Point2D.Double d) {
		
		if(Line2D.linesIntersect(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY(), d.getX(), d.getY()))
			return false;
		else 
			return true;
		
	}

	/**
	 * @param i
	 * @param j
	 *            indices of two edges of the polygon.
	 * @return true if the i-th and j-th edges of the polygon are disjoint. Runs
	 *         in O(1) time.
	 * @throws IndexOutOfBoundsException
	 *             if i or j are outside the index range [0..n-1].
	 */
	public boolean disjointEdges(int i, int j){
		
		try{ 
			
			double x1 = vertices[i].getX();
			double y1 = vertices[i].getY();       //x and y coordinates 1 and 2 are for edge i
			double x2;
			double y2;
			double x3 = vertices[j].getX();      //x and y coordinates 3 and 4 are for edge j
			double y3 = vertices[j].getY();
			double x4;
			double y4;
			
			if(i == this.getSize() - 1){
				 x2 = vertices[0].getX();             //if its the last point in the array,
				 y2 = vertices[0].getY();             //connect it to the first point
			}
			else{
				x2 = vertices[i + 1].getX();          //else connect it to the next point
				y2 = vertices[i + 1].getY();
			}//if else loop
			
			if(j == this.getSize() - 1){
				 x4 = vertices[0].getX();             //if its the last point in the array,
				 y4 = vertices[0].getY();             //connect it to the first point
			}
			else{
				x4 = vertices[j + 1].getX();          //else connect it to the next point
				y4 = vertices[j + 1].getY();
			}//if else loop
			
			if(Line2D.linesIntersect(x1, y1, x2, y2, x3, y3, x4, y4))
				return false;
			else 
				return true;
			
		} catch (IndexOutOfBoundsException e1){
			System.out.println("one of your indices are out of bounds");
			return false;
		}
	}//This large try will find the coordinates of the ends of the 2 edges being compared
	//and see if they are disjoint

	/**
	 * This method verifies whether the claimed "simple-polygon" is indeed
	 * simple.
	 * 
	 * @return true if the polygon is simple. Runs in O(n^2) time.
	 */
	public boolean isSimple() {
		
		boolean simple = true;
		
		for(int edge1 = 0; edge1 < this.getSize() - 1; edge1++){
		//int edge1 = 4; //edge 1 will be int i that is sent to the disJointEdges method
		               // 
		
		for(int i = edge1 - 2; i >= 0; i--){
			
			if(this.disjointEdges(edge1, i) == false)
				simple = false;
					
		}                        //This for loop will check all edges before the given edge1
		                         //that are not adjacent.  Returns false if any two edges intersect              
		
		for(int i = edge1 + 2; i < this.getSize() - 1; i++){
			
			if(this.disjointEdges(edge1, i) == false)
				simple = false;
			
		}   //this for loop will check all edges after the given edge1 that are not adjacent
		    //Returns false if any 2 edges intersect
			
		}//This is the first for loop.  It will Traverse each edge.  At each edge of the polygon
		 //It will traverse through all other polygons not adjacent to it and check if it intersects.
		//with any other lines.  If it does, even once, simple = false; else simple will be true;
		
		return simple;
	}

	/************ perimeter & area ***************/

	/**
	 * 
	 * @return the sum of the edge lengths of the polygon. Runs in O(n) time.
	 */
	public double perimeter() {
		
	    double perimeter = 0.0;
	    for(int i = 0; i < n -1; i++){
	    	
	    	perimeter += vertices[i].distance(vertices[i+1]);
	    }
	    
	    perimeter += vertices[n-1].distance(vertices[0]);
	    return perimeter;
	    
	}//perimeter
		

	/**
	 * 
	 * @return area of the polygon interior. Runs in O(n) time not counting the
	 *         simplicity test.
	 * @throws NonSimplePolygonException
	 *             if the polygon is non-simple.
	 */
	public double area() {
		double area = 0.0;
		try{
			
			if (isSimple() == false)
					throw new NonSimplePolygonException();
			
			for(int i = 0; i < n - 1; i++){
				area += (vertices[i].getX() * vertices[i+1].getY()) - (vertices[i].getY() * vertices[i+1].getX());
			}
			
		 } catch (NonSimplePolygonException e1){
			 System.out.println("This is not a simple polygon");
		 }
		
		
		
		return Math.abs(0.5 * area);
	}

}
