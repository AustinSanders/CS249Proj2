//Node class implementing generics to allow for any data type to be stored in the node
public class Node<T1> {
	public T1 data;
	public Node<T1> next;
	public Node<T1> down;
	
	public Node(T1 inData){
		data = inData;
		next = null;
		down = null;
	}
	
	public void displayNode(){
		System.out.print("{" + data + "}\t"); //puts a tab after display for proper formatting of matrix display
	}
}