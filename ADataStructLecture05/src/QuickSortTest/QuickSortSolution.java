package QuickSortTest;

public class QuickSortSolution {

	public static void main(String[] args) {
		//int[] array = {9, 4, 8, 2, 1, 7, 3, 5, 6};//{6, 0, -3, 56, 19, 2, 12};
		int[] array = {6, 0, -3, 56, 19, 2, 12};
		printArray(array);
		QuickSort(array, 0, array.length-1);
		printArray(array);
	}
	
	public static void QuickSort(int[] array, int low, int upper) {
		if(low < upper) {
			int pivot = partition(array, low, upper);
			
			//Lower elements
			QuickSort(array, low, pivot - 1);
			//Larger elements
			QuickSort(array, pivot + 1, upper);
		}		
	}
	
	public static int partition(int[] array, int low, int upper) {
		int pivot = array[upper];
		int i = low - 1;
		for(int j = low; j < upper; j++){
			if(array[j] < pivot) {
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		i++;
		int temp = array[i];
		array[i] = array[upper];
		array[upper] = temp;
		
		return i;
	}

	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
