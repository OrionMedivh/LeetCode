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
	
	public static void main(String[] args){
		MinQueue mq = new MinQueue();
		mq.offer(5);
		mq.offer(4);
		mq.offer(1);
		mq.offer(3);
		mq.offer(2);
		System.out.println(mq.getMin());
		System.out.println(mq.top());
		mq.poll();
		System.out.println(mq.getMin());
		System.out.println(mq.top());
		mq.poll();
		System.out.println(mq.getMin());
		System.out.println(mq.top());
		mq.poll();
		System.out.println(mq.getMin());
		System.out.println(mq.top());
		mq.poll();
		System.out.println(mq.getMin());
		System.out.println(mq.top());
		System.out.println(mq.toString());
	}
}
