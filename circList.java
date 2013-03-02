
public class circList<T1> {
	public Node<T1> current;
	public int size;
	
	public circList(){
		current = null;
		size = 0;
	}
	
	public void addAfterCurrent(T1 data){
		Node<T1> newNode = new Node<T1>(data);
		if (size == 0){
			current = newNode;
			current.next = newNode;
		}else{
			newNode.next = current.next;
			current.next = newNode;
			current = current.next;
		}
	}
	
	public T1 removeCurrent(){
		if (size >0){
			Node<T1> temp = current;
			while (current.next != temp){
				current = current.next;
			}
			return temp.data;
		}else{
			System.out.println("There is nothing in the list");
			return null;
		}
	}
	
}
