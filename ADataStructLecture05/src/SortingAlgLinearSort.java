
public class SortingAlgLinearSort {
	
	/*
	 * 1) Comparison Sort
	 * 		-Selection Sort
	 * 		-Bubble Sort			**Never use Bubble Sort or Selection Sort (bubble is more efficient, in sequentially ordered data)
	 * 		-Insertion Sort
	 * 		-Merge Sort				**Recursion == divide and conquer
	 * 		-Heap Sort (*later)
	 * 		-Quick Sort				**Recursive	== divide and conquer
	 * 		-Lower Bound on Comparison Sorting (*later)
	 * 
	 * 2) Linear Sorting			**Linear Sorting will not be on the Exam
	 * 		-Counting Sort
	 * 		-Radix Sort
	 * 		-Bucket Sort		
	 */
	
	/**				Linear Sorting
	 * 		Counting Sort
	 * 			* Consider the following case: The elements to be sorted come from a finite 
	 * 				(and preferably small) set [1, ..., k]
	 * 
	 * 					[1][0][2][0][1][1][0][2]				0	1	2	elements
	 * 						|								   [3] [3] [2]
	 * 					  --									
	 * 					 |											*First sort the 0s and then sort the rest
	 * 					[0][0][0][1][1][1][2][2]
	 * 					[0][1][2][3][4][5][6][7]	index
	 * 			
	 * 			* Running Time will be O(n + k)
	 */
	
	/**
	 * 		Radix Sort
	 * 
	 */

	public static void main(String[] args) {
		
	}

}
