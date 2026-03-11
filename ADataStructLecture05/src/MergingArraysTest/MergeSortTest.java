package MergingArraysTest;

public class MergeSortTest {
	/**
	 * Algorithm mergeSort(S)
	 * 			// Input: sequence S with n elements
	 * 			// Output: sequence S sorted
	 * 			if (S.size() > 1){					//If size greater than 1, keep dividing it
	 * 				(S1, S2) = partition(S, n/2)	//Divide	Partition = split into **two different arrays** (one is lower half 
	 * 																and second is upper half)
	 * 				mergeSort(S1)					//Recur
	 * 				mergeSort(S2)					//Recur
	 * 				S = merge(S1, S2)				//Conquer
	 * 			}
	 * 
	 * 		Merging Two Sorted Sequences
	 * 			Algorithm merge(A, B)
	 * 			// Input: sequences A and B with n/2 elements each
	 * 			// Output: sorted sequence of A and B
	 * 			
	 * 			S = empty sequence			//NOTE: Could use Linked List or a Queue (not Stack), but can use an array
	 * 			while (!A.isEmpty() && !B.isEmpty()){
	 * 				if(A.first().element() < B.first().element())
	 * 					S.addLast(B.remove(A.first()))
	 * 				else
	 * 					S.addLast(B.remove(B.first()))
	 * 			}
	 * 			while(!A.isEmpty())
	 * 				S.addLast(A.remove(A.first()))
	 * 			while(!B.isEmpty())
	 * 				S.addLast(B.remove(B.first()))
	 * 			return S
	 */

	public static void main(String[] args) {
		int[] array = {2, 8, 6, 1, 16, -5, 4};
		
		// Before
		printArray(array);
		
		mergeSort(array);
		
		//After
		printArray(array);
		
	}
	
	public static void mergeSort(int[] array) {
						
		if(array.length <= 1) return;
		
		int mid = (array.length) >> 1;
		int[] lowerA = new int[mid];
		int[] upperA = new int[array.length - mid];
		
		int k = 0;
		for(int i = 0; i < array.length; i++) {	// Array partitioning
			if(i < mid)
				lowerA[i] = array[i];
			else {
				upperA[k] = array[i];
				k++;
			}
		}
		
		mergeSort(lowerA);
		mergeSort(upperA);
		merge(array, lowerA, upperA);
	}
	
	public static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int leftSize = (array.length >> 1);
		int rightSize = array.length - leftSize;
		
		/**NOTE: This code here only takes care of the elements in *half* the array (leftArray is split), to take care of the rest, iterate again */
		
		//Keep track of the indices in the original array as well as the ones for the left and right
		int i = 0, l = 0, r = 0;	// i is for position in array, l is for position in left array, and r is for right array indices
		
		//While there are elements in the arrays, will continue to add elements to the merge array
		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {	/** Similar to stack, place the smallest element in the first index (bottom of the stack)*/
				array[i] = leftArray[l];
				i++;
				l++;
			}else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		
		//All the elements in the split arrays have to be accounted for when iterating through them
		//Make sure than every element is accounted for, so loop again
		while(l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
