package test.app.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	public static void main(String[] args) {
		MedianFinder1 obj = new MedianFinder1();
		obj.addNum(12);
		System.out.println( obj.findMedian() );
		
		obj.addNum(10);
		System.out.println( obj.findMedian() );
		
		obj.addNum(13);
		System.out.println( obj.findMedian() );
		
		obj.addNum(11);
		System.out.println( obj.findMedian() );
		
		obj.addNum(5);
		System.out.println( obj.findMedian() );
	}

}

class MedianFinder1 {

	PriorityQueue<Integer> maxpq ;
	PriorityQueue<Integer> minpq ;
    public MedianFinder1() {
    	maxpq = new PriorityQueue<>((i1,i2) -> Integer.compare(i2, i1) );
    	minpq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
    	if( maxpq.isEmpty() ) {
    		maxpq.add(num);
    		return ;
    	}
    		
    	if( num <= maxpq.peek()  ) {
    		if( maxpq.size() > minpq.size() ) {
    			minpq.add(maxpq.remove());
    		}
    		
    		maxpq.add(num);
    	} else {
    	
    		if( (minpq.size()>maxpq.size()) ) {
    			if ( num>=minpq.peek() ) {
    			    maxpq.add(minpq.remove());
    		     	minpq.add(num);
    		    } else
    				maxpq.add(num);
    		} else 
    			minpq.add(num);
    		
    	}
    }
    
    public double findMedian() {
    	return minpq.size() == maxpq.size() ? (minpq.peek()+maxpq.peek())/2d: ( minpq.size() > maxpq.size() ? minpq.peek() : maxpq.peek()) ;
    	
    }
}


class MedianFinder {

	List<Integer> list ;
    public MedianFinder() {
    	list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
    	return list.size()%2 == 1 ? list.get( list.size()/2 ) : ( list.get(list.size()/2) + list.get( (list.size()/2) - 1) ) / 2 ;
    	
    }
}
