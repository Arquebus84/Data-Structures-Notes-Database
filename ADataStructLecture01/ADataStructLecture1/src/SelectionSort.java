
import java.util.Arrays;
/*
 * CSCI-3230
 * Instructor: Dr. Rahman
 */
public class SelectionSort {

	public static void main(String[] args) {
		int n = 5; // Static number of test arrays (int) with various lengths
		
		int[][] arrs = new int[n][]; // Stores initial 'n' number arrays
		int[][] sortedArrs = new int[n][]; // Storing sorted 'n' number of arrays

		long[] times = new long[n]; // Storing the times in milliseconds for running the algorithm
		int[] sizes = new int[n]; // Size of all arrays

		for (int i = 0; i < n; i++) {
			
			int size = (int)(Math.pow(10, (i + 1))); //Size for each test array (CHANGE HERE to use (i + 2) or (i + 3) will change the size)
			//int size = (int) (Math.pow(10, (i + 3))); // Will start at 10^3 (1000 is size of first array) and end at
														// 10^7

			int maxNum = 10 * (int) (Math.pow(10, (i + 1))); // Random number for ceiling
			//*** The highest value will be 100 b/c it's 10 * 10^(0 + 1)

			sizes[i] = size;

			// Creates an array of size 10
			arrs[i] = new int[size]; // Generate memory for storing the array
			for (int j = 0; j < size; j++) {
				arrs[i][j] = (int) (Math.random() * maxNum);
				//*** Assign random int numbers [0, maxNum] to each testing array
			}
			
			/**Recall: Unix epoch time from jan 1, 1970*/			
			// Find actual millisec time for running the selecionSort algorithm on test
			// array to sort
			long startTime = System.currentTimeMillis(); 	//Starting here
			sortedArrs[i] = selectionSort(arrs[i]);			//Start the selection sort method
			long endTime = System.currentTimeMillis();		//Check the time again

			//Find the difference to compare the amount of time that has passed
			times[i] = endTime - startTime; // Record running time for each sorting example
		}
		// Print arrays with sizes and times separately: see how number changes the
		// running time
		System.out.println("The Array Sizes Are:");
		System.out.println(sortedArrs.length);
		System.out.printf("Time in millisecond for each array: %n %s %n", Arrays.toString(times));
		
		for(int i = 0; i < sortedArrs.length; i++) {
			System.out.print(sortedArrs[i] + " ");
		}
		
		//Selection Sort Test
		/**int[] arrA = {2, 6, 3, 8, 12, 9};
		selectionTest(arrA);*/
	}

	public static int[] selectionSort(int[] arr) {

		int[] sortedArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					sortedArr[i] = arr[i];
				}
			}
		}

		return sortedArr;
	}
	
	public static void selectionTest(int[] arr) {
		
		//int[] sortedArr = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int e : arr) {
			System.out.print(e + " ");
		}
	}

}