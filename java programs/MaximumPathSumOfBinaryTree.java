public class MaximumPathSumOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Global variable to track max path sum
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // start with smallest possible value
        recursion(root);
        return maxSum;
    }

    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Only add positive contributions from subtrees
        int leftSum = recursion(root.left);
        int rightSum = recursion(root.right);

        // Update global max sum
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);

        // Return max path starting from this node going downward
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        MaximumPathSumOfBinaryTree pathSum = new MaximumPathSumOfBinaryTree();

        // Single node [-3]
        TreeNode root = new TreeNode(-3);

        System.out.println("Max Path Sum: " + pathSum.maxPathSum(root));
        // Output: -3
    }
}
