import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class OrderPair {
    TreeNode node;
    int vertical;
    int level;

    OrderPair(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<OrderPair> q = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        OrderPair pair = new OrderPair(root, 0, 0);
        q.add(pair);
        while (!q.isEmpty()) {
            pair = q.remove();
            int vertical = pair.vertical;
            TreeNode temp = pair.node;
            int level = pair.level;
            map.computeIfAbsent(vertical, k -> new TreeMap<>())
                    .computeIfAbsent(level, k -> new ArrayList<>())
                    .add(temp.data);
            if (temp.left != null) {
                pair = new OrderPair(temp.left, vertical - 1, level + 1);
                q.add(pair);
            }
            if (temp.right != null) {
                pair = new OrderPair(temp.right, vertical + 1, level + 1);
                q.add(pair);
            }
        }
        map.forEach((key, valueMap) -> {
            List<Integer> tempList = new ArrayList<>();
            valueMap.forEach((key1, valueList) -> {
                Collections.sort(valueList);
                tempList.addAll(valueList);
            });
            result.add(tempList);
        });

        return result;
    }
}