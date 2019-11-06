package dsa;

import java.util.Arrays;

public class MyArrayList implements MyList {

	private String[] arr = new String[4];
	private int myLength = 0;

	// we will use this method as a helper method inside this class
	private boolean isFull() {
		return arr.length == myLength;
	}

	// we will use this as a helper method as well to dynamically increase the
	// size of the array
	private void doubleLength() {
		// make a copy of the array that is twice as long
		arr = Arrays.copyOf(arr, arr.length * 2);
	}

	@Override
	public void addAtBeginning(String data) {
		if (isFull()) {
			doubleLength();
		}

		// loop backwards and shift all the items over to make room for the new data
		// this is increasing the size also
		for (int i = myLength; i > 0; i--) {
			arr[i] = arr[i - 1]; // this is assigning the element that was before it to the new index
		}

		arr[0] = data;
		myLength++; // same as myLength = myLength + 1;

	}

	// code challenge
	@Override
	public void removeFromBeginning() {
		if (myLength != 0) {
			// we are going to the length - 1 because we want to force the last index to be
			// cut off
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			myLength--;
		}
	}

	// code challenge
	@Override
	public void addAtEnd(String data) {
		if (isFull()) {
			doubleLength();
		}
		arr[myLength] = data;
		myLength++;

	}

	// code challenge
	@Override
	public void removeFromEnd() {
		if (myLength != 0) {
			// clear the slot and decrement the length
			arr[myLength - 1] = null;
			myLength--;
		}

	}

	@Override
	public String get(int index) {
		// For Kevin F. -- this is one way of handling for a user putting in an index
		// that doesn't exist
		if (index >= myLength) {
			throw new ArrayIndexOutOfBoundsException("the index you entered is out of bounds");
		}

		return arr[index];
	}

	@Override
	public int size() {

		return myLength;
	}

	@Override
	public boolean removeAt(int index) {
		if (index >= myLength) {
			return false;
		}
		for (int i = index; i < myLength - 1; i++) {
			arr[i] = arr[i + 1];
		}
		myLength--;
		return true;
	}

	@Override
	public boolean insertAt(int index, String item) {
		myLength++;
		if (isFull()) {
			doubleLength();
		}
		if (index >= myLength) {
			return false;
		}
		for (int i = index; i <= myLength + 1; i++) {
			arr[i + 1] = arr[i];
		}
		arr[index] = item;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		for (int i = 0; i < myLength; i++) {
			sb.append(arr[i]);
			if (i != myLength - 1) { // checking to make sure it hasn't reached the last index
				sb.append(", ");
			}
		}

		sb.append(" ]");
		return sb.toString();
	}

}
