package MergingArraysTest;

public class ArrayMergeAndSplit {
	public static void main(String[] args) {
		int arrSize = 6;
		
		int[] arr1 = {2, 4, 6};
		int[] arr2 = {1, 3, 5};
		
		int[] temp = new int[6];
		
		//Merge arrays
		int j = 0;
		for(int i = 0; i < temp.length; i++) {
			if(i < arr1.length) {
				temp[i] = arr1[i];
			}else {
				temp[i] = arr2[j];
				j++;
			}
			
//			if(arr1[i / 2] < arr2[i / 2]) {
//				temp[i] = arr1[i / 2];
//				//temp[i + 1] = arr2[i / 2];
//			}else {
//				temp[i] = arr2[i / 2];
//				//temp[i + 1] = arr1[i / 2];
//			}
		}
		
		//Split into two arrays
		int[] mainArr = {2, 4, 6, 8, 10, 12};
		int mid = mainArr.length >> 1;			//Divide by 2 (bitwise manipulation is faster)
		int[] left = new int[mid];
		int[] right = new int[mainArr.length - mid];
		
		int k = 0;
		for(int i = 0; i < mainArr.length; i++) {
			if(i < mid) {
				left[i] = mainArr[i];
			}else {
				right[k] = mainArr[i];
				k++;
			}
		}
		
		// Merge two arrays
		for(int i : temp)
			System.out.print(i + " ");
		
		System.out.println();
		// Separate an array
		for(int a : left)
			System.out.print(a + " ");
		
		System.out.println();
		for(int a : right)
			System.out.print(a + " ");
	}
}
