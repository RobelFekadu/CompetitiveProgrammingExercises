public class ReverseList{
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode temp = new ListNode(head.val);
        ListNode temp2;
        head = head.next;
        if(head != null){
            while (head.next != null){
                temp2 = new ListNode(head.val);
                temp2.next = temp;
                temp = temp2;
                head = head.next;
            }
            temp2 = new ListNode(head.val);
            temp2.next = temp;
        }else{
            temp2 = temp;
        }

        return temp2;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}