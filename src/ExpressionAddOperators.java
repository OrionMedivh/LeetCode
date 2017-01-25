import java.util.ArrayList;
import java.util.List;


public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> list = new ArrayList<>();
		if (num == null)
			return list;
		dfs(num, target, list, new StringBuffer(), 0, 0, 0);
		return list;
	}
	
	void dfs(String num, int target, List<String> list, StringBuffer path, int index, long value, long multi){
		if(index == num.length()){
			if(value == target){
				list.add(path.toString());
				return;
			}
		}
		for(int i=index;i<num.length();i++){
			if(i!=index && num.charAt(index)=='0') break;
			long curValue = Long.parseLong(num.substring(index,i+1));
			int len = path.length();
			if(index == 0){
				dfs(num, target, list, path.append(curValue), i+1, value + curValue, curValue);
				path.setLength(len);
			}else{
				dfs(num, target, list, path.append("+").append(curValue), i+1, value + curValue, curValue);
				path.setLength(len);
				dfs(num, target, list, path.append("-").append(curValue), i+1, value - curValue, -curValue);
				path.setLength(len);
				dfs(num, target, list, path.append("*").append(curValue), i+1, value - multi + curValue*multi, curValue*multi);
				path.setLength(len);
			}
		}
	}
}
