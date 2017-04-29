import java.util.Iterator;
import java.util.List;

public class Flattern2DVector {
    Iterator<List<Integer>> i1;
    Iterator<Integer> i2;
    
    public Flattern2DVector(List<List<Integer>> vec2d) {
        i1=vec2d.iterator();
    }

    public int next() {
        hasNext();
        return i2.next();
    }

    public boolean hasNext() {
        while ((i2==null || !i2.hasNext()) && i1.hasNext()){
            i2=i1.next().iterator();
        }
        return i2 != null && i2.hasNext();
    }
}

/**
 * Your Flattern2DVector object will be instantiated and called as such:
 * Flattern2DVector i = new Flattern2DVector(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */