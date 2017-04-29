public class Shortestpalindrome {
	public String shortestPalindrome(String s) {
		int i=0, end = s.length()-1, j=end;
		char[] array = s.toCharArray();
		while(i<j){
			if(array[i]==array[j]){
				i++;j--;
			}else{
				i=0;end--;j=end;
			}
		}
		return new StringBuffer(s.substring(end+1)).reverse().toString()+s;
	}
}