
public class RegularExpressionMatching {
	    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 0; i <= s.length(); i++){ // i starts from 0, which is for pattern c* match empty string.
            for(int j = 1; j<= p.length(); j++){ // j == 0 means empty pattern, which is false, so start from 1
                if(p.charAt(j-1) != '*'){ // j-1 is current index
                	// i >= 1; previous pairs matches; (current pair equals or current pattern is '.' )  
                    dp[i][j] = i >= 1 && dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }else{
					// c* match empty
					// or  i > 1; c* matches previous; (current equals or current is '.' )
                    dp[i][j] = j >= 2 && dp[i][j-2] 
                    || j>=2 && i >= 1 && dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
	
	public static void main(String[] args){
		RegularExpressionMatching s = new RegularExpressionMatching();
		System.out.println(s.isMatch("aab", "c*a*b"));
	}
}
