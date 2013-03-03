import java.util.Scanner;

public class TwoDimensionalLinkedList<T1> {
	int rows;
	int columns;
	int size;
	Node<Integer> current;
	Node<Integer> leftMost;
	Node<Integer> upLink;
	Node<Integer> first;
	
	public TwoDimensionalLinkedList(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number of rows: ");
		rows = sc.nextInt();
		System.out.println("Enter a number of columns: ");
		columns = sc.nextInt();
		size = 0;
		current = null;
		leftMost = null;
		upLink = null;
		first = null;
		buildMatrix();
	}
	
	public void buildMatrix(){
		boolean firstRow = true;
		for (int i = 0; i < rows; i++){
			int sizeOfRow = 0;
			for (int j = 0; j<columns; j++){
				Node<Integer> newNode = new Node<Integer>((i*10)+j);
					if (sizeOfRow ==0) {
						if (size ==0){
							current = newNode;
							leftMost = newNode;
							upLink = newNode;
							first = newNode;
						}else{
							current = newNode;
							leftMost.down = current;
						}
					}else{
						if (firstRow){
						current.next = newNode;
						current = newNode;
						}else{
							current.next = newNode;
							upLink = upLink.next;
							upLink.down = newNode;
							current = current.next;
						}
					}
				sizeOfRow++;
				size++;
			}
		if (!firstRow){
			upLink = leftMost.down;
			leftMost = leftMost.down;
		}
		firstRow = false;
		}
	}
	
	public void displayMatrix(){
		leftMost = first;
		for (int i = 0; i<rows; i++){
			current = leftMost;
			for (int j = 0; j<columns; j++){
				current.displayNode();
				current = current.next;
			}
			System.out.println("\n");
			leftMost = leftMost.down;
		}
	}
	
	public void fillMatrix(int value){
		leftMost = first;
		for (int i = 0; i<rows; i++){
			current = leftMost;
			for (int j = 0; j<columns; j++){
				current.data = value;
				current = current.next;
			}
			leftMost = leftMost.down;
		}
	}
	
}
