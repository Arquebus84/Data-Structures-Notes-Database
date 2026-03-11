import java.util.Stack;
public class QueueTest {

	public static void main(String[] args) {
//		Stack<Integer> st1 = new Stack<>();
//		st1.add(1); st1.add(12);
//		System.out.println(st1.toString());
		
		ArrayQueue<Integer> queueTest = new ArrayQueue<>(5);
		//queueTest.data = new Integer[]{2, 6, 8, 17, 25};
		queueTest.enqueue(3); queueTest.enqueue(6); queueTest.enqueue(9);
		
		queueTest.printQueue();
		
		queueTest.dequeue();
		queueTest.printQueue();
	}
	
	/**
	 * Array Queue Representation:
	 * 
	 * 			(front)									(rear)
	 * 				0 	1	2	3	4	5	6	7	8	9
	 * 				[]	[]	[]	[]	[]	[]	[]	[]	[]	[]
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
	
	private static interface Queue<E>{
		int size();
		boolean isEmpty();
		void enqueue(E e);	//Adds a new node in the stack (item)
		E first(); //returns top most element value without removing it (doesn't decrease the size by anything)
		E dequeue(); //Returns value of top most element
	}
	
	private static class ArrayQueue<E> implements Queue<E>{
		private E[] data;
		private int front = 0;
		
		private int size = 0;
		
		public ArrayQueue(int size) {
			this.size = size;
			data = (E[])new Object[size];
		}
		
		@Override
		public int size() {
			return data.length;	//Returns the length of the array, not the entire size
		}

		@Override
		public boolean isEmpty() {
			if(size() < 1) 
				return true;
			else 
				return false;
		}

		@Override
		public void enqueue(E e) {
			//int rear = (size - 1);			//Rear
			
			if(size == size()-1) {
				throw new IllegalStateException();
			}else {
				int rear = (front + size) % size();
				data[rear] = e;
				size++;
			}
		}
		@Override
		public E first() {
			E front = data[0];
			return front;
		}
		@Override
		public E dequeue() {
			E o;							//Object in the front of the list
			
			if(isEmpty()) {
				return null;
			}else {
				o = data[front];
				data[front] = null;
				front = (front + 1) % size;
				size--;
				return o;
			}
		}
		
		/**
		 * 	Enqueue for ***inserting new elements at the top of the Queue
		 * 			Algorithm enqueue(o):			//Object o is of generic type
		 * 				if size() = N - 1 then:
		 * 					throw new IllegalStateException()
		 * 				else:
		 * 					r = (f + sz) mod N		//Change the rear to (front + size) % N
		 * 					Q[r] = o				//The rear (last element) will be the inserted element o (Q is the generic array)
		 * 					sz = sz + 1;			//Increase the size by one
		 * 
		 * 		
		 * 	Dequeue for ***deleting first element of the Eueue
		 * 			Algorithm dequeue():
		 * 				if isEmpty() then:
		 * 					return null
		 * 				else:
		 * 					o = Q[f]				//The object will be at the front of the generic array (at the start)
		 * 					f = (f + 1) mod N		//Change the front to (f + 1) % N  (N is size of the Queue)
		 * 					sz = sz - 1;			//Decrease size by one
		 * 					return o;				//Return the removed first object
		 */
		
		public void printQueue() {
			for(int i = 0; i < size(); i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
	}

}
