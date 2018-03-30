import java.util.HashMap;
import java.util.Map;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  ); // capacity //

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

public class LRUCache {
	class Node{
		int key;
		int value;
		Node prev;
		Node next;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity;
	private Map<Integer, Node> map; 
	private Node head;
	private Node tail;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		this.map = new HashMap<Integer,Node>();
		this.head = new Node(-1,-1);
		this.tail = new Node(-1,-1);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key){
		Node node = map.getOrDefault(key, null);
		if(node == null) return -1;
		node.prev.next = node.next;
		node.next.prev = node.prev;
		MoveToHead(node);
		return node.value;
	}
	
	public void put(int key, int value){
		if(get(key) != -1){
			// exists, update value
			map.get(key).value = value;
			return;
		}
		Node newNode = new Node(key, value);
		MoveToHead(newNode);
		if(map.size() == capacity){
			removeTail();
		}
		map.put(key, newNode);
	}
	
	private void MoveToHead(Node node){
		Node first = head.next;
		head.next = node;
		node.prev = head;
		first.prev = node;
		node.next = first;
	}
	
	private void removeTail(){
		Node last = tail.prev;
		last.prev.next = tail;
		tail.prev = last.prev;
		last.prev = null;
		last.next = null;
		map.remove(last.key);
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
