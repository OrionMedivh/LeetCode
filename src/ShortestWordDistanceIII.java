public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i=-1,j=-1,min = Integer.MAX_VALUE;
        for (int k=0;k<words.length;k++){
            if (words[k].equals(word1)) i=k;
            if (i>=0 && j>=0 && i!=j) min = Math.min(Math.abs(i-j),min);
            if (words[k].equals(word2)) j=k;
            if (i>=0 && j>=0 && i!=j) min = Math.min(Math.abs(i-j),min);
        }
        return min;
    }
} // 4 ms concise solution

//public class ShortestWordDistanceIII {
//    public int shortestWordDistance(String[] words, String word1, String word2) {
//        int i=-1,j=-1,min = Integer.MAX_VALUE;
//        if (!word1.equals(word2))
//        for (int k=0;k<words.length;k++){
//            if (words[k].equals(word1)) i=k;
//            if (words[k].equals(word2)) j=k;
//            if (i>=0 && j>=0) min = Math.min(Math.abs(i-j),min);
//        }
//        else
//        for (int k=0;k<words.length;k++){
//            if (words[k].equals(word2))
//            {
//                j=k;
//                if (i!=-1){
//                min = Math.min(Math.abs(i-j),min);
//                }
//                i=k;
//            }
//        }
//        return min;
//    }
//}// 2 ms long answer