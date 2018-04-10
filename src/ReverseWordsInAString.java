import java.util.Arrays;
import java.util.Collections;

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 */

public class ReverseWordsInAString {

	public String reverseWords(String s) {
		// trim first, then split by multiple one or more spaces
		String[] words = s.trim().split(" +");
		// reverse the words
		// Arrays.asList acts as bridge between array-based and collection-based APIs.
		Collections.reverse(Arrays.asList(words));
		// join the words to String
		return String.join(" ", words);
	}

	public static void main(String[] args) {
		ReverseWordsInAString s = new ReverseWordsInAString();
		System.out.println(s.reverseWords("   a   b "));
	}

	// public String reverseWords(String s) {
	// Stack<String> WordStack=new Stack<String>();
	// StringBuffer tmp=new StringBuffer(),result=new StringBuffer();
	// s=s+" ";
	// for(int i=0;i<s.length();i++){
	// if (s.charAt(i)!=' '){
	// tmp.append(s.charAt(i));
	// }
	// else{
	// if (!tmp.toString().isEmpty())
	// {
	// WordStack.push(tmp.toString());
	// tmp=new StringBuffer();
	// }
	// }
	// }
	//
	// int size=WordStack.size();
	// for (int j=0;j<size;j++){
	// result.append(WordStack.pop());
	// if (j<size-1){
	// result.append(" ");
	// }
	// }
	//
	// return result.toString();
	// }
}
