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


/**
 * 
 * This will act as the tester for the TurnOn, TurnOff
 *
 */
public class turnOnOffTester {

	public static void main(String[] args) {
		List<Integer> n = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		System.out.println("How many light switches are you using?");
		int size = input.nextInt();
		System.out.println("Press 3 to turn them all on or 4 to turn them all off.");
		Integer allOnOff = input.nextInt();
		System.out.println("Enter 1 if you want all the lights initially on, or 0 if you want them all off.");
		Integer onOff = input.nextInt();
		
		for (int i = 0; i < size; i++) {
			n.add(onOff);
		}
		
		if (allOnOff == 3) {
		Problem1.turnOn(n);
		} else if (allOnOff == 4) {
			Problem1.turnOff(n);
		}
		System.out.println(n);

	}

}
