class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class MaximumBinaryTree:
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        if(len(nums) == 0):
            return None
        
        if(len(nums) == 1):
            return TreeNode(nums[0])
        
        maxIndex = 0
        
        for i in range(1,len(nums)):
            if(nums[maxIndex] < nums[i]):
                maxIndex = i
                
        node = TreeNode(nums[maxIndex])
        
        node.left = self.constructMaximumBinaryTree(nums[:maxIndex])
        node.right = self.constructMaximumBinaryTree(nums[maxIndex + 1:])
        
        return node
        