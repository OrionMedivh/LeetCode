import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    private HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> list = new LinkedList<>();
	
    public List<String> findItinerary(String[][] tickets) {
    	for(String[] ticket:tickets){
    		if(!map.containsKey(ticket[0])){
    			map.put(ticket[0],new PriorityQueue<String>());
    		}
    		map.get(ticket[0]).offer(ticket[1]);
    	}
    	visit("JFK");
    	return list;
    }
    
    public void visit(String start){
    	while(map.containsKey(start) && !map.get(start).isEmpty()){
    		visit(map.get(start).poll());
    	}
		list.add(0,start);
    }
    
    public static void main(String[] args){
    	ReconstructItinerary s = new ReconstructItinerary();
    	//String[][] tickets = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//    	String[][] tickets = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
    	String[][] tickets = new String[][]{{"JFK", "A"}, {"JFK", "D"}, {"A", "C"}, {"C", "D"},
    				{"C", "JFK"}, {"D", "A"}, {"D", "B"}, {"B", "C"}}; 	
    	System.out.println(s.findItinerary(tickets));
    }
}