
import java.util.Stack;
public class StacksAndQueuesCombination {
	
	public static Stack<Integer> S1, S2;
	
	/**	Push and pop (enQ and deQ) and element from S1 to S2
	 * 		push()
	 * 	[]------		[]
	 * 	[]		|		[]
	 * 	[]		|		[]
	 * 	[]		|		[]
	 * 	[]		------>	[]
	 *  S1				S2
	 *  
	 *  Then pop it back to S1 (then S2 will appear as if it was never used)
	 *  
	 *  		pop()
	 * 	[]		-------	[]
	 * 	[]		|		[]
	 * 	[]		|		[]
	 * 	[]		|		[]
	 * 	[] <-----		[]
	 *  S1				S2
	 */
	/*
	 * 	[1]-------Push
	 * 	[3]			|
	 * 	[2]			|------[1]
	 */
	
	
	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<>(5);
		
		
		queue.enqueue(2); queue.enqueue(4); queue.enqueue(6); queue.enqueue(8); queue.enqueue(10); 
		//queue.enqueue(10); queue.enqueue(12); queue.enqueue(14); queue.enqueue(16);
		queue.printQueue();
		queue.dequeue(); queue.dequeue(); 
		queue.printQueue();
		
	}		
	
	private static interface Queue<E>{
		int size();
		boolean isEmpty();
		E first(); //returns top most element value without removing it (doesn't decrease the size by anything)
		void enqueue(E e);	//Adds a new node in the stack (item)
		E dequeue(); //Returns value of top most element
	}
	
	private static class ArrayQueue<E> implements Queue<E>{
		private E[] data;
		private int front = 0;
		
		private int size = 0;
		
		public ArrayQueue(int size) {
//			S1 = new Stack<>();
//			S2  = new Stack<>();
			this.size = size;
			data = (E[])new Object[size]; 
		}
		
		@Override
		public int size() {
			return data.length;	//Returns the size the data array, not the size itself
		}
		@Override
		public boolean isEmpty() {
			if(size() < 1) 
				return true;
			else 
				return false;
		}
		@Override
		public E first() {
			E front = data[0];
			return front;
		}
		
		@Override
		public void enqueue(E e) {		//Pop the newest element into the front of the Queue
			// Define the rear; will be size - 1, but when adding, the rear will be size + 1
			//int rear = size()-1;
			if(size == size()-1) {
				throw new IllegalStateException();
			}else {
				int rear = (front + size) % size();
				data[rear] = e;
				size++;
			}
		}
		@Override
		public E dequeue() {			//Push the first element out of the Queue (done in O(1) time, so don't push all the elements to the front)
			E object;
			
			if(isEmpty()) {
				return null;
			}else {
				object = data[front];
				data[front] = null;
				front = (front + 1) % size();
				size = size - 1;
				return object;
			}
		}
		
		public void printQueue() {
			System.out.print("[ ");
			for(int i = 0; i < size(); i++) {
				System.out.print(data[i] + " ");
			}
			System.out.print("]\n");
		}
	}
}
