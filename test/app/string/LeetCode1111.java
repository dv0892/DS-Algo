class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int depth_A = 0, depth_B = 0;
        
        int i=0;
        for(char ch : seq.toCharArray()) {
            if(ch == '(') {	
            	
            	if(depth_A <= depth_B) {
            		res[i] = 0; depth_A++;
            	} else {
            		res[i] = 1; depth_B++;
            	}
            	
            } else if(ch == ')') {
            	
            	if(depth_A >= depth_B) {
            		res[i] = 0; depth_A--;
            	} else {
            		res[i] = 1; depth_B--;
            	}
            }
            
            i++;
       }
        
      return res;
    }
}
