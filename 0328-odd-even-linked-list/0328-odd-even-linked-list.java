/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode headEven = head.next;

        ListNode odd = head;
        ListNode even = head.next; 

        while(even != null && even.next != null ) {
            ListNode nextOdd = even.next;
            ListNode nextEven = nextOdd.next;
           

            odd.next = nextOdd;
            even.next = nextEven;

            odd = nextOdd;
            even = nextEven;
        }

        odd.next = headEven;

        return head;
        
    }
}