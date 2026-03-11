package QuickSortTest;

public class QuickSortInPlaceTest {
		
	/**
	 * Algorithm QuickSort(A, p, r)	//p will be 0 and r will be length-1
	 * 	if (p < r)
	 * 		q = Partition(A, p, r)			//q is the pivot index
	 * 		QuickSort(A, p, q - 1)
	 * 		// Small elements are sorted
	 *  	QuickSort(A, q + 1, r)
	 * 		//Large elements are sorted
	 * 		//Thus input is sorted
	 * 
	 * 			p	   i		   j		  r			*NOTE:
	 *			 0  1  2  3  4  5  6  7  8  9				* p and r represent the lower and upper bounds
	 *			[ ][ ][ ][ ][ ][ ][ ][ ][ ][X]				* i and j represent the indices for values less-than-equal-to
	 *					|			|	  |						the pivot and values greater-than-equal to the pivot, respectively
	 *				<=X	|	>=X		|	  |					* pivot is chosen as 9 (highest value)
	 * 					|			|	  |			
	 * 									>values in 7 and 8 are unrestricted
	 */
	public static void QuickSortInPlace(int[] array, int lower, int upper) {
		
		if(lower < upper) {
			int pivotIndex = PartitionInPlace(array, lower, upper);
			QuickSortInPlace(array, lower, pivotIndex - 1);			
			QuickSortInPlace(array, pivotIndex + 1, upper);
		}
	}
	
	/**
	 *  InPlacePartition(A, p, r)	//array, lower and upper bounds
	 *		x = A[r]
	 *		i = p − 1
	 *		for j = p to r − 1
	 *			if A[j] <= x
	 *				i = i + 1
	 *				swap A[j] and A[i]
	 *		swap A[i + 1] and A[r]				//At the end when all elements are swapped, increment i
							^						by 1 first in order to not get a indexOutOfBoundsException
							|
						i++
						swap A[i] and A[r]
	 */
	public static int PartitionInPlace(int[] array, int lower, int upper) {
		int x = array[upper];
		int i = lower - 1;
		for(int j = lower; j < upper; j++) {
			if(array[j] < x) {
				i++;
				int temp = array[j];	//Swap j and i
				array[j] = array[i];
				array[i] = temp;		//i will be at index 0 first, and, if cond. met, will have same element as j, and j will have value of i
			}
		}
		i++;			//Update first here
		int temp = array[i];		//When loop terminates, change both i+1 and rightmost element
		array[i] = array[upper];
		array[upper] = temp;
		
		return i;
	}
		
	//Printing the entire array
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// QuickSort Array
		int[] array = {3, 6, 2, 7, -1, 0, 22, 5};
		
		printArray(array);
		//QuickSortNotInPlace(array);
		int l = 0;
		int r = array.length-1;
		QuickSortInPlace(array, l, r);
		
		printArray(array);
		
	}

}
