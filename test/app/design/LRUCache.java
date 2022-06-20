package test.app.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRUCache cache = new LRUCache(2);
		cache.put(1, 21);
		cache.put(2, 22);
		
		cache.get(2);
		
		cache.put(3, 33);
		cache.put(2, 22222);
		
		System.out.println( cache.get(1) );
			
	}

	Map<Integer, Node> map ;
	Node start , end;
	int size;
	
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        
    	Node node = map.get(key);
    	
    	if( node == null ) 
    		return -1;
    	
    	
    	remove(node);
    	offerLast(node);
    	
    	return node.v;
    			
    }
    
    public void remove( Node node ) {
    	if ( node.next != null ) {
    		node.next.prev = node.prev;
    	} else {
    		end = node.prev;
    	}
    	
    	if ( node.prev == null ) {
    		start = node.next;
    	} else {
    		node.prev.next = node.next;
    	}
    	
    	node.next = node.prev = null;
    } 
    
    
    public Node removeFirst() {
    		if( start == null)
    			return null;
    		
    		Node node = start;
    		remove(start);
    		return node;
    } 
    
    
    
    public void offerLast( Node node ) {
    	
    	if ( start == null && end == null ) {
    		start = end = node;
    	} else {
    		end.next = node;
    		node.prev = end;
    		
    		end = node;
    		node.next = null;
    	}
    } 
    
    public void put(int key, int value) {
        
    	Node node = map.get(key);
    	
    	if( node != null ) {
    		remove(node);
    		node.v = value;
    	} else {
    		if( map.size() == size ) {
        		Node first = removeFirst();
        		map.remove(first.k);
        	}
    		node = new Node(key, value, null, null);
    	}
    	
    	map.put(key, node);
    	offerLast(node);
    	
    }	
    
    // This can't be implem
    class Node {
    	int k , v ;
    	Node prev, next;
    	Node(int k, int v ,Node prev ,Node next ){
    		this.k = k;
    		this.v = v;
    		this.prev = prev;
    		this.next = next;
    	}
    }
	
}
