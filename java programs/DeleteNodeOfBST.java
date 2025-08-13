
public class DeleteNodeOfBST {
    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.data > key) {
                if (root.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode lastRight = lastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    private TreeNode lastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return lastRight(root.right);
    }
}
