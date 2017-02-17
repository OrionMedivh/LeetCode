public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i; // find out the smallest letter in the part each char > 1
            if (--cnt[s.charAt(i) - 'a'] == 0) break; 
            //stop when one letter reached 0, 
            // which means from current place to the end of the string, 
            // we still have an entire set of letters, 
            // so it's safe to remove everything before pos,
            // because everything before pos will appear from current position to the end.
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
        //remove everything before smallest letter and duplicates of it afterwards.
    }
    
    public static void main(String[] args){
    	RemoveDuplicateLetters s = new RemoveDuplicateLetters();
    	System.out.println(s.removeDuplicateLetters("bcabcab"));
    }
}