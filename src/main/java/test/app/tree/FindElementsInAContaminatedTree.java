package test.app.tree;

public class FindElementsInAContaminatedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class FindElements {

    TreeNode root;
    public FindElements(TreeNode root) {
        recover(root,0);
        this.root = root;
    }
    
    private void recover( TreeNode curr , int newVal ){
        if( curr == null )
            return ;
        
        curr.val = newVal;
        recover( curr.left  , newVal*2+1 );
        recover( curr.right , newVal*2+2 );
    }
    
    public boolean find(int target) {
        return find(root,target);
    }
    
    private boolean find( TreeNode curr , int target) {
        
        if( curr == null )
            return false;
        
        if( curr.val == target)
            return true;
        
        return find(curr.left,target) || find(curr.right,target);
    }
}