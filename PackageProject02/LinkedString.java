package PackageProject02;
/**
 * Representing a LinedString with a name.
 * @author Yulong Chen
 * @version 2.1
 */
public class LinkedString implements LinkedStringInterface{
	/**
	 * A reference to an array of data
	 */
	private Node<Character> head;
	/**
	 * The number of data in this ADT list
	 */
	private int count;
	
	/**
	 * Default constructor Creates an empty DoublelinkedList
	 */
	public LinkedString() {
		this.head = null;
		this.count = 0;
	}
	/**
	 * Create a LinkedString instance containing a sequence of characters
	 * @param element The value of all char type elements
	 */
	public LinkedString(char[] element) {
		//show the value of the LinkedString
		System.out.println(element);
		for(int i = 0; i < element.length; i++) {
			this.initialAdd(i, new Node(element[i]));
		}
	}
	
	/**
	 * Create a LinkedString instance containing a sequence of strings
	 * @param object The value of all elements
	 */	
	public LinkedString(String object) {
		char[] a = object.toCharArray();
		//show the value of the LinkedString
		System.out.println(a);
		for(int i = 0; i < object.length(); i++) {
			this.initialAdd(i, new Node(a[i]));
		}	
	}	
	
	/**
	 * Initial all LinkedString, add all elements to DoubleLinkedList
	 * @param index The location of the node
	 * @param data  A reference to this added element
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void initialAdd(int index, Node<Character> data){
		if(index < 0 || index > this.count){
			  throw new ArrayIndexOutOfBoundsException("The index value must be between 0 and " 
		                               + (this.count -1));
		  }else{//not node
			  if(this.head == null) {//if the index == 0
				  this.head = new Node(data.getItem(), null, null);			  
			  }else {//exist node list
				//insert the node at the front of the node at index
					  Node current = find(this.count - 1);
					  current.setNext(new Node(data.getItem(), current, null));  
			  }
		  }
		this.count++;
	}
	
	/**
	 * 
	 * @param index The location of the node
	 * @param data A reference type, point to the address of item
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void add(int index, Node<Character> data){
		if(index < 0 || index > this.length()){
			  throw new ArrayIndexOutOfBoundsException("The index value must be between 0 and " 
		                               + (this.length() - 1));
		  }else{
			  if(this.head == null) {//Empty list
				  this.head = new Node(data.getItem(), null, null);
			  }else if(this.count == 1) {//One-node list
				  if(index == 0) {//front
						  this.head = new Node(data.getItem(), null, this.head);
				  }else {//end
					  this.head.setNext(new Node(data.getItem(), this.head, null));
				  }
			  }else {//a multi-node list
				  if(index == 0) {//front
					  this.head = new Node(data.getItem(), null, this.head);
				  }else if(index == this.count) {//end
					//insert the node at the front of the node at index
					  Node current = find(index - 1);
					  current.setNext(new Node(data.getItem(), current, null));
				  }else {//middle
					//insert the node at the front of the node at index
					  Node current = find(index - 1);
					  current.setNext(new Node(data.getItem(), current, current.getNext()));
				  }
			  }
		  }
		this.count++;
	}
	
	 /**
	   * Returns a reference to a specific node at index
	   * @param index the location of specific node
	   * @return The index of a specific node
	   */
	public Node find(int index) {
		int position = 0;
		Node current = this.head;
		while(position != index) {
			position++;
			current = current.getNext();
		}
		return current;
	}
	
	/**
      * Get the char value at the index
	  * @param index the location of specific node
	  * @return The value in index position
	 */
	@Override
	public char charAt(int index) {
		 if(this.count == 0){
			  throw new ArrayIndexOutOfBoundsException("The list is empty");
		  }else if(index < 0 || index > this.count){
			  throw new ArrayIndexOutOfBoundsException("The index value must be between 0 and count.");
		  }else {
			//Make Object type to char type
			  char c = (char) find(index).getItem();
			// return an item at index from this list
			  return c; 
		  }
	}
	/**
	 * Concatenate a specified linked string to the end of this linked string
	 * @param A The second LinkedString connect the end of first LinkedString
	 * @return A new LinkedString that connect two LinkedString
	 */
	@Override
	public LinkedString concat(LinkedString a) {
		LinkedString newString = new LinkedString();
		//The index of node of first LinkedString
		Node current = this.find(0);
		//The index of node of second LinkedString
		Node current1 = a.find(0);
		//The value of head to copy
		Node copy = new Node(current.getItem(), null, null);
		//make copy node to newString head
		newString.head = copy;
		for(int i = 0; i < this.length(); i++) {
			//it indicates only have one element
			if(current.getNext() == null) {
				//return
				break;
			}else {
				//get next value, because the first value has assigned the head
			current = current.getNext();
			//create new node in next position 
			copy.setNext(new Node(current.getItem()));
			//reference to next node
			copy = copy.getNext();
			}
		}
		//The second LinkedString
		for(int i = 0; i < a.length(); i++) {
			//The first item to link the end of first LinkedString
			if(i == 0) {
				copy.setNext(new Node(current1.getItem()));
				copy = copy.getNext();
				//if next item is null
			}else if(current1.getNext() == null) {
				//return
				break;
			}else {
				//get next value
			current1 = current1.getNext();
			//create new node in next position 
			copy.setNext(new Node(current1.getItem()));
			//reference to next node
			copy = copy.getNext();
			}
		}
		return newString;
	}
	/**
	 * Judge whether the LinkedString is empty
	 * @return True or False
	 */
	@Override
	public boolean isEmpty() {
		System.out.print("The LikedString is(true is null, false is not null): ");
		//if this.count equal to 0 return true and vice versa
		return this.count == 0;
	}
	
	/**
	 * Get the length of the LinkedString
	 * @return The length of the LinkedString
	 */
	@Override
	public int length() {
		if(this.head == null) {
			//the length is null when return 0
			return 0;
		}
		//local variable to record the length of doubleLinkedList
		int length = 0;
		Node current = new Node();
		//make the head to current
		current = head;
		while(current != null) {
			length++;
			//from head traverse all node
			current = current.getNext();
		}
		return length;
	}
	
	/**
	 * Remove a item in specific index
	 * @param index The specific index of remove
	 */
	public void remove(int index) {
		//if the doubleLinkedList is null
		if(this.length() == 0) {
			throw new ArrayIndexOutOfBoundsException("The linkedString is no item to remove");
		}else if(this.length() == 1) {
			this.head = null;
			this.count = 0;
		}else {
			if(index == 0) {//front
				Node temp = this.head;
				this.head = this.head.getNext();
				temp.setItem(null);
			}else if(index == this.length() - 1) {//end
				Node temp = find(this.length() - 2);
				temp.setItem(null);
			}else {//middle
				Node temp = find(index);
				Node predessor = find(index - 1);
				predessor.setNext(temp.getNext());
				temp.setItem(null);
			}
		}
	}
	
	/**
	 * Return a new linked string that is a substring of this linked string
	 * @param firstIndex The first index of the new LInked string
	 * @param lastIndex The last index of the new LInked string
	 * @return Return a new linked string that is a substring of this linked string
	 */
	@Override
	public LinkedString substring(int firstIndex, int lastIndex) {
		if(firstIndex < 0 || lastIndex > (this.length() - 1)) {
			 throw new ArrayIndexOutOfBoundsException("The index value must be between 0 and "+ (this.length() - 1)+".");
		}else if(firstIndex > lastIndex){
			throw new ArrayIndexOutOfBoundsException("The secondIndex must bigger than firstIndex.");
		}else {
			//create new LinkedString for storing nodes
		LinkedString subString = new LinkedString();
		//The index of head
		Node current = this.find(firstIndex);
		//Create a new node 
		Node copy = new Node(current.getItem());
		subString.head = copy;
		//from the index of head to the lastIndex 
		for(int i = firstIndex; i < lastIndex; i++) {
			//get next value
			current = current.getNext();
			//create new node in next position 
			copy.setNext(new Node(current.getItem()));
			//reference to next node
			copy = copy.getNext();
		}
		return subString;
		}
	}
}
