/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 4
 * Student Name:         Michael Williams
 * Student cse account:  mw1992
 * Student ID number:    211087798
 **********************************************************/

package assignment4;
import assignment4.NutsAndBolts;


/**
 * 
 * @author Michael Williams
 * 
 * This is the tester class for the NutsAndBolts class.  In this tester, 2 Arrays are hard coded, and sent to the method
 * for computation.  The arrays are returned in a sorted manner, such that a nut in the nuts array matches to its
 * unique bolt in the bolts array.  More specifically, in the 2 arrays that are returned, nuts[i] matches bolts[i], 
 * where i is an index of the arrays.
 * 
 * Both arrays must contain the same elements, and therefore, the same size.  Ordering does not matter.
 * This information is congruent with the information the professor provided us both on the website forum and
 * assignment pdf.  The numbers in each array refer to the sizes of each individual nut or bolt, so numbers cannot
 * be repeated.
 * 
 * For neatness sake, only 1 example of input is provided in the coding.  Further input and 
 * the appropriate output can be seen in the Test Cases File.
 *
 */
public class NutsAndBoltsTester {

public static void main(String[]args){
	
	NutsAndBolts mine = new NutsAndBolts(); 
	
	int nuts[] = {0, 4, 7, -2};     
	int bolts[] ={4, -2, 0, 7};    
	mine.sort(nuts, bolts);
	
	System.out.println();
	System.out.print("Nuts: {");
	for(int i = 0; i < nuts.length; i ++){
		if(i == nuts.length - 1){ System.out.print(nuts[i]);}
		else
		System.out.print(nuts[i] + ", ");
		}
	System.out.print("}");
	
	//The above prints out the sorted first Array
	//The below prints out the sorted Second array
	
		System.out.println();
	System.out.print("Bolts: {");
	for(int i = 0; i < nuts.length; i ++){	
		if(i == nuts.length - 1){ System.out.print(bolts[i]);}
		else
		System.out.print(bolts[i] + ", ");  
		}
		System.out.println("}");
		

	
}//main tester method
}//Nuts and Bolts