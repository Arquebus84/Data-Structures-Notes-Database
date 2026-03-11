package MergingArraysTest;

public class UpdateArray {

	public static void main(String[] args) {
		int[] array = {2, 4, 6, 8, 10, 12, 14, 16};
		int[] newArr = null;
		
		newArr = update(array, newArr);
		System.out.println(newArr.length);
		
	}
	
	public static int[] update(int[] array, int[] newArray) {
		newArray = new int[array.length];
		return newArray;
	}

}
