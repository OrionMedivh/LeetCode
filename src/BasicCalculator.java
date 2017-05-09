import java.util.Stack;

//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
//non-negative integers and empty spaces .
//
//You may assume that the given expression is always valid.
//
//Some examples:
//"1 + 1" = 2
//" 2-1 + 2 " = 3
//"(1+(4+5+2)-3)+(6+8)" = 23
//Note: Do not use the eval built-in library function.

public class BasicCalculator
{
  public int calculate( String s )
  {
    s = s.replace( " ", "" );
    Stack<Boolean> stack = new Stack<Boolean>();
    String cur = "";
    int result = 0;
    boolean positive = true; // current positive.
    stack.push( positive );
    boolean prepositive = stack.peek(); //previous positive
    for ( char c : s.toCharArray() ){
       if ( c == '+' ){
        int curValue = cur.equals("")?0:Integer.valueOf( cur );
        result += prepositive == positive? curValue : -curValue;
        cur = "";
        positive = true;
      }else if ( c == '-' ){
        int curValue = cur.equals("")?0:Integer.valueOf( cur );
        result += prepositive == positive? curValue : -curValue;
        cur = "";
        positive = false;
      }else if ( c == '(' ){
        stack.push( prepositive == positive );
        prepositive = stack.peek();
        positive = true; // ( followed by + by default. extra - will be parsed next.
        cur = "";
      }else if ( c == ')' ){
        int curValue = cur.equals("")?0:Integer.valueOf( cur );
        result += prepositive == positive? curValue : -curValue;
        cur = "";
        stack.pop();
        prepositive = stack.peek();
        positive = true;
      }else{
        cur = cur + c;
      }
    }
    int curValue = cur.equals("")?0:Integer.valueOf( cur );
    result += prepositive == positive ? curValue : -curValue;
    return result;
  } // iteration

  public static void main( String args[] )
  {
    BasicCalculator s = new BasicCalculator();
    System.out.println( s.calculate( "-(1+(4+5+2)-3)+(6+8)" ) );
    //System.out.println( s.calculate( "1-1" ) );
  }
}