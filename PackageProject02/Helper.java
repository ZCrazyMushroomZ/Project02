package PackageProject02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Representing a Helper with a name.
 * @author Yulong Chen
 * @version 2.1
 */
public class Helper {
	/**
	 * Execute some operations
	 * @throws Exception
	 */
	public static void start() throws Exception{ 
		//create a array list to store the LinkedString
		LinkedString[] link = new LinkedString[100];
		try {
			//create a new DoubleLinkedList
			creat(link);
			//insert the end of linkedString
			creatString(link,"Happy");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
       }
		//show the items of the LinkedString and executing functions
		display(link);
    }	

    /**
     * Add elements into LinkedString
     * @param list The object of an array ofLinkedString to store LinkedString
     * @throws FileNotFoundException
     */ 	
	private static void creat(LinkedString[] list) throws FileNotFoundException {
		String object;
		int i = 0;
		//Create a object 
		Scanner sc = new Scanner(new File("LinkedString_test.txt"));
		//hasNext() read one line
		while(sc.hasNext()){
			//Read line one by one
			object = sc.nextLine();
			LinkedString list3 = new LinkedString(object);
			list[i] = list3;
			i++;
		}
		sc.close();
	}

	
	/**
	 * Create a new string LinkedString
	 * @param list The object of LinkedString[]
	 * @param object The value of LinkedString
	 */
	private static void creatString(LinkedString[] list, String object) {
			LinkedString list3 = new LinkedString(object);
			int i = 0;
			while(list[i] != null) {
				i++;
			}
			list[i] = list3;
			
	}
	/**
	 * Create a new char[] LinkedString
	 * @param list The object of LinkedString[]
	 * @param element The value of LinkedString
	 */
	private static void creatChar(LinkedString[] list, char[] element) {
		   LinkedString list3 = new LinkedString(element);
		    int i = 0;
			while(list[i] != null) {
				i++;
			}
			list[i] = list3;
    }
	

	/**
	 * Display all elements in one LinkedString and run the test all of the method
	 * @param link The object of LinkedString
	 * @throws Exception
	 */
	public static void display(LinkedString[] link) throws Exception {
		//show all elements in doubledLinkedList
		int i = 0;
		while(link[i] != null) {
			displayAll(link[i]);
			i++;
		}
		System.out.println("The length of this LinkedString is " + i + ".");
		
		
		//The following is a test of all methods
		
		//Test length() method
		System.out.println("\nThe first length of doubleLinkedList is " + link[0].length() + ".\n");
		System.out.println("-------------------------------------------");
		
		//Test charAt() method
		int input = 3;
		System.out.println("The charAt("+ input +") = " + link[0].charAt(input) + ".\n");
		System.out.println("-------------------------------------------");
		
		//Test isEmpty() method
		System.out.println(link[0].isEmpty() + "\n");
		System.out.println("-------------------------------------------");
		
		//Test substring() method
		System.out.println("The subString is:");
		displayAll(link[0].substring(1, 3));
		System.out.println("-------------------------------------------");
		
		//Test concat() method
		link[20] = link[1].concat(link[2]);
		displayAll(link[20]);
		System.out.println("-------------------------------------------");
		
		//Test add() method
		link[20].add(0, new Node('X'));
		displayAll(link[20]);
		System.out.println("-------------------------------------------");
		
		//Test remove() method
		link[20].remove(0);
		displayAll(link[20]);
	}
	
    /**
     * Display all elements in LinkedString
     * @param list The object of LinkedString
     * @throws Exception
     */
    public static void displayAll(LinkedString list) throws Exception {
        for(int i = 0; i < list.length(); i++) {
		    Object a = list.find(i).getItem();
		    System.out.print(i + ":" + a +" ");
	    }
	  System.out.println();  
    }
}