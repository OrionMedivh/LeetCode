import java.util.*;

public class TwoSumIII {
    private HashMap<Integer,Integer> map;
    private ArrayList<Integer> list;
    public TwoSumIII(){
	    map = new HashMap<Integer,Integer>();
	    list = new ArrayList<Integer>();
    }
    
    // Add the number to an internal data structure.
	public void add(int number) {
        map.put(number, map.containsKey(number)?map.get(number)+1:1);
        list.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
        for (int i=0;i<list.size();i++) {
		    int key = list.get(i);
            if ((key == (value-key) && map.get(key)>1) || (key!=(value -key) && map.containsKey(value-key)))
            return true;
        } 
        return false;
	}
}