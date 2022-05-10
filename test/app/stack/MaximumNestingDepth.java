package test.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumNestingDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new MaximumNestingDepth().maxDepth("(1+(2*3)+((8)/4))+1"));
	}
	
	public int maxDepth(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        int max=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if('('==ch){
                stack.push(ch);
                max = Math.max(max,stack.size());
            } else if(')'==ch){
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        
        return max;
        
    }

}
