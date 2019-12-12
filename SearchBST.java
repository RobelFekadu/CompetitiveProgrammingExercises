class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return root;
        if(root.val == val)
            return root;
        if(root.left == null && root.right == null)
            return root.left;
        
        if(root.val > val)
            return searchBST(root.left, val);
        else if(root.val < val){
            return searchBST(root.right, val);
        }
        else{
            return null;
        }
    }
}