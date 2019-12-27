class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left:TreeNode = None
        self.right:TreeNode = None

class FindBottomLeftValue:
    def findLeftValue(self, node:TreeNode, level:int):
        level+=1
        LvalueAndLevel = [0,-1]
        RvalueAndLevel = [0,-1]
        if(node.left != None):
            LvalueAndLevel = self.findLeftValue(node.left, level)
        if node.right != None:
            RvalueAndLevel = self.findLeftValue(node.right, level)
        if(LvalueAndLevel[1] < RvalueAndLevel[1]):
            LvalueAndLevel = RvalueAndLevel
        if(LvalueAndLevel[1] < level):
            return [node.val, level]
        else:
            return LvalueAndLevel
           
    def findBottomLeftValue(self, root: TreeNode) -> int:
        return self.findLeftValue(root, 0)[0]
    