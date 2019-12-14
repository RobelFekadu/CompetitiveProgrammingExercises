class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class InsertIntoBST:
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if(root == None):
            return TreeNode(val)
        
        node = root
        while(True):
            if(node.val < val):
                if(node.right == None):
                    node.right = TreeNode(val)
                    break
                else:
                    node = node.right
                    continue
            else:
                if(node.left == None):
                    node.left = TreeNode(val)
                    break
                else:
                    node = node.left
                    continue
        return root