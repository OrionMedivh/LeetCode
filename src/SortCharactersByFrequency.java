import java.util.Arrays;
import java.util.Comparator;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[][] buckets = new int[128][2];
        for(int i = 0 ; i < 128; i++){
            buckets[i][0] = i;
        }
        for(char c:s.toCharArray()){
            buckets[c][1]++;
        }
        Arrays.sort(buckets, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return b[1]-a[1];
            }
        });
        char[] result = new char[s.length()];
        int j = 0;
        for(int i = 0; i < buckets.length;i++){
            if(buckets[i][1]>0){
                while(buckets[i][1]>0){
                    result[j]=(char)buckets[i][0];
                    j++;
                    buckets[i][1]--;
                }
            }
        }
        return new String(result);
    }
}