import java.util.Arrays;

public class SubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, target, 0, dp);
    }

    private boolean solve(int[] nums, int sum, int index, int[][] dp) {
        if (sum == 0) return true;
        if (index >= nums.length) return false;

        if (dp[index][sum] != -1) {
            return dp[index][sum] == 1;
        }

        boolean take = false;
        if (sum >= nums[index]) {
            take = solve(nums, sum - nums[index], index + 1, dp);
        }
        boolean notTake = solve(nums, sum, index + 1, dp);

        dp[index][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}

