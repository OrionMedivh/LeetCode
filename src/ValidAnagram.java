import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0)
        return true;
        // if size is different, return false
        if (s.length() != t.length()) return false;
        // compare string
        char [] s1,t1 = new char[s.length()];
        s1 = s.toCharArray();
        t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        if (Arrays.equals(s1, t1)){
        return true;
        }
        return false;
    }
    
    public static void main(String[] args){
    	ValidAnagram s = new ValidAnagram();
    	System.out.println(s.isAnagram("a", "a"));
    }
}
