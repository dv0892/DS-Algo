package test.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new RemoveAllAdjacentDuplicates().removeDuplicates( "azxxzy" ));
	}
	
	public String removeDuplicates(String s) {
		
		Deque<Character> stack = new ArrayDeque<>();
		
		for(int i=0;i<s.length();i++) {
			if( !stack.isEmpty() && s.charAt(i) == stack.peek()) {
				stack.pop();
				continue;
			}
			stack.push(s.charAt(i));
		}
		
		return rev(stack,new StringBuilder()).toString();
        
    }

	private StringBuilder rev(Deque<Character> stack, StringBuilder stringBuilder) {
		// TODO Auto-generated method stub
		if(stack.isEmpty())
			return stringBuilder;
		
		char ch = stack.pop();
		
		return rev(stack,stringBuilder).append(ch);
	}

}
