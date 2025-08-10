import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversalOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int flag = 0;
        List<Integer> tempList;
        while (!q.isEmpty()) {
            tempList = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.remove();
                if (flag == 0) {
                    tempList.add(node.data);
                } else {
                    tempList.add(0, node.data);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            flag = flag == 0 ? 1 : 0;
            result.add(tempList);

        }
        return result;
    }
}
