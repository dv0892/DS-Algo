package test.app.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        pathSum( root , targetSum , 0 , new ArrayList<>() , ans );
        
        return ans;
    }
    
    	public void pathSum(TreeNode root, int targetSum, int runningSum , List<Integer> list ,
            List<List<Integer>> ans  ) {

			if( root == null )
				return ;
	
			list.add( root.val );
			
			if( (runningSum + root.val) == targetSum && root.left == null && root.right == null ){
				ans.add ( new ArrayList<>(list) );
            } else {			 
     			pathSum ( root.left  , targetSum ,runningSum + root.val , list , ans);
	     		pathSum ( root.right , targetSum ,runningSum + root.val , list , ans);
            }
			
            list.remove(list.size()-1);
	}

}
