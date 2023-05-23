/*
143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */
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
    public ListNode reverse(ListNode h){
        ListNode c=h,next=null,prev=null;
        while(c!=null){
            next=c.next;
            c.next=prev;
            prev=c;
            c=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        int n=0;
        ListNode h=head;
        while(h!=null){
            h=h.next;n++;
        }
        int i=0;
        h=head;
        while(i<(n/2-1)){
            h=h.next;i++;
        }
        ListNode head2=h.next;
        h.next=null;
        head2=reverse(head2);
        i=0;
        ListNode h1=head,h2=head2;
        ListNode node=head;
        h1=h1.next;i=1;
        while(h1!=null && h2!=null){
            if(i%2==0){
                node.next=h1;
                h1=h1.next;
            }else{
                node.next=h2;
                h2=h2.next;
            }i++;
            node=node.next;
        }
        if(h1!=null)node.next=h1;
        if(h2!=null)node.next=h2;
    }
}