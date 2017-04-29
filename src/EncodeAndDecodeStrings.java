import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String str: strs){
            sb.append(str.length()+"");
            sb.append("@");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> list = new ArrayList<String>();
        int index = 0;
        int start= 0;
        while(index < s.length()){
            if(s.charAt(index)=='@'){
                int size = Integer.parseInt(s.substring(start, index));
                list.add(s.substring(index+1, index+size+1));
                index += size+1;
                start = index;
            }
            index++;
        }
        return list;
    }
    
    public static void main(String[] args){
    	ArrayList<String> strs = new ArrayList<String>();
    	strs.add("");
    	strs.add("abcd");
    	strs.add("");
    	EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
    	System.out.println(encodeAndDecodeStrings.decode(encodeAndDecodeStrings.encode(strs)));
    }
}

// Your EncodeAndDecodeStrings object will be instantiated and called as such:
// EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();
// codec.decode(codec.encode(strs));