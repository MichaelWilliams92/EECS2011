package assignment1;

	/**********************************************************
	 * EECS2011: Fundamentals of Data Structures,  Fall 2014
	 * Assignment 1: Polygon Hierarchy
	 * Student Name:   
	 * Student cse account:  
	 * Student ID number:  
	 **********************************************************/

	import java.awt.geom.Point2D;

	/**
	 * This interface represents the Polygon ADT. It is intended to be implemented
	 * by the class SimplePolygon, and further extended by the class ConvexPolygon.
	 * This interface provides methods to compute polygon perimeter and polygon
	 * area, as well as getSize and getVertex.
	 * 
	 * @author andy
	 */
	public interface Polygon {

		/**
		 * 
		 * @return the number of edges (equivalently, vertices) of the polygon.
		 */
		int getSize();
		
		/**
		 * 
		 * 
		 * @return the i-th vertex of the polygon.
		 * @throws IndexOutOfBoundsException
		 *             if {@code 0 > i || i >= sides() }
		 */
		Point2D.Double getVertex(int i) throws IndexOutOfBoundsException;
		
		/**
		 * 
		 * @return the sum of the edge lengths of the polygon.
		 */
		double perimeter();
		
		/**
		 * 
		 * @return area of the polygon interior.
		 * @throws NonSimplePolygonException
		 *             if the polygon is non-simple
		 */
		double area() throws NonSimplePolygonException;
	}

	

