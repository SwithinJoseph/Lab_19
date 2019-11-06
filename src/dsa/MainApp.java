package dsa;

public class MainApp {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.addAtBeginning("hello");
		list.addAtBeginning("hello2");
		list.addAtBeginning("hello3");
		list.addAtBeginning("hello4");
		list.removeFromBeginning();
		
		System.out.println(list);
		System.out.println(list.get(2));
		list.addAtEnd("Java is cool!");
		System.out.println(list);
		list.removeFromEnd();
		System.out.println(list);
		
		System.out.println("\nLinkedList starts here: ");
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtBeginning("help");
		linkedList.addAtBeginning("help1");
		linkedList.addAtBeginning("help2");
		System.out.println(linkedList);
		linkedList.removeFromBeginning();
		System.out.println(linkedList);
		
		

	}

}
