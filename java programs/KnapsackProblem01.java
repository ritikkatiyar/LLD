import java.util.Arrays;

public class KnapsackProblem01 {
    static int[][] dp;
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        dp=new int[val.length+1][W+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return knapsack(W,val,wt,0);
    }
    private static int knapsack(int W,int val[] ,int wt[],int index){
        if(index>=wt.length){
            return 0;
        }
        if(dp[index][W]!=-1){
            return dp[index][W];
        }
        //take
        int take=0;
        if(wt[index]<=W){
            take=knapsack(W-wt[index],val,wt,index+1)+val[index];
        }
        //not take
        int nottake=knapsack(W,val,wt,index+1);

        return dp[index][W]=Math.max(take,nottake);
    }
}
