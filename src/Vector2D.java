import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

	Iterator<List<Integer>> i1;
	Iterator<Integer> i2;

	public Vector2D(List<List<Integer>> vec2d) {
		i1 = vec2d.iterator();
	}

	@Override
	public Integer next() {
		return i2.next();
	}

	@Override
	public boolean hasNext() {
		while ((i2 == null || !i2.hasNext()) && i1 != null && i1.hasNext()) {
			i2 = i1.next().iterator();
		}
		return i2 != null && i2.hasNext();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}

/**
 * Your Vector2D object will be instantiated and called as such: Vector2D i =
 * new Vector2D(vec2d); while (i.hasNext()) v[f()] = i.next();
 */
