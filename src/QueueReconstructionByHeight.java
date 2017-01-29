import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){ //sort by h desc, k asc
                if(a[0]!=b[0]){
                    return b[0]-a[0];
                }
                return a[1]-b[1];
            }
        });
        
        ArrayList<int[]> result = new ArrayList<int[]>();
        for(int[] i:people){
            result.add(i[1], i); // each k is the insert place.
        }
        
        for(int i=0;i<result.size();i++){
        	people[i]=result.get(i); // copy from arraylist to int[][].
        }
        return people;
    }
    
    public static void main(String[] args){
    	//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    	QueueReconstructionByHeight s = new QueueReconstructionByHeight();
    	int[][] input = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    	System.out.println(Arrays.deepToString(s.reconstructQueue(input)));
    }
}
