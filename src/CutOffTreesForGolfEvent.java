import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:
Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
Example 2:
Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
Example 3:
Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
Hint: size of the given matrix will not exceed 50x50.
 */

public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
    	// parse List<List<Integer>> into a sorted list.
        List<int[]> trees = new ArrayList<>();
        for(int i = 0; i< forest.size(); i++){
        	for(int j = 0; j< forest.get(i).size(); j++){
        		int k = forest.get(i).get(j);
        		if( k > 1) trees.add(new int[]{k, i, j});
        	}
        }
        
        Collections.sort(trees, (a,b) -> Integer.compare(a[0], b[0]));
        
        int total = 0, x = 0, y = 0;
        for(int[] tree:trees){
        	int dist = dist(forest, x, y, tree[1], tree[2]);
        	if(dist < 0) return -1;
        	total += dist;
        	x = tree[1];
        	y = tree[2];
        }
        return total;
    }
    
    int[] direction = new int[]{0, -1, 0, 1, 0};
    
    //bfs
    public int dist(List<List<Integer>> forest, int x1, int y1, int x2, int y2){
    	int row = forest.size();
    	int column = forest.get(0).size();
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[]{x1,y1,0});
    	boolean[][] seen = new boolean[row][column];
    	seen[x1][y1] = true;
    	while(!queue.isEmpty()){
    		int[] cur = queue.poll();
    		if(cur[0] == x2 && cur[1] == y2) return cur[2];
    		for(int i = 0; i < 4; i++){
    			int nextX = cur[0] + direction[i];
    			int nextY = cur[1] + direction[i+1];
    			if( nextX >=0 && nextX < row && nextY >=0 && nextY < column 
    					&& !seen[nextX][nextY] && forest.get(nextX).get(nextY) > 0){
    				seen[nextX][nextY] = true;
    				queue.add(new int[]{nextX, nextY, cur[2]+1});
    			}
    		}
    	}
		return -1;
    } 
}
