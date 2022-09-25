
public class DesignCircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyCircularQueue {

    int MAX_SIZE , i ;
	Node f , r ;

    public MyCircularQueue(int k) {
        i = 0;
        MAX_SIZE = k;
    }
    
    public boolean enQueue(int value) {
        if( isFull() )
        	return false;
        i++;
        Node n = new Node(value);
        
        if( isEmpty() ) {
        	f = r = n;
        } else {
        	r.next = n;
        	r = n;
        }
        
        n.next = f;
        
        return true;
    }
    
    public boolean deQueue() {
    	if( isEmpty() )
        	return false;
    	i--;
        if( f == r ) {
        	f = r = null;
        } else {
        	f = f.next;
        	r.next = f;
        }
        return true;
    }
    
    public int Front() {
    	return isEmpty() ? -1 : f.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : r.val;
    }
    
    public boolean isEmpty() {
        return f == null;
    }
    
    public boolean isFull() {
        return i == MAX_SIZE ;
    }
    
    static class Node {
    	int val;
    	Node next ;
    	
    	Node ( int val ){
    		this.val = val;
    	}
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */