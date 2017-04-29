import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupShiftStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(String s:strings){
        	String key="";
        	for(int i=1;i<s.length();i++){
        		int n=s.charAt(i)-s.charAt(i-1)+'a';
        		if(n<'a') n+=26;
        		key+=(char)n;
        	}
        	if(map.containsKey(key)) map.get(key).add(s);
        	else{
        		ArrayList<String> list=new ArrayList<String>();
        		list.add(s);
        		map.put(key,list);
        	}
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(String key:map.keySet()){
        	List<String> list = map.get(key);
        	Collections.sort(list);
        	result.add(list);
        }
        return result;
    }
}