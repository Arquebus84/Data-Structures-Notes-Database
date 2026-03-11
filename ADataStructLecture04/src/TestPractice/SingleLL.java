package TestPractice;

public class SingleLL {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> LL = new SinglyLinkedList<>();
		LL.addFirst(22); LL.addFirst(24); LL.addFirst(26); LL.addFirst(28); LL.addFirst(30); LL.addFirst(32);
		
		LL.printList(LL.head);
		//LL.reverseLL(LL.head);
		//LL.ReverseRecLL(LL.head);
		//LL.printList(LL.reverseLL(LL.head));
		//System.out.println(LL.ReverseRecLL(LL.head).element);
		//System.out.println(LL.ReverseRecLL(LL.head).nextAddress.element);
		LL.printList(LL.ReverseRecLL(LL.head));
	}
	
	private static class Node<E>{
		E element;
		Node<E> nextAddress;
		
		public Node(E element, Node<E> nextAddress){
			this.element = element;
			this.nextAddress = nextAddress;
		}
		E getElement() {return element;}
		void setElement(E element) {this.element = element;}
		Node<E> getNextAddress() {return nextAddress;}
		void setNextAddress(Node<E> nextAddress) {this.nextAddress = nextAddress;}
	}
	
	private static class SinglyLinkedList<E>{
		Node<E> head;
		Node<E> tail;
		int size;
		

		public SinglyLinkedList(){
			this.size = 0;
		}
		
		public SinglyLinkedList(int size){
			this.size = size;
		}
		public boolean isEmpty() {
			return (size < 1);
		}
		public E first() {
			return head.getElement();
		}
		public E last() {
			return tail.getElement();
		}
		public void addFirst(E element) {
			Node<E> newest = new Node<E>(element, head);
			if(isEmpty()) {
				tail = newest;
			}
			head = newest;
			
			size++;
		}
		public void addLast(E element) {
			Node<E> newest = new Node<E>(element, null);
			if(isEmpty()) {
				head = newest;
			}else {
				tail.setNextAddress(newest);
				tail = newest;
			}
			size++;
		}
		
		/**Iterative approach to reversing Linked List*/
		public Node<E> reverseLL(Node<E> head) {
			Node<E> prev = null;		//When reversing, the head will point to null (which will be the new tail)
			Node<E> current = head;		//references the head element
			Node<E> next;				//Stores the next element
			
			while(current != null) {
				next = current.getNextAddress();
				current.setNextAddress(prev);
				prev = current;
				current = next;
			}
			//this.head = current;
			return prev;
			//Return prev since it will replace the head node
		}
		
		/**Recursive approach to reversing Linked List
		 * 	   head
		 * 		 |
		 * 		[0]->[1]->[2]->[3]->[4]->null			//NOTE: want the new head to be the last element
		 * 
		 * 	//In the recursive approach, call recRev(head.next)	until the 'next element is null' (base case)
		 *	
		 *	//Set the newHead to the recRev() function, which will be updated until the base case is executed
		 *			* During the last recursive call, the newHead will be the last element (which is the current head)
		 *								newHead
		 *									|
		 *								  head
		 *						 [2]->[3]->[4]->null					
		 *
		 *	//	When the recursive function 'unwinds', update the nextAddress of the head's next node to point to itself:
		 *								newHead
		 *									|
		 *								  head->->head.next.next = head		
		 *						 [2]->[3]->[4]->null						//The next address of head's nextAddress will point to the head
		 *									<-<-head.next.next				//head's next address will be null
		 *											
		 *
		 *								newHead
		 *							 head	|
		 *						 [2]->[3]->[4]->null			//The process repeats here until it reaches the beginning
		 * 								<-<-head.next.next
		 * 
		 * 			// This will effectively reverse the entire linked list; by redefining the addresses 
		 * 				that reference the previous recursive calls
		 * 
		 * */
		public Node<E> ReverseRecLL(Node<E> head) {
			Node<E> current;
			if(head.nextAddress == null) {
				return head;
			}
			current = ReverseRecLL(head.nextAddress);
			head.nextAddress.nextAddress = head;
			head.nextAddress = null;
			
			return current;
		}
		
		public void printList(Node<E> current) {
			//Node<E> current = head;
			while(current != null) {
				System.out.print(current.getElement() + " ");
				current = current.getNextAddress();
			}
			System.out.println();
		}
		
	}

}
