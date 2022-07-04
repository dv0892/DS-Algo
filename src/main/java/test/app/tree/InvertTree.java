package test.app.tree;

public class InvertTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public TreeNode invertTree(TreeNode root) {
        
        invert(root);
        
        return root;
    }
    
    public void invert( TreeNode root) {
        
        if( root == null || ( root.left == null && root.right == null) )
            return ;
        
        TreeNode temp = root.left;
        root.left  = root.right;
        root.right = temp;
        
        invert(root.left);
        invert(root.right); 
    }

}
