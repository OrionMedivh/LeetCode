import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1= new Stack<Integer>(); //storage stack
    private Stack<Integer> s2= new Stack<Integer>(); //operation stack
    
    // Push element x to the back of queue.
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.pop();
    }

    // Get the front element.
    public int peek() {
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return s1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

public class ImplementQueueUsingStack {
	public static void main(String[] args){
	MyQueue q = new MyQueue();
	q.push(1);
	q.pop();
	System.out.println(q.empty());
	}
}


