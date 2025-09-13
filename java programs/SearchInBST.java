import java.util.LinkedList;
import java.util.Queue;

class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode result = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.val == val) {
                result = temp;
                break;
            }
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }

        }
        return result;

    }
    public static void main(String[] args) {
        // Build tree from input [4,2,7,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;

        SearchInBST sol = new SearchInBST();
        TreeNode result = sol.searchBST(root, val);

        // Print result subtree
        if (result != null) {
            printTree(result);
        } else {
            System.out.println("null");
        }
    }

    // Helper to print subtree (preorder)
    private static void printTree(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}


