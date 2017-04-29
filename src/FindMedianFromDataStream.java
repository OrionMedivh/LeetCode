import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
	private Queue<Long> small = new PriorityQueue<>(),
			large = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(small.size()==large.size()){
        	small.offer(-(long)num);
        	large.offer(-small.poll());
        }else{ //keep large size >= small size
        	large.offer((long)num);
        	small.offer(-large.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(large.size()==small.size()){
        	return (large.peek()-small.peek())/2.0;
        }else{
        	return large.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();