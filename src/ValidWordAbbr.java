import java.util.HashMap;
import java.util.HashSet;

public class ValidWordAbbr {
    
    private HashMap<String,HashSet<String>> map;
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, HashSet<String>>();
        for(String s:dictionary){
            String s1 = Abbreviate(s);
            if(!map.containsKey(s1)) map.put(s1,new HashSet<String>());
            map.get(s1).add(s);
        }
    }
    
    private String Abbreviate(String s){
        if(s.length() < 3) return s;
        return ""+s.charAt(0)+(s.length()-2)+s.charAt(s.length()-1);
    }

    public boolean isUnique(String word) {
        String s1 = Abbreviate(word);
        if(!map.containsKey(s1) || map.get(s1).size() == 1 && map.get(s1).contains(word)) return true;
        return false;
    }
    
    public static void main(String[] args){
    	String[] s = new String[0];
    	ValidWordAbbr v = new ValidWordAbbr(s);
    	System.out.println(v.isUnique("hello"));
    }
}