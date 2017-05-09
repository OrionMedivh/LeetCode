import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path.split("/+"); // one or more '/'
		for (String s : paths) {
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!s.equals(".") && !s.equals("")) {
				stack.push(s);
			}
		}
		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
			sb.insert(0, "/");
		}
		if (sb.length() == 0) {
			return "/";
		}
		return sb.toString();
	}
}
