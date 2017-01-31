
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] ascii = new int[256];
        int size = 0; // window size;
        int distinct = 0; // how many distinct characters
        int max = 0; // longest size;
        int start = 0; // starting index of the substring
        int index = 0; // iteration index;
        while(index < s.length()){
            char c = s.charAt(index);
            if(ascii[c] == 0){
            	distinct ++;
            }
            ascii[c]++;
            size++;
            while(distinct > k){
            	if(--ascii[s.charAt(start)]== 0 ){
            		distinct -- ;
            	}
            	size--;
            	start++;
            }
            max = Math.max(size, max);
            index++;
        }
        return max;
    }
}
