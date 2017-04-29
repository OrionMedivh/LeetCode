import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {
//    public List<int[]> getSkyline(int[][] buildings) {
//        //1. merge each pair into multiple non-overlap rectangle areas
//    	//2. collapse connected, having same height areas.//not needed
//    	List<int[]> list = new ArrayList<int[]>();//final result'
//    	if(buildings == null || buildings.length==0) return list;
//    	List<int[]> rects = new ArrayList<int[]>();//store rectangles
//    	rects.add(new int[]{0,buildings[buildings.length-1][1],0});
//    	for(int[] building : buildings){//each building
//    		List<int[]> curRect = new ArrayList<int[]>();
//    		for(int[] rect :rects){//each rectangle
//    			if(rect[0] < building[1] 
//    					&& rect[1] > building[0]){
//    				int begin,end;
//    				int[] left=null, mid=null, right=null;
//    				if (rect[0] < building[0]){
//    					left = new int[]{rect[0], building[0], rect[2]};
//    					begin = building[0];
//    				}else if(rect[0] > building[0]){
//    					left = new int[]{building[0], rect[0], building[2]};
//    					begin = rect[0];
//    				}else{
//    					begin = rect[0];
//    				}
//    				if (rect[1] < building[1]){
//    					right = new int[]{rect[1], building[1], building[2]};
//    					end = rect[1];
//    				}else if(rect[1] > building[1]){
//    					right = new int[]{building[1], rect[1], rect[2]};
//    					end = building[1];
//    				}else{
//    					end = rect[1];
//    				}
//    				if(begin!=end){
//    					mid = new int[]{begin, end, Math.max(building[2], rect[2])};
//    				}
//    				if(left != null) curRect.add(left);
//    				if(mid != null) curRect.add(mid);
//    				if(right != null) curRect.add(right);
//    			}else{
//    				curRect.add(rect);
//    			}
//    		}
//    		rects=curRect;
//    	}
//    	
//    	int hi=0;
//    	for(int[] rect:rects){
//    		if(rect[2]!=hi){
//    			list.add(new int[]{rect[0],rect[2]});
//    			hi = rect[2];
//    		}
//    	}
//    	list.add(new int[]{rects.get(rects.size()-1)[1], 0});
//    	return list;
//    } //TLE
	
    public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<>();
    List<int[]> height = new ArrayList<>();
    for(int[] b:buildings) {
        height.add(new int[]{b[0], b[2]});
        height.add(new int[]{b[1], -b[2]});
    }
    Collections.sort(height, new Comparator<int[]>(){
    	public int compare(int[] a, int[] b){
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return b[1] - a[1];
    	}
    });
    Queue<Integer> pq = new PriorityQueue<>(buildings.length,Collections.reverseOrder());
    pq.offer(0);
    int prev = 0;
    for(int[] h:height) {
        if(h[1] > 0) {
            pq.offer(h[1]);
        } else {
            pq.remove(-h[1]);
        }
        int cur = pq.peek();
        if(prev != cur) {
            result.add(new int[]{h[0], cur});
            prev = cur;
        }
    }
    return result;
}
    
    public static void main(String[] args){
//    	int[][] buildings = new int[][]{{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
    	int[][] buildings = new int[][]{{0,2,3},{2,5,3}};
    	TheSkylineProblem s = new TheSkylineProblem();
    	for(int[] arr: s.getSkyline(buildings)){
    		for(int i:arr){
    			System.out.print(i+",");
    		}
    		System.out.println();
    	}
    }
}