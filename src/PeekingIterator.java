import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> i;
    int cache;
    boolean cached;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    i= iterator;
	    cached=false;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(cached) return cache;
        cache = i.next();
        cached=true;
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(cached) {
            cached=false;
            return cache;
        }
        return i.next();
	}

	@Override
	public boolean hasNext() {
	    return cached || i.hasNext();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}