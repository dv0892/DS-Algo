package test.app.tree;


  //Definition for a binary tree node.
   public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode parent;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.parent = parent;
      }
      
      TreeNode(int val, TreeNode left, TreeNode right ) {
          this(val,left,right,null);
      }
      
      public String toString() {
    	  return " "+val;
      }
  }
 
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if( root ==  null ) return 0;
        
        if( root.val < low ) 
            return rangeSumBST(root.right,low,high);
        else if ( root.val > high )
            return rangeSumBST(root.left,low,high);
        else 
            return root.val + rangeSumBST(root.right,low,high)
                        + rangeSumBST(root.left,low,high);
    }
}
