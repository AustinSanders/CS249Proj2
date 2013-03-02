
public class LastManStanding {
	public int startingPos;
	public int numBetweenRemoval;
	circList<String> a = new circList<String>();
	
	public LastManStanding(int numOfPeople, int numToRemove, int startPos){
		startingPos = startPos;
		numBetweenRemoval = numToRemove;
		for (int i = 1; i <= numOfPeople; i++){
			a.addAfterCurrent("Person number " + (i));
		}
		a.current = a.current.next;  //sets current back to person 1;
	}
	
	public String findLast(){
		setStart();
		while (a.getSize() > 1){
			for(int i = 0; i<numBetweenRemoval; i++){
				a.current = a.current.next;
			}
			a.removeCurrent();
		}
		return a.current.data;
	}
	
	public int getSize(){
		return a.getSize();
	}
	
	public void setStart(){
		for (int j = 1; j < startingPos; j++){
			a.current = a.current.next;
		}
	}
}
