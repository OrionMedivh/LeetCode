import java.util.Arrays;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
	
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
		nodes[find(node1, nodes)]=find(node2, nodes); //connect the deepest parents of two nodes.
	}
	
	public int find(int node, int[] nodes){//find deepest connected node.
		if(nodes[node] == -1 || nodes[node] == node) return node; // find an end or itself(loop)
		return find(nodes[node], nodes);
	}
	
	
}