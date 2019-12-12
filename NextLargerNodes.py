from typing import List

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next:ListNode = None

class NextLargerNodes:
    def reverseLinkedList(self, head: ListNode):
        next = head.next
        head.next = None
        finalHead = head
        
        while next != None:
            temp = next
            next = next.next
            temp.next = finalHead
            finalHead = temp
        return finalHead
            
            
        
    def nextLargerNodes(self, head: ListNode) -> List[int]:
        if head == None:
            return head
        elif head.next == None:
            return [0]
        head = self.reverseLinkedList(head)
        finalList = [0]
        max = head.val
        localMax = []
        head = head.next
        while (head != None):
            if (head.val >= max):
                max = head.val
                localMax.clear()
                finalList.append(0)
            else:
                while(len(localMax) > 0 and localMax[len(localMax) - 1] <= head.val):
                    localMax.pop()
                if(len(localMax) == 0):
                    finalList.append(max)
                else:    
                    finalList.append( localMax[len(localMax) - 1])
                localMax.append(head.val)
            head = head.next
        
        finalList.reverse()
        
        return finalList  
    
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
    a.next = b
    b.next = c
    c.next = d
    d.next = e
    
    nln = NextLargerNodes();
    print(nln.nextLargerNodes(x));
    
if __name__ == '__main__':
    main()
        