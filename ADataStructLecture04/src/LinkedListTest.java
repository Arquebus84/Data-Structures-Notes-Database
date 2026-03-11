import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> linked = new LinkedList<>();
		linked.add(23); linked.add(16); linked.add(45); linked.add(2);
		//System.out.println(linked);
		
		//Test 1: Singly Linked List
		System.out.println("Singly Linked List:");
		SinglyLinkedListTest<Integer> linkList = new SinglyLinkedListTest<>();
		
		linkList.addLast(16); 
		linkList.addLast(70);
		linkList.addLast(19);
		linkList.addLast(20);
		//System.out.println("Empty LinkedList: " + linkList.isEmpty());
		System.out.println("First element in LinkedList: " + linkList.first());
		//System.out.println("First element to remove in LinkedList: " + linkList.removeFirst());
		System.out.println("Last element in LinkedList: " + linkList.last());
		//Print out each element in the array with removeFirst() method
		//linkList.getCurrent();
		linkList.printSinglyLinkedList(linkList.head);
//		System.out.println("\nReversing Linked List:\n");
		//System.out.println(linkList.ReverseLinkedList(linkList.head).next.next.element);
		//linkList.IterReverseLinkedList(linkList.head);
		//System.out.println(linkList.RecReverseLinkedList(linkList.head).next.element);
//		linkList.RecReverseLinkedList(linkList.head);
//		linkList.printSinglyLinkedList(linkList.tail);
		
		
		//Test 2: doubly Linked list
		System.out.println("\n\nDoubly Linked List:");
		DoublyLinkedListTest<Integer> doubleLinked = new DoublyLinkedListTest<>();
		doubleLinked.addLast(22); doubleLinked.addLast(16); doubleLinked.addLast(12); doubleLinked.addLast(53);
		doubleLinked.printDoublyLinkedList();
	}
	
	//Node class (If it's a private static class, then put it as an inner class for LinkedListTest)
	private static class Node<E>{
		
		//Create an element variable of generic type (stores a value) and a Node (which is the same class) that stores the address***
		private E element;				//The element will contain the data for each node
		private Node<E> next;			// next will be the address (pointer) of the next element (This is an instance variable)
										// each element in list is a node, so the newest elements will be of type Node
		private Node<E> prev;			//NOTE: comment out for singly linked list, otherwise use it for doubly linked list b/c
										//	previous will not be obtained for singly
		
		//Node for singly linked list
		public Node(E e, Node<E> n){	//each element in the linked list is a Node, so the next element will be a Node, but
			element = e;				//	the current element will have to have a data type
			next = n;
			//prev = p
		}
		
		//****Node for Doubly linked list:
		public Node(E e, Node<E> p, Node<E> n){	//each element in the linked list is a Node, so the next element will be a Node, but
			element = e;						//	the current element will have to have a data type
			next = n;
			prev = p;
		}
		
		public E getElement() { return element;}			//Returns the current element
		public void setElement(E e) {this.element = e;}		//Sets the current element
		
		public Node<E> getNext() { return next;}		//Returns the next Node
		public Node<E> getPrev() { return prev;}			//NOTE: Comment out for singly
		
		public void setNext(Node<E> n) { this.next = n;}	//The next node will be the tail
		public void setPrev(Node<E> p) { prev = p;}		//NOTE: Comment out for singly
	}

	//Singly Linked List
	private static class SinglyLinkedListTest<E> {
		// E makes it generic
		private Node<E> head;				//The head, tail, and current nodes are set to null
		private Node<E> tail;
		// Next/Current element in the list
		//private Node<E> next;				//next will be set to null by default
		// Number of nodes in the list
		private int size = 0;

		//Get size of the linked list
		public int size() {
			return size;
		}

		public boolean isEmpty() {return size() < 1;}

		//Return first and last elements by their data types (Note: will be generic)
		public E first() {					//NOTE: will return tail b/c the code will be reversed
			if(isEmpty())
				return null;
			else
				return head.getElement();	//head is of Node<E> object type, so will  essentially return Node<E>().getElement()
		}
		public E last() {					//NOTE: will return head b/c the code will be reversed
			if(isEmpty())
				return null;
			else
				return tail.getElement();
		}

		//Add first and add last methods
		public void addFirst(E e) {
			head = new Node<>(e, head);			// Could declare Node<E> newest = new Node<>(e, head)
			if (size == 0)
				tail = head;					// Can set tail = newest
			size++;								// Could write else {head = newest;}
		}
		public void addLast(E e) {
			Node<E> newest = new Node<>(e, null);	//each element in the linked list is a node, so the newest element is of type Node
			if(isEmpty())
				head = newest;			//the head node will be newest if size is 0
			else
				tail.setNext(newest);	//otherwise, tail will be the next node
			tail = newest;
			size++;
		}
		
		//Remove first element
		public E removeFirst() {
			if (isEmpty()) return null;
			E first2Remove = head.getElement();		//Find the first element that has to be removed
			head = head.getNext();
			size--;
			if(size == 0) 
				tail = null;
			return first2Remove;
			
		} // NOTE: Cannot removeLast() because it will be O(n) due to
			// Missing the addBetween() method for inserting element between
		
		//Get the current element in the Linked List (Linear Search iteration)
		public void getCurrent() {
			if(isEmpty())
				//return null;
				System.out.println("null element, null pointer");
			else{
				Node<E> n = head;
				while(n != null) {		//Check if the address of current node is same as the tail node
					System.out.print((n == tail)? n.getElement() + " " : n.getElement() + ", ");
					n = n.getNext();
					
					// if the node has same address as tail, print the tail's data
				}
			}
		}
	
		public Node<E> IterReverseLinkedList(Node<E> head){
			Node<E> prev = null;
			Node<E> current = head;
			Node<E> next;
			while(current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			
			System.out.println("Iteratively: ");
			return prev;
		}
		
		public Node<E> RecReverseLinkedList(Node<E> head){
			
			if(head.next == null) {
				return head;
			}
			Node<E> current = RecReverseLinkedList(head.next);
			
			head.next.next = head;
			head.next = null;
			
			System.out.println("Recursively: ");
			return current;
		}
		
		
		public void printSinglyLinkedList(Node<E> current) {
			while(current != null) {
				System.out.print((current.getNext() != null)? current.getElement() + ", " : current.getElement());
				current = current.getNext();
			}
		}
	}

	//Doubly Linked List
	private static class DoublyLinkedListTest<E>{
		private Node<E> head;
		private Node<E> tail;
				
		private int size = 0;
		
		public DoublyLinkedListTest() {
			head = new Node<E>(null, null, tail);
			tail = new Node<E>(null, head, null);
			size = 0;
		}		
		public int size() {
			return this.size;
		}
		public boolean isEmpty() {
			if(size() < 1)
				return true;
			else
				return false;
		}
		public E first() {
			if(isEmpty())
				return null;
			else
				return head.getElement();
		}
		public E last() {
			if(isEmpty())
				return null;
			else
				return tail.getElement();
		}
		public void addFirst(E e) {
//			head = new Node<>(e, head);
//			if(isEmpty()) {tail = head;}
//			size++;
			addBetween(e, head, head.next);
		}
		public void addLast(E e) {
//			Node<E> newest = new Node<>(e, null);
//			if(isEmpty()) 
//				head = newest;
//			else 
//				head = tail;
//			size++;
			addBetween(e, tail.prev, tail);
		}
		public E removeFirst() {
			if(isEmpty()) return null;
			E first2Remove = head.getElement();
			head = head.getNext();
			size--;
			if(size == 0) 
				tail = null;
			return first2Remove;
		}
		public E removeLast() {
			if(isEmpty()) return null;
			E last2Remove = tail.getElement();
			tail = tail.getPrev();
			size--;
			if(size == 0) 
				head = null;
			return last2Remove;
		}
		
		//Add between two nodes (refer to the addLast() as reference)
		public void addBetween(E e, Node<E> predecessor, Node<E> successor) {			
			Node<E> newest  = new Node<>(e, predecessor, successor);
			if(isEmpty()){
                head.setNext(newest);
                tail.setPrev(newest);
            }else{
                successor.setPrev(newest);
                predecessor.setNext(newest);
            }
			size++;
		}
		public E remove(Node<E> node) {
			if(isEmpty())
				return null;
			else {
				Node<E> predecessor = node.getPrev();
				Node<E> successor = node.getNext();
				predecessor.setNext(successor);		//When removing, set the address for predecessor to successor, since the node was between
				successor.setPrev(predecessor);			//both of them
				
				size--;
				return node.getElement();
			}			
		}
		
		public void printDoublyLinkedList() {
			Node<E> current = head.getNext();
			while(current.getNext() != null) {
				System.out.print(current.getElement() + " ");
				current = current.getNext();
			}
		}
		
	}
}
