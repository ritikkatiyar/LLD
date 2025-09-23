public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(0,nums.length-1,null,nums);
    }
    private TreeNode construct(int start,int end,TreeNode root,int[] nums){
        if(start>end) return null;
        int mid=start+(end-start)/2;
        if(root==null){
            root=new TreeNode(nums[mid]);
        }
        root.left=construct(start,mid-1,root.left,nums);
        root.right=construct(mid+1,end,root.right,nums);
        return root;
    }
    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public static void main(String[] args){
        ConvertSortedArrayToBST toBST=new ConvertSortedArrayToBST();
        int[] nums={-10,-3,0,5,9};
        System.out.println(toBST.sortedArrayToBST(nums));
    }
}
