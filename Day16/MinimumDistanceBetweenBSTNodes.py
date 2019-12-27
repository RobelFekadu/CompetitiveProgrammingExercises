class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left:TreeNode = None
        self.right:TreeNode = None

class MinimumDistanceBetweenBSTNodes:        
    def minDiffInBST(self, node: TreeNode):
        minDiffInLeftBST = float('inf')
        minDiffInRightBST = float('inf')
        
        if(node.left != None):
            if(node.left.right != None):
                minDiffInLeftBST = abs(node.val - self.getRightMax(node.left.right))
            else:
                minDiffInLeftBST = abs(node.val - node.left.val)
            
            tempMinDiffInLeftBST = self.minDiffInBST(node.left)
            if(tempMinDiffInLeftBST < minDiffInLeftBST):
                minDiffInLeftBST = tempMinDiffInLeftBST

        if node.right != None:
            if(node.right.left != None):
                minDiffInRightBST = abs(node.val - self.getLeftMax(node.right.left))
            else:
                minDiffInRightBST = abs(node.val - node.right.val)
                
            tempMinDiffInRightBST = self.minDiffInBST(node.right)
            if(tempMinDiffInRightBST < minDiffInRightBST):
                minDiffInRightBST = tempMinDiffInRightBST

        if(minDiffInLeftBST < minDiffInRightBST):
            return minDiffInLeftBST
        return minDiffInRightBST
    
    def getRightMax(self, node: TreeNode):
        while node.right != None:
            node = node.right
        
        return node.val
        
    def getLeftMax(self, node: TreeNode):
        while node.left != None:
            node = node.left
        
        return node.val