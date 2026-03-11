
public class RecursionNotes {
		
	/**	Types of Recursion		(NOTE: Recursion requires induction to break a problem down into smaller parts)
	 * 		1) Linear Recursion
	 * 		2) Binary Recursion
	 */

	/**
	 * Recursion requires:
	 * 		Base case
	 * 		Recursive function Terminate at 0 (i.e. the recursive case must converge to zero (recursiveFunc(n - 1)))
	 * 
	 */
	
	//Example of Linear Recursion: printing hello n times	(will have time complexity of O(n) time)
	public static void RecursiveHello(int n) {
		if(n < 1) {								// Base Case: If n reaches zero, return will
			return;					// NOTE: The return statement is used here to ensure that once this condition is met, the following 
									//		statements of code will not execute, therefore, terminating the program
		}else {
			System.out.println("Hello");
			RecursiveHello(n - 1);
		}
	}
	/**			This recursive call will be represented as a tree, with the root (top) representing
	 * 								n
	 * 							  /	  \
	 * 							n-1	  n-1
	 * 							/	  	\
	 * 						  n-1	  	n-1
	 * 
	 * 				Ex: if n = 5, then it will continue to subtract it until 0 is reached
	 * 								
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		//RecursiveHello(5);
		
		int num = 3;
		int pow = 2;
		System.out.println(num + "! = " + recFactorial(num));
		System.out.println(num + "^" + pow + " = " + recPower(num, pow));
		System.out.println(num + "^" + pow + " = " + fasterRecPower(num, pow));
		
		int k = 6;
		int F_1 = 1;
		int F_km1 = 0;
		System.out.println("BinaryFibonacci(" + k + ") = " + BinaryFib(k));
		System.out.print("LinearFibonacci(" + k + ") = [");
		for(int i = 0; i < LinearFib(k).length; i++) {
			System.out.print((i < 1)? LinearFib(k)[i] + ", " : LinearFib(k)[i] + "]");
		}

		System.out.printf("%nLinearFib2(%d) = %d", k, LinearFib2(F_km1, F_1, k));
	}
	
	/**Linear Recursion*/
	
	//Factorial n! = 1 * 2 * 3 * ... (n - 1) * n
	/*
	 * f(n) = {1, 				n = 0}
	 * 		  {n * f(n - 1),	n > 0}
	 */
	public static int recFactorial(int n) {		//Entire function is called n + 1 times
		if(n == 0) {		// Optimization: n == 1 return 1;
			//Base case
			return 1;						// 1 operation
		}else {
			//Recursive case
			return n * recFactorial(n - 1);	// n operations
		}
		
		//Order of n + 1, n + 1 is O(n)
		//Running time is O(n)
		
	}
	//Power function
	/*
	 * 	p(x, n) = x^n
	 * 
	 * 	= {1,					n = 0}
	 * 	  {x * p(x, n - 1)		n > 0}
	 */
	public static double recPower(double x, int n) {
		if(n == 0) {
			//Base case
			return 1;							// 1 Operation
		}else {
			//Recursive case
			return x * recPower(x, n - 1);		// n operations
		}
		
		//Order of n + 1
		//Running time?		will be O(n)
		//What can we do better? could be log(n) or sqrt(n)			(Recall that it is log_2(n), sub 2**)
	}
	
	//Another recursive func (where base stays same, but split into two different equations)
	/**
	 * p(x, n) =	{1,							n = 0}
	 * 				{x * p(x, (n - 1)/ 2)^2,	n > 0 is odd}
	 * 				{p(x, n)^2,					n > 0 is even}
	 */
	public static double fasterRecPower(double x, int n) {		//Will be Linear Recursion 
																//	(Depending on the condition, recursive function will be called once***)
		if(n == 0) {
			//Base case
			return 1;																		// 1 Operation
		}else if(n % 2 == 1){
			//Recursive case 1
			/**return x * fasterRecPower(x, (n - 1) / 2) * fasterRecPower(x, (n - 1) / 2);		// will have 2 recursive calls (increases the Time complexity 
																									& memory call stack)*/
			return x * Math.pow(fasterRecPower(x, (n - 1) / 2), 2);								//Will only have one recursive call be (n-1)/2 operations
		}else {
			//Recursive case 2
			//return fasterRecPower(x, n/2) * fasterRecPower(x, n/2);							// Operation will also be n/2 operations will be n = 2log(x) 
			return Math.pow(fasterRecPower(x, n/2), 2);											//Will be 1 recursive calls
		}
		//NOTE: in both recursive cases, it will be branching (split into two, therefore, it will be log) {log == branching}
		/**
		 * When there is branching or division, then there is log (n/2)
		 * 		It is log because we start with one recursive call (will be 2 branches), then another
		 * 		 				 n			(x 1/2)
		 * 			   			/ \
		 * 					 n/2   n/2			(x 1/2)
		 * 					/		 \
		 * 		  	 	   n/4		 n/4				(x 1/2)
		 * 		  		   /		   \
		 * 		 	   	 n/8	  	   n/8				(x 1/2)
		 * 
		 */
		
		//n = log(x)
		//Running time will be O(log(n))
	}
	
	/**Binary Recursion: Severely dangerous!!*/
	//		The Use of recursive function two times in the recursive call
	
	/**			Binary Recursion will be represented as a tree, with the root (top) representing the root node
	 * 				Example: if this binary recursion calls the Fibonacci Method (Fib) twice 
	 * 						(once for decrementing by one and twice for decrementing by 2)
	 * 
	 * 							Fib(n)
	 * 						  /	 	  \
	 * 				  Fib(n-1)	        Fib(n-2)			//Each recursive call must remember the previous call, therefore
	 * 				  /	  \		  	   /  	   \			//	it will consume more memory in binary
	 * 			Fib(n-1)   Fib(n-2)  Fib(n-1)	Fib(n-2)
	 * 				/		\			/			\
	 * 			...			...			...			...
	 * 
	 * 
	 * 		At first, since Fib(n-1) is called first, it will check each method that leads up to Fib(n-1), for example, if n = 5
	 * 							Fib(5)
	 * 						  /	 	  \
	 * 				  		Fib(4)	  Fib(3)
	 * 				  		/	  \	
	 * 					Fib(3)   Fib(2)
	 * 					/	  \	
	 * 				Fib(2)   Fib(1)
	 * 				/	  \	
	 * 			Fib(1)   Fib(0)
	 * 
	 * 					After each of the branches on the left are checked, the ones on the left size are tracked
	 * 				This means that in recursion, the method has to keep track of every single previous call (leads to memory issues) 
	 * 							Fib(5)
	 * 						  	 	  \
	 * 				  				  Fib(3)
	 * 								 /	  \	
	 * 							Fib(2)   Fib(1)
	 * 							/	 \	
	 * 						Fib(1)   Fib(0)
	 */	
	/*
	 * Fibonacci numbers defined recursively:
	 * 		F_0 = 0				}
	 * 		F_1 = 1				} if i <= 1
	 * 
	 * 		F_i = F_i-1 + F_i-2, for i > 1
	 * 
	 * 
	 * Golden Ration: F_i/F_i-1	==> [1 + sqrt(5)]/2 = 1.61803...
	 */
	public static int BinaryFib(int k) {	//Dangerous!!
		if(k < 2) {
			return k;
		}else {
			return BinaryFib(k - 1) + BinaryFib(k - 2);
		}
	}
	/**
	 * ******n_k is number of recursive calls  made by binaryFib(k), meaning that the + 1 is the base case
	 * 
	 * n_0 = 1
	 * n_1 = 1											//n_1 and n_0 will have running time equal to 1, because it's the base case that's checked
	 * n_2 = n_1 + n_0 + 1 = 1 + 1 + 1 = 3				//These will calculate running time
	 * n_3 = n_2 + n_1 + 1 = 3 + 1 + 1 = 5
	 * n_4 = n_3 + n_2 + 1 = 5 + 3 + 1 = 9
	 * n_5 = n_5 + n_3 + 1 = 9 + 5 + 1 = 15
	 * 
	 * 
	 * Running time:	n_k > 2^(k/2) increases exponentially!
	 */	
	
	
	//Make Fibonacci linear!
	/*
	 * Modify output as pair of Fib numbers (	F_k, F_(k-1)	)
	 * 
	 * The linear Fib algorithm will return the current number and the number before it (i.e. if k = 6, then it returns (13, 8))
	 * 
	 * Algorithm linearFibonacci(k)
	 * 	if(k = 1) then:
	 * 		return (k, 0)
	 * 	else:
	 * 		(i, j) = linearFibonacci(k - 1)
	 * 	return (i + j, i)
	 * 
	 */
	/**
	 * Recall the switch function for replacing the old number with the new number
	 * 		old = 0;
	 * 		new = 1;
	 * 
	 * 		temp = old;
	 * 		old = new;
	 * 		new = temp;
	 * 
	 * 	In Fibonacci, you add the old to the new to create the next number and replace the old with the former new
	 * 		temp = old;
	 * 		old = new;
	 * 		new += temp;	This will create the next number
	 */
	
	public static int[] LinearFib(int k) {
		// must return 2 elements: {F_k, F_k-1}
		//int i = 1;		//F_k
		//int j = 0;		//F_k-1
		
		int[] fibSequence = new int[2];
		if(k < 2) {
			fibSequence = new int[]{k, 0};
			return fibSequence;				//Return (k, 0)
		}else {
//			int temp = j;	// = F_k-1
//			j = i;
//			i += temp;
			int[] temp = LinearFib(k - 1);							//Used to represent the F_k-1
			fibSequence = new int[]{temp[0] + temp[1], temp[0]};
			return fibSequence;
		}
		
		//Running time will be O(k)
	}
	
	/**		Linear Fibonacci 2
	 * 			Start from 0 and 1, (F_km1 and F_1) and to index k = 4
	 * 				* will switch both starting values and then add
	 * 						int temp = 0_index
	 * 						0_index = 1_index		// F_km1 will be F_1
	 * 						1_index += 0_index 		// (0_index will be 1_index), therefore, at k = 2, it will be 1_index + 1_index = 2
	 * 
	 * */
	// 2nd iteration of linear Fibonacci sequence returns only the F_k value 
	//		start value = 0, next value will be 1, then switch the two
	public static int LinearFib2(int F_km1, int F_1, int k) {								// (F_k-1, F_1, k)
		
		//		(F_k, F_k-1)				
		if(k < 2) {		//i = k and j = 0
			return F_1;
		}else {
			//int temp = LinearFib2(k - 1);	// will be j
			/**int temp1 = LinearFib2(k - 2); // Cannot do this (will be Binary****)*/
			
			return LinearFib2(F_1, F_1 + F_km1, k - 1);		//Switch between F_1 and F_km1
		}		
		//Running time will be O(k)
	}
	
	//Tower of Hanoi - 2 Disks
	/*
	 * 		The least amount of intermediate towers, the harder to solve
	 * 				|| 				||
	 * 				|| 				||
	 * 				|| 				||
	 * 			==========		==========
	 * 		The more, the easier to take each disk out
	 * Algorithm:
	 * 		MoveTower(disk, source, dest, spare){
	 * 			if(disk == 1){
	 * 				move disk from source to dest						//	1 operation
	 * 			}else{
	 * 				MoveTower(disk - 1, source, spare, dest)
	 * 				move disk from source to dest
	 * 				MoveTower(disk - 1, spare, dest, source)
	 * 			}
	 * 
	 * 			Running time:
	 * 				Assume running time is T(n); n is number of disks, recursive definition:
	 * 					T(n) = 1 + 2T(n - 1)
	 * 				then
	 * 					T(n) = 2T(n - 1) => 4T(n - 2) => 8T(n - 3) =>...=> 2^n
	 * 
	 * 				will be O(2^n) exponential
	 * 		}
	 */
	
	//Drawbacks and pitfalls of recursion
	/*
	 * 		Recursive solutions entail cost in time and memory; each recursive call requires that the current process state (variables,
	 * 		program counter) be pushed onto the system stack, and popped once recursion unwinds.
	 * 
	 * Call Stack (Last In First Out)
	 * 		Memory Intensive: In the stack, each recursive call is pushed onto the system stack and popped once
	 * 						recursion unwinds
	 * 
	 * 		In Recursion, when the recursive method is called every n times, then it is pushed to the java stack.
	 * 			This is best seen in the recursive Fibonacci sequence
	 * 
	 * 		recursive method calls
	 * 								push()
	 * 	Last		[call 5]---------		[] *Last time the method is called will be placed in a new call stack
	 * 				[call 4]		|		[]
	 * 				[call 3]		|		[]
	 * 				[call 2]		|		[]
	 * 	First		[call 1]		------>	[]
	 * 
	 * 		Example, if n = 4, here is the representation on the left side of the calculation
	 * 
	 * 						Fib(4)							**Fib(4) will call itself and be pushed into the stack, and then Fib(2) and Fib(3)
	 * 				  		/	  \					[Fib(1)] |	After the methods are all called onto the stack, the last one (Fib(1)) has
	 * 					Fib(3)   Fib(2)				[Fib(0)] |		its value returned, and then Fib(0), and then Fib(2), and so forth
	 * 					/	  \						[Fib(2)] |
	 * 				Fib(2)   Fib(1)					[Fib(1)] |
	 * 				/	  \							[Fib(3)] |
	 * 			Fib(1)   Fib(0)						[Fib(2)] v
	 *												[Fib(4)] 
	 * 				
	 * 			NOTE: Since Fib(2) on the right of Fib(4), after Fib(3) has its value returned, Fib(2) will call itself, and then will
	 * 					have Fib(0) and Fib(1) call themselves, until finally returning their values
	 * 
	 * 				Fib(2)					[Fib(1)] |
	 * 				/	  \					[Fib(0)] |
	 * 			Fib(1)   Fib(0)				[Fib(2)] v
	 *										[Fib(4)]
	 *
	 */
	/**	Qualities of Recursion
	 * 
	 * There must be a base condition: the recursion must ground out!
	 *		if(n == 0){										//**Base condition for recursive factorial
	 *			return 1; } 	
	 *
	 * The base condition must not involve more recursion!
	 * 		if(n == 0){
	 * 			return recursiveFactorial(n - 1); }			//**Cannot return recursive
	 * 
	 * The input must be converging toward the base condition!
	 * 		if(n == 0){
	 * 			return 1; }									//Base Case
	 * 		else{
	 * 			return n * recursiveFactorial(n - 1); }		//Recursive Case
	 * 
	 * 
	 */
	
}