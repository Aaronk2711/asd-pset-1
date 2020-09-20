import java.util.List;

public class SimpleArrayList {
	
	public String[] base_array; //creates a string of arrays called array
	public int array_size; //array size
	
	public SimpleArrayList() { //initializes array with capacity of 10
		base_array = new String[10];
		array_size = 0;
	}
	
	public SimpleArrayList(int initialLength) {//creates the array with given length
		if(initialLength < 0) throw new IllegalArgumentException("Illegal Capacity: " + initialLength);
		base_array = new String[initialLength];
		array_size = 0;
	}
	
	public SimpleArrayList(List<String> given_list) { //converts a list into an array
		if (given_list == null) throw new NullPointerException();
		base_array = new String[given_list.size()];
		for (int i = 0; i < given_list.size(); i++) {
			base_array[i] = given_list.get(i);
		}
		array_size = base_array.length;
	}
	
	public void add(int index, String given) { //adds a string at given index
		checkForSpace();
		checkArrayBounds(index, array_size);
		
		
		for(int i = base_array.length-2; i > index-1; i--) {
			base_array[i+1] = base_array[i];
		}
		base_array[index] = given;
		array_size ++;
	}
	
	public boolean add(String given) { //adds a string to end of array
		checkForSpace();
		base_array[array_size] = given;
		array_size ++;
		return true;
	}
	
	public void clear() { //clears entire array
		array_size = 0;
		base_array = new String[0];
	}
	
	public boolean contains(String given) { //checks if given string is within array
		for(int i = 0; i < array_size; i++) {
			if(base_array[i].equals(given)) return true;
		}
		return false;
	}
	
	public String get(int index) { //retrieves the element at that index
		checkArrayBounds(index, array_size);
		
		return base_array[index];
	}
	
	public int indexOf(String given) { //checks for the index of a certain string
		for(int i = 0; i < array_size; i++) {
			if(base_array[i].equals(given)) { return i; }
		}
		return -1;
	}
	
	public boolean isEmpty() { //checks if array is empty
		return (array_size==0);
	}
	
	public String remove(int index) { //removes the string at a specific index
		checkArrayBounds(index, array_size);
		String element = base_array[index];
		for(int i = index; i < array_size-1; i++) {
			base_array[i] = base_array[i+1];
		}
		base_array[array_size-1] = null;
		array_size --;
		return element;
	}
	
	public boolean remove(String given) { //removes the string given by user
		int index = indexOf(given);
		if(index != -1) {
			remove(index);
			return true;
		}
		return false;
	}
	
	public String set(int index, String given) {
		checkArrayBounds(index, array_size);
		String element = base_array[index];
		base_array[index] = given; 
		return element;
	}
	
	public int size() { //returns the size of the array
		return array_size;
	}
	
	public void trimToSize() {
		String[] tmp = new String[array_size];
		for(int i = 0; i < array_size; i++) {
			tmp[i] = base_array[i]; 
		}
		base_array = tmp;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < array_size-1; i++) {
			str += base_array[i];
			str += ", ";
		}
		if(array_size != 0) {
			str += base_array[array_size-1];
		}
		str += "]";
		return str;
	}
	
		
	public void checkForSpace() {
		if(array_size+1 > base_array.length) {
			String[] temp = new String[base_array.length+10];
			for(int i = 0; i < base_array.length; i++) {
				temp[i] = base_array[i];
			}
			base_array = temp;
		}
	}
	
	
	private void checkArrayBounds(int index, int array_size) { //checks if index is within array bounds
		if(index < 0 || index >= array_size) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + array_size);
			}
		}
	}
	
