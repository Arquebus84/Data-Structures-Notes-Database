package ReadDataTest;

import java.io.File;
import java.util.Scanner;

public class FileRead {

	public static void main(String[] args) {
//		File file = new File("C:\\Users\\matte\\TextFiles\\ClassGradeTest.txt");		//Windows
//		File file = new File("/mnt/c/Users/matte/TextFiles/ClassGradeTest.txt");		//Linux
//		try {
//			Scanner inputRead = new Scanner(file);
//			
//			while(inputRead.hasNext()) {
//				System.out.println(inputRead.nextLine());
//			}
//			
//			inputRead.close();
//			
//		}catch(Exception ex) {
//			System.out.println(ex.toString());
//		}		
		
		int[] arr = {-1,0,3,5,9,12};
		int target = 9;
		
		
		System.out.println(binSearch(arr, target));
	}
	
	public static int binSearch(int[] arr, int target) {
		//Binary Search
		
		int l = 0, r = arr.length-1, mid;
		while (l <= r) {
			mid = (l + r)>>1;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}
