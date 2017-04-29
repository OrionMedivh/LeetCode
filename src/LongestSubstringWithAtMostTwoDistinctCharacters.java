import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	// public int lengthOfLongestSubstringTwoDistinct(String s) {
	// int[] mask = new int[s.length()];
	// for(int i = 0; i < s.length(); i++){
	// mask[i] = 1 << s.charAt(i)-'a';
	// }
	// int longest = 0;
	// for(int size = 1; size < s.length();size++){ // substring size-1
	// for(int i =0; i< s.length()-size; i++){
	// mask[i] = mask[i] | mask[i+1];
	// if (countDistinct(mask[i]) <=2) longest=size+1;
	// }
	// }
	// return longest;
	// }
	//
	// private int countDistinct(int n){
	// int i = 1, count =0;
	// for(int k =0; k < 26; k++){
	// if( (n & i) > 0 ) count++;
	// i = i << 1;
	// }
	// return count;
	// } // O(n^2) bad.

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		HashMap<Character, HashSet<Integer>> map = new HashMap<Character, HashSet<Integer>>();
		int CurWindowSize = 0, MaxWindowSize=0;
		for(int i =0;i< s.length(); i++){
			if (map.size() <= 2) {
				if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i), new HashSet<Integer>());
				map.get(s.charAt(i)).add(i);
				CurWindowSize ++;
			}
			while (map.size() > 2){
				char FirstCharInWindow = s.charAt(i-CurWindowSize+1);
				HashSet<Integer> set = map.get(FirstCharInWindow);
				if(set.size()>1){
					set.remove(i-CurWindowSize+1);
				}else{
					map.remove(FirstCharInWindow);
				}
				CurWindowSize -- ;
			}
			
			MaxWindowSize=Math.max(CurWindowSize, MaxWindowSize);
		}
		return MaxWindowSize;
	}

	public static void main(String[] args) {
		LongestSubstringWithAtMostTwoDistinctCharacters s = new LongestSubstringWithAtMostTwoDistinctCharacters();
//		System.out.println(s.lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(s.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
	}
}