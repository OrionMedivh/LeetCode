import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString {
//    public String reverseWords(String s) {
//        Stack<String> WordStack=new Stack<String>();
//        StringBuffer tmp=new StringBuffer(),result=new StringBuffer();
//        s=s+" ";
//        for(int i=0;i<s.length();i++){
//        	if (s.charAt(i)!=' '){
//        		tmp.append(s.charAt(i));
//        	}
//        	else{
//        		if (!tmp.toString().isEmpty())
//        		{
//        		WordStack.push(tmp.toString());
//        		tmp=new StringBuffer();
//        		}
//        	}
//        }
//        
//        int size=WordStack.size();
//        for (int j=0;j<size;j++){
//        	result.append(WordStack.pop());
//        	if (j<size-1){
//        	result.append(" ");
//        	}
//        }
//        
//        return result.toString();
//    }
	
    public String reverseWords(String s) {
    	String[] words = s.trim().split(" +");
    	Collections.reverse(Arrays.asList(words));
    	return String.join(" ", words);
    } 
    
    public static void main(String[] args)
    {
    	ReverseWordsInAString s=new ReverseWordsInAString();
    	System.out.println(s.reverseWords("   a   b "));
    }
}
