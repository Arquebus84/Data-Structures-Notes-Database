import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class StacksTest {
	
	public static void main(String[] args) {
		//Test 1
		ArrayStack<Integer> stackArr = new ArrayStack<>(5);
		stackArr.push(2); stackArr.push(4);
		
		stackArr.printStack();
		
		//Test 2: built-in
		Stack<Integer> stk = new Stack<>();
		stk.push(2);
		stk.push(3);
		stk.toString();
		
		System.out.println();
		//Test 3: File IO
//		try {
//			File file = new File("C:\\Users\\matte\\TextFiles\\IntegerList.txt");
//			Scanner scan = new Scanner(file);
//			
//			
//			ArrayStack<Integer> stack = new ArrayStack<>(8);
//			
//			while(scan.hasNext()) {
//				//System.out.println(scan.next());
//				stack.push(scan.nextInt());
//			}
//			stack.printStack();
//			scan.close();
//			
//		}catch(Exception ex) {
//			System.out.println("File Not Found");
//		}
		
	}
	
	/**
	 * Array Stack Representation:
 	 * 			(rear)									(front)	top*
	 * 				0 	1	2	3	4	5	6	7	8	9
	 * 				[]	[]	[]	[]	[]	[]	[]	[]	[]	[]
	 * 					bottom....top	-->
	 */
	/**	Stack (LIFO): Last In First Out
	 * 		* Idea is arrays: could use array, ArrayList, or linked lists ()primarily use linked lists
	 * 
	 * 			push--------v			pop
	 * 					top	[]----------^
	 * 						[]
	 * 						[]
	 *  					[]
	 *  					[]
	 *  			bottom	[]
	 * 
	 * 		* Stack ADT stores arbitrary objects
	 * 		* Insertions and deletions follow the first-in first-out scheme (push-pop)
	 */ 
	
	private static interface StackNode<E>{
		int size();
		boolean isEmpty();
		void push(E e);	//Adds a new node in the stack (item) (increases size by 1)
		E top(); //returns top most element value without removing it (doesn't decrease the size by anything)
		E pop(); //Returns value of top most element (decreases size by 1)
	}
	
	private static class ArrayStack<E> implements StackNode<E>{
		
		private int size;
		private E[] data;
		private int top = -1;				//t (NOTE: if top = 0, then you an increment size by top++ in push())
		//Index of top element in stack
		
		public ArrayStack(int size){
			this.size = size;
			data = (E[])new Object[size()];
		}
		
		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean isEmpty() {
			if(size() < 1)
				return true;
			else
				return false;
		}

		@Override
		public void push(E e) {		//Add elements to the top
			if(isEmpty()) {
				throw new IllegalStateException();
			}else {
				data[++top] = e;	//Increment top index first*, then assign it to data
			}						//NOTE: if top = 0, then you can do top++, but this is just for practice
		}
		@Override
		public E top() {
			if(isEmpty()) {
				return null;
			}else {
				E topStack = data[size() - 1];
				return topStack;
			}
		}

		@Override
		public E pop() {
			if(isEmpty()) {
				return null;
			}else {
				E key =  data[size() - 1];
				data[top] = null;
				size--;
				return key;
			}
		}
		
		public void printStack() {
			for(int i = 0; i < size(); i++) {
				System.out.print(data[i] + " ");
			}
		}
		
	}


}
