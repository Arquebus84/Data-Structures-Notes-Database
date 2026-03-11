package QuickSortTest;

public class QuickSortNotInPlace {

	//NOTE: For this to work for arrays, there must be 3 separate methods for partition: less than, equal to, and greater than
	//			values compared to the pivot
	
	/**
	 * Algorithm QuickSort(S)
	 * 			// L: less; E: equal; G:greater
	 * 			// P: pivot or position
	 * 			if	(S.size() > 1)
	 * 				(L, E, G) = Parition(S, p)	//Divide	(key step)
	 * 				QuickSort(L)				//Recur: Small elements are sorted
	 * 				QuickSort(G)				//Recur: Large elements are sorted
	 * 				S = (L, E, G)				//Conquer: Thus input is sorted
	 * 
	 * 
	 * 			**Key Step:
	 * 				(L, E, G) = Parition(S, p) 	// p (pivot can be any number, in this case, the last number)
	 * 					- L: all the elements smaller than the pivot p (ex: all elements smaller than 5)
	 * 					- E: all elements equal to p
	 * 					- G: all elements greater than p 
	 */
	// May require Stack or LinkedList 
	public static void QuickSortNotInPlace(int[] array) {
		int size = array.length;
		int pivot = array[size-1];
				
		if(size > 1) {
			int[] LessT = new int[0], EqualT = new int[0], GreaterT = new int[0];
			LessT = partitionLess(array, pivot);
			EqualT = partitionEqual(array, pivot);
			GreaterT = partitionGreater(array, pivot);
			//System.out.printf("Less is %d\nEqual is %d\nGreater is %d", LessT.length, EqualT.length, GreaterT.length);
			printArray(LessT);
		};
	}
		
	/*		NOTE: Not Sort-in-place
	 * Algorithm Partition(S, p)
	 * 			// Input: sequence S, position p of pivot
	 * 			// Output: subsequences L, E, G of elements of S less than, equal to, or greater than pivot, respectively
	 * 			L, E, G <- empty sequences
	 * 			while( !isEmpty())
	 * 				y <- S.remove(S.first())
	 * 				if y < p
	 * 					L.addLast(y)
	 * 				else if y = p
	 * 					E.addLast(y)
	 * 				else		// y > p
	 * 					G.addLast(y)
	 * 			return L, E, G
	 */
	public static int[] partitionLess(int[] array, int pivot) {
		int size = array.length;
		int newSize = 0;
		int[] newArray = new int[0];
		int index = 0;
		while(size > 0 && index < size) {
			int y = array[index];
			if(y < pivot) {
				newSize++;
				newArray = new int[newSize];			
				newArray[newSize] = y;
			}
			index++;
		}
		return newArray;
	}
	
	public static int[] partitionEqual(int[] array, int pivot) {
		int size = array.length;
		int newSize = 0;
		int[] newArray = new int[0];
		int index = 0;
		while(size > 0 && index < size) {
			int y = array[index];
			if(y == pivot) {
				newSize++;
				newArray = new int[newSize];
				//newArray[index] = array[index];
			}
			index++;
		}
		return newArray;
	}
	
	public static int[] partitionGreater(int[] array, int pivot) {
		int size = array.length;
		int newSize = 0;
		int[] newArray = new int[0];
		int index = 0;
		while(size > 0 && index < size) {
			int y = array[index];
			if(y > pivot) {
				newSize++;
				newArray = new int[newSize];
				//newArray[index] = array[index];
			}
			index++;
		}
		return newArray;
	}
	
	public static void printArray(int[] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
 	
	public static void main(String[] args) {
		int[] array = {3, 0, 7, 9, -2, 5};
		
		QuickSortNotInPlace(array);

	}
	
	public static class QuickSortNIPLinkedList{
		java.util.LinkedList<Integer> mainList;
		//Create Linked Lists for the less, equal, and greater lists for this to work
		
		
		public QuickSortNIPLinkedList(){
			
		}
		
		public void partition() {
			
		}
	}

}
