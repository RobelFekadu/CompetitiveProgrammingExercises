class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class InsertionSortListLinkedList {
    
    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2);
        ListNode z = new ListNode(3);
        ListNode w = new ListNode(4);
        ListNode v = new ListNode(6);
        
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(23);

        x.next = y;
        y.next = z;
        z.next = w;
        w.next = v;
        v.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        //w.next = v;
        //v.next = a;
        //a.next = b;
        ListNode head = insertionSortList(x);

        int count = 0;
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
            count++;
            if(count > 10)
                break;
        }
        System.out.println("null");
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode currentNode = head.next;
        head = new ListNode(head.val);
        ListNode nodeForIteration = head;
        ListNode temp = null;

        while(currentNode != null){
            temp = currentNode.next;
            if(currentNode.val < nodeForIteration.val){
                ListNode newHead = new ListNode(currentNode.val);
                currentNode.next = null;
                newHead.next = head;
                head = newHead;
                nodeForIteration = head;
            }
            else{
                while(nodeForIteration.next != null && !nodeForIteration.next.equals(currentNode) && currentNode.val >= nodeForIteration.next.val){
                    nodeForIteration = nodeForIteration.next;
                }
                if(nodeForIteration.next == null){
                    nodeForIteration.next = new ListNode(currentNode.val);
                }
                else if(!nodeForIteration.next.equals(currentNode)){
                    ListNode newNode = new ListNode(currentNode.val);
                    currentNode.next = null;
                    currentNode = null;
                    newNode.next = nodeForIteration.next;
                    nodeForIteration.next = newNode;
                }
            }
            nodeForIteration = head;
            currentNode = temp;
        }
        return head;
    }
}