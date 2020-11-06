class Solution {
    public int maxDepth(String s) {
        int at_depth=0,max_depth=0;
        for(char el : s.toCharArray()){
            if(el == '('){
                at_depth++;
                if(max_depth < at_depth) max_depth = at_depth;
            } else  if(el == ')'){
                at_depth--;
            }
        }
        
        return max_depth;
    }
}
