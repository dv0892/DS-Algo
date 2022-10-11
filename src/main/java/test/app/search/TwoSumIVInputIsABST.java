package test.app.search;

import java.util.HashSet;
import java.util.Set;

import test.app.tree.TreeNode;

public class TwoSumIVInputIsABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Set<Integer> set = new HashSet<>();
	
    public boolean findTarget(TreeNode root, int k) {
        if( root == null )
            return false;
        
        if( set.contains(k-root.val) )
            return true;
        
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
    
    public boolean findTargetTwoPointer(TreeNode root, int k) {
        if( root == null )
            return false;
        
        if( set.contains(k-root.val) )
            return true;
        
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }

}
