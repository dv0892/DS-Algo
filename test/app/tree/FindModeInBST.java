package test.app.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindModeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode leaf = new TreeNode(2);
		
		
		TreeNode root = new TreeNode(1,null,leaf,null);
		
		System.out.println( Arrays.toString( new FindModeInBST().findMode(root) ) );
	}
	
	
	public int[] findMode(TreeNode root) {
		int count = findMode1(root, -1);
		
		if ( count >= max.get( max.size()-1 )[0] )  {
        	if( count > max.get( max.size()-1 )[0] )
                max.clear();
        	
            int[] modeArr = {  count, prev };
            max.add(modeArr);
        }
		
        return max.stream().mapToInt(i -> i[1]).toArray();
    }
    
   int prev = Integer.MIN_VALUE ;
   List<int[]> max = new ArrayList<>();
    
    public int  findMode1(TreeNode root ,int count ) {
        
        if( root == null )
            return count ;
        
       count =  findMode1( root.left , count ) ;
           
       if( root.val != prev ){
          
            if( max.isEmpty() ) {
            	int[] modeArr = {  count, prev };
                max.add(modeArr);
            }else{
                if ( count >= max.get( max.size()-1 )[0] )  {
                	if( count > max.get( max.size()-1 )[0] )
                        max.clear();
                    int[] modeArr = {  count, prev };
                    max.add(modeArr);
                }
            }
           
           prev = root.val;
           count=1;
       } else{
           count++;
       }
        
       count = findMode1( root.right , count ) ;
       
       return count;
        
    }
    
    
    public int findMode(TreeNode root ,int val, int mode ) {
        
        if( root == null )
            return mode;
        
        if ( root.val != val ){
            int t = mode;
            
            mode = findMode( root.left , root.val , 1);
            mode = findMode( root.right , root.val , mode);
            
            if( max.isEmpty() ) {
            	int[] modeArr = {  mode, root.val };
                max.add(modeArr);
            }else{
                if ( mode >= max.get(0)[0] )  {
                
                	if( mode > max.get(0)[0] )
                        max.clear();
                	int[] modeArr = {  mode, root.val };
                    max.add(modeArr);
                }
            }
            
            return t;
        } else {
            mode = findMode( root.left  , val  , ++mode);
            mode = findMode( root.right , val ,    mode);
            
            return mode;
        }
        
    }

}
