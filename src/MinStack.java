import java.util.Stack;

public class MinStack {
private Stack<Integer> stack;
private Stack<Integer> minStack;
	
	//Constructor
	public MinStack(){
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	
	public void push(int x){
		stack.push(x);
		if(minStack.isEmpty() || x <= minStack.peek()){
			//we only push x into minStack when it's <= minStack.peek()
			minStack.push(x);
		}
	}
	
	public void pop(){
		if(stack.isEmpty()) {
			return;
		}
		if(!minStack.empty() && minStack.peek().equals(stack.peek())){
			minStack.pop();
		}
	}
	
	public int top(){
		return stack.peek();
	}
	
	public int getMin(){
		return minStack.peek();
	}
	
	//5,4,1,3,2
	//5,4,1,(1),(1)
}
