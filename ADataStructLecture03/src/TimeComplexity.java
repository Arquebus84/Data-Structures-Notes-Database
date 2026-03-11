
public class TimeComplexity {
	
	// Time Complexity measures the number of elementary operations performed by an algorithm
	// Space Complexity measures the total amount of memory used by an algorithm, including input, output,
	//		and auxiliary data structures

	public static void main(String[] args) {
		//Consider Binary Search Algorithm
		int[] array = {1, 2, 3, 4, 5, 8, 11, 21, 33, 45};
		
		int val = 11;
		System.out.println("Array finding value " + val + " is located in index: " + binarySearch(array, val));
		
		
	}
	
	/**
	 * Binary Search:
	 * 
	 * int array
	 * int value in the array
	 * 
	 * int startIndex is 0 (0 for index)
	 * int endIndex is array.length - 1 (for last index)
	 * int halfPoint is the value in the half-size (middle element) of the array
	 * 
	 * while(endIndex > startIndex)
	 * 		if value == mid
	 * 			return index of middle
	 * 		else if value < mid
	 * 			set endIndex to mid
	 * 		else if value > mid
	 * 			set startIndex to (mid + 1)
	 * 
	 * 	return element;
	 * 
	 */
	public static int binarySearch(int[] array, int value) {
		/**
		 * For each of these iterations, it will be O(log(n))		//log_2(n)
		 * 				n			(x 1/2)
		 * 			   / \
		 * 			n/2   n/2			(x 1/2)
		 * 			/		\
		 * 		  n/4		n/4				(x 1/2)
		 * 		  /			  \
		 * 		 n/8		  n/8				(x 1/2)
		 * 
		 */
		
		int startIndex = 0;
		int endIndex = (array.length - 1);
		int midIndex = endIndex/2;
		
		while(endIndex > startIndex) {
			if(value == array[midIndex]) {
				return midIndex;
			}else if(value < array[midIndex]) {
				endIndex = midIndex - 1;
				midIndex /= 2;
			}else {
				startIndex = midIndex + 1;
				midIndex = midIndex + midIndex/2;
			}
		}
		
		return midIndex;
	}

}
