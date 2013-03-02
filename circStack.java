
public class circStack {
	private Node<Integer> current;
	public int size;
	
	public circStack(){
		current = null;
		size = 0;
	}
	
	public void push(Integer data){
		Node<Integer> newNode = new Node<Integer>(data);
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
	
	public int pop(){
		if (size ==0){
			System.out.println("There are no elements in the list");
			return -9999999;
		}
		Node<Integer> temp = current;
		while (current.next != temp){
			current = current.next;
		}
		current.next = temp.next;
		temp.next = null;
		size--;
		return (int)temp.data;
	}
	
	public void displayStack(){
		for (int i = 0; i<this.size; i++){
			current.displayNode();
			Node temp = current;
			while (current.next !=temp){
				current = current.next;
			}
		}
	}
	
}
