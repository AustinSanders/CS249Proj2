//a stack implemented as a circular singularly linked list
public class CircStack<T1> {
	private Node<T1> current;
	public int size;

	public CircStack(){
		current = null;
		size = 0;
	}

	public void push(T1 data){
		Node<T1> newNode = new Node<T1>(data);
		if (size ==0){
			current = newNode;
			current.next = newNode;
		}else{
		newNode.next = current.next;
		current.next = newNode;
		current = newNode;
		}
		size++;
	}

	public T1 pop(){
		if (size ==0){
			System.out.println("There are no elements in the list");
			return null;
		}
		Node<T1> temp = current;
		while (current.next != temp){
			current = current.next;
		}
		current.next = temp.next;
		temp.next = null;
		size--;
		return (T1)temp.data;
	}

	public void displayStack(){
		for (int i = 0; i<this.size; i++){
			current.displayNode();
			Node<T1> temp = current;
			while (current.next !=temp){
				current = current.next;
			}
		}
	}

}