import java.util.HashMap;

public class SingleNumberII {
    public int singleNumber(int[] A) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i:A){
            if (map.containsKey(i))
            map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        for (int i:map.keySet()){
            if (map.get(i)==1)
            return i;
        }
        return -1;//error
    }
}

//public int singleNumber(int[] A) {
//    int ones = 0, twos = 0;
//    for(int i = 0; i < A.length; i++){
//        ones = (ones ^ A[i]) & ~twos;
//        twos = (twos ^ A[i]) & ~ones;
//    }
//    return ones;
//}