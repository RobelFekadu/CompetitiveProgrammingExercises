class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class LowestCommonAncestor:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if(root == None or p == None or q == None or (root.left == None and root.right == None)):
            return None
        min = 0;
        max = 0;
        if(p.val < q.val):
            min = p.val
            max = q.val
        else:
            min = q.val
            max = p.val
        
        if(min <= root.val <= max):
            return root
        if root.val < min:
            return self.lowestCommonAncestor(root.right, p, q)
        elif root.val > max:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return None
            
            