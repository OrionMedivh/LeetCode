
public class LongestSubstring {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - i, maxLen);
                i = j + 1; 
            }
            j = k - 1;  
        }
        return Math.max(s.length() - i, maxLen);
    }
  
  public static void main(String[] args){
    LongestSubstring s = new LongestSubstring();
    System.out.println(s.lengthOfLongestSubstringTwoDistinct( "eceba" ));
    System.out.println(s.lengthOfLongestSubstringTwoDistinct( "eebba" ));
  }
}
