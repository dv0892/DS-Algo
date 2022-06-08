package test.app.linkedlist;

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void deleteNode(ListNode node) {
		ListNode next =  node.next;
        node.val      =  next.val;
        node.next     =  next.next;
    }

}
