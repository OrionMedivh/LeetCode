import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTrees {
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
//        for(int i=0;i<n;i++) list.add(new HashSet<Integer>());
//        for(int[] i:edges){
//            list.get(i[0]).add(i[1]);
//            list.get(i[1]).add(i[0]);
//        }
//        
//        while(n>2){
//            for(int i=0;i<n;i++){
//                if(list.get(i).size() == 1) {
//                    n--;
//                    int num = list.get(i).iterator().next();
//                    list.get(num).remove(i);
//                    list.get(i).remove(num);
//                }
//            }
//        }
//        List<Integer> result = new ArrayList<Integer>();
//        for(int i=0;i<n;i++){
//            if (list.get(i).size()!=0)
//            result.add(i);
//        }
//        return result;
//    } //TLE
	
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        for(int i=0;i<n;i++) list.add(new HashSet<Integer>());
        for(int[] i:edges){ // save the nodes as node -> all connections
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<n;i++){  // get all degree 0 nodes.
            if (list.get(i).size()==1)
            result.add(i);
        }
        
        while(n>2){ //start to cut off degree 0 nodes, stop at 1 or 2 nodes.
            n-=result.size(); //reduce size
            List<Integer> new_result = new ArrayList<Integer>();
            for(int i:result){
                int num = list.get(i).iterator().next(); //get the only connection
                list.get(num).remove(i); //cut the edge
                if(list.get(num).size()==1) new_result.add(num); // save all 1 degree
            }
            result=new_result;
        }
        
        if(result.size()==0) result.add(0); // there's a loop
        return result;
    }
}