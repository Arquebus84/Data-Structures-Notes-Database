package QuickSortTest;

//==============****FILL IN YOUR INFO HERE****======================
//Name: Matteo Ventura
//Eagle ID:	901405780
//==============****FILL IN YOUR INFO HERE****======================
//===============================================
//CSCI 3230A Data Structures
//Fall 2025
//Instructor: M Arif Rahman, Ph.D.
//
//CQ-5; Closed-Resources, Individual Test.
//
//====================== Requirements ========================
//
//Implement "In-Place Quick Sort" as illustrated in the lecture slides "Lecture5-Sorting Algorithms.pdf".
//That is, you need to translate the following pseudo-code to Java code.


	/*
Algorithm-1 QuickSort (A, p, r)
	i f p < r
		q = P a r t i t i o n ( A , p , r )
		QuickSort ( A , p , q − 1 )
		// Small elements are sorted
		QuickSort ( A , q + 1 , r )
		// Large elements are sorted
//Thus input is sorted	



Algorithm-2 inPlacePartition ( A , p , r )
	x = A [ r ]
	i = p − 1
	for j = p to r − 1
		i f A [ j ] <= x
			i = i + 1
			swap A [ j ] and A [ i ]
	swap A [ i + 1 ] and A [ r ]
*/

//Please use appropriate data types and
//also design appropriate output 
//to demonstrate the correctness of your code.
//
//Assume we use input array as this: int[] input = { 23, 31, 1, 21, 36, 72, 31, -23, 12};
//Your output will look as follows:
//------------------------------------
//Before Sorting:
//[23, 31, 1, 21, 36, 72, 31, -23, 12]
//After Sorting:
//[-23, 1, 12, 21, 23, 31, 31, 36, 72]

//======================= Note ======================== 
//1. DO NOT DELETE ANY COMMENT!!!
//2. You will only need to fill the blocks with comment "COMPLETE THIS BLOCK".
//3. Modify the file name to "QuickSort.java" before compiling and submitting it.
//4. DON’T FORGET TO INPUT YOUR NAME AND EAGLE ID AT THE TOP! OTHERWISE, YOU GET NO 
//   POINTS!!
//===============================================


import java.util.Arrays;

public class CQ5QuickSort{

//Driver
	public static void main(String args[]) {

		// INPUT ARRAY HERE
		// Modify this input to test your code
		int[] input = { 23, 31, 1, 21, 36, 72, 31, -23, 12 };

		System.out.println("Before sorting :\n " + Arrays.toString(input));

		// sort the integer array using quick sort algorithm
		quickSort(input);

		System.out.println("After sorting :\n " + Arrays.toString(input));

	}

	public static void quickSort(int[] array) {

		// Use a separate function for recursive calls
		recursiveQuickSort(array, 0, array.length - 1);	//end index

	}

	public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) { 

		// COMPLETE THIS BLOCK
		//USING ALGORITHM-1:
		/*
		 * Algorithm-1 QuickSort ( A , p , r )
	i f p < r
		q = P a r t i t i o n ( A , p , r )
		QuickSort ( A , p , q − 1 )
		// Small elements are sorted
		QuickSort ( A , q + 1 , r )
		// Large elements are sorted
		 */
		if(startIdx > endIdx) {
			return;		
		}else {
			int pivot = partition(array, startIdx, endIdx);
			
			recursiveQuickSort(array, startIdx, pivot - 1);	// Values less than the pivot
			recursiveQuickSort(array, pivot + 1, endIdx); 	// Values greater than the pivot
		}
		//Recursive QuickSort

	}

	public static int partition(int[] array, int left, int right) {

		// COMPLETE THIS BLOCK
		// USING ALGORITHM-2 :
		/*
		 * Algorithm-2 inPlacePartition ( A , p , r )
	x = A [ r ]
	i = p − 1
	for j = p to r − 1
		i f A [ j ] <= x
			i = i + 1
			swap A [ j ] and A [ i ]
	swap A [ i + 1 ] and A [ r ]
		 */
		
		int x = array[right];
		int i = left - 1;
		for(int j = left; j <= right-1; j++) {
			if(array[j] <= x) {
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		i++;
		int temp = array[i];
		array[i] = array[right];
		array[right] = temp;
		
		return i;

		// in-place-Partition

	}

}











