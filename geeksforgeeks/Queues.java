class ArrayQueue{
	int[] arr;
	int front,size;
	ArrayQueue(int s){
		arr = new int[s];
		front=-1;
		size=s;
	}
	boolean isQueueFull(){
		return (front== size-1? true:false);
	}
	boolean isQueueEmpty(){
		return (front==-1? true:false);
	}
	void ensureSize(){
		int[] newArr = new int[2*size];
		for (int i=0;i<size ;i++ ) {
			newArr[i] = arr[i];
		}
		arr = newArr;
		size = arr.length;
	}
	int queueSize(){
		return front+1;
	}
	void enqueue(int data){
		if(isQueueFull()){
			System.out.println("queue full..enlarging queue");
			ensureSize();
		}
		for (int i=front;i>=0 ;i-- ) {
			arr[i+1]=arr[i];
		}
		arr[0]=data;
		front++;
	}
	int dequeue(){
		int deq = arr[front];
		front--;
		return deq;
	}
	void printQueue(){
		if(!isQueueEmpty()){
		for (int i=0;i<=front ;i++ ) {
			System.out.print(""+arr[i]+" ");
		}}
		System.out.println();
	}
}

class ListQueue{
	QNode front,rear;
	int size;
	class QNode{
		int data;
		QNode next,prev;
		QNode(int d){
			data=d;
			next=prev=null;
		}
	}
	ListQueue(){
		front=rear=null;
		size=0;
	}
	int getSize(){
		return size;
	}
	void enqueue(int d){
		QNode node = new QNode(d);
		if(rear==null){
			front=rear=node;
		}
		else{
			rear.prev = node;
			node.next = rear;
			rear = node;
		}
		size++;
	}
	int dequeue(){
		if(getSize() > 0){
			int t=front.data;
			front = front.prev;
			size--;
			return t;
		}
		return -10101;
	}
	void printList(){
		if(size>0){
		QNode temp=rear;
		for (int i =0;i<size ;i++ ) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}}
		System.out.println();
	}
}
class Queues{
	static void arrayQueueTester(){
		ArrayQueue aq = new ArrayQueue(10);
		aq.printQueue();
		aq.enqueue(10);
		aq.printQueue();
		aq.enqueue(2);
		aq.printQueue();
		System.out.println("queue size "+aq.queueSize());
		aq.enqueue(8);
		aq.printQueue();
		aq.enqueue(-5);
		aq.printQueue();
		System.out.println(aq.dequeue());
		aq.printQueue();
	}
	static void listQueueTester(){
		ListQueue lq = new ListQueue();
		// lq.enqueue(10);
		lq.printList();
		System.out.println(lq.dequeue());
		lq.printList();
	}
	public static void main(String[] args) {
		// arrayQueueTester();
		listQueueTester();
	}
}