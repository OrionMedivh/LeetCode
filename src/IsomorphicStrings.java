//import java.util.HashMap;

public class IsomorphicStrings {
//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) return false;
//        HashMap<Character,Character> map = new HashMap<Character, Character>();
//        HashMap<Character,Character> map1 = new HashMap<Character, Character>();
//        for (int i=0;i<s.length();i++){
//            if (map.containsKey(s.charAt(i))){
//                if (map.get(s.charAt(i)) != t.charAt(i))
//                return false;
//            }
//            if (map1.containsKey(t.charAt(i))){
//                if (map1.get(t.charAt(i)) != s.charAt(i))
//                return false;
//            }
//            map.put(s.charAt(i),t.charAt(i));
//            map1.put(t.charAt(i),s.charAt(i));
//        }
//        return true;
//    }
	
	    public boolean isIsomorphic(String s1, String s2) {
	        int[] m = new int[512];
	        for (int i = 0; i < s1.length(); i++) {
	            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
	            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
	        }
	        return true;
	    }
    
    public static void main(String[] args){
    	IsomorphicStrings s = new IsomorphicStrings();
    	System.out.print(s.isIsomorphic("ab","aa"));
    }
}