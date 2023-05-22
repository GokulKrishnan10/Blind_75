/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
 
Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Approch:
    Pointers, LinkedList
Timecomplexity:O(n)
Spacecomplexity:O(1)
 */
class Solution {
    public ListNode reverse(ListNode head){
        ListNode c=head,next=null,prev=null;
        while(c!=null){
            next=c.next;
            c.next=prev;
            prev=c;
            c=next;
        }
        return prev;
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
}