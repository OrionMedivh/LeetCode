import java.util.HashMap;

public class LRUCache {
	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
	}

	private int capacity;
	private HashMap<Integer, Node> map;
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key);
		moveToTail(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}
		if (map.size() == capacity) {
			removeHead();
		}
		Node insert = new Node(key, value);
		map.put(key, insert);
		moveToTail(insert);
	}

	private void moveToTail(Node node) {
		if (node == null)
			return;
		Node A = node.prev;
		Node B = node.next;
		if (A != null) {
			A.next = B;
		}
		if (B != null) {
			B.prev = A;
		}

		// don't define before AB operations, the Z node might be influenced by
		// them, e.g. head <=> node <=> tail
		Node Z = tail.prev;
		if (Z != null) {
			Z.next = node;
		}
		node.prev = Z;
		node.next = tail;
		tail.prev = node;
	}

	private void removeHead() {
		Node node = head.next;
		if (node == null) {
			return;
		}
		map.remove(node.key);
		head.next = node.next;
		head.next.prev = head;
	}

	// public static void main(String[] args){
	// LRUCache cache = new LRUCache(1);
	// cache.put( 2, 1 );
	// cache.get( 2 );
	// cache.put( 3, 2 );
	// cache.get( 2 );
	// cache.get( 3 );
	// }
}
