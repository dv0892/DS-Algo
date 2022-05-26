package test.app.queue;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfRecentCalls {
	
	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();
		System.out.println(recentCounter.ping(1));
		System.out.println(recentCounter.ping(2));
		System.out.println(recentCounter.ping(4000));
		System.out.println(recentCounter.ping(18000));
	}

}


class RecentCounter {
	
	Deque<Integer> queue ;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
    	
    	queue.add(t);
        
    	while( ( t - queue.peek().intValue() ) > 3000) {
    		queue.remove();
    	}
    	
    	return queue.size();
    }
}