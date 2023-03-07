package test.app.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	    Map<String,Integer> mapCount = new HashMap<>();

	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        List<TreeNode> res = new ArrayList<>();
	        dfs(root, res);
	        return res;
	    }


	    public String dfs(TreeNode root , List<TreeNode> res ) {
	        if( root == null ) return "()";

	        String l = dfs(root.left,res) ;
	        String r = dfs(root.right,res);
	        String unique = l + root.val+ r;

	        mapCount.put(unique, mapCount.getOrDefault(unique,0) + 1);

	        if( mapCount.get(unique) == 2 ){
	            res.add(root);
	        } 

	        return "("+unique+")";
	    }
	

}
