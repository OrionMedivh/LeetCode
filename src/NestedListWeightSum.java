import java.util.List;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	private int depthSum(List<NestedInteger> nestedList, int depth) {
		int res = 0;
		if (nestedList == null || nestedList.size() == 0) {
			return res;
		}
		for (NestedInteger i : nestedList) {
			if (i.isInteger()) {
				res += i.getInteger() * depth;
			} else {
				res += depthSum(i.getList(), depth + 1);
			}
		}
		return res;
	}
}