public class Scores{
	public static final int maxEntries = 10; //number of high scores to be kept
	protected int numEntries;	//number of actual entries
	protected GameEntry[] entries; //array of game entries
	public Scores(){
		entries = new GameEntry[maxEntries];
		numEntries = 0;
	}
	/**Returns a string representation of high scores here*/
	public String toString() {
		String s = "[";
		for (int i=0; i<numEntries; i++) {
			if(i>0) s += ", "; //separate entries by commas
			s += entries[i];
		}
		return s+"]";
	}
	//adding a high score if it really is one in its correct position
	public void add(GameEntry e){
		int newScore = e.getScore();
		if(numEntries == maxEntries){
			if (newScore <= entries[numEntries-1].getScore()) {
				return; //new entry e does not have a high enough score
			}
		}
		else numEntries++;
		//locate the place the new high score entry belongs to 
		int i=numEntries-1;
		for (; i>=1 && (newScore > entries[i-1].getScore()) ;i-- )
			entries[i]= entries[i-1];
		entries[i] = e;
	}
	/**Remove and return the high score at index i*/
	public GameEntry remove(int i) throws IndexOutOfBoundsException {
		if((i < 0) || i>= numEntries)
			throw new IndexOutOfBoundsException("Invalid Index: "+ i );
		GameEntry temp = entries[i];
		for (int j=i; j < numEntries-1;j++) {
		  	entries[j] = entries[j+1]; //move one cell to the left
		}
		entries[numEntries-1] = null;
		numEntries--;
		return temp;
	}
}