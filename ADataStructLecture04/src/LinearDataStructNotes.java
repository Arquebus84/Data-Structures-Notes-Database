//import LinkedListTest.Node;

public class LinearDataStructNotes {
	/**NOTE: If asked 'what type of data structure will you use?' in an interview; NEVER say Array, say Linked Lists!!!*/

	/*
	 * Arrays
	 * ArrayLists
	 * Linked Lists						**Answer will be Linked Lists (Important******)
	 * 		* Single Linked Lists
	 * 		* Double Linked Lists
	 * Stacks
	 * Queues
	 * 
	 */
	
	/*		Arrays			NOTE: Use arrays when static size is suffice**
	 * 			*Fixed-size sequential collection of elements of same type
	 * 		
	 * 0	1	2	3	4	5	6	7	8	9		(Indices)	array length = 10
	 * []	[]	[]	[]	[]	[]	[]	[]	[*]	[]
	 * 	|								|
	 * 	|							9th element
	 * 	NOTE: We don't know the address of this initial index (0)
	 * 		Compute Address of the array:
	 * 			Initial Address + (Index of element * byte size of element)		//Byte size of int is 4 (4 bytes = (8 * 4 bits))
	 * 				|
	 * 			2204255 (all the memory is byte participle)
	 * 
	 *			//Calculate the 5th element:
	 *				2204255 + (5 * 4)
	 * 	
	 * 
	 * 	Array size is fixed at the time of array's construction
	 * 	array elements are placed contiguously in memory				***Contiguous: Share a common border
	 * 	indexing into a component takes O(1) time
	 * 
	 * Java arrays are homogeneous
	 * 		-All components are of same type (object or primitive or generic)
	 * 		-Array of object type can contain objects of any respective subtype
	 * An array itself is an object
	 * 		-Is allocated dynamically by means of new
	 * 		-Is automatically deallocated when no longer referrred to
	 * When array is first created, all values are automatically initialized with:
	 * 		* 0 for array int[] or double[]
	 * 		* false for boolean[] 
	 * 		* null for array of objects (String, Circle, etc.)
	 * 
	 * Best Time Complexity in Array
	 * 		* O(1) (or omega(1)) when inserting an element at the last point in the array
	 * 
	 * Limitations of Arrays:
	 * 		-Static data structure
	 * 		-Insertion/deletion in an array is time consuming:
	 * 			It will be O(n) (worst-case time complexity; and n represents array size)
	 * 			Worst time happens when deleting the first element
	 * 
	 * 			Insert an entry e in index 3	**Will shift the elements to the right
	 * 		[a]	[b]	[c]	[d]	[f]	[g]	[h]	[]	[]	[]
	 * 					->	->	->	->	->
	 * 
	 * 			After:							**Shifting will have Time Complexity of O(n)
	 * 		[a]	[b]	[e]	[c]	[d]	[f]	[g]	[h]	[]	[]
	 * 
	 * 			Deleting element at index 3 		**Will shift elements to the left (can go the other way around), 
	 * 		[a]	[b]	[e]	[c]	[d]	[f]	[g]	[h]	[]	[]		and put a null value on index 7 (nullify index 7), otherwise, you will
	 * 													get a copied index
	 * 			After
	 * 		[a]	[b]	[c]	[d]	[f]	[g]	[h]	[null]	[] []
	 */
	
	/*ArrayLists	*/
	
	/**	ArrayLists		(Object-Oriented programming)			NOTE: Use ArrayLists when size needs to be dynamic**
	 * 		*Dynamic sized arrays in Java that implements List interface
	 * 			-Not static sized (static size is arrays)
	 * 	ArrayList {
	 * 		size();
	 * 		isEmpty();
	 * 		add(int i, E e);		//If not specify the index, will add the element at the end
	 * 		get(int i);
	 * 		remove(int i);			//Move every other element after specified index to the left and nullify the end
	 * 		set(int i, E e);
	 * }
	 * 
	 * 		In the array based implementation
	 * 			* The space used by data structure is O(n)
	 * 			* size, isEmpty, get, and set run in O(1) time
	 * 			* add and remove run in O(n) time as these two operations need to
	 * 					 shift forward and backward on the array, respectively
	 * 
	 * 
	 * 		When array is full, instead of throwing an exception, replace the array with a larger one
	 * 			*EX:
	 * 				arr[5]
	 * 			
	 * 				[J]	[M]	[O]	*This is a size 3 array (initial array is static in size)
	 * 					//Want to add two more elements P and R
	 * 				[J]	[M]	[O]	[P]	[R]		*Create a new array of greater size in order to include the extra elements
	 * 					//There can be more students to be put in the array; do the same thing again	 * 				
	 * 				[J]	[M]	[O]	[P]	[R]		N1 N2 N3
	 * 
	 * 		//**For example: When 30 students already occupy the limit N = 30 size of classroom, increase the size by 
	 * 			creating a new array of greater size
	 * 		
	 * 		Algorithm - add(element)
	 * 			newArray = new array of size newN	*newArray has size newN (which is > N)
	 * 			if n = N then:						*Check if the initial array size reaches the capacity of N
	 * 				for i = 0 to N - 1 do:			*The for loop will copy every element in the original array
	 * 					newArray[i] = array[i]
	 * 				array = newArray
	 * 				n = n + 1						*increase the size of the new array (Can optimize the code by omitting this line)
	 * 				array[n] = element				*Add the newest element at the newest point
	 * 
	 * 			NOTE: for optimizing, omit the line n = n + 1, and change the next line:
	 * 				array[n++] = element
	 * 
	 * 			*Incremental strategy: Increase size by a constant C (Ex:)
	 * 			*Doubling strategy: Double the size
	 * 			
	 * 
	 * 		Incremental Strategy analysis
	 * 			[n]	==	[N]		[]						*Ceil will round ratios up
	 * 			[0]		[0]		[]
	 * 			[1]		[c]		[Extend array]				Replace the array k = ceil(n/c) times
	 * 			[2]		[c]		[]							The total time T(n) is proportional to:
	 * 			[...]	[...]	[]						n + c + 2c + 3c + 4c +...+ kc = n + ck(k+1)/2
	 * 			[c]		[c]		[]						
	 * 			[c + 1]	[2c]	[Extend array]			Since c is constant
	 *			[...]	[...]	[]							T(n) is O(n + k^2), i.e, O(n^2)
	 * 			[2c]	[2c]	[]
	 * 			[2c + 1][3c]	[Extend array]			The amortized time of an add(element) operation is O(n)
	 * 			[...]	[...]	[]
	 * 			[n]		[kc]	[k = ceil(n/c)]
	 * 
	 * 
	 * 		Doubling Strategy analysis (Probably best one to use)
	 * 			[n]	==	[N]		[]						*Ceil will round ratios up
	 * 			[0]		[0]		[]
	 * 			[1]		[1]		[Extend array]				Replace the array k = ceil(n/c) times
	 * 			[2]		[2]		[Extend array]				The total time T(n) is proportional to:
	 * 			[3]		[4]		[Extend array]			n + 1 + 2 + 4 + 8 +...+2^k = n + 2^(k+1) - 1 <= 5n
	 * 			[4]		[4]		[]						
	 * 			[5]		[8]		[Extend array]			Since c is constant
	 *			[6]		[8]		[]							T(n) is O(n)
	 * 			[7]		[8]		[]						The amortized time of an add(element) operation is O(1)
	 * 			[...]	[...]	[]
	 * 			[n]		[kc]	[k = ceil(log(n))]
	 * 
	 * 
	 * 	* Whichever strategy is better, depends entirely on the size of the Array!
	 * 			-Sometimes Increment strategy is better if there are only a "few" elements to add
	 * 			-Double strategy is good for "many" elements 
	 * 				* Double also better if there are new elements coming in at a faster rate
	 */
	
	/*Linked Lists (Singly and Doubly)*/
	
	/**
	 * 	Linked Lists	(Very Important)
	 * 		* A concrete data structure  consisting of a sequence of nodes		**Instead of treating each point in the array as an
	 * 																			element; treat each as a node
	 * 		* Each node stores
	 * 			- Element (each element stores an address)
	 * 			- link to the next/previous node			***Can change links depending on where the new node will be put
	 * 
	 * 		* Notation of each Node:	for singly and doubly linked lists
	 * 				[Value][Address]---->					*Singly
	 * 
	 * 				<----[Address][Value][Address]---->		*Doubly
	 * 			
	 * 			***NOTE: Each node contains a value of the element and an address pointing to the next node
	 * 						* The address is also called a pointer in C languages
	 * 						* The final node will have a null address
	 */
	 /** 
	 * 	 head/first/root		tail/last
	 * 		  |						|
	 * 		[e_1][adr_e2]---->[e_2][adr_e3]----->[e_3][null]----->[X]							Singly Linked list (Move only one direction)
	 * 
	 * 
	 * 	 header(root)													trailer
	 * 		|															  |
	 * 		[X]<---->[*][e_1][*]<---->[*][e_2][*]<---->[*][e_3][*]<----->[X]	Doubly linked list (Move in both directions)
	 * 
	 * 			Notation
	 * 					([data][*]------>)	Connectors
	 * 						|	|
	 * 					 data	pointer(address)
	 * 
	 * 		NOTE:
	 * 			*In a singly linked list, a head is the first node
	 * 				-When implementing a new node within two nodes, the new node must extend to the next node, and the prev node
	 * 					has to extend to the new node:
	 * 
	 * 				put:	[e_A] between [e_1] and [e_2]
	 * 
	 * 					[e_1][*]---->[e_2][*]----->[e_3][*]----->[X]
	 * 								  |
	 * 							[e_A][*]
	 * 				
	 * 				***For [e_A][addr], the addr will be the address for e_2, when that is established, e_1 will
	 * 				establish a link to e_A (pointer/address of e_A) and then discard pointer to e_2
	 * 				
	 * 				will be:
	 * 					[e_1][*]---->[e_A][*]---->[e_2][*]----->[e_3][*]----->[X]
	 * 
	 * 			* Remove [e_2], have [e_A] attach to [e_3], and discard [e_2]
	 * 
	 * 					[e_1][*]---->[e_A][*]---->[e_3][*]----->[X]			
	 * 										
	 * 										[e_2][*]----->
	 * 
	 * 			*In a doubly linked list, both header and trailer are place-holders
	 * 				-The header is null node (contains no element and no address) 
	 * 					that points to the first element
	 * 				-The trailer is a null node
	 */
	
	/* 		Singly Linked List: Node Class
	 * 
	 * 			private static class Node<E>{		// E is the Data Type (generic data type)
	 * 				private E element;				// element is the generic type that we want to return
	 * 				private Node<E> next;			// Must
	 * 				//private Node<E> prev			// commented out because previous will not be obtained for singly
	 * 				public Node(E e, Node<E> n){
	 * 					element = e;
	 * 					next = n;
	 * 					//prev = p
	 * 				}
	 * 				public E getElement() { return element;}
	 * 				public Node<E> getNext() { return next;}
	 * 				//public Node<E> getPrev() { return prev;}
	 * 				public void setNext(Node<E> n) { next = n;}
	 * 				//public void setPrev(Node<E> p) { prev = p;}
	 * 			}
	 */
	
	/*		Doubly Linked List: Node Class
	 * 			
	 * 			private static class Node<E>{		// E is the Data Type (generic data type)
	 * 				private E element;				// element is the generic type that we want to return
	 * 				private Node<E> next;
	 * 				private Node<E> prev			// previous will be obtained for doubly
	 * 				public Node(E e, Node<E> p, Node<E> n){
	 * 					element = e;
	 * 					prev = p;
	 * 					next = n;
	 * 				}
	 * 				public E getElement() { return element;}
	 * 				public Node<E> getNext() { return next;}
	 * 				public Node<E> getPrev() { return prev;}
	 * 				public void setNext(Node<E> n) { next = n;}
	 * 				public void setPrev(Node<E> p) { prev = p;}
	 * 			}
	 */
	
	/** 	Singly linked list: ADT					(Abstract Data Type)
	 * 			private Node<E> head = null;
	 * 			private Node<E> tail = null;
	 * 			//	Number of nodes in the list
	 * 			private int size = 0;
	 * 
	 * 			public int size()
	 * 			public boolean isEmpty()
	 * 			public E first()				//Since head and tail are of Node<E> type, for first(), return head.getElement()
	 * 			public E last()
	 * 			public void addFirst(E e)
	 * 			public void addLast(E e)
	 * 			public E removeFirst()			//NOTE: Cannot removeLast() because it will be O(n) due to
	 * 											//Missing the addBetween() method for inserting element between
	 *  
	 * 
	 *		//NOTE: addFirst() adds a new node in the first element, so the head will be the last element that you pushed
	 * 			Singly Linked Lists: addFirst(E e)
	 * 				NOTE: in reversed order, use addFirst()
	 * 																//If there's no tail, then start from the head
	 * 		head									tail			//tail is reference that is assigned to something
	 * 		 |							  			|
	 * 		[e_0][*]---->[e_1][*]---->[e_2][]----->[e_3][*]----->[X]
	 * 			public void addFirst(E e) {
	 * 				head = new Node<>(e , head );		//**Assign head Node to head, because it will need an address: head node needs an element
	 * 				if(size == 0)						
	 * 					tail = head;					//**When there is no node in the next node, the next node will be head***
	 * 				size++;								//		When there is no node in prev node, prev node will be head
	 * 			} 
	 * 
	 */ 
	/*			NOTE:
	 * 	//Could also do it as this (easier to remember for addLast() method):
	 * 				public void addFirst(E e) {						//Add to the head, replace head node
	 * 					Node<E> newest = new Node<>(e , head );	
	 * 					if(size == 0)								//If empty, then tail will have same value as head node
	 * 						tail = newest;					
	 * 					head = newest;
	 * 					size++;
	 * 				} 
	 */
	
	/** 			Singly Linked Lists: removeFirst()
	 * 
	 * 						head					tail
	 * 						|			  			| 
	 * 		[e_0][*]	[e_1][]---->[e_2][]----->[e_3][*]----->[X]
	 * 			public void removeFirst() {
	 * 				if(isEmpty()) return null;
	 * 				E answer = head.getElement();
	 * 				head = head.getNext();
	 * 				size--;
	 * 				if(size == 0)
	 * 					tail = null;
	 * 				return answer;
	 * 			} 
	 * 
	 * 		//addLast() pushes nodes to the last element, so it builds up, so the head will be the first element that you pushed
	 * 				NOTE: in forward order, use addLast()
	 * 			Singly Linked Lists: addLast()
	 * 					head					 tail---->[e_4][*]
	 * 					  |								   ^	\
	 * 					  v								  /		 v
	 * 					[e_1][*]---->[e_2][]----->[e_3][*]		[X]			//NOTE: e_3 points to e_4
	 * 																		//	e_4 points to trailer ([X])
	 * 											//e_3 will point to the last node**
	 * 
	 * 				//NOTE: Do the tail assignment first: the tail for e_3 no longer exists (diminished), so the connection
	 * 							from e_3 to trailer is diminished
	 * 						The tail is now pointing to e_4
	 * 				
	 * 				//NOTE: In order to find an element (search), must traverse from root (head) towards that 
	 * 					element (node); which is done by linear search (loop from i = 0 to n)
	 * 						- Therefore, finding a node is done in O(n) operations
	 * 						
	 * 						* Update e_2, start from head and keep going until reach e_2
	 * 						Still have reference to e_2, but cannot go to e_2 because it's a singly linked list
	 * 						1) connect e_4 to trailer
	 * 						2) connect e_3 to e_4			**STEPS 2 and 3 are very important
	 * 						3) assign tail to e_4
	 * 
	 * 			**Focus on Time Complexity, adding/removing nodes in linked lists will be done in O(1) time 
	 * 
	 * 		//NOTE: When the list is first empty, the tail will be set to newest regardless
	 * 			public void addLast(E e) {
	 * 				Node<E> newest = new Node<>(e, null)
	 * 				if(isEmpty())			// previously empty list
	 * 					head = newest;		//**head will be the newest(newest will act as the tail)
	 * 				else					// new node after existing tail
	 * 					tail.setNext(newest);		//tail will have the null address and element
	 * 				tail = newest;			// tail will become the new node
	 * 				size++ 
	 * 			}
	 * 
	 * 			Singly Linked Lists: removeLast()
	 * 					head					 tail		[e_4][*]
	 * 					  |							|	  		
	 * 					[e_1][*]---->[e_2][]----->[e_3][*]----->[X]
	 * 																		
	 * 			public void removeLast(E e) {} 	//**There is no constant time way to update tail to point in previous node
	 * 		
	 * 			//Won't be O(c) but will be O(n)
	 * 		
	 */
	
	//NOTE: the header in doubly linked list will have null address (same as tail)
	/**	Linked Lists: Doubly Linked Lists (ADT)
	 * 		private Node<E> header = null;	//Has to be = new Node(null, null, null)	//Doubly has to have element, prevAddress, nextAddress
	 * 		private Node<E> trailer = null;	//Has to be = new Node(null, header, null)
	 * 		private int size = 0;
	 * 		
	 * 		public int size()
	 * 		public boolean isEmpty()
	 * 		public E first()
	 * 		public E last()
	 *  	public void addFirst(E e)
	 * 		public void addLast(E e)
	 *  	public E removeFirst()
	 * 		public E removeLast()
	 *  	public void addBetween(E e, Node<E> predecessor, Node<E> successor)
	 * 		public E remove(Node<E> node)
	 *
	 *	
	 *	Doubly Linked List: addBetween() and remove()
	 *			*Easier in Doubly than Singly linked lists because of bi-directional advantage
	 *	header															trailer
	 * 		|															  |
	 * 		[X]<---->[*][e_1][*]<---_->[*][e_2][*]<---->[*][e_3][*]<----->[X]
	 *
	 * 										   
	 * 										   [*][	e_0	][*]	
	 *
	 *			**NOTE: Once e_2 points to e_0, the link from e_2 to e_3 is lost!!
	 *
	 * 	header															trailer
	 * 		|															  |
	 * 		[X]<---->[*][e_1][*]<---_->[*][e_2][*]<---->[*][e_3][*]<----->[X]
	 * 										   ^ |		^ |
	 * 										   | |		| |
	 * 										   | v		| v
	 * 										   [*][	e_0	][*]
	 * 
	 * 			**NOTE: remove link from e_0 to e_3 (or from e_0 to e_2) first, and then have either e_2 connect to e_3 or
	 * 						e_3 connect to e_2 until bi-directional link is established
	 * 
	 * 	header															trailer
	 * 		|															  |
	 * 		[X]<---->[*][e_1][*]<---_->[*][e_2][*]<---->[*][e_3][*]<----->[X]
	 *
	 * 										   
	 * 										   [*][	e_0	][*]
	 * 
	 * 			// Which point to remove is from e_0 to the next or previous node, so you could either remove
	 * 		the point from e_0 to e_3 or the point from e_0 to e_2 because of doubly directions
	 * 
	 * 			// NOTE: Order Matters for adding nodes, but doesn't matter when removing nodes
	 * 
	 * 		Doubly Linked List: AddBetween()
	 * 
	 * 		//Old: Does not work with addFirst() method b/c it does not account for the linked list being empty
	 * 				public void addBetween(E element, Node<E> predecessor, Node<E> successor){
	 * 					Node<E> newest  = new Node<>(e, predecessor, successor);
						predecessor.setNext(newest);
						successor.setPrev(newest);
						size++;
					}
					
	 * 		//New
	 * 			AddBetween(E element, Node<E> predecessor, Node<E> successor){
	 * 				Node<E> newest = new Node<>(element, predecessor, successor)
	 * 				if(isEmpty()){
	 * 					head.setNext(newest);			// head will be null, but the head.getNext() will have a value
	 * 					tail.setPrev(newest)			// tail will be null, but the tail.getPrev() will have a value
	 * 				}else{
	 * 					successor.setPrev(newest);		// After head and tail are defined, set each of their next/previous parts to the newest
	 * 					predecessor.setNext(newest);
	 * 				}
	 * 				size++;
	 * 			}
	 */
	
	/* 
	 * 		Benefits of Linked Lists (pro)
	 * 			* Insert/remove doesn't shift the elements in the list
	 * 				- Done in O(1) time
	 * 
	 * 		Limitations of Linked Lists
	 * 			* Not contiguous (like arrays), so cannot store contiguously
	 * 			* Not sortable
	 * 			* Must traverse list to find the element (node) in the list
	 * 				- Done in O(n) time
	 */
	
	/*Stacks and Queues*/
	
	/**	Stack (LIFO): Last In First Out
	 * 		* Idea is arrays: could use array, ArrayList, or linked lists ()primarily use linked lists
	 * 
	 * 			push--------v			pop
	 * 					top	[]----------^
	 * 						[]
	 * 						[]
	 *  					[]
	 *  					[]
	 *  			bottom	[]	0
	 * 
	 * 		* Stack ADT stores arbitrary objects
	 * 		* Insertions and deletions follow the first-in first-out scheme (push-pop)
	 */ 
	
	/**NOTE: In a stack, when we push an element into a stack, it will be inserted at the bottom, and the newer elements
	 * 			will stack on top of the first one
	*/
	
	 /* 	public interface Stack<E>{
	 * 			int size();
	 * 			boolean isEmpty();
	 * 			void push(E e);		//Adds a new node in the stack (item)
	 * 			E top(); 			//returns top most element value without removing it (doesn't decrease the size by anything)
	 * 			e pop(); 			//Returns value of top most element
	 *		}
	 * 			//NOTE:	java.util.Stack provides push and pop, but differs in other respects
	 */	
	/** 	Array-Based Stack: ArrayStack.java
	 * 
	 * 		public class ArrayStack<E> implements Stack<E>{
	 * 			private E[] data;
	 * 			private int top = -1;				//AKA t
	 * 			//Index of top element in stack
	 * 			
	 * 			public int size()
	 * 			public boolean isEmpty()
	 * 			public void push(E e)				//Pushes the front-most element (Last-In First-Out)
	 * 			public E pop()
 	 * 		}
 	 * 
 	 * 		Array Stack Representation:
 	 * 			(rear)									(front)
	 * 				0 	1	2	3	4	5	6	7	8	9
	 * 				[]	[]	[]	[]	[]	[]	[]	[]	[]	[]
	 * 					bottom....top	-->
	 * 
	 * 		// Performance: each operation runs in time O(1)
	 * 		// Limitations: Fixed size	
	 */
	
	/**	Queues (FIFO): First In First Out
	 * 								dequeue
	 * 			top/front	[]----------^
	 * 						[]
	 * 						[]
	 *  					[]
	 *  					[]
	 *  		bottom/rear	[]
	 * 						^
	 * 						|
	 * 				enqueue
	 * 
	 * 				Enqueue enters element in first (bottom to top)
	 * 				Dequeue returns element back the last element (top to bottom)
	 * 
	 * 	* The Queue ADT stores arbitrary objects
	 * 	* Insertions and deletions follow first-in first-out scheme (FIFO)
	 */ 
	
	/* 
	 * 	Queue interface
	 * 
	 * 			public interface Queue<E>{
	 * 				int size();
	 * 				boolean isEmpty();
	 * 				void enqueue(E e);			//Inserts a new element
	 * 				E first();
	 * 				E dequeue();				//(If invoked) Pushes the first element in the Queue; first-in first-out manner
	 * 			}
	 */ 
	/** 	Array-Based Queue
	 * 			public class ArrayQueue<E> implements Queue<E>{
	 * 				/**Generic array used for storage of queue elements/
	 * 				private E[] data;
	 * 
	 * 				/**Index of the top element of the queue in the array/
	 * 				private int front = 0;		//AKA f 
	 * 
	 * 				/**Current number of elements in the queue/
	 * 				private int size = 0;		//AKA sz
	 * 				
	 * 				public int size()
	 * 				public boolean isEmpty()
	 * 				public void enqueue(E e) throws IllegalStateException
	 * 				public E first()
	 * 				public E dequeue()					//Pushes the first-most element out (First-In First-Out)
	 * 	
	 * 			}
	 * 
	 * 		Array Queue Representation:
	 * 			(front)									(rear)
	 * 				0 	1	2	3	4	5	6	7	8	9
	 * 				[]	[]	[]	[]	[]	[]	[]	[]	[]	[]
	 * 
	 * 		Array-Based Queue: Mod Operation (modulus % will obtain the remainder of an operation)
	 * 
	 * 							(f)									(r)
	 * 							0 	1	2	3	4	5	6	7	8	9
	 * 							[]	[]	[]	[]	[]	[]	[]	[]	[]	[]
	 * 		
	 * 		/**Enqueue for ***inserting new elements at the top of the Queue
	 * 			Algorithm enqueue(o):			//Object o is of generic type
	 * 				if size() = N - 1 then:
	 * 					throw new IllegalStateException()
	 * 				else:
	 * 					r = (f + sz) mod N		//Change the rear to (front + size) % N (N is size() of the Queue)
	 * 					Q[r] = o				//The rear (last element) will be the inserted element o (Q is the generic array)
	 * 					sz = sz + 1;			//Increase the size by one
	 * 
	 * 			//Example size = 3
	 * 				[5]		enqueue(9): r = size-1, f = 0, r = (0 + 3)%3 will be 0 (index 0 will change):
	 * 				[2]					r = 0	Q[r] = 9, size++;
	 * 				[1]
	 * 
	 * 
	 * 			**NOTE: could also implement a Stack's push method to achieve the same result:
	 * 			Algorithm enqueuePush(o):				
	 * 				if size = size()-1:
	 * 					throw new Exception() 
	 * 				else:								//Stack objects S1 and S2
	 * 					S1.push(o)						//Push the new element into the list
	 * 
	 * 		
	 * 		/**Dequeue for ***deleting first element of the Queue
	 * 			Algorithm dequeue():
	 * 				if isEmpty() then:
	 * 					return null
	 * 				else:
	 * 					o = Q[f]				//The object will be at the front of the generic array (at the start)
	 * 					Q[f] = null;			//Make the front null (value of f will change to the next index)
	 * 					f = (f + 1) mod N		//Change the front to (f + 1) % N  (N is size() of the Queue)
	 * 					sz = sz - 1;			//Decrease size by one
	 * 					return o;				//Return the removed first object
	 * 
	 * 			//Example size = 3, object will always be at the first index
	 * 				[5]		dequeue(): f = 0, Object o = Q[f],  f = (f + 1)%3 (1%3 = 1); f will be index 1 (index 0 will become 1):
	 * 				[2]					size--
	 * 				[1]
	 * 
	 * 	NOTE: In Queue, removing from front has to push all these elements to the front of the queue				
	 * 
	 * 
	 * 			**NOTE: could also implement a Stack's pop method to achieve the same result:
	 * 			Algorithm dequeuePush(o):				
	 * 				if isEmpty():
	 * 					return null 
	 * 				else:								//Stack objects S1 and S2
	 * 					for(i = 0 to data.length-1):
	 * 						S2.push(S1.pop())
	 * 					
	 * 
	 * 
	 * 			//Performance For both Enqueue and Dequeue: Runs in O(1) time
	 * 			//Limitations for Queues: Fixed Size
	 */
	
	/*
	 * 		Stacks and Queues methods:
	 * 
	 * 		pop()		==		dequeue()		Pulls element out the list
	 * 		push()		==		enqueue()		Puts element in the list
	 * 
	 * 		* Stack is LIFO, so pop() will take out last element
	 * 		* Queue is FIFO, so dequeue will take out first element
	 */
	
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.printf("Incremental Strategy%n");
		int[] arr = new int[4];
		int[] newArr = add(2, arr, 4); newArr = add(3, arr, 4); newArr = add(6, arr, 4); newArr = add(1, arr, 4);
		newArr = add(5, arr, 4);
		for(int i : newArr) {
			System.out.printf("%d ", i);
		}
		long end = System.currentTimeMillis();
		System.out.printf("%nTotal Time: %d", (end - start));
	}
	
	//Incremental Strategy
	public static int[] add(int element, int[] array, int N) {
		//Use the Math.ceil function to round up the 
		
		int[] newArr;
		int count = 0;
		for(int i : array)
			count += (i == 0)? 0 : 1;
		
		if((count) == N) {
			newArr = new int[array.length + 1];
			
			for(int i = 0; i < array.length; i++) {
				newArr[i] = array[i];
			}
			newArr[newArr.length - 1] = element;
			
			//Return new array of new size
		}else {
			//If the size of the array doesn't exceed the limit, then place the newest number at the top of the list
			//newArr = new int[array.length];
			newArr = array;
			for(int i = 0; i < array.length; i++) {
				if (array[i] == 0) {
					newArr[i] = element;
					break;
				}
			}
		}
		return newArr;		
	}	

}
