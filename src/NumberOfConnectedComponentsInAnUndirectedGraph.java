import java.util.Arrays;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
//	
//	private HashSet<Integer> set = new HashSet<Integer>();
//	
//    public int countComponents(int n, int[][] edges) {
//    	int m = edges.length;
//        // the idea of disjoint set
//        HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
//        for(int i=0;i<m;i++){
//            map.put(i,-1); //initialize all edges to not connect to anyone.
//        }
//        for(int i=0;i<m-1;i++) 
//        // the last edge doesn't need to pair.
//            for(int j=i+1;j<m;j++)
//            // double for loop: for every possible pair of edges
//            {
//                if(map.get(j) == -1 && connect(edges[i],edges[j]))
//                // when 2nd edge is not connected then try to connect it.
//                map.put(j,i);//connect 2nd to 1st.
//            }
//        int count = 0;
//        for (int i=0;i<m;i++)
//        {
//            if(map.get(i) == -1)
//            // only need to find how many edges are not mapped to anyone.
//            count++;
//        }
//        return n-set.size()+count;
//    }
//    
//    private boolean connect(int[] e1, int[] e2){
//        for(int i:e1)
//            for(int j:e2){
//            	set.add(i);
//            	set.add(j);
//                if (i==j)
//                return true;
//            }
//        return false;
//    }
	//TLE
	
	public int countComponents(int n, int[][] edges) {
		//initialize nodes
		int[] nodes = new int[n];
		Arrays.fill(nodes, -1);
		//connect edges
		for(int[] edge:edges){
			union(edge[0],edge[1], nodes);
		}
		//count how many -1 left
		int count =0;
		for(int i=0;i<n;i++){
			if(nodes[i] == -1 || nodes[i] == i)
				count++;
		}
		return count;
	}
	
	public void union(int node1, int node2, int[] nodes){
		nodes[find(node1, nodes)]=find(node2, nodes);
	}
	
	public int find(int node, int[] nodes){//find deepest connected node.
		if(nodes[node] == -1 || nodes[node] == node) return node; // find an end or itself(loop)
		return find(nodes[node], nodes);
	}
}