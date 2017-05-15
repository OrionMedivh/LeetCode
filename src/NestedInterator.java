import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedInterator implements Iterator<Integer> {

	private Stack<NestedInteger> stack;

	public NestedInterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			if (stack.peek().isInteger()) {
				return true;
			}
			List<NestedInteger> list = stack.pop().getList();
			for (int i = list.size() - 1; i >= 0; i--) {
				stack.push(list.get(i));
			}
		}
		return false;
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

}
