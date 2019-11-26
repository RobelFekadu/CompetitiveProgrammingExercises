import java.util.*;

public class AddTwoNumbers{

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);

        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l7;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode x = addTwoNumbers(l1, l4);

        while (x.next != null){
            System.out.print(x.val);
            x = x.next;
        }
        System.out.println(x.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ArrayList<Integer> sums = new ArrayList<>();
        int count = 0;
        int sum;
        int carry = 0;
        Boolean nextIsNotNull = false;
        while (l1.next != null && l2.next != null){
            sum = l1.val + l2.val + carry;
            carry = 0;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }

            sums.add(sum);

            l1 = l1.next;
            l2 = l2.next;
        }

        sum = l1.val + l2.val+ carry;
        carry = 0;
        if(sum >= 10){
            carry = 1;
            sum = sum % 10;
        }
        sums.add(sum);
        if(l1.next != null){
            nextIsNotNull = true;
        }
        else if(l2.next != null){
            nextIsNotNull = true;
            l1 = l2;
        }
        if(nextIsNotNull){
            l1 = l1.next;
            while (l1.next != null){
                sum = l1.val + carry;
                carry = 0;
                if(sum >= 10){
                    carry = 1;
                    sum = sum % 10;
                }
                sums.add(sum);
                l1 = l1.next;
            }
            sum = l1.val + carry;
            carry = 0;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }
            sums.add(sum);
        }

        if(carry == 1)
            sums.add(1);
        for (int i = sums.size() - 1; i >= 0; i--){
            if(count == 0){
                listNode = new ListNode(sums.get(i));
                count++;
            }
            else {
                ListNode temp = new ListNode(sums.get(i));
                temp.next = listNode;
                listNode = temp;
            }
        }
        return listNode;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}