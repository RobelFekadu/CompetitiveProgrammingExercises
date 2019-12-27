class ListNode:
    def __init__(self, x):
        self.val = x
        self.next:ListNode = None

class SwapPairs:
    def swapPairs(self, head: ListNode) -> ListNode:
        if(head == None or head.next == None):
            return head
        next = head.next
        head.next = next.next
        next.next = head
        head = next
        
        next = head.next
        
        while(next.next != None):
            if(next.next.next == None):
                return head
            temp = next.next.next
            temp2 = next.next
            temp2.next = temp.next
            temp.next = temp2
            next.next = temp
            next = next.next.next
            
        return head
            
def main():
    x = ListNode(1)
    y = ListNode(7)
    z = ListNode(5)
    a = ListNode(1)
    
    b = ListNode(9)
    c = ListNode(2)
    d = ListNode(5)
    e = ListNode(1)
    
    x.next = y
    y.next = z
    z.next = a
    #a.next = b
    #b.next = c
    #c.next = d
    #d.next = e
    
    sp = SwapPairs();
    lsn = sp.swapPairs(x);
    
    while(lsn != None):
        print(lsn.val, " ")
        lsn = lsn.next
    
if __name__ == '__main__':
    main()
            