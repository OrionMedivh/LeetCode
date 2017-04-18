import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class MinQueue {
	private Queue<Integer> queue;
	private Deque<Integer> minQueue;
	
	//Constructor
	public MinQueue(){
		queue = new LinkedList<>();
		minQueue = new ArrayDeque<>();
	}
	
	public void offer(int x){
		while (!minQueue.isEmpty() && minQueue.peekLast() > x){
			minQueue.pollLast();
		}
		queue.offer(x);
		minQueue.offer(x);
	}
	
	public void poll(){
		if(queue.isEmpty())
			return;
		if(queue.peek().equals(minQueue.peek())){
			minQueue.poll();
		}
		queue.poll();
	}
	
	public int top(){
		return queue.peek();
		
	}
	
	public int getMin(){
		return minQueue.peek();
	}
	//5,4,1,3,2
	//5
	//(5),4
	//(5),(4),1
	//(5),(4),1,3
	//(5),(4),1,(3),2
}
