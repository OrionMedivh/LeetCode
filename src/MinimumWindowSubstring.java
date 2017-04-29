import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,ArrayList<Integer>> map1 = new HashMap<Character, ArrayList<Integer>>();
        HashMap<Character,Integer> map2 = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
        	if(map1.containsKey(s.charAt(i))){
        		map1.get(s.charAt(i)).add(i);
        	}
        	else{
        		ArrayList<Integer> tmp = new ArrayList<Integer>();
        		tmp.add(i);
        		map1.put(s.charAt(i), tmp);
        	}
        }
        for(int i=0;i<t.length();i++){
        	if(map2.containsKey(t.charAt(i))){
        		map2.put(t.charAt(i),map2.get(s.charAt(i))+1);
        	}
        	else{
        		map2.put(s.charAt(i), 1);
        	}
        }
        int start =0, end = s.length()-1;
        for(int i=0;i<t.length();i++){
        	char current = t.charAt(i);
        	if(!map1.containsKey(current)) return "";
        	ArrayList<Integer> range = map1.get(current);
        	
        }
		return null;//to do
    }
}