package assignment2;

import java.util.Scanner;
import java.util.Stack;

public class Problem3 {

	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Character> stack1 = new Stack<Character>();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the RPIE");   
		
		//We have to check to ensuer that value given is an rpie
		//For now assume we are given a valid rpie
		
		String s = input.nextLine();
		s = s.toString();
		
		
		StringBuffer line = new StringBuffer(s);  //line contains string sent by user
		int lineLength = line.length();
		
		for(int i = 0; i < lineLength; i++){
			
			
			if(line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '*' || line.charAt(i) == '/'){
				stack1.push(line.charAt(i)); //will put operative into stack
				line.deleteCharAt(i);  //will remove operative
				i--;
				lineLength--;
				
			}//if char is an operative
			
			if(line.charAt(i) == ')'){
				line.setCharAt(i, stack1.pop()); //pops top stack value and replaces the bracket with it
			}//char is a right bracket
			
		}//for loop to traverse through line.  
		
		
//The above will compute UPPE succesfully, under the assumption that the input is valid
		
			System.out.println(line);//prints out UPPE
			//System.out.println(s);
		
			
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
				
	//			System.out.println(stackNum);
	//			System.out.println(stackOp);
			
		
		
		
	}
}
	


