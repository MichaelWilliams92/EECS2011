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

/**
 * 
 * This is the class Lights.  This program is the combined versions of both the TurnOn and 
 * TurnOff method, condensed into 1.
 * 
 * @author Owner
 *
 */
public class Lights {

	private Lights() {
		
	}
	public static void lightsSwitch(List<Integer> lights, boolean s) {
		
		if (s == false) {
		
				if (lights.size() == 0) {
					return;
				}
				if (lights.size() == 1) {
					lights.set(0, 0); //turn off light 1
				}
				
				else {
					if (lights.size() > 2) {
						lightsSwitch((lights.subList(0, lights.size() - 2)), false);
					}
					lights.set(lights.size() - 1, 0); //turn off light n
					if (lights.size() > 2) {
						lightsSwitch((lights.subList(0, lights.size() - 2)), true);
					}
					lightsSwitch((lights.subList(0, lights.size() - 1)), false);
				}
		}
			
		if (s == true) {
				if (lights.size() == 0) {
					return;
				}
				if (lights.size() == 1) {
					lights.set(0, 1); //turn off light 1
				}
				
				else {
					if (lights.size() > 2) {
						lightsSwitch((lights.subList(0, lights.size() - 2)), true);
					}
					lights.set(lights.size() - 2, 1); //turn on light n - 1
					if (lights.size() > 2) {
						lightsSwitch((lights.subList(0, lights.size() - 2)), false);
					}
					lights.set(lights.size() - 1, 1 ); //turn on light n
					lightsSwitch((lights.subList(0, lights.size() - 2)), true);
					
				}
			}
		}
		
	
	/**
	 * Tester method to run the above program
	 * 
	 * @param args
	 */
	public static void main(String[]args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(0);
		list.add(1);
		list.add(1);
		list.add(0);
		list.add(1);
		
		System.out.print(list);
		
		Lights.lightsSwitch(list, true);
		System.out.println(list);
		
	}
	
	
}
