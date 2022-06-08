package test.app.linkedlist;


// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      
      @Override
      public String toString() {
    	  return ""+val;
      }
  }
 
public class LeetCode445 {
	public static void main(String... args) {
		
		/*ListNode fourth  = new ListNode(3,null);
		ListNode third  = new ListNode(4,fourth);
		ListNode second  = new ListNode(2,third);
		ListNode l1  = new ListNode(7,second);
		
		ListNode l2_fourth  = new ListNode(6,null);
		ListNode l2_third  = new ListNode(5,l2_fourth);
		ListNode l2_second  = new ListNode(3,l2_third);
		ListNode l2  = new ListNode(5,l2_second);*/
		
		ListNode l1  = new ListNode(0,null);

		ListNode l2_second  = new ListNode(3,null);
		ListNode l2  = new ListNode(7,l2_second);
		
		Solution sol = new Solution();
		Solution.iterate(sol.addTwoNumbers(l1, l2));;
	}

}
 
class Solution {
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	
        int l1Size = size(l1);
        int l2Size = size(l2);
        
        ListNode res;
        if( (l1Size - l2Size) < 0 ){
        	res = addListNodes(l2,l1,(l2Size-l1Size));
        } else {
        	res = addListNodes(l1,l2,(l1Size - l2Size));
        }
        
        
        
        if(res.val/10 > 0){
             ListNode f_res = new ListNode(res.val/10, res); 
             res.val = res.val % 10;
            
             return f_res;
            
        }
        
        return res;
    }
    
    public int size(ListNode node){
        int size = 0;
        while(node.next != null) {
            size++;
            node = node.next;
        }
        
        return size;
    }
    
    public ListNode addListNodes(ListNode l1, ListNode l2, int delay){
        if(l1.next == null && l2.next == null) {
            return new ListNode(l1.val + l2.val, null);
        }
        
        ListNode res, prev_res;
        int carry = 0;
        
        if(delay > 0) {
            prev_res = addListNodes(l1.next,l2,delay-1);
            
            carry = prev_res.val/10;
            prev_res.val = prev_res.val%10;
            
            res = new ListNode(carry+l1.val,prev_res);
            
        } else {
            prev_res = addListNodes(l1.next,l2.next,delay);
           
            carry = prev_res.val/10;
            prev_res.val = prev_res.val%10;
            
            res = new ListNode(carry+l1.val+l2.val,prev_res);
        }
        
        return res;
    }
    
    public static void iterate(ListNode head) {
    	ListNode curr = head;
		while(curr != null) {
			System.out.print(curr.val+ " -> ");
			curr = curr.next;
		}
	}
}
