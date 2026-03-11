package Test3;

//CS-3230A Fall 2025
//Instructor: M Arif Rahman, PhD

//Name: Matteo Ventura
//Eagle ID: 901405780
//Email:  mv06011@georgiasouthern.edu 


//Recursive Binary Search in a sorted array of positive integers
//I.E. Find 12 and its index (if it exists) in the array [1,2,5,8,9,11,12]

//Algorithm:

//Compare x (the number being searched) with the middle element.
//If x matches with the middle element, we return the mid index.
//Else If x is greater than the mid element, then x can only lie in the right half of subarray
//after the mid element. So we recur for the right half.
//Else (x is smaller) we recur for the left half.



class RecursiveBinarySearch {

	// Main driver method
	public static void main(String args[])
	{
		// YOU ABSOLUTELY CANNOT CHANGE ANYTHING IN THIS FUNCTION.
	     RecursiveBinarySearch objct = new RecursiveBinarySearch();
	     int myArray[] = { 10, 20, 30, 40, 50, 60, 65 };
	     int size = myArray.length;

	     // Custom element to be checked
	     int findMe = 20;

	     int result = objct.binarySearch(myArray, 0, size - 1, findMe);

	     if (result == -1)
	         System.out.println("Element not present");
	     else
	         System.out.println("Element being searched is "+ myArray[result]+ " and it is found at index " + result);
	}
	
	
 // COMPLETE THE FOLLOWING FUNCTION USING RECURSION
	// Returns index of x if it is present
     // else return -1
 	int binarySearch(int arr[], int l, int r, int x){
 		// Restrict the boundary of right index by r and the left index by l to prevent overflow of indices. x is the element being searched for.
 	 	int mid = (r + l) / 2;
 	 	//Terminating case (base case) will have two lines of code**
 	 	
 	 	// when element is not present in array, works as a terminating case as well (when the length of array is less than 0)
 	 	if(r <= l) {
 	 		return -1;
 	 	}
 	 	/**In the following lines, we can explain why we have to check when r < l
 	 	 * 		if x = -20, then it's less than mid, which will be less than new mid (mid/2 is < mid - 1):
 	 	 * 			it will be r = mid + 1, and continues until it reaches index l (i.e. r = l)
 	 	 * 			when r = l, it's the minimum, but it will continue until it reaches the next point; thus making r < l
 	 	 * 			so, restrict it to be greater than index 0
 	 	 * 		
 	 	 * 		if x = 200, then it's greater than mid, thus l = mid + 1, and eventually will reach a point when l = r, and continue to
 	 	 * 			increase. It reaches a point when l > r, which will be checked.
 	 	 */
 	 	
 	 	// If the element is present at the middle itself; works as a terminating case as well
 	 	if(x == arr[mid]) {			//Terminating
 	 		return mid;
 	 	}else if(x < arr[mid]) { 	// If element is smaller than mid, then it can only be present in left subarray if it exists
 	 		return binarySearch(arr, l, mid - 1, x);
 	 	}else {						// if(x > arr[mid])	Else the element can only be present in right subarray if it exists
 	 		return binarySearch(arr, mid + 1, r, x);
 	 	}
 	 	
 	 	
 	 	//Ref: The normal binary search
 	 	/**
 	 	while(r >= l) {
 	 		int mid = (r + l)/2;
 	         // If the element is present at the middle itself
 		        // works as a terminating case as well
 	 		if(x == arr[mid]) {
 	 			return mid;
 	 		}else if(x < arr[mid]) {
 	         // If element is smaller than mid, then it can only be present in left subarray if it exists
 	 			r = mid - 1;
 	 		}else {
 	         // Else the element can only be present in right subarray if it exists
 	 			l = mid + 1;
 	 		}
 	 	}
 	 	return -l + 1;*/
 	 	
 	}

     // when element is not present in array, works as a terminating case as well

 }



