
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p){
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		
		for(int i=0;i<s.length();i++)
			for(int j=0;i<p.length();j++){
				if(p.charAt(j-1)!='*')
					dp[i][j] = i > 0 && dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) == '.');
				else
					dp[i][j] = j > 2 && dp[i][j-2]
							|| i > 1 && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j];		
			}
		return dp[s.length()][p.length()];
	}
	
	public static void main(String[] args){
		RegularExpressionMatching s = new RegularExpressionMatching();
		System.out.println(s.isMatch("aab", "c*a*b"));
	}
}
