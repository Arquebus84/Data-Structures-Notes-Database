
public class AnalysisOfAlgorithms {

	//Time complexity
	
	//Max in array
	/**
	  	Algorithm arrayMax ( A , n )

		currentMax = A [ 0 ]			// There are 2 operations (declare and initialize the variable currentMax)
		for i = 1 to ( n − 1) do 		// 1 operation
		if A[ i ] > currentMax then		// 2 operations with n-1
			currentMax = A [ i ] 		// 2 operations with n-1	// (2 + 2)(n-1) There are about 4(n - 1) operations
		return currentMax				// 1 operation

			In total 4(n - 1) + 2 + 1 = (4n - 1) operations			
					Will be done in O(n) time complexity
	 */
	
	//Selection Sort method
	/**
		public static int[] selectionSort(int[] arr) {
			for (i = 0 to n − 1) {
 				int indexOfCurrentMin = i ; 					// ≈ 1 × n
 				for (int j = i + 1 to n ) {
 					if(arr [j] < arr [indexOfCurrentMin] ) {
 						indexOfCurrentMin = j ;
 					} 											// ≈ 4 × (n − i) for each i
 				}
 				int currentMin = arr [indexOfCurrentMin]; 		// ≈ 2 × n
 				arr [indexOfCurrentMin] = arr [i] ; 			// ≈ 3 × n
 				arr[i] = currentMin ; 							// ≈ 2 × n
 			}
 			return arr ; 										// ≈ 1
 		}
 											n - 1
		In total, it will be 1 + 8n + 4 * SUMMATION(n - i) **sum from i = 0 to n - 1 for (n - i)
											i = 0
	 */
	
	
	public static void main(String[] args) {
		//Random Sorting Algorithm
						
		//List with a random size from 1 to 50
		int[] arrayRandom = new int[(int)(1 + Math.random() * 50)]; // 2 + 3 operations
		
		for(int i = 0; i < arrayRandom.length; i++) {			// (array.length) operation
			//Set each element as a random number between 1 and 500
			arrayRandom[i] = (int)(1 + Math.random() * 500);	// 2 + 3 operations
		}														//Results in 5(array.length) operations
		
		for(int i = 0; i < arrayRandom.length; i++) {
			System.out.print(arrayRandom[i] + " ");
		}
		
		System.out.println();
		//Starting time
		long startTime = System.currentTimeMillis();
		int[] sortedArray = selectionSort(arrayRandom);
		
		for(int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		
		long endTime = System.currentTimeMillis();
		
		long totalTime = endTime - startTime;
		
		System.out.println("\nTotal Time to Process (in millis): " + totalTime);
		
	}
	
	public static int[] selectionSort(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

}