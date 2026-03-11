// ==============****FILL IN YOUR INFO HERE****======================
//Name:			Matteo Ventura
//Eagle ID:		901405780
// ==============****FILL IN YOUR INFO HERE****======================

// ===============================================
// CSCI 3230A Data Structures
// Fall 2025
// Instructor: M Arif Rahman, Ph.D.
//
// CQ-4; Closed-Resources, Individual Test.
//
// ====================== Requirements ========================
//
// Implement "Merge Sort" as illustrated in the lecture slides "Lecture5-Sorting Algorithms.pdf".
// That is, you need to translate the following pseudo-code to Java code.


	/*
Algorithm mergeSort ( S )
Input : sequence S with n elements
Output : sequence S sorted
       	if S.size() > 1
			(S1 , S2) = partition(S, n/2) // Divide
			mergeSort ( S1 ) // Recursive
			mergeSort ( S2 ) // Recursive
			S = merge ( S1 , S2 ) // Conquer	

Algorithm merge (A, B)
	Input sequences A and B with n/2 elements each
	Output sorted sequence of A and B
	S = empty sequence
	while !A.isEmpty() and !B.isEmpty()
		if A.first().element() < B.first().element()
			S.addLast(A.remove(A.first()))
		else
			S.addLast(B.remove(B.first()))
	while !A.isEmpty()
		S.addLast (A.remove(A.first()))
	while !B.isEmpty( )
		S.addLast(B.remove(B.first()))
	return S
*/


// Please use appropriate data types and
// also design appropriate output using utility function printArray
// to demonstrate the correctness of your code.
//
// Assume we use input array as this: int arr[] = {102,1,12, 11, 13,11, 5, 6, 7,114,-1};
// Your output will look as follows:
// ------------------------------------
// Given Array:
// 102 1 12 11 13 11 5 6 7 114 -1
//Sorted Array:
// -1 1 5 6 7 11 11 12 13 102 114


class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    { 
	// COMPLETE THIS BLOCK- MERGE FUNCTION
	
	// FOLLOW THE FOLLOWING COMMENTS 
	// TO COMPLETE EACH PART OF THE MERGE FUNCTION
	
        /* Find sizes of two sub arrays to be merged */	//Use length
    	int n1 = m - l + 1; 	//Left sub array	(l stays the same, and middle will be decreased by its change by 1)
    	int n2 = r - m;			//Right sub array (r will be the array length and will be the size from middle to the length)
 
        /* Create temp arrays */
    	int[] L = new int[n1];
    	int[] R = new int[n2];
 
        /*Copy data to temp arrays*/	//Check if less than r, since it will be the newest size of the array
    									//Note: is not needed and will waste more memory space by creating new temp arrays
    	//Old Method
//    	int h = 0, k = 0;
//    	for(int i = 0; i < arr.length; i++) {
//    		if(i < m && h < n1) {		// When the length is 1, index must be 0 (h < length of L which will be 1)
//    			L[h] = arr[i];			// NOTE: could replace the h with just i in order to safe on memory space
//    			h++;
//    		}else if(k < n2){
//    			R[k] = arr[i];
//    			k++;
//    		}
//    	}
    	//New copy data
    	for(int i = 0; i < n1; i++) {
    		L[i] = arr[i + l];
    	}
    	for(int j = 0; j < n2; j++) {
    		R[j] = arr[j + m + 1];
    	}
    	
    	/**NOTE: this code here only takes care of the elements in half the arr array, to take care of the rest, iterate again*/
    	
    	// Similar to stack, place the smallest element in the first index (bottom of the stack)
    	int leftIndex = 0, rightIndex = 0, arrayIndex = l;	//Keep track of all the indices for each array (main, lower, and upper)
        /* Merge the temp arrays */
    	while(leftIndex < n1 && rightIndex < n2) {		// If the leftIndx and rightIndx are less than their respective array size, iterate
    		if(L[leftIndex] < R[rightIndex]) {			// At the same index, if element in L < element in R, stack element in arr
    			arr[arrayIndex] = L[leftIndex];
    			//arrayIndex++;
    			leftIndex++;						//Ctrl size of the L array
    		}else {
    			arr[arrayIndex] = R[rightIndex];
    			//arrayIndex++;
    			rightIndex++;						//Ctrl size of the R array
    		}
    		arrayIndex++;
    	}
    	    	
    	//Ensure that all the elements in the split arrays are accounted for when iterating through them
        /* Copy remaining elements of L[] if any */
    	while(leftIndex < n1) {
    		arr[arrayIndex] = L[leftIndex];
    		arrayIndex++;
    		leftIndex++;
    	}
 
        /* Copy remaining elements of R[] if any */
    	while(rightIndex < n2) {
    		arr[arrayIndex] = R[rightIndex];
    		arrayIndex++;
    		rightIndex++;
    	}
    }
 
    // Main sorting function that sorts arr[l..r] using
    // merge() above
    void sort(int arr[], int l, int r)	// l = 0, r = arr.length - 1
    {
        if (l < r)		// If the length is less than 0, return
        {
            // Find the middle point
            int m = (l+r)/2;			//Creates middle index and recursively calls it
 
            // Sort first and second halves
            sort(arr, l, m);		//Lower Array from l and m 		(m will change)
            sort(arr , m+1, r);		//Upper Array: from m+1 to r 	(l will increase until it is greater than r)
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        // Input Array
		// Modify this to check the correctness of your code
		int arr[] = {102,1,12, 11, 13,11, 5, 6, 7,114,-1};
 
        System.out.println("Given Array:");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);		//ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array:");
        printArray(arr);
    }
}