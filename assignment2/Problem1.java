/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 2
 * Student Name:   Michael Williams
 * Student cse account:  mw1992
 * Student ID number:  211087798
 **********************************************************/
package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
	
	public static int countOn = 0;
    public static int countOff = 0;
	
	public static void turnOff(List<Integer> Light){

	if(Light.size() == 0)
		return;
		
	if (Light.size() == 1){
		Light.set(0,0); //base case
		countOff ++;
	}//if for base case
	
	else{
		
		if(Light.size() > 2)
			turnOff(Light.subList(0, Light.size() - 2)); //turnOff(n-2)
		    Light.set(Light.size() - 1, 0);
		    countOff ++;                       //turnOff light n
		if(Light.size() > 2)
			turnOn(Light.subList(0, Light.size() - 2));
		    turnOff(Light.subList(0, Light.size() - 1));

		    
	}//if not at the base case
		
	}//end
	
	public static void turnOn(List<Integer> Light){
		
		if(Light.size() == 0)
			return;
		
		if(Light.size() == 1){
			Light.set(0, 1);
			countOn ++;
		}//base case
		
		else{
			
			if(Light.size() > 2)
				turnOn(Light.subList(0, Light.size() - 2));
			    Light.set(Light.size() - 2, 1);
			    countOn ++;
			if(Light.size() > 2)
				turnOff(Light.subList(0, Light.size() - 2));
			    Light.set(Light.size() - 1, 1);
			    countOn ++;
			    
			turnOn(Light.subList(0, Light.size() - 2));
			    
		}//if not at base case
		
	}//end
	
//	public static void main(String[] args){
		
//		List<Integer> n = new ArrayList<Integer>();
		
//		n.add(1);
//	    n.add(1);
//		n.add(1);
//		n.add(1);
//		n.add(1);
//		n.add(1);
//		n.add(1);
//		n.add(1);
//		n.add(1);
		
//		turnOff(n);
		
//		System.out.println(n);
//		System.out.println(countOff);
//		System.out.println(countOn);
		
/*		n.add(1);
		n.add(0);
		n.add(1);
		n.add(0);
		n.add(1);
		n.add(0);
		n.add(1);
		n.add(0);
		n.add(1);
		n.add(0);
		
		turnOn(n);
		
		System.out.println(n);
*/	




		
	}//tester

