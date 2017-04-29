import java.util.Arrays;

public class ValidGraphTree {
//    public boolean validTree(int n, int[][] edges) {
//        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
//        for(int[] edge:edges){
//            if(!map.containsKey(edge[0])) map.put(edge[0], new HashSet<Integer>());
//            map.get(edge[0]).add(edge[1]);
//            if(!map.containsKey(edge[1])) map.put(edge[1], new HashSet<Integer>());
//            map.get(edge[1]).add(edge[0]);
//        }
//        int count = map.size();
//        while(map.size()!=0 && count!=0){
//        for(int i:map.keySet()){
//	        	if(map.get(i).size()==1){
//	        		count++;
//	            	int value = map.get(i).iterator().next();
//	        		map.get(value).remove(i);
//	        		map.remove(i);
//	        	}
//	        }
//        }
//        if(map.size()!=0) return false;
//        return true;
//    } //topological prune, too complicated
	
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums,-1);
        for(int[] edge: edges){
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);
            if(x==y) return false;
            nums[x]=y;
        }
        return edges.length == n-1;
    }
    
    private int find(int[] nums,int i){
        if(nums[i]==-1) return i;
        return find(nums, nums[i]);
    }
    
    public static void main(String args[]){
    	ValidGraphTree s = new ValidGraphTree();
    	System.out.println(s.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
    }
    
}