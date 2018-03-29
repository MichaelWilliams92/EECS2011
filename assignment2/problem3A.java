/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 2
 * Student Name:   Michael Williams
 * Student cse account:  mw1992
 * Student ID number:  211087798
 **********************************************************/

package assignment2;

import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * Problem 3A is the programmed answer to Question # 3.  This takes an input from the user
 * in the form of RPIE and sends it to 2 other methods which will convert the sent string 
 * to its UPPE and FPIE forms
 * 
 */
public class problem3A {
	
	/**
	 * will take given string and convert to UPEE form
	 * 
	 * @param s
	 * @return
	 */
	public static StringBuffer UPEE(String s){

	Stack<Character> stack1 = new Stack<Character>();
	StringBuffer line = new StringBuffer(s);          //line contains string sent by user
	int lineLength = line.length();
	
	for(int i = 0; i < lineLength; i++){
		
		
		if(line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '*' || line.charAt(i) == '/'){
			stack1.push(line.charAt(i));            //will put operative into stack
			line.deleteCharAt(i);                   //will remove operative
			i--;
			lineLength--;
			
		}           //if char is an operative
		
		if(line.charAt(i) == ')'){
			line.setCharAt(i, stack1.pop()); //pops top stack value and replaces the bracket with it
		}//char is a right bracket
		
	}//for loop to traverse through line.  
	return line;
	
	}//UPIE method
	
	
	/**
	 * 
	 *  This method will take given input and convert it to the FPIE
	 * 
	 * @param s
	 * @return
	 */
	public static StringBuffer FPIE(String s){
		
		Stack<String> stackNum = new Stack<String>();    //StackNum contains the the integers in the given line
		Stack<Character> stackOp = new Stack<Character>(); //StackOp contains the operative characters, +,-,*,/
		String temp = "";     //temp string will take values from string before being stored in stack
		int start = 0;
		
		StringBuffer sb2 = new StringBuffer(s);
		//System.out.println(sb2);
		
		
		for( int i = 0; i < sb2.length(); i++){
			
			
			if(sb2.charAt(i) == '+' || sb2.charAt(i) == '-' || sb2.charAt(i) == '*' || sb2.charAt(i) == '/' || sb2.charAt(i) == ')' ){
			   
				
				
                temp = sb2.substring(0, i);// temp will take number before operative
                
                
                stackNum.push(temp);        //push number into stackNum
                
                stackOp.push(sb2.charAt(i)); //push operator into stackOp
                
                
             
                
                //delete all spaces in front of line
                
               // sb2.delete(0, i + 1);           //delete all data from temp in sb2
                start = i;                      //reset to the first index
                
            
                
			}//when we encounter an operator or a right bracket
			
            
			
		}//for loop
		
		return null;
		
		
	}//FPIE
	
	/**
	 * Tester method.  This is where the program will get user input
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your RPIE:");
		
		String s = input.nextLine();
		
		StringBuffer sb = problem3A.UPEE(s);
		System.out.println("The UPPE Value is: " + sb.toString());
		
		//StringBuffer sb2 = problem3A.FPIE(s);
		//System.out.println("The FPIE Value is: " + sb2.toString());
		
		
	}

}//public class
