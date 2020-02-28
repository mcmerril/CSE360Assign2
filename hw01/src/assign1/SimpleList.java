/* Name: Matthew Merrill 
 * ClassID: #197
 * Class: CSE360
 * Assignment: Assignment2
 * Files: SimpleList.java SimpleListTest.java
 * Description: The file SimpleList.java initializes an array[10] and count 0 which are both modified
 *				in following methods in a variety of ways the user desires.
 *
 */

package assign1;

public class SimpleList {

private int[] list;
private int count;


//Creates an array to hold 10 int and sets count to 0
public SimpleList() {											
	list = new int [10];
	count = 0;
	
}

/**
 * Add the parameter to the list at the beginning
 * Also moves other elements so there is room and if full
 * The end element 'falls' off the list, (is removed)
 * @param input
 */
public void add(int input) {								
																
	for(int position = 9; position > 0; position--) {
		list[position] = list[position - 1]; 
		
	}	
	list[0] = input;
	count++;

}

/**
 * Iterates though array
 * Checks if element matches input
 * Starts at found elements 
 * Shifts elements at and about current element down
 * Sets ending element to 0
 * Shows total num of elements left
 * @param input
 */
public void remove(int input) {

	for(int position = 9; position > 0; position--) {			
		if(list[position] == input) {							
			for(int placeholder = position; placeholder < 9 ; placeholder++) {	
				list[placeholder] = list[placeholder + 1];		
				
			}
			list[9] = 0;										
			count--;											
		}
	}	
}

//Returns the number of elements stored in the list
public int count() {											
	return count;
	
}

/**
 * Returns the list as a string in the proper format
 */
public String toString() {										
	
	String word = "";
	
	for(int position = 0; position < 9; position++) {
		word = word + list[position] + " ";
	}
	word = word +  list[9];
	
	return word;
}

/**
 * Returns the location of the parameter in the list	
 * If it is not within the list, default returns -1
 * @param input
 * @return
 */
public int search(int input) {											
	
	for(int position = 9; position > 0; position--) {			
		if(list[position] == input) {
			return position;
		
		}
	}
		
	return -1;											
}

}