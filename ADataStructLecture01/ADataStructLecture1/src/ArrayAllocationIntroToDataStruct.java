
public class ArrayAllocationIntroToDataStruct {
	/*
	 * Data Structure
		- An organization of data or information, usually in memory, such as array, queue, or stack.
			- A representation of the logical relationship existing between individual elements of data.
			- Data structures provide an organized way to access and manipulate the information, thus 
				affecting the design of both structural and functional aspects of a program.
					
					Programs = Data Structures + Algorithms
	 */
	
	/**		NOTE: The size of each element is important for memory allocation (ex: int data type has max size of 2^31 - 1)
	 * 
			4-byte sized integer in an array (notice the addressed are n + 4)
				
		Address: 	200 	204 	208		212 	216 	220 	224 	228 	232
		Element:	[23]	[14]	[9]		[18]	[87]	[19]	[2]		[43]	[56]
		Index:		0		1		2		3		4		5		6		7		8			(array size = 9)

			If we define int[] Array as the array for these elements, then Array is the **Starting Address**
					which will have a default element of 0 and a starting address (pointer) of 200
					
			To find an element in the array, you must find its address***
			Start with the initial address, and then use the specified index along with the 
				size of the element (each element will have size 4 bytes)
			
			Representation of Array[index] = element

				Array[index] ==> elementAddress = startingAddress + (index * elementSize)
				
				Ex: find element address at index 2 and 5
				
				elementAddress = 200 + (2*4) = 208
				
				elementAddress = 200 + (5*4) = 220
				
			NOTE: Since the equation is constant, it will be done in O(1) time
	 */
	
	public static void main(String[] args) {
		int[] array = {3, 16, 2, 9};
		
		// Data type int has max size of 2^31 - 1 bits
		//final int MAX_INT_SIZE = (int)(Math.pow(2, 31) - 1);
		//System.out.println("Max Int Size = " + MAX_INT_SIZE);
		
		//Integers (32 bits) will have memory size of 4 bytes (4 * 8 = 32) 
		// Use Integer.SIZE() to obtain the starting address
		
		int index = 0;
		System.out.println("Array Object Address: " + array.hashCode());
		System.out.println("Element at index " + index + " will have address: " + (array.hashCode() + (index * Integer.SIZE)));
	}
}
