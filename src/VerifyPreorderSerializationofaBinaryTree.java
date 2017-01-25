//import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {
	// public boolean isValidSerialization(String preorder) {
	// Stack<String> s = new Stack<String>();
	// String[] nodes = preorder.split(",");
	// String preNode = "";
	// for (String node : nodes) {
	// while (node.equals("#") && preNode.equals("#")) {
	// if (s.size()>=2) {
	// s.pop();
	// s.pop();
	// preNode = s.isEmpty()?"":s.peek();
	// } else {
	// return false;
	// }
	// }
	// s.push(node);
	// preNode = node;
	// }
	// return s.size()==1 && (s.pop().equals("#"));
	// }

	public boolean isValidSerialization(String preorder) {
		// each non-null node provides 2 outdegree and 1 indegree (2 children
		// and 1 parent), except root
		// each null node provides 0 outdegree and 1 indegree (0 child and 1
		// parent).
		// so we only need to calculate to see if the final result is 0.
		// lets start from 1 to compensate root.

		// can also comprehend as non null nodes are always 1 less than null
		// nodes
		String[] nodes = preorder.split(",");
		int diff = 1;
		for (String node : nodes) {
			if (diff <= 0)
				return false;
			if (node.equals("#"))
				diff--;
			else
				diff++;
		}
		return diff == 0;
	}

}