import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for undirected graph.
  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) { //This question is just to traverse a graph.
    	if(node == null) return null;
    	UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    	HashMap<Integer,UndirectedGraphNode> map = new HashMap<>(); // label -> node
    	map.put(newNode.label,newNode);
    	Queue<UndirectedGraphNode> queue = new LinkedList<>();
    	queue.add(node);
    	while(!queue.isEmpty()){
    		UndirectedGraphNode cur = queue.poll();
    		for(UndirectedGraphNode neighbor:cur.neighbors){
    			if(!map.containsKey(neighbor.label)){
    				map.put(neighbor.label, new UndirectedGraphNode(neighbor.label)); // create a new node, add label -> node into map
    				queue.offer(neighbor);
    			}
    			map.get(cur.label).neighbors.add(map.get(neighbor.label));//add node to List
    		}
    	}
    	return newNode;
    }
}
