package test.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveOuterMostParenthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new RemoveOuterMostParenthese().removeOuterParentheses("()()"));
	}
	
	public String removeOuterParentheses(String s) {
        
		StringBuilder res = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		
		int st = 0;
		
		for(int i=0;i<s.length();i++) {
        	char ch = s.charAt(i);
        	if('('==ch){
        		if(stack.isEmpty())
        			st = i;
        		
                stack.push(ch);
                
            } else if(')'==ch){
                if(stack.size() == 1) {
                	res.append(s.substring(st+1, i));
                }
                 
                stack.pop();
            }

        }
		
		return res.toString();
		
    }

}
