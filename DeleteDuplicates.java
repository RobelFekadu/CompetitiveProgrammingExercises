class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(1);
        ListNode z = new ListNode(2);
        ListNode w = new ListNode(3);
        ListNode v = new ListNode(3);
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(3);

        x.next = y;
        y.next = z;
        z.next = w;
        w.next = v;
        v.next = a;
        a.next = b;
        ListNode head = deleteDuplicates(x);

        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode temp = head;

        while(head != null){
            if(head.next != null){
                if(head.val == head.next.val){
                    head.next = head.next.next;
                }
                else{
                    head = head.next;
                }
            }
            else{
                break;
            }
        }

        return temp;
    }
}