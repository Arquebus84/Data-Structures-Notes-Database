
public class SortingAlgComparisonSort {
	
	//NOTE on sorting algorithms, the outer loop is i, the inner loop is j, 
	/**NOTE: if you don't connect j to i, then you're **wasting your processing time***/
	
	//NOTE: If you Sort In Place, that means that you are using less memory
	
	/*
	 * 1) Comparison Sort
	 * 		-Selection Sort
	 * 		-Bubble Sort			**Never use Bubble Sort or Selection Sort (bubble is more efficient, in sequentially ordered data)
	 * 		-Insertion Sort			**Will hint at divide and conquer
	 * 		-Merge Sort				**Recursion == divide and conquer	
	 * 		-Heap Sort (*later)
	 * 		-Quick Sort				**Recursive	== divide and conquer
	 * 		-Lower Bound on Comparison Sorting (*later)
	 * 
	 * 2) Linear Sorting			(in SortingAlgorithmsNotes2)	**NOT on the Exam
	 * 		-Counting Sort
	 * 		-Radix Sort
	 * 		-Bucket Sort
	 */
	
	/**	Comparison Sorts Summary and Time Complexity:
	 * 
	 * 		Algorithm		Best		Worst		Average		In Place		Stable		Comments
	 * 		---------------------------------------------------------------------------------------
	 * 		Selection		O(n^2)		O(n^2)					Yes				Yes			None
	 * 		Bubble			O(n)		O(n^2)					Yes				Yes			*Must count swaps for linear best-case running time
	 * 		Insertion		O(n)		O(n^2)					Yes				Yes			*Good if often most sorted
	 * 		Merge			O(nlog(n))	O(nlog(n))				Yes				Yes			*Good for large Datasets that require swapping to disk
	 * 		Heap			O(nlog(n))	O(nlog(n))				Yes				No			*Best if guaranteed O(nlog(n)) required
	 * 		Quick			O(nlog(n))	O(n^2)		O(nlog(n))	Yes				Yes			*Fastest in Practice
	 * 																			 ^CANNOT be BOTH In Place and Stable (one or other)
	 */
	
	/**
	 * 	Comparison Sort		(checking each element)
	 * 			Method 1: smallest element is put first (smallest to largest)
	 * 			Method 2: largest element is put first (largest to smallest)
	 * 		
	 * 		Sort input by successive comparison of pairs of input elements
	 * 				 0  1  2  3   4  5  6  7  8  9
	 * 				[4][3][7][11][2][2][1][3][5][6]
	 * 
	 * 					e.g. 3 < 11?
	 * 		Comparison Sort algorithms are very general: they make no assumptions about the values of input elements
	 * 			Object comparison: compare each of their attributes (values, parameters such as size)
	 * 
	 * 		*Sort in Place: Require only O(1) additional memory
	 * 			**NO additional memory is required; no additional space because both arrays below are the SAME
	 * 
	 * 		*Sorting algorithm is **stable** if the ordering of identical keys in the input is preserved in the output
	 * 				 0  1  2  3   4  5  6  7  8  9
	 * 				[4][3][7][11][2][2][1][3][5][6]
	 * 
	 * 				[1][2][2][3][3][4][5][6][7][11]		* Sorted
	 * 
	 * 		*Stable Sort property is crucial: for example, when entries with identical keys are already ordered by another criterion
	 */
	
	/*		Selection Sort 			Both the worst-case and best-case time complexity is O(n^2)
	 * 			1) Works with Indices***
	 * 			2) Find the ***Smallest first (start at index 0 for outer loop)
	 * 
	 * 		operates by:
	 * 			* First finds smallest element in input list, and moving it to the output list;
	 * 			* Then, it finds the next smallest value and does the same,
	 * 			* Continuing in this way until all the input elements have been selected and placed in the output list in correct order 
	 * 
	 * 				 0  1  2  3   4  5  6  7  8  9
	 * 				[4][3][7][11][2][2][1][3][5][6]
	 * 				 6	4  9  10  2  3	1  5  7  8
	 * 
	 * 				[1][2][2][3][3][4][5][6][7][11]
	 * 
	 * 
	 * 		NOTE: in the algorithm below, it will not guarantee a sorted list because the j_min
	 * 					will not always update
	 * 			**Thus, the worst case is as bad as best case (both are O(n^2))
	 * 			for i = 0 to n-1:
	 * 				//A[0, ..., i-1]: i is smallest keys in sorted order		Will go to A[i]
	 * 				//A[i, ..., n-1]: is remaining keys
	 * 				j_Min = i;
	 * 				for j = i+1 to n-1:								//Nested will have Run Time Complexity O(n^2)
	 * 					if(A[j] < A[j_Min]):
	 * 						j_Min = j;
	 * 					swap A[i] with A[j_Min]		//Will swap regardless (even if j and j_min remain unchanged)
	 * 
	 * 			**Will not sort the list until the entire iteration is done
	 */
	
	/**		Bubble Sort 	(time complexity is still O(n^2), but is more efficient than Selection Sort (WILL sort the array))
	 *  		1) Works with Values***
	 *  		2) Look for ***Largest first (find the last element first since it's supposed to hold the largest)
	 *  			* (Start at final index first for outer loop)
	 *  	NOTE: Will use Bubble sort instead of Selection, because the distribution of data is more sequentially sorted
	 *  
	 * 		operates by:
	 * 			* Successively comparing adjacent elements, swap them if they are out of order;
	 * 			* After first pass, largest element is in correct position;
	 * 			* Continuing in this way until sort the entire array
	 * 
	 * 			 0	 1	 2	 3	 4	
	 * 			[4] [3] [7] [11] [2]		//First: compare 4 and 3 (4 > 3, so swap), we are done with this pair
	 * 			 ^	 ^
	 * 
	 * 			 0	 1	 2	 3	 4	
	 * 			[3] [4] [7] [11] [2]		//Then, compare 4 and 7 (no swap), then 7 and 11 (no swap), then 11 and 2 (11 > 2, swap)
	 * 				 ^	 ^
	 * 
	 *  		 0	 1	 2	 3	 4	
	 * 			[4] [3] [7] [2] [11]		//Going backwards, compare 2 and 11 (no swap), compare 2 and 7 (7 > 2, swap)
	 * 						 ^	 ^
	 * 
	 *		  	 0	 1	 2	 3	 4	
	 * 			[4] [3] [2] [7] [11]		//Continue backwards: compare 11 and 7 (no swap), compare 7 and 2 (no swap)
	 * 				
	 * 							//			compare 2 and 3 (3 > 2 swap), then compare 2 and 4 (4 > 2, swap)
	 * 			 0	 1	 2	 3	 4	
	 * 			[2] [3] [4] [7] [11]		//Final sort
	 * 
	 * 		Algorithm(Bubble Sort):
	 * 			for i = n-1 downto 1		//Front the final element to the beginning element
	 * 				// A[i + 1, ..., n-1]	Largest keys in sorted order
	 * 				// A[0, ..., i]			The remaining keys
	 * 				
	 * 				for j = 0 to i-1
	 * 					if A[j] > A[j+1]
	 * 						swap A[j] and A[j+1]
	 * 
	 * 			//Total running time will be O(n^2)
	 * 		
	 * 			//Worst case will be O(n^2) if the majority of elements are not sorted
	 * 			//Best case will be O(n) if only two elements need to be swapped (only one swap)
	 * 
	 */
	
	/**		Insertion Sort 		(time complexity is still O(n^2))		NOTE: Insertion Sort will act like Bubble sort when the last
	 * 			1) Divide and Conquer									element in the array is greatest (already sorted)
	 * 			2) Look for the **Smallest first
	 * 
	 * 		Similar to Selection Sort and Bubble Sort, Insertion Sort maintains 2 sublists:
	 * 			* Left sublist containing sorted keys
	 * 			* Right sublist containing the remaining unsorted keys
	 * 		Unlike Selection Sort, the keys in left sublist are:
	 * 			* "Not" the smallest keys in the input list
	 * 			* But the "first sorted" keys in the input list (NOTE: first sorted keys are in the left side of the array)
	 * 
	 * 			 0	 1	 2	 3	  4	
	 * 			[4] [3] [7] [11] [5]		//Pick an element that divides the array into two parts
	 * 
	 * 			 0	 1	 2	 3	  4	
	 * 			[4] [3] [7] [11] [5]		//key = 3 (3 and 4 are not in order, so swap)
	 * 
	 * 			 0	 1	 2	 3	  4	
	 * 			[ ] [4] [7] [11] [5]		//key = 3
	 * 			 ^	 ^
	 * 			 0	 1	 2	 3	  4	
	 * 			[3] [4] [7] [11] [5]		//key = 3
	 * 
	 * 			 0	 1	 2	 3	  4	
	 * 			[3] [4] [7] [11] [5]		//key = 7 (4 and 7 are in order), 
	 * 										//	then key = 11 (7 and 11 are in order)
	 * 			 0	 1	 2	 3	  4	
	 * 			[3] [4] [7] [11] [5]		//key = 5 (11 and 5 are not in order)
	 * 
	 * 			 0	 1	 2	 3	  4	
	 * 			[3] [4] [7] [ ] [11]		//key = 5 
	 * 
	 * 			 0	 1	 2	 3	  4	
	 * 			[3] [4] [ ] [7] [11]		//key = 5 
	 * 
	 * 			 0	 1	 2	 3	  4	
	 * 			[3] [4] [5] [7] [11]		//key = 5 
	 * 
	 * 
	 * 		Algorithm:
	 * 			for i = 1 to n-1
	 * 				// A[0, ..., n-1]:	// First i keys of the input in sorted order
	 * 				// A[i, ..., n-1]:	// The remaining keys
	 * 				key = A[i]
	 * 				j = i							//j will be 1 (first loop), but j will NEVER reach the right-most side of the array
	 * 				while(j > 0 & A[j - 1] > key)		// j will be n-2 at the end of loop (NEVER reaches right-most side)
	 * 					A[j] = A[j-1]
	 * 					j = j-1
	 * 				A[j] = key
	 * 
	 */

	/*		Recursive Sorts:
	 * 				* Divide and Conquer is general algorithm design paradigm
	 * 					-Divide: Divide input data S in two disjoint subsets S_1 and S_2
	 * 					-Recur: Solve subproblems associated with S_1 and S_2
	 * 					-Conquer: Combine Solutions for S_1 and S_2
	 * 				The "Base Case" for recursion is a subproblem of size 0 or 1
	 * 
	 * 				* Recursive Sorts: Given list of objects to be sorted		(Ex: Merge Sort, Quick Sort)
	 * 					-Split the list into two sublists
	 * 					-Recursively have two friends sort the two sublists
	 * 					-Combine the two sorted sublists into one entirely
	 */	
	/**
	 * 	Merge Sort (Look on Google Doc for Tree Representation)
	 * 			* A sorting alg. based on divide-and-conquer paradigm
	 * 			* Invented by John Von Neumann (pioneers of computing in 1945). Neumann Architecture
	 * 		
	 * 			Algorithm mergeSort(S)
	 * 			// Input: sequence S with n elements
	 * 			// Output: sequence S sorted
	 * 			if (S.size() > 1){					//If size greater than 1, keep dividing it
	 * 				(S1, S2) = partition(S, n/2)	//Divide	Partition = split into two different arrays (one is lower half 
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
	 * 			
	 * 
	 * 		Merge Sort Tree
	 * 			* NOTE: Divide each part of the sequence by 2 (will be logarithm)
	 * 			* Terminate the recursive call when the number of elements is 1
	 * 			* Each node represents recursive call of merge-sort and stores unsorted sequence before execution, and its partition sorted
	 * 				sequence at end of execution
	 * 			* Root is initial call
	 * 			* The leaves (connections) are calls on subsequences of size 0 or 1
	 * 	
	 * 								[7 2 9 4 | 3 8 6 1 => 1 2 3 4 5 6 7 8 9]
	 * 									/					\
	 * 							[7 2 | 9 4]					[3 8 | 6 1]
	 * 							/		\					/		\
	 * 						[7 | 2]		[9 | 4]			[3 | 8]		[6 | 1]
	 * 						/	\		/	\			/	\		/	\
	 * 					 [7]	 [2]  [9]	 [4]	  [3]	 [8]  [6]	 [1]
	 * 
	 * 
	 * 		Height of the Tree (Depth)		** will be log_2(n) since dividing it by two parts
	 * 			* Height of any binary tree is log(n)***
	 * 			* Height of merge sort tree is O(log(n))
	 * 			
	 * 							root (start)							n number of elements
	 * 						[			]						depth	seq			size
	 * 						/			\						0		1			n
	 * 					[	]			[	]					1		2			n/2
	 * 					/	\			/	\					i		2^i			n/(2^i)
	 * 				[	]	[	]	[	]	[	]
	 * 														Runtime: O(nlog(n))
	 * 			**Depth of tree is the base			
	 * 
	 * 		Merge Sort Discussion:
	 * 			Sort in Place? Yes****
	 * 				Normally, merging is not in-place: new memory must be allocated to hold S. 
	 * 					It's possible to do in-place merging using Linked Lists****
	 * 					* Code is more complicated
	 * 					* Only changes memory usage by a constant factor
	 * 			Stable? Yes***
	 */
	
	/**		Heap Sort (min-Heap and max-Heap: sort from increasing to decreasing order respectively)
	 * 			* Build an array-based (max) heap structure
	 * 			* Iteratively call removeMax() to extract the keys in descending order
	 * 			
	 * 			Run time is still O(nlog(n)) as worst case
	 * 			Sort in place?: Yes
	 * 			Stable? No, because heap operations may disorder the elements in the branches (disorder ties)
	 * 
	 * 		Heap sort isn't stable
	 * 				[3]							[3]							[3]	
	 * 			   /  \			insert 2		/ \			uphead		2nd	/  \  1st
	 * 			[1]     [2]		---->   	  [1]	[2]		----->		  [2]   [2]
	 * 										  /							  /
	 * 										[2]							[1]
	 * 				
	 * 				[3]			insert 2		[3]
	 * 			   /    		---->		1st	/ \ 2nd
	 * 			[2]							  [2]	[2]
	 */
	
	/**		Quick Sort	
	 * 			* Quick sort is divide and conquer algorithm
	 * 			* Not sort in place, because will divide the elements into separate arrays
	 * 				- Will give use arrays L, E, G 
	 * 				- Each of these arrays will contain elements
	 * 				- NOTE: DONT SELECT THE PIVOT RANDOMLY
	 * 
	 * 			Algorithm QuickSort(S)
	 * 			// L: less; E: equal; G:greater
	 * 			// P: pivot or position
	 * 			if	(S.size() > 1)
	 * 				(L, E, G) = Parition(S, p)	//Divide	(key step)
	 * 				QuickSort(L)				//Recur: Small elements are sorted
	 * 				QuickSort(G)				//Recur: Large elements are sorted
	 * 				S = (L, E, G)				//Conquer: Thus input is sorted
	 * 
	 * 
	 * 			**Key Step: Each array (L, E, G) will have their size created with Partition (Partition returns a new array)
	 * 				(L, E, G) = Parition(S, p) 	// p (pivot can be any number, in this case, the last number)
	 * 					- L: all the elements smaller than the pivot p (ex: all elements smaller than 5)
	 * 					- E: all elements equal to p
	 * 					- G: all elements greater than p
	 */ 
	/* 		// NOTE: This partitioning algorithm is not sort-in-place because it will create 3 different arrays that organize 
	 * 					the elements less than the pivot, equal to pivot, and greater than pivot
	 * 			Algorithm Partition(S, p)
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
	/* 
	 * 		Quick Sort Tree
	 * 		*****NOTE: Worst case will remain the same, but the Average Case will improve** (better than Merge)
	 * 				- In Merge sort, all the branches will have log(n) height (each branch is divided into two branches)
	 * 				- In Quick Sort, not all the leaves will have a height of log(n)
	 * 					**Look at example below
	 * 
	 * 			* Better than Merge Sort: minimizes computation by checking less elements
	 * 				- Will check each element based on the pivot
	 * 			* Each node represents a recursive call of quick sort and stores:
	 * 				- Unsorted sequence before the execution and its partition
	 * 				- Sorted sequence at the end of the execution
	 * 			* Root is the initial call
	 * 			* The leaves are calls on subsequences of size 0 or 1
	 * 
	 * 						* Left will be elements smaller than the pivot, right are elements greater
	 * 							 than the pivot (no equal)
	 * 
	 * 		root				[7 2 9 4 3 8 |6| 1 => 1 2 3 4 5 |6| 7 8 9]		*6 is pivot
	 * 									/					\
	 * 					[2 4 3 1 -> 1 2 3 4]				[7 9 7 -> 7 7 9]
	 * 						/			\					  /		\
	 * 					[1 -> 1]	[4 3 -> 3 4]			[ ]		[9 -> 9]
	 * 								 	/	\				
	 * 		depth		 			  [ ]	 [4 -> 4]
	 * 
	 * 			* NOTE: If select the pivot randomly, will be the same as worst case of Merge Sort because the pivot can 
	 * 						result in branch checks that results in height of log(n); same as Merge Sort
	 * 			
	 * 			Running Time of Quick Sort
	 * 				* Worst case for Quick Sort occurs when pivot is unique minimum or maximum element
	 * 					- NOTE: DONT SELECT THE PIVOT RANDOMLY, you need a more sophisticated way to select the pivot
	 * 					
	 * 				* Worst case occurs when pivot is highest/lowest element in the array, which ends up with a time complexity of O(n^2)
	 * 				* One of L and G has size (n - 1) and the other has size 0
	 * 				* The running time is proportional to the sum
	 * 							n + (n - 1) + (n - 2) + ... + 2 + 1
	 * 
	 * 				* Thus, the worst case running time of quick sort is O(n^2)
	 * 
	 * 		* If pivot is selected randomly (NEVER DO), then the Average Case Time Complexity will be O(nlog(n))
	 * 			In the next example, q represents the pivot index, much more sophisticated
	 * 
	 * 		More Discussion on Quick Sort
	 * 			* Sort in Place?		Yes, when using Linked List (pointer manipulation; doesn't require additional space)		
	 * 
	 * 												**NOTE: Quick Sort can't be both sort in place and stable
	 * 			* Stable? 				Yes
	 * 									** Algorithm is stable, however, it does not sort in-place: O(n) new memory is allocated
	 * 											for arrays L, E, and G (therefore taking up more space)
	 */ 
	
	
	/** 	Optimization for Partition in Quick Sort, which will be In-Place: Uses less memory by using only one array instead of splitting
	 * 			In-place Quick Sort
	 * 				3 subsets are maintained
	 * 					* One containing values less than/equal to the pivot
	 * 					* One containing values greater than the pivot
	 *	 				* One containing values yet to be processed
	 *
	 *				* Similar technique to Recursive Binary Search (check if the right-end is still greater than left-end)
	 *
	 *											
	 *													
	 *						p	   i		   j		  r			*NOTE:
	 *						 0  1  2  3  4  5  6  7  8  9				* p and r represent the lower and upper bounds (r is array.length)
	 *						[ ][ ][ ][ ][ ][ ][ ][ ][ ][X]				* i and j represent the indices for values less-than-equal-to
	 *								|			|	  |						the pivot and values greater-than-equal to the pivot, respectively
	 *							<=X	|	>=X		|	  |					* pivot is chosen as 9 (highest value)
	 * 								|			|	  |			
	 * 												>values in 7 and 8 are unrestricted
	 * 
	 * 						* X will be array[r-1] (last element), 
	 * 
	 * 				Algorithm QuickSort(A, p, r)	//p will be 0 and r will be array.length-1 (last element)
	 * 					if (p < r)
	 * 						q = Partition(A, p, r)				//q is an int which represents the index of the pivot****
	 * 						QuickSort(A, p, q - 1)
	 * 						// Small elements are sorted
	 *  					QuickSort(A, q + 1, r)
	 * 						//Large elements are sorted
	 * 						//Thus input is sorted
	 * 
	 * 
	 * 			* In Place Quick Sort only uses one array, saves the memory
	 * 				 inPlacePartition(A, p, r)			//array, lower and upper bound
	 *					x = A[r]
	 *					i = p − 1						// i will be the pivot-1 (0-1) will be -1
	 *					for j = p to r − 1				//When it reaches second-to-last index (array.length-2), it will repeat this process
	 *						if A[j] <= x
	 *							i = i + 1
	 *							swap A[j] and A[i]
	 *					swap A[i + 1] and A[r]			//Swap between i+1 and the last index
	 *						^							//At the end when all elements are swapped, increment i by 1 first 
	 *						|							in order to not get a indexOutOfBoundsException
	 *						|							// Change the "swap A[i + 1] and A[r" code to the one below
	 *					i++
	 *					swap A[i] and A[r]
	 *
	 *											In the partition method, the unrestricted elements are checked if <=X and >=X:
	 *		Before									|					* If it's <=X, then place the element in the <=X section (0->2),
	 *						p	   i		   j	|	  r					then update the size in which they are kept
	 *						 0  1  2  3  4  5  6  7  8  9	
	 *						[ ][ ][ ][ ][ ][ ][ ][ ][ ][X]	
	 *								|			|	  |	
	 *							<=X	|	>=X		|	  |	
	 * 								|			|	  |			
	 * 												>values in 7 and 8 are unrestricted
	 * 		------------------------------------------------------------------------------------------------
	 * 		After
	 * 						p	   i		   j		  r
	 *						 0  1  2  3  4  5  6  7  8  9	
	 *						[ ][ ][ ][ ][ ][ ][ ][ ][ ][X]					* The size for <=X is now from 0 -> 3
	 *									|			|  |	
	 *							<=X		|	>=X		|  |	
	 * 									|			|  |			
	 * 												  >values in 7 and 8 are unrestricted
	 *		-------------------------------------------------------------------------------------------------
	 *			How The Quick Sort-in-place Works: example with 5 element array
	 *				
	 *					[6] [9] [2] [11] [5]		* 5 is selected as pivot
	 *				  i  j								- i is set to -1, and j = 0 (element 6)
	 *													- If the element at j is <= pivot, i will be set to 1, and i and j will
	 *												swap places. 
	 *				NOTE: if something like this occurs when both i and j are at the first element,
	 *					then swapping is unneeded, for example: pivot is 4
	 *						[2] [6] [3] [9] [4]						[2] [6] [3] [9] [4]
	 *					 ^   ^	 									^^
	 *					 i   j		* i is -1 and j is 0			ij		* i and j will be at same index, and j will continue
	 *
	 *			Continuing:
	 *
	 *					[6] [9] [2] [11] [5]	* i will remain -1 and j will be j + 1
	 *				  i		 j
	 *
	 *					[6] [9] [2] [11] [5]	* Here, j is < pivot, so i will be i + 1, and it will swap elements 2 and 6
	 *				  i	i+1	 	 j
	 *
	 *					[2] [9] [6] [11] [5]    * Here, j has reached the pivot p (terminating condition was when p < r in QuickSort method,
	 *				  	i+1			 	 j p		so here, the q is equal to p), and now it will compare between i+1 and p
	 *					 |----------------|
	 *
	 *					[2] [9] [6] [11] [5]	* If the pivot is less than i+1, then swap i+1 and p
	 *				  		i+1		 	  p
	 *						 |------------|
	 *
	 *					[2] [5] [6] [11] [9]	* Repeating will result in		[2] [5] [6] [9] [11]
	 *
	 *				*NOTE: In the example above, the time complexity will be O(n^2) because we used the highest element in the array
	 *					as a pivot. The average case will be O(nlog(n)) if we choose the pivot wisely
	 */
	
	/**
	 * 		Lower Bound and Comparison Sorting
	 * 			Comparison Sort: Decision Trees
	 * 				* For a 3-element array, there are 6 external nodes
	 * 				* For an n-element array, there are n! external nodes
	 * 
	 * 			left (<=)	right (>)			[1:2]	*Compare 1 and 2
	 * 											/	\
	 * 										  /		  \
	 * 										/			\  
	 * 									[2:3]		  	[1:3]		* Compare [2:3]	and then [1:3]
	 * 								   /   \			/  	  \
	 * 								 /     \		    /	    \
	 * 						[<1,2,3>]	[1:3]		  [<2,1,3>]	[2:3]		*Compare [1:3] and then [2:3]
	 * 									/	\			/			\
	 * 							[<1,3,2>]	[<3,2,1>]  [<2,3,1>]	[<3,2,1>]
	 * 
	 * 
	 * 				* To store n! external nodes, a decision tree must have a height of at least [log(n!)]
	 * 				* Worst-case time is equal to the height of the binary decision tree
	 * 							T(n) is element of set Ω(log(n!)) = Ω(nlog(n))
	 * 					Thus, Merge sort and Heap sort are asymptotically optimal
	 * 				* Asymptotically Optimal: Algorithm performs with constant factor of best possible performance for large inputs
	 * 						- How a function behaves as it approaches a value or limit (Ex: derivatives) 
	 */
	
	/**NOTE: Connect i to j to save on processing time*/
	public static void main(String[] args) {
		int[] arr = {4, 8, 2, 16, 5, 11};
		//SortN(arr);
		//SimpleSort(arr);
		//SelectionSort(arr);
		//BubbleSort(arr);
		InsertionSort(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
//	public static void SortN(int[] arr) {
//		int j = 1;
//		for(int i = 0; i < arr.length - 1; i++) {
//			if(arr[j] < arr[i]) {
//				int temp = arr[j];
//				arr[j] = arr[i];
//				arr[i] = temp;
//			}
//			j++;
//		}
//	}
	//In SimpleSort, look for smallest element (not via indices, but with values) combination of selection sort and bubble sort
	public static void SimpleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				if(arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
				
			}
		}
	}	
	
	//Will not sort the list until the entire iteration is done
	public static void SelectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j_min = i;
			for (int j = i + 1; j < arr.length - 1; j++) {
				if(arr[j] < arr[j_min]) {
					j_min = j;
				}
				int temp = arr[j];
				arr[j] = arr[j_min];
				arr[j_min] = temp;
				
			}
		}
	}	
	public static void BubbleSort(int[] arr) {
		for(int i = arr.length - 1; i > 0; i--) {
			for(int j = 0; j < i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void InsertionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int key = arr[i];
			int j = i;
			while((j > 0) && (arr[j-1] > key)) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = key;
		}
	}

}
