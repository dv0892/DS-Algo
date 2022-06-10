package test.app.tree;

public class TreeUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TreeUtils utils = new TreeUtils();
		
		TreeNode leafNode1 = new TreeNode(2);
		TreeNode leafNode2 = new TreeNode(9);
		
		TreeNode node1 = new TreeNode(5,leafNode1,leafNode2);
		
		
		
		
		TreeNode node1 = new TreeNode(5,leafNode1,leafNode2);
		TreeNode leafNode3 = new TreeNode(17);
		TreeNode leafNode4 = new TreeNode(19);
		
	}
	
	public void inorderTraversal( TreeNode node ) {
		if( node == null )
			return ;
		
		inorderTraversal(node.left);
		System.out.println( " " + node.val );
		inorderTraversal(node.right);
	}
	
	
	public void preorderTraversal( TreeNode node ) {
		if( node == null )
			return ;
		
		System.out.println( " " + node.val );
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	
	public void postorderTraversal( TreeNode node ) {
		if( node == null )
			return ;
		
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println( " " + node.val );
	}
	
	public TreeNode search( TreeNode node , int x ) {
		
		if( node == null )
			return node;
		
		if( node.val == x)
			return node;
		else if ( x < node.val )
			return search(node.left, x);
		else
			return search(node.right, x);
	}
	
	public TreeNode min( TreeNode node  ) {
		
		TreeNode min = node;
		
		while ( node != null ) {
			min = node;
			node = node.left;
		}
		
		return min;
	}
	
	
	public TreeNode max( TreeNode node  ) {
		
		TreeNode max = node;
		
		while ( node != null ) {
			max = node;
			node = node.right;
		}
		
		return max;
	}
	
	
	public TreeNode successor ( TreeNode node , int x ) {
		
		TreeNode val =  search(node, x);
		
		if( val.right != null )
			return min(val.right);
		
		TreeNode parent =  val.parent;
		
		while ( parent != null && parent.right == val ) {
			val = parent;
			parent = parent.parent;
		}
		
		return parent;
	}
	
	
	public TreeNode predeccessor ( TreeNode node , int x ) {
		
		TreeNode val =  search(node, x);
		
		if( val.left != null )
			return max(val.left);
		
		TreeNode parent =  val.parent;
		
		while ( parent != null && parent.left == val ) {
			val = parent;
			parent = parent.parent;
		}
		
		return parent;
	}
	
	
	public void insert ( TreeNode root , int x ) {
		
		TreeNode newNode = new TreeNode(x);

		TreeNode parent = null;
		while ( root != null ) {
			parent = root;
			if( newNode.val > root.val )
				root = root.right;
			else
				root = root.left;
		
		}
		
		newNode.parent = parent;
		
		if( parent == null) {
			// new Node  becomes root of tree;
			// return
		}
		
		if( newNode.val > parent.val )
			parent.right = newNode;
		else
			parent.left = newNode;
		
	}
	
	
	
	

}
