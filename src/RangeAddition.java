

public class RangeAddition {
//    public int[] getModifiedArray(int length, int[][] updates) {
//        int[] result = new int[length+1];
//        for(int[] i:updates){
//            result[i[0]]+=i[2];
//            result[i[1]+1]-=i[2];
//        }
//        for(int i = 1; i< length; i++){
//            result[i] += result[i-1];
//        }
//        return Arrays.copyOf(result, length);
//    }
	
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int[] i:updates){
            result[i[0]]+=i[2]; // put start in result
            if(i[1]<length - 1){ // if the last element, skip it.
            result[i[1]+1]-=i[2]; // put end in result
            }
        }
        for(int i = 1; i< length; i++){
            result[i] += result[i-1]; // scan the array and sum up results.
        }
        return result;
    }
}
