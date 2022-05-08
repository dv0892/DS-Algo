package test.app.stack;

import java.util.Stack;

public class CrawlerLogFolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ops = {"d1/","d2/","./","d3/","../","d31/"};
		System.out.println( new CrawlerLogFolder().minOperations(ops) );
	}
	
	public int minOperations(String[] logs) {
        
        Stack<String> stack = new Stack<>();
        
        for(String op : logs ){
            if("../".equals(op)){
                if(!stack.isEmpty())
                    stack.pop();
            } else if("./".equals(op)){
                
            } else {
                String dir = op.substring(0,op.length()-1);
                stack.push(dir);
            }
        }
        
        return stack.size();
    }

}
