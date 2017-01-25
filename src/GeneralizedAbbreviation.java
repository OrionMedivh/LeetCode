import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
//    public List<String> generateAbbreviations(String word) {
//        List<String> list = new ArrayList<String>();
//        int n = word.length();
//        for(int i=0;i<Math.pow(2,n);i++){
//            int count = 0;
//            StringBuffer sb = new StringBuffer();
//            for(int j=0;j<n;j++){
//                if ((i & (1 << j))==0){
//                    count++;
//                }
//                else{
//                    sb.append(count>0?count:"");
//                    sb.append(word.charAt(j));
//                    count =0;
//                }
//            }
//            sb.append(count>0?count:"");
//            list.add(sb.toString());
//        }
//        return list;
//    }//correct, bit manipulation, somewhat complex

	public List<String> generateAbbreviations(String word) {
		List<String> ret = new ArrayList<String>();
		backtrack(ret, word, 0, "", 0);

		return ret;
	}

	private void backtrack(List<String> ret, String word, int pos, String cur,
			int count) {
		if (pos == word.length()) {
			if (count > 0)
				cur += count;
			ret.add(cur);
		} else {
			backtrack(ret, word, pos + 1, cur, count + 1); // abbreviate current character
			backtrack(ret, word, pos + 1,
					cur + (count > 0 ? count : "") + word.charAt(pos), 0); // keep current character
		}
	}
}