/* Name: Matthew Merrill 
 * ClassID: #197
 * Class: CSE360
 * Assignment: Assignment 2
 * Files: SimpleList.java SimpleListTest.java
 * Description: The file SimpleList.java initializes an array[10] and count 0 which are both modified
 *				in following methods in a variety of ways the user desires.
 *
 */

package cse360assign2;

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
 * Also moves other elements so there is room and if not, makes the array 50% larger
 * @param input
 */
public void add(int input) {								
	
	if (count != list.length) {
		for(int position = list.length - 1; position > 0; position--) {
			list[position] = list[position - 1]; 
		
		}	
	} else {
		int fity = (int) (list.length * 1.5);
		int[] temp = new int[fity];
		for(int element = 0; element < count; element++) {
			temp[element] = list[element];
		
		}
		list = new int[fity];
		
		for(int eli = 0; eli < list.length; eli++) {
			list[eli] = temp[eli];
			
		}
		add(input);
		
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
 * if array is greater than 25% empty it removes 1 array length
 * @param input
 */
public void remove(int input) {

	int holder = search(input);
	if(holder != -1) {
		for(int placeholder = holder; placeholder < 9 ; placeholder++) {	
			list[placeholder] = list[placeholder + 1];		
			
		}
		list[list.length - 1] = 0;	
		count--;
	}
	
	
	int eCount = ((list.length/4) * 3);
	if((count <= eCount) && (list.length != 1)) {
		
		int fity = ((list.length * 3)/ 4);
		int[] temp = new int[fity];
		for(int element = 0; element < count; element++) {
			temp[element] = list[element];
		
		}
		list = new int[fity];
		
		for(int eli = 0; eli < list.length; eli++) {
			list[eli] = temp[eli];
			
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
	
	for(int position = 0; position < list.length - 1; position++) {
		word = word + list[position] + " ";
	}
	word = word +  list[list.length - 1];
	
	return word;
}

/**
 * Returns the location of the parameter in the list	
 * If it is not within the list, default returns -1
 * @param input
 * @return
 */
public int search(int input) {											
	
	for(int position = list.length - 1; position > 0; position--) {			
		if(list[position] == input) {
			return position;
		
		}
	}
		
	return -1;											
}

/**
 * Adds the input to the end of the array, if the array is already full it
 * adds 50% to the array and adds to end of array after elements
 * @param input
 */
public void append(int input) {
	
	
	if(count < list.length) {
		list[count] = input;
		
		
	} else {
		int fity = (int) (list.length * 1.5);
		int[] temp = new int[fity];
		for(int element = 0; element < count; element++) {
			temp[element] = list[element];
		
		}
		list = new int[fity];
		
		for(int eli = 0; eli < list.length; eli++) {
			list[eli] = temp[eli];
			
		}
		
		list[count] = input;
	}
	
}

/**
 * Returns the first array element
 * @return
 */
public int first() {
	
	if(list.length != 0) {
		return list[0];
		
	}
	
	return -1;
}

/**
 * Returns the last value in the array
 * @return
 */
public int last() {
	
	if(list.length != 0) {
		return list[count - 1];
	}
	
	return -1;
}

/**
 * returns the size of the array
 * @return
 */
public int size() {
	return list.length;
	
}

}