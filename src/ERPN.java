import java.util.Stack;


public class ERPN {
    public int evalRPN(String[] tokens) {
       Stack<Integer> s=new Stack<Integer>();
       int size=tokens.length;
       int result=0;
       for (int i=0;i<size;i++){
    	   boolean plus=tokens[i].equals("+"),
    	   minus=tokens[i].equals("-"),
    	   multiply=tokens[i].equals("*"),
    	   divide=tokens[i].equals("/");
    	   
    	   if (plus||minus||multiply||divide){   		   
    		   if (s.size()==0){
    			   return 0;
    		   }
    		   else if(s.size()==1){
    			   return s.pop();
    		   }
    		   else {
    			   int a,b;
    			   a=s.pop();
    			   b=s.pop();
    			   if (plus){
    				   result=a+b;
    			   }
    			   if (minus){
    				   result=b-a;
    			   }
    			   if (multiply){
    				   result=a*b;
    			   }
    			   if (divide){
    				   result=b/a;
    			   }
				   s.push(result);
    		   }
    	   }
    	   else{
    		   s.push(Integer.parseInt(tokens[i]));
    	   }
       }
    	return s.pop();
    }
    
    public static void main(String[] args){
    	ERPN sol=new ERPN();
    	String[] tokens={"18"};
    	System.out.println(sol.evalRPN(tokens));
    }
}


