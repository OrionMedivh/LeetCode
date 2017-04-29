
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int max = 0;
        int n = words.length;
        int[] mask = new int[n];
        for(int i =0; i< n; i++){
            for(char c:words[i].toCharArray()){
                mask[i] |= 1 << (c - 'a');
            }
        }
        
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if ((words[i].length()*words[j].length()) <= max) continue;
                if ((mask[i] & mask[j]) == 0){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args){
    	String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    	MaximumProductOfWordLengths s = new MaximumProductOfWordLengths();
    	System.out.println(s.maxProduct(words));
    }
}