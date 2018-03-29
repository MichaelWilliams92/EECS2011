package assignment1;

/**
* EECS2011: Fundamentals of Data Structures,  Fall 2014
* Assignment 1: Polygon Hierarchy
* Student Name:   ?
* Student cse account:  ?
* Student ID number:  ? 
**********************************************************/

/**
* PolygonTester should enable a thorough testing of the polygon hierarchy.
* 
* It should provide an easy to read input-output recording of the test cases.
* 
* The student should also submit these recorded test results as part of
* Assignment1.
* 
* @author andy
*/
public class PolygonTester {

	// TODO: place additional test-helper methods here if you like
	public static void main(String[] args) throws NonSimplePolygonException{
		//SimplePolygon q = getNewPoly();
		
		ConvexPolygon c1 = new ConvexPolygon();
		String s = SimplePolygon.getNewPoly().toString();
		System.out.println("*******************FOR P1*******************");
		System.out.println("Coordinates of p1 is: " + s);
		System.out.println("The size of p1 is: " + SimplePolygon.getNewPoly().getSize());
		System.out.println("The second last vertex of p1 is: " + SimplePolygon.getNewPoly().getVertex(1));
		System.out.println("The last vertex of p1 is: " + SimplePolygon.getNewPoly().getVertex(2));
		System.out.println("Disjoint Edges between the 2nd last and last edges: " + SimplePolygon.getNewPoly().disjointEdges(0, 2));
		System.out.println("p1 is simple? " + SimplePolygon.getNewPoly().isSimple());
		System.out.println("The perimeter of this polygon is: " + SimplePolygon.getNewPoly().perimeter());
		System.out.println("Is this polygon convex? " + c1.isConvex());
		System.out.println("The area of this polygon is: " + SimplePolygon.getNewPoly().area());

		
		
		
		
		
		
	}

}
