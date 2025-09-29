public class NextPermutation {
    public void nextPermutation(int[] nums) {
        Integer foundIndex = null;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                foundIndex = i - 1;
                break;
            }
        }
        //System.out.println(foundIndex);
        if (foundIndex != null) {
            int swapIndex = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[foundIndex]) {
                    swapIndex = i;
                    break;
                }
            }
            swap(foundIndex, swapIndex, nums);
        }
        if(foundIndex==null){
            foundIndex=-1;
        }
        reverseArray(foundIndex + 1, nums.length - 1, nums);
    }

    private void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverseArray(int start, int end, int[] nums) {
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
}
