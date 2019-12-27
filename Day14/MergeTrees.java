class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MergeTrees {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null){
            return t1 == null ? t2:t1; 
        }

        TreeNode mergedTree = new TreeNode(t1.val + t2.val);
        mergedTree.left = addLeftNode(t1, t2);
        mergedTree.right = addRightNode(t1, t2);

        return mergedTree;
    }

    public static TreeNode addLeftNode(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return t1;
        else if(t1 == null && t2 != null)
            return t2.left;
        else if(t1 != null && t2 == null)
            return t1.left;
        
        TreeNode headTreeNode;
        if(t1.left == null && t2.left == null){
            return null; 
        }
        else if(t1.left != null && t2.left != null)
            headTreeNode = new TreeNode(t1.left.val + t2.left.val);
        else if(t1.left == null)
            headTreeNode = new TreeNode(t2.left.val);
        else
            headTreeNode = new TreeNode(t1.left.val);

        headTreeNode.left = addLeftNode(t1.left, t2.left);
        headTreeNode.right = addRightNode(t1.left, t2.left);

        return headTreeNode;
    }

    public static TreeNode addRightNode(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return t1;
        else if(t1 == null && t2 != null)
            return t2.right;
        else if(t1 != null && t2 == null)
            return t1.right;

        TreeNode headTreeNode;
        if(t1.right == null && t2.right == null){
            return null; 
        }
        else if(t1.right != null && t2.right != null)
            headTreeNode = new TreeNode(t1.right.val + t2.right.val);
        else if(t1.right == null)
            headTreeNode = new TreeNode(t2.right.val);
        else
            headTreeNode = new TreeNode(t1.right.val);

        headTreeNode.left = addLeftNode(t1.right, t2.right);
        headTreeNode.right = addRightNode(t1.right, t2.right);

        return headTreeNode;
    }

}