public class LongestIncreasiingSubsequence {
    public int lengthOfLIS(int[] nums) {
        return recursion(0,-1,nums);
    }
    private int recursion(int index,int prevIndex,int[] nums){
        if(index>=nums.length){
            return 0;
        }
        int take=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            take=recursion(index+1,index,nums)+1;
        }
        int nottake=recursion(index+1,prevIndex,nums);

        return Math.max(take,nottake);
    }
    public static void main(String[] args){
        LongestIncreasiingSubsequence subsequence=new LongestIncreasiingSubsequence();
        int[] arr={10,9,2,5,3,7,101,18};
        System.out.println(subsequence.lengthOfLIS(arr));
    }
}
