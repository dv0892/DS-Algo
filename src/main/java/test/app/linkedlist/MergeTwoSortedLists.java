package test.app.linkedlist;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		if( list1 == null )
            return list2;
        
        if( list2 == null )
            return list1;
        
        ListNode res ;
        
        if ( list1.val <= list2.val ) {
            res = new ListNode( list1.val );
            res.next = mergeTwoLists(list1.next , list2 );
        } else {
            res = new ListNode( list2.val );
            res.next = mergeTwoLists(list1 , list2.next );
        }
        
        return res;
    }

}
