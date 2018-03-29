/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Fall 2014
 * Assignment 4
 * Student Name:         Michael Williams
 * Student cse account:  mw1992
 * Student ID number:    211087798
 **********************************************************/

package assignment4;
import java.util.Random;


/**
 * 
 * @author Michael Williams
 * 
 * This is assignment question 2.
 * In this program, 2 arrays are given, an array of nuts and an array of bolts, such that each nut has an unique
 * matching bolt and vice versa.  The nuts and bolts, because they must all be of different sizes, are simply given
 * a value in the array.  The numbers represent the size of each nut and bolt.  The program sorts the the bolts and
 * nuts, such that there is a simple way of matching each unique nut to its corresponding unique bolt, in this case
 * that nuts[i] matches bolts[i], where i is an index of the arrays.  This is done efficiently and effectively while
 * maintaining that only bolt-to-nut comparisons can be made, and assuming, as explained in the site forum, that
 * both arrays are of the same size. 
 * 
 * The program contains one main recursive method for sorting the nuts and bolts arrays, and a few helper methods
 * used to simplify the program overall. Overall the program runs in O(n log n) time, where n refers to the number
 * of nut-to-bolt comparisons.  It results in O(n log n) because we essentially use a quick sort, where the starting 
 * pivot point is randomized and as such will result in, at most, n log n + n log n (one n log n for each array).
 * n log n + n log n = 2(n log n) or, O(n logn) time.  
 * 
 * Also included is a tester method to create create the nuts and bolts arrays and run the computation
 * to sort the arrays in a way that the nuts and bolts can be matched
 * 
 * I only provide 1 test case in the tester below, but there are other
 * test cases as well as their results recorded and submitted in the Test Cases File, if needed.  
 */
public class NutsAndBolts  {
	  private int[] Nuts;      //Nuts array
	  private int[] Bolts;     //Bolts array
	  private int number;    
	  Random rand = new Random();
	  
	  boolean isFirstRecursion = true;  //used for the random pivot

	  public void sort(int[] first, int[] second) {
		  // check for empty or null array
		if(first == null){
			System.out.println("At least 1 array is null");
			return;
		}
		else if(first.length == 0){
			System.out.println("At least 1 Array is empty");
			return;
		}
	   
	    this.Nuts = first;
	    this.Bolts = second; 
	    
	    number = first.length;
	    sortArrays(0, number - 1);
	  }// Sort  startup method

	  
	
  
/**
* This is the main recursive method, that essentially carries out the sorting of both arrays
* 
*   In it we get 2 arrays, one containing all the nuts and one containing all the bolts.  We choose a random bolt 
*   and use it to rearrange the nuts through comparisons, such that the left side of the array contains all the nuts 
*   that are too small to fit the bolt, and the right side contains all the nuts that are too big. At the end of the 
*   rearranging process, the matching nut will be between these two sides.  We then take that nut and compare it 
*	in the same fashion to all the bolts, rearranging them in the same way.  Once, this is complete, all the 
*	elements to the left of the matching nut or bolt are of smaller size and all the elements to the right are of
*	larger size, in comparison to the pivot nut or bolt in question. We then recursively apply the same sorting 
*	method to both sides of the pivot, or matching elements. Once this is complete, both the arrays will have 
*	effectively been sorted from smallest to largest. Therefore, every nut and bolt matches up at the same index.  
*	In other words, nuts[i] will match to bolts[i] for any index, i,  within the array.
*
*The rearranging process is done by first assigning variables to the ends of the array or sub-array, which will be used
*to refer to the index. So long as the value at that index is in the correct side, we move the index forwards or backwards
*depending on which end we are at.  Once both indices stop at an index, we swap those two values with each other, Then
*we simply continue as normal.  This will effectively place all nuts/bolts larger than the pivot to the right side, and
*all nuts/bolts smaller than the pivot to the left.  The rearranging process then ends and we recursively do it again,
*with the left and right sides acting as the sub-arrays to be sorted.
*
*This method sorts the array of nuts, but calls the helper method to sort the array of bolts as well
*The sorting of this array and the array of nuts is separated for simplicity and readability.
* 
* @param low           the left boundary of the array or sub-array to be sorted
* @param high          the right boundary of the array or sub-array to be sorted 
*/
 private void sortArrays(int low, int high) { 
	    int i = low, j = high; 		//high/low references for arrayA
  	    int k = low, l = high; 		//high/low references for arrayB
  	       
  int pivotA;
	    
  if(isFirstRecursion){                                 
	  pivotA = Bolts[rand.nextInt(Nuts.length)];  
	  isFirstRecursion = false;
  } //Makes first pivot choice random
  
  else{
	  pivotA = Bolts[low + (high-low)/2];           
      }//used for all the recursive calls

 //The above obtains the pivot
 //Below is the actual sorting
  
	    while (i <= j) {
	    	
	      // If the current value from the left of the array or sub-array in question is smaller then the pivot
	      //  then get the next element in the array or sub-array.  Stops when you hit a value !< pivot
	      while (Nuts[i] < pivotA) {
	        i++;
	      }
	   
	      // If the current value from the right of the array or sub-array is larger then the pivot
	      //  then get the previous element in the array or sub-array.  Stops when you hit a value !> pivot
	      while (Nuts[j] > pivotA) {
	        j--;
	      }
	 
	      // If we have found a values in the left array which is larger then
	      // the pivot element and if we have found a value in the right array
	      // which is smaller then the pivot element then we exchange the
	      // values.
	       if (i <= j) {
	        exchangeA(i, j);
	        
	        		if(i == j){                //Matching nut has been found, and sorting for nuts[] is done for this recursion
	        			sortArrayB(i, k, l);   //sorts the array of Bolts using the matching nut
	        			
	        			  i++;                   //the increment and decrement will terminate the while loop
	        		      j--;                   //and set the positions for the new subArray
	        		}
	        		
	      }
	    }//end of while loop and sorting process
	    
	
	    // Recursive call
	    if (low < j)					 //if the left side contains more than 1 element, we sort it
	      sortArrays(low, j);            //this sub-array contains all values less than the current pivot
	    								  
	    
	    if (i < high)					  //if the right side contains more than 1 element, we sort it
	      sortArrays(i, high);			  //this sub-array contains all values greater than the current pivot
	    
	  }//quick sort method				
	  
 
////////////////////////////////////////////below are the helper methods////////////////////////////////////////////	  
	  /**
	   * The exchange A method exchanges the values at index i and index j with one another, in the Nuts array
	   * 
	   * @param i    The index of a value to be swapped 
	   * @param j    The index of a value to be swapped
	   */
	  private void exchangeA(int i, int j) {  
	    int temp = Nuts[i];
	    Nuts[i] = Nuts[j];
	    Nuts[j] = temp;
	  }  
	  
	  /**
	   * The exchange B method exchanges the values at the index i and index j with one another, in the Bolts array
	   * 
	   * @param k  The index of a value to be swapped
	   * @param l  The index of a value to be swapped
	   */
	  private void exchangeB(int k, int l) { 
		int temp = Bolts[k];
		Bolts[k] = Bolts[l];
		Bolts[l] = temp;
	  }
	  
	  
	  /**
	   * The SortArrayB method sorts the array of bolts, as described in the sortArrays method
	   * The sorting of this array and the array of nuts is separated for simplicity and readability.
	   * 
	   * 
	   * @param i  The index of the pivot
	   * @param k  The left boundary of the array or sub-array to be sorted
	   * @param l  The right boundary of the array or sub-array to be sorted
	   */
	  private void sortArrayB(int i, int k, int l){
		        			      			
		  int pivotB = Nuts[i];  

		    while (k <= l) {

		    	  // If the current value from the left of the array or sub-array in question is smaller then the pivot
			      //  then get the next element in the array or sub-array.  Stops when you hit a value !< pivot
		      while (Bolts[k] < pivotB) {
		        k++;
		      }

		      // If the current value from the right of the array or sub-array is larger then the pivot
		      //  then get the previous element in the array or sub-array.  Stops when you hit a value !> pivot
		      while (Bolts[l] > pivotB) {
		        l--;
		      }

		      if (k <= l) {         //Matching bolt has been found, and sorting for bolts[] is done for this recursion
		        exchangeB(k, l);  
		        
		        if(k == l){
		        k++;              //the increment and decrement will terminate the while loop              
		        l--;             
		     
		        }
		
		      }
		    }//end of while loop and sorting process

	  }//Sort ArrayB method

}//quick Sort class
