from typing import List
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTFromPreorder:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if(len(preorder) == 0):
            return None
        node = TreeNode(preorder[0])
        
        if(len(preorder) == 1):
            return node
        
        index = 1
        while(index < len(preorder) and node.val > preorder[index]):
            index += 1
            
        node.left = self.bstFromPreorder(preorder[1:index])
        node.right = self.bstFromPreorder(preorder[index:])
        
        return node
        