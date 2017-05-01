import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> list = new ArrayList<>();
		dfs(num, target, list, new StringBuffer(), 0, 0, 0);
		return list;
	}

	private void dfs(String num, int target, List<String> list, StringBuffer path, int index, long value, long multi) {
		if (index == num.length() && value == target) {
			list.add(path.toString());
			return;
		}
		for (int i = index; i < num.length(); i++) {
			if (num.charAt(index) == '0' && i != index) {
				break;
			}
			long curValue = Long.parseLong(num.substring(index, i + 1));
			int len = path.length();
			if (index == 0) {
				// starting number, only + is possible
				dfs(num, target, list, path.append(curValue), i + 1, value + curValue, curValue);
				path.setLength(len);
			} else {
				dfs(num, target, list, path.append("+").append(curValue), i + 1, value + curValue, curValue);
				path.setLength(len);
				dfs(num, target, list, path.append("-").append(curValue), i + 1, value - curValue, -curValue);
				path.setLength(len);
				dfs(num, target, list, path.append("*").append(curValue), i + 1, value - multi + curValue * multi,
						multi * curValue);
				// save mutiplication number in multi. a+b*c = (a+b) - b + b*c
				path.setLength(len);
			}
		}
	}
}
