package test.app.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SmallestSubTreeWithAllTheDeepestNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
	       // find the deepest leaves 
	       Deque<TreeNode> q = new LinkedList<>();
	       q.add(root);
	       List<TreeNode> deepestLeaves = new ArrayList<>();

	       while(!q.isEmpty()){
	           int sz = q.size();
	           deepestLeaves = new ArrayList<>(q);
	           while(sz-- > 0){
	               TreeNode curr = q.remove();

	               if( curr.left != null )
	                    q.add(curr.left);

	               if( curr.right != null )
	                    q.add(curr.right);
	           }
	       }

	       if( deepestLeaves.size() == 1 ) 
	           return deepestLeaves.get(0);
	       
	       TreeNode lca = deepestLeaves.get(0);
	       for(int i=1;i<deepestLeaves.size();i++){
	           lca = lowestCommonAncestor(root,lca,deepestLeaves.get(i));
	       }

	       return lca;
	    }


	    
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		        
		        if( root==null || root.val==p.val || root.val==q.val )
		            return root;

		        TreeNode anc1 = lowestCommonAncestor(root.left,p,q) ;
		        TreeNode anc2 = lowestCommonAncestor(root.right,p,q) ;

		        if( anc1==null && anc2==null )
		            return null;
		        else if( anc1==null )
		            return anc2;
		        else if( anc2==null )
		            return anc1;
		        else 
		            return root;
		    }
	

}
