/**
* Represents an ordered list that stores elements of type T. 
*
* CSC 1351 Programming Project No 1
7
* Section 2
*
* @author Andrew Dang
* @since March 17, 2024
*/
package Prog01_aOrderedList;

import java.util.Arrays;

public class aOrderedList <T> {
	// Size increments of the list.
	final int SIZEINCREMENTS = 20;
	
	// Keeps track of the current position of the iterator within the list. 
	private int curr; 
	
	// Array of elements T. 
	private T[] oList; 
	
	// The maximum capacity of the list. 
	private int listSize; 
	
	// The number of elements in the list. 
	private int numObjects; 
	
   /**
	* Initializes the aOrderedList class and assigns initial values to the class'
	* attributes numObjects, listSize, oList, and curr. 
	*
	* CSC 1351 Programming Project No <enter project number here>
	* Section <insert your section number here>
	*
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	@SuppressWarnings("unchecked")
	public aOrderedList()
	{
		curr = 0; 
		numObjects = 0; 
		listSize = SIZEINCREMENTS; 
	    oList = (T[]) new Object[SIZEINCREMENTS];  
	}
	
   /**
	* Adds the specified object to the list. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	* @param newObject The object being added to the list. 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public void add (T newObject) {
		if (listSize == size()) {
			listSize += SIZEINCREMENTS; 
			oList = Arrays.copyOf(oList, listSize); 
		}
			oList[size()] = newObject; 
			numObjects++; 
			Arrays.sort(oList, 0 , size());
	}
	
   /**
	* Removes an element at a specified index from the list. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @param index The index of the element to remove
	* @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()). 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public void remove (int index) {
		if (index >= 0 && index < listSize) {
			oList[index] = null; 
			for (int i = index; i < size() - 1; i++) {
				oList[i] = oList[i + 1]; 
			}
			oList[size() - 1] = null; 
			numObjects--; 
		} else { 
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + listSize);
		}
	}
	
   /**
	* Resets the iterator to the beginning of the list. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public void reset() {
		curr = 0; 
	}
	
   /**
	* Moves the iterator forward and returns the element it goes over. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @return The element the iterator goes over. 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public T next() {
		curr++; 
		return oList[curr - 1]; 
	}
	
   /**
	* Returns whether the list has a next element. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @return true if the list has a next element, and false otherwise. 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public boolean hasNext() {
		return curr + 1 <= size(); 
	}

   /*
	* Removes the element at the current position in the list. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @throws IndexOutOfBoundsException if the index is out of range (curr - 1 < 0 || curr - 1 >= size()). 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public void remove() {
		if (curr - 1 >= 0 && curr - 1 < size()) {
		remove(curr - 1); 
		} else {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + (curr - 1) + ", Size: " + size());
		}
		curr--; 
	}
	
   /**
	* Returns the number of objects in the list. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @return The number of objects in the list. 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public int size() {
		return numObjects; 
	}
	
   /**
	* Returns an element at a specified index in the list. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @param index The index of the element to retrieve
	* @return the element at the specified index  
	* @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()). 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public T get (int index) {
		if (index >= 0 && index < size()) {
	        return (T) oList[index];
	    } else {
	        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
	    }
	}
	
   /**
	* Checks if the list is empty
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @return true if the list if empty, and false otherwise. 
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	public boolean isEmpty() {
		return size() == 0; 
	}
	
   /**
	* Returns a string representation of the object, including all elements in the list. 
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @return A string representation of the object, including all elements in the list.
	* @author Andrew Dang
	* @since March 17, 2024
	*/
	@Override
	public String toString() {
		String returnString =  "[" + oList[0].toString() + "]"; 
		for (int i = 1; i < size(); i++) {
			returnString += ", [" + oList[i].toString() + "]"; 
		}
		return returnString; 
	}
}
