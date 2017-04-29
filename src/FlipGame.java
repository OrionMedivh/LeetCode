import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        for (int i=0; i < s.length()-1; i++)
            if (s.substring(i, i+2).equals("++")) 
                result.add(s.substring(0,i) + "--" + s.substring(i+2));
        return result;
    }
}

//public class Solution {
//	public List<String> generatePossibleNextMoves(String s) {
//      List<String> list = new ArrayList<String>();
//		for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0;)
//			list.add(s.substring(0, i) + "--" + s.substring(i + 2));
//		return list;
//	}
//}