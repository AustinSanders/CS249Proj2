public class Driver {
	public static void main(String[] args){
		CircStack<Integer> a = new CircStack<Integer>();
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		a.push(5);
		a.pop();
		a.pop();
		a.push(6);
		a.push(7);
		a.displayStack();
		CircStack<String> b = new CircStack<String>();
		System.out.println("");
		b.push("first node");
		b.push("second node");
		b.push("third node");
		b.displayStack();
	}
}
