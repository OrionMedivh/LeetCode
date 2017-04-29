public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i=-1,j=-1,min = Integer.MAX_VALUE;
        for (int k=0;k<words.length;k++){
            if (words[k].equals(word1)) i=k;
            if (words[k].equals(word2)) j=k;
            if (i>=0 && j>=0) min = Math.min(Math.abs(i-j),min);
        }
        return min;
    }
}