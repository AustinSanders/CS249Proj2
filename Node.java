
public class Node<T1> {
	public T1 data;
	public Node<T1> next;
	public Node(T1 inData){
		data = inData;
		next = null;
	}
	public void displayNode(){
		System.out.println("{" + data + "}");
	}
}
