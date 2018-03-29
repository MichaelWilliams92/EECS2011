package assignment1;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args){
	
	double x;
	double y;
	Random m;                            //test code for creating random x and y coordinates
	Random n;
	
	m = new Random();
	n = new Random();
	x = 10 * m.nextDouble();
	y = 10 * m.nextDouble();
	
	System.out.println(x);
	System.out.println(y);
	
	////////////////////////////////////////////////////////////////////////////////////
	 

	
	int a = 0;
	
		File file = new File("numbers.txt");
		
		try {
	        Scanner input = new Scanner(file);

	        while(input.hasNextLine()){                 //assumes the x and y coordinates of 1
	        	                                        //point are on a single line
	        a = a + 1;  //each line have the info for a point, ie each line is a point
	        input.nextLine();
	        }//while loop

	    } catch (FileNotFoundException e1) {
	            System.out.println("File not found.  Nice try asshole");
	           // e1.printStackTrace();
	    }//catch
		
		//the try catch statement above will read the file and determine the size variable
	  
		System.out.println(a);   

//This method calculates the size of the polygon, ie how many points it has
		//that is, assuming each line contains the info for each each point.
 //Testing try catch statement to read files and determine size/coordinates
		
//////////////////////////////////////////////////////////////////////////////////////////////
		
		// ***  System.out.println(System.getProperty("user.dir"));  //USE TO GET FILE DIR *******
	
/////////////////////////////////////////////////////////////////////////////////////////////
		
		Point2D.Double[] vertices = new Point2D.Double[a]; //creates array of size a
		//double x;
		//double y;
		
		try {
	        Scanner input = new Scanner(file);
            int i = 0;
	        
	        while(input.hasNextLine()){   
	        	
	          x = input.nextDouble();
	          y = input.nextDouble();
	          vertices[i] = new Point2D.Double(x, y);
	          i++;
	          
	          if(input.hasNextLine())
	          input.nextLine();
	          
	        	
	        }//while loop

	    } catch (FileNotFoundException e1) {
	            System.out.println("File not found.  Nice try asshole");
	            e1.printStackTrace();
	    }//catch
		
		for(int q = 0; q < a; q++){
			System.out.println(vertices[q].getX());
			System.out.println(vertices[q].getY());
			
		}//for loop
		
		//The method above puts all x and y coordinates into the points of the array
	
///////////////////////////////////////////////////////////////////////////////////////////////		
        
		 x = 2.5;
		 y = 9.4;
	
	    Point2D.Double[] vertices1 = new Point2D.Double[1];
	    vertices1[0] = new Point2D.Double(x, y);
	    
		try{ System.out.println(vertices1[0].getX());
		
		} catch (IndexOutOfBoundsException e1){
		  System.out.println("Index out of bounds.  Returning null");
		}
		
		//simple try catch to make sure the method getVertices works fine
		
///////////////////////////////////////////////////////////////////////////////////////////
	
		Point2D.Double [] vertex = new Point2D.Double [4];
		
		vertex[0] = new Point2D.Double(1.0, 2.0);
	    vertex[1] = new Point2D.Double(3.0, 6.0);
		vertex[2] = new Point2D.Double(53.0, 32.0);
		vertex[3] = new Point2D.Double(23.0, 74.0);
/*		
		double Xa = vertex1.getX();
		double Xb = vertex2.getX();
		double Xc = vertex3.getX();
		double Ya = vertex1.getY();
		double Yb = vertex2.getY();
		double Yc = vertex3.getY();
		double delta = (Xa * (Yb - Yc)) - (Ya * (Xb - Xc)) + ((Xb * Yc) - (Yb * Xc));
	//	System.out.println(delta);
		
	//	Line2D.Double line1 = new Line2D.Double(vertex1, vertex2);
	//	Line2D.Double line2 = new Line2D.Double(vertex3, vertex4);
		
		if(Line2D.linesIntersect(vertex1.getX(), vertex1.getY(), vertex2.getX(), vertex2.getY(), vertex3.getX(), vertex3.getY(), vertex4.getX(), vertex4.getY()))
			System.out.println("The lines intersect");
		else System.out.println("They do not interesect");
*/		
		int i = 0;
		int j = 2;
			
			double x1 = vertex[0].getX();
			double y1 = vertex[0].getY();       //x and y coordinates 1 and 2 are for edge i
			double x2;
			double y2;
			double x3 = vertex[2].getX();      //x and y coordinates 3 and 4 are for edge j
			double y3 = vertex[2].getY();
			double x4;
			double y4;
			
				// x2 = vertices[0].getX();             //if its the last point in the array,
			//	 y2 = vertices[0].getY();             //connect it to the first point
			
			
				x2 = vertex[1].getX();          //else connect it to the next point
				y2 = vertex[1].getY();
		
			
		
				// x4 = vertices[0].getX();             //if its the last point in the array,
				// y4 = vertices[0].getY();             //connect it to the first point
			
		
				x4 = vertex[3].getX();          //else connect it to the next point
				y4 = vertex[3].getY();
			
				
				
			
			if(Line2D.linesIntersect(x1, y1, x2, y2, x3, y3, x4, y4))
				System.out.println("lines intersect so this is not a simple polygon");
			else 
				System.out.println("lines do not intersect.  This is a simple polygon");
		
		
		//The above segments are all used to test the lines, and if they are disjoint.
		
		
/////////////////////////////////////////////////////////////////////////////////////////////
			
			int q = (5 << 16) | 0;
			int e = (5 << 16);
			int register[] = {q};
			System.out.println(register[0]);
			System.out.println(e);
	}
	}


