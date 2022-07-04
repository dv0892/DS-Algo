package test.app.stack;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( new BuildAnArrayWithStackOperations().buildArray( new int[] {4}, 4));
	}
	public List<String> buildArray(int[] target, int n) {
        
        List<String> res = new ArrayList<>();
        for(int i=0,j=1; j <= target[target.length-1] ; j++){
            res.add("Push");
            
            if(target[i] == j){
            	i = Math.min(i+1, target.length-1);
            }else{
                res.add("Pop");
            }
                
        }
        
        return res;
        
    }
}
