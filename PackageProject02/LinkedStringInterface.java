package PackageProject02;
/**
 * Representing a LinkedStringInterface with a name.
 * @author Yulong Chen
 * @version 2.1
 */
public interface LinkedStringInterface {
	
	/**
	 * Return a value in index position
	 * @param index The index of value
	 */
	public char charAt(int index);
	
	/**
	 * Connect two LinkedString 
	 * @param a The second LinkedString connect the end of the first LinkedString
	 * @return Return a new LinkedString
	 */
	public LinkedString concat(LinkedString a);
	
	/**
	 * Judge the LinkedString whether is null
	 * @return True when the LinkedString is empty and vice versa
	 */
	public boolean isEmpty();
	
	/**
	 * Each length of LinkedString
	 * @return The length of each LinkedString
	 */
	public int length();
	
	/**
	 * Substring a LinkedString
	 * @param firstIndex The index of first location
	 * @param lastIndex The index of last location
	 * @return Return a new linked string that is a substring of this LinkedString 
	 */
	public LinkedString substring(int firstIndex, int lastIndex);

}
