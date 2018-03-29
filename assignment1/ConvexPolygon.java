package assignment1;

import java.awt.geom.Point2D;

/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 1: Polygon Hierarchy
 * Student Name:   ?
 * Student cse account:  ?
 * Student ID number:  ? 
 **********************************************************/

/**
 * The class ConvexPolygon extends SimplePolygon.
 * 
 * TODO:_______ Add more Javadoc comments here. ______ ???
 * 
 * @author andy
 */
public class ConvexPolygon extends SimplePolygon {
	
	private static double tester(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
		double value = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY());
		if (value == 0) {
		return 0.0;
		}
		else if (value > 0.0) {
		return 1.0;
		}
		return 2.0;
		}
	
	
	/**
	 * The class ConvexPolygon extends SimplePolygon.
	 * 
	 * TODO:_______ Add more Javadoc comments here. ______ ???
	 * 
	 * @author andy
	 */
	public boolean isConvex()
	{
	double a = tester(vertices[0], vertices[1], vertices[2]);
	double b;
	for (int i = 1; i < n -2; i++)
	{
	b = tester(vertices[i], vertices[i + 1], vertices[i + 2]);
	if (a != b)
	{
	return false;
	}
	}
	double c = tester(vertices[n -2], vertices[n-1], vertices[0]);
	double d = tester(vertices[n-1], vertices[0], vertices[1]);
	if (a == c && a == d)
	{
	return true;
	}
	return false;
	}
	
	 

 }//is convex

