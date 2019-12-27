public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    public int length;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= length)
            return -1;
        ListNode temp = head;
        while (index !=0){
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        if(head == null){
            head = temp;
            tail = temp;
        }else {
            temp.next = head;
            head = temp;
        }
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = new ListNode(val);
        if(tail == null){
            tail = temp;
            head = temp;
        }else {
            tail.next = temp;
            tail = temp;
        }
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index >= 0 && index <= length){
            if(index == 0){
                addAtHead(val);
                return;
            } else if(index == length){
                addAtTail(val);
                return;
            }
            ListNode nodeToBeAdded = new ListNode(val);
            ListNode temp = head;
            while (index !=1){
                temp = temp.next;
                index--;
            }
            nodeToBeAdded.next = temp.next;
            temp.next = nodeToBeAdded;
            length++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(length == 0)
            return;
        boolean isTail = index == length - 1;
        if(index >= 0 && index <= length-1){
            if(index == 0){
                head = head.next;
                if(isTail)
                    tail = null;
                length--;
                return;
            }
            ListNode temp = head;
            while (index !=1){
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
            if(isTail)
                tail = temp;
            length--;
        }
    }

    public void print() {
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}