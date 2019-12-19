class MyCircularDeque:

    def __init__(self, k: int):
        self.size = k
        self.circularDeque = []

    def insertFront(self, value: int):
        if self.isFull():
            return False
        self.circularDeque.insert(0, value)
        return True
        
    def insertLast(self, value: int):
        if self.isFull():
            return False
        self.circularDeque.append(value)
        return True

    def deleteFront(self):
        if self.isEmpty():
            return False
        self.circularDeque.pop(0)
        return True


    def deleteLast(self):
        if self.isEmpty():
            return False
        self.circularDeque.pop()
        return True
        

    def getFront(self):
        if self.isEmpty():
            return -1
        return self.circularDeque[0]
        

    def getRear(self):
        if self.isEmpty():
            return -1
        return self.circularDeque[len(self.circularDeque) - 1]
        

    def isEmpty(self):
        return len(self.circularDeque) == 0

    def isFull(self):
        return len(self.circularDeque) == self.size
    
if __name__ == "__main__":
    circularDeque = MyCircularDeque(0)
    print(circularDeque.insertLast(1));		
    print(circularDeque.insertLast(2));		
    print(circularDeque.insertFront(3));		
    print(circularDeque.insertFront(4));		
    print(circularDeque.getRear());  			
    print(circularDeque.isFull());				
    print(circularDeque.deleteLast());			
    print(circularDeque.insertFront(4));	
    print(circularDeque.getFront());	