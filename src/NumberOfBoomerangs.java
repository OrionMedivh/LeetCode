import java.util.HashMap;
import java.util.Map;

/*Given n points in the plane that are all pairwise distinct, 
a "boomerang" is a tuple of points (i, j, k) such that the distance 
between i and j equals the distance between i and k (the order of the tuple matters).
Find the number of boomerangs. You may assume that n will be at most 500 and 
coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]*/

public class NumberOfBoomerangs
{
  public int numberOfBoomerangs(int[][] points) {
    //basic ideas is to count how many points have same distance to another points, and pair number is count*count-1;
    Map<Integer, Integer> map = new HashMap<>();
    if(points.length==0 || points[0].length==0) return 0;
    int ret = 0;
    for(int i=0;i<points.length;i++){
        for(int j=0;j<points.length;j++){
            if(j==i) continue;
            int dis = getDis(points[i],points[j]);
            map.put(dis, map.getOrDefault( dis, 0 )+1);
        }
        for(int size : map.values()){
            ret += (size*(size-1));
        }
        map.clear();
    }
    return ret;
  }
public int getDis(int[] p, int[] q){
    int a = p[0]-q[0];
    int b = p[1]-q[1];
    return a*a+b*b;
  }
}
