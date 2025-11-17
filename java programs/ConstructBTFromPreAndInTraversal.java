import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreAndInTraversal {
    public class TreeNode {
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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return buildTree(preorder,inMap,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder,Map<Integer,Integer> inMap,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preIndex++]);
        int inIndex=inMap.get(root.val);

        root.left=buildTree(preorder,inMap,start,inIndex-1);
        root.right=buildTree(preorder,inMap,inIndex+1,end);
        return root;
    }
    public static void main(String[] args){
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        ConstructBTFromPreAndInTraversal bt=new ConstructBTFromPreAndInTraversal();
        bt.buildTree(preorder,inorder);
    }
}
