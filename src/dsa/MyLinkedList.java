package dsa;

public class MyLinkedList implements MyList {

	private Node head;
	private int myLength = 0;

	// created a helper method to get the node at a certain location
	// to help us prevent some code duplication
	private Node getNodeAt(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			if (node == null) {
				return null;
			}
			node = node.getNext();
		}
		return node;
	}

	@Override
	public void addAtBeginning(String data) {
		// add a new Node and set it to the head
		head = new Node(head, data);
		myLength++;

	}

	@Override
	public void removeFromBeginning() {
		head = head.getNext();
		myLength--;

	}

	// code challenge
	@Override
	public void addAtEnd(String data) {
		// check to make sure the list is not empty!
		// if empty add to the beginning (hint: we have some code for that!)

		// otherwise - create logic to add to the end (tail)
		// the reference to the next node should be null
		// increase the length
	}

	// code challenge
	@Override
	public void removeFromEnd() {
		// think again about methods that you can reuse!

	}

	// code challenge
	@Override
	public String get(int index) {

		return null;
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
		Node nextNode = getNodeAt(index + 1);
		getNodeAt(index).setNext(null);
		getNodeAt(index - 1).setNext(nextNode);
		myLength--;
		return true;
	}

	@Override
	public boolean insertAt(int index, String item) {
		if (index > myLength) {
			return false;
		}
		Node newNode = new Node(getNodeAt(index), item);
		getNodeAt(index - 1).setNext(newNode);
		myLength++;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		Node node = head;
		// follow the links between the nodes until it reaches the end
		while (node != null) {
			sb.append(node);
			node = node.getNext();
		}
		sb.append(" ]");

		return sb.toString();
	}

}
