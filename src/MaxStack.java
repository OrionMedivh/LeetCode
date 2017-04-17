import java.util.Stack;

public class MaxStack
{
  private Stack<Integer> stack;
  private Stack<Integer> maxStack;
  
  public MaxStack() {
    stack = new Stack<Integer>();
    maxStack = new Stack<Integer>();
  }
  
  public void push(int x){
    stack.push( x );
    if(maxStack.empty() || maxStack.peek() <= x){
      maxStack.push( x );
    }
  }
  
  public void pop(){
    if(stack.empty()){//remember to check whether the stack is empty
      return;
    }
    if(!maxStack.empty() && maxStack.peek().equals( stack.peek() )){//use equals, not == !!!
      maxStack.pop();
    }
  }
  
  public int top(){
    return stack.peek();
  }
  
  public int getMax(){
    return maxStack.peek();
  }
}
