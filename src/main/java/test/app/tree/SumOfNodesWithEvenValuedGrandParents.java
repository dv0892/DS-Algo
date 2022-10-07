package test.app.tree;

public class SumOfNodesWithEvenValuedGrandParents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root,null,null);
    }
    
   
    public int sumEvenGrandparent(TreeNode curr , TreeNode p , TreeNode gp  ) {
        if( curr == null )
            return 0;
        
        int sum = 0;
        if( gp!=null && (gp.val%2==0) )
            sum += curr.val;
        
        sum += sumEvenGrandparent(curr.left,curr,p);
        sum += sumEvenGrandparent(curr.right,curr,p);
        
        return sum;
    }

}
