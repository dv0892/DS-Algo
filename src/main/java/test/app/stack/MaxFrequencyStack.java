package test.app.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class MaxFrequencyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FreqStack obj = new FreqStack();
		obj.push(5);
		obj.push(7);
		obj.push(5);
		obj.push(7);
		obj.push(4);
		obj.push(5);
		
		System.out.println( obj.pop()  );
		System.out.println( obj.pop()  );
		System.out.println( obj.pop()  );
		System.out.println( obj.pop()  );
		System.out.println( obj.pop()  );
	}

}

class FreqStack {
    
	Map<Integer,Integer> freq ;
	Map<Integer,Deque<Integer>> group ;
	int maxFreq = 0;
    public FreqStack() {
    	freq = new HashMap<>();
    	group = new HashMap<>();
    }
    
    public void push(int val) {
    	int newFreq = freq.getOrDefault(val,0) + 1;
    	freq.put(val, newFreq);
    	if( newFreq > maxFreq )
    		maxFreq = newFreq;
    	
    	group.computeIfAbsent(newFreq, x -> new LinkedList<>()).push(val);
    }
    
    public int pop() {
    	int el = group.get(maxFreq).pop() ;
    	int f = freq.get(el);
    	freq.put(el, --f);
    	if( group.get(maxFreq).size() == 0 )
    		maxFreq--;
    	
    	return el;
    	
    }


   
}
