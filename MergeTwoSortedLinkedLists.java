class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2);
        ListNode z = new ListNode(4);

        ListNode w = new ListNode(1);
        ListNode v = new ListNode(3);
        ListNode a = new ListNode(4);

        x.next = y;
        y.next = z;
        
        w.next = v;
        v.next = a;
        
        ListNode head = mergeTwoLists(x, w);

        int count = 0;
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
            count++;
            if(count >= 10)
                break;
        }
        System.out.println("null");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2:l1;
        }
        ListNode headOfFirstList = null;
        ListNode mergedListNode = null;

        while(l1 != null && l2 != null){
            if(l2.val <= l1.val){
                if(mergedListNode == null){
                    mergedListNode = l2;
                    headOfFirstList = mergedListNode;
                }
                else{
                    mergedListNode.next = l2;
                    mergedListNode = mergedListNode.next;
                }
                l2 = l2.next;
            }
            else{
                if(mergedListNode == null){
                    mergedListNode = l1;
                    headOfFirstList = mergedListNode;
                }
                else{
                    mergedListNode.next = l1;
                    mergedListNode = mergedListNode.next;
                }
                
                l1 = l1.next;
            }
        }

        l1 = l1 == null ? l2:l1;

        while(l1 != null){
            mergedListNode.next = l1;
            mergedListNode = mergedListNode.next;
            l1 = l1.next;
        }

        return headOfFirstList;
    }
}