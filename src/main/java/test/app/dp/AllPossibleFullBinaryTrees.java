package test.app.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.app.tree.TreeNode;

public class AllPossibleFullBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		TreeNode[] dp = new TreeNode[n+1];
		System.out.println( new AllPossibleFullBinaryTrees().allPossibleFBT( new HashMap<>(),7));
	}
	
	// A Full Binary Tree has always odd number of nodes.
	
	
	public List<TreeNode> allPossibleFBT(Map<Integer,List<TreeNode>> dp, int n) {
        if( n%2 == 0)
            return new ArrayList<>();
       
        if( n == 1 ) {
        	List<TreeNode> listOfTrees = new ArrayList<>();
        	listOfTrees.add(new TreeNode() );
        	return listOfTrees;
        }
        
        if( dp.containsKey(n) )
        	return dp.get(n);
        
       List<TreeNode> listOfTrees = new ArrayList<>();

       int c=1;
       while( c < n) {
           List<TreeNode> left = allPossibleFBT(dp,c);
           List<TreeNode> right = allPossibleFBT(dp,n-c-1);
           
           for(TreeNode l : left ) {
        	   for(TreeNode r : right ) {
        		   TreeNode newRoot = new TreeNode();
        		   newRoot.left = l;
        		   newRoot.right = r;
        		   
        		   listOfTrees.add(newRoot);
        	   }
           }
           
           c+=2;
       }
       
       dp.put(n, listOfTrees);
       
       return listOfTrees;
    }

	private void addTwoNodesToAllItsLeaf(TreeNode node,  List<TreeNode> listOfTrees, TreeNode root) {
		if( node.left == null && node.right == null ) {
			node.left  = new TreeNode() ; 
			node.right = new TreeNode() ;
			//add this tree to list of trees;
			
			listOfTrees.add(clone(root));
			
			node.left  = null ; 
			node.right = null;
			return ;
		}
		
		if( node.left != null )
			addTwoNodesToAllItsLeaf ( node.left ,listOfTrees , root);
		
		if( node.right != null )
			addTwoNodesToAllItsLeaf ( node.right ,listOfTrees , root);
		
	}
	
	TreeNode clone(TreeNode node){
        if(node==null)return null;
        TreeNode newnode=new TreeNode();
        newnode.left=clone(node.left);
        newnode.right=clone(node.right);
        return newnode;
    }

}
