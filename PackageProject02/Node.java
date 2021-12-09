package PackageProject02;
/**
 * Representing a Node<E> with a name.
 * @author Yulong Chen
 * @version 2.1
 */
public class Node<E> {
	/**
	 * The item of this node
	 */
	private E item;
	/**
	 * The link to previous node
	 */
	private Node<E> previous;
	/**
	 * The link to next node
	 */
	private Node<E> next;
	
	/**
	 * Default constructor
	 */
	public Node() {
		this(null, null, null);
	}
	
	/**
	 * Constructs a node with a element
	 * @param item The name of value
	 */
	public Node(E item) {
		this.item = item;
	}
	
	/**
	 * Constructs a node with an element and a link to next node and link to previous node
	 * @param item The name of value
	 * @param previous Reference to previous node
	 * @param next Reference to next node
	 */
	public Node(E item, Node<E> previous, Node<E> next){
		this.item = item;
		this.next = next;
		this.previous = previous;
	}
	
	/**
	 * Return the node of element
	 * @return Return the value of element
	 */
	public E getItem() {
		return item;
	}
	
	/**
	 * Changes the element of this node
	 * @param item The element of this node
	 */
	public void setItem(E item) {
		this.item = item;
	}
	/**
	 * Returns the previous reference of this node
	 * @return Returns the reference reference of this node
	 */
	public Node<E> getPrevious() {
		return previous;
	}
	
	/**
	 * Changes the previous reference of this node
	 * @param previous a reference of this node
	 */
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
	
	/**
	 * Returns the next reference of this node
	 * @return Returns the next reference of this node
	 */
	public Node<E> getNext() {
		return next;
	}
	
	/**
	 * Changes the next reference of this node
	 * @param next The reference of this node
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	

}
