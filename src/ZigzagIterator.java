import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {

//	private List<Queue<Integer>> list;
//	private int line;
//
//	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//		Queue<Integer> q1 = new LinkedList<Integer>(v1);
//		Queue<Integer> q2 = new LinkedList<Integer>(v2);
//		list = new ArrayList<Queue<Integer>>();
//		list.add(q1);
//		list.add(q2);
//		line = 0;
//	}
//
//	public int next() {
//		int result = 0;
//		if(hasNext())
//		result = list.get(line).poll();
//		do {
//			line = (line + 1) % 2;
//		} while (list.get(line).isEmpty());
//		return result;
//	}
//
//	public boolean hasNext() {
//		if (list.get(0).isEmpty() && list.get(1).isEmpty())
//			return false;
//		return true;
//	} //all kinds of small bugs
	
    private Iterator<Integer> i1,i2,tmp;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	    i1=v1.iterator();
	    i2=v2.iterator();
	}

	public int next() {
		if (i1.hasNext()) { tmp=i1;i1=i2;i2=tmp; }
		return i2.next();
	}

	public boolean hasNext() {
		return i1.hasNext() || i2.hasNext();
	}

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
			}
		};
		List<Integer> list2 = new ArrayList<Integer>() {
			{
				add(3);
				add(4);
				add(5);
				add(6);
			}
		};
		ZigzagIterator s = new ZigzagIterator(list1, list2);
		while (s.hasNext())
			System.out.println(s.next());
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] =
 * i.next();
 */
