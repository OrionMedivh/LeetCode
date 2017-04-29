public class HitCounter {

int[] counts;
int index;

/*
5 array

-----
(1)
1
index=0; end = 0
nohing got cleaned
(3)
1 1
index = 0; end = 2
index cleaned from 1 to 2
(5)
1 1 1
index = 2, end = 4
index cleaned from 3 to 4
(6)
1 1 1
index = 4, end = 5
index cleaned from 0 to 0
(13)
1 0 0
index = 5, end = 13
index cleaned from 1 to 7
*/

    /** Initialize your data structure here. */
    public HitCounter() {
        counts = new int[300];
        index=0; // timestamp - 1
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int end = timestamp-1;
        int start = index+1;
        if ((end-start)>300) {
        	counts = new int[300];
        }else{
        	for(int i= start;i<=(end-start)%300+start;i++){
        		counts[i%300]=0;
        	}
        }
        counts[end%300]++;
        index=end;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        hit(timestamp);
        counts[(timestamp-1)%300]--;
        
        int sum = 0;
        for(int i:counts){
            sum+=i;
        }
        return sum;
    }
    
    
    public static void main(String[] args){
    	HitCounter obj = new HitCounter();
    	obj.hit(100);
    	obj.hit(198);
    	obj.hit(294);
    	System.out.println(obj.getHits(299));
    	System.out.println(obj.getHits(397));
    	System.out.println(obj.getHits(480));
    	System.out.println(obj.getHits(587));
    	System.out.println(obj.getHits(614));
    	obj.hit(625);
    	System.out.println(obj.getHits(684));
    	System.out.println(obj.getHits(1006));
    	System.out.println(obj.counts);
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */