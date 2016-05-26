/**
* A Class for numeric progressions
*/
public class Progression {
	/** First value of progression */
	protected long first;
	/** Current value of progression */
	protected long cur;
	/** Default constructor */
	Progression(){
		cur=first=0;
	}
	/** Resets the progression to first value
	*	@return first value
	*/
	protected long firstValue(){
		cur=first;
		return cur;
	}
	/** Advances progression to next value
	* @return next value
	*/
	protected long nextValue(){
		return ++cur;
	}
	/** Print the first n values of progression
	* @param n number of values to print
	*/
	public void printProgression(int n){
		for (int i=0; i<n;i++ ) {
			if(i==0) System.out.print(firstValue());
			else System.out.print(" "+nextValue());
		}
		System.out.println();
	}
}