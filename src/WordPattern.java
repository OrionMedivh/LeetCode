import java.util.HashMap;

/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String words[] = str.split(" ");
        if(words.length != pattern.length())
        	return false;
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for(int i = 0; i< pattern.length();i++){
        	String pre = map1.put(pattern.charAt(i), words[i]);
        	if(pre != null && !pre.equals(words[i])) return false;
        	Character pre1 = map2.put(words[i], pattern.charAt(i));
        	if(pre1 != null && !pre1.equals(pattern.charAt(i))) return false;
        }
        return true;
    }
}
