package test.app.stack;

import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ValidParanthesis().isValid("({{{{"));
	}
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
        	char ch = s.charAt(i);
        	if(isOpening(ch)) {
        		stack.push(ch);
        	} else {
                if(stack.isEmpty())
                    return false;
                
        		Character popped = stack.pop();
        		if(!isClosingOf(ch,popped) )
        			return false;
        	}

        }
        return stack.isEmpty();
    }
	
	private boolean isOpening(char ch) {
		return ch == '(' || ch == '{' || ch == '[';
	}
	
	private boolean isClosingOf(char closing, char opening ) {
		return    closing == '}' && opening  == '{'
			  ||  closing == ']' && opening  == '['
			  ||  closing == ')' && opening  == '(';
	}

}

	
