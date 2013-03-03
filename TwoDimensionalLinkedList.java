import java.util.Scanner;

public class TwoDimensionalLinkedList<T1> {
	private int rows;
	private int columns;
	private int size;
	private Node<Integer> current;
	private Node<Integer> leftMost;
	private Node<Integer> upLink;
	private Node<Integer> first;
	
	public TwoDimensionalLinkedList(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number of rows: ");
		rows = sc.nextInt();
		System.out.println("Enter a number of columns: ");
		columns = sc.nextInt();
		sc.close();	
		size = 0;
		current = null;
		leftMost = null;
		upLink = null;
		first = null;
		buildMatrix();
	}
	
	public void buildMatrix(){
		boolean firstRow = true;
		for (int i = 0; i < rows; i++){						//iterates through each row
			int sizeOfRow = 0;
			for (int j = 0; j<columns; j++){
				Node<Integer> newNode = new Node<Integer>((i*10)+j);
					if (sizeOfRow ==0) {					//checks to see if the node is the first in the row
						if (size ==0){						//checks to see if the node is the first in the matrix
							current = newNode;
							leftMost = newNode;
							upLink = newNode;
							first = newNode;
						}else{
							current = newNode;
							leftMost.down = current;
						}
					}else{
						if (firstRow){						//if it is the first row, no "down" pointers are set
						current.next = newNode;
						current = newNode;
						}else{								//if it is not the first row, sets the current pointers and down pointers
							current.next = newNode;
							upLink = upLink.next;
							upLink.down = newNode;
							current = current.next;
						}
					}
				sizeOfRow++;							//increments the size of the row
				size++;									//increments size of the entire matrix
			}
			if (!firstRow){								//moves the leftmost pointer down if it is now the first row
				upLink = leftMost.down;
				leftMost = leftMost.down;
			}
		firstRow = false;								//at the end of the first iteration, it is no longer the first row
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
	
	
	public void setValueAtPosition(int value, int position){
		leftMost = first;
		int down = (int)(position/10);
		int over = (int)(position%10);
		for (int i = 0; i<down; i++){
			leftMost = leftMost.down;
		}
		current = leftMost;
		for (int i = 0; i<over; i++){
			current = current.next;
		}
		current.data = value;
	}
	
	public void showSums(){
		Node<Integer> topSlider = first;				//node pointer that stays in first row. Used for column summation
		int rowSum = 0;
		int colSum = 0;
		leftMost = first;
		for (int i = 0; i<rows; i++){					//summation of rows
			current = leftMost;
			rowSum = 0;
			for (int j = 0; j<columns; j++){
				rowSum+= current.data;
				current.displayNode();
				current = current.next;
			}
			System.out.println("Sum: " + rowSum + "\n");
			leftMost = leftMost.down;
		}
		for (int k = 0; k<columns; k++){				//summation of columns
			current = topSlider;
			colSum = 0;
			for (int l = 0; l<rows; l++){
				colSum+= current.data;
				current = current.down;
			}
			System.out.print(colSum + "\t");
			topSlider = topSlider.next;
		}
		
	}
	
	
}
