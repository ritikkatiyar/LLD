import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict=new HashSet<>(wordDict);
        //int[] dp=new int[301];
        //Arrays.fill(dp,-1);
        return solve(0,dict,s,s.length()/*,dp*/);
    }
    private boolean solve(int index,Set<String> dict,String s,int n/*,int[] dp*/){
        if(index==n){
            return true;
        }
        /*if(dp[index]!=-1){
            return dp[index]==1;
        }*/

        for(int i=index+1;i<=n;i++){
            String temp=s.substring(index,i);
            System.out.print(temp+index+" ");
            if(dict.contains(temp) && solve(i,dict,s,n/*,dp*/)){
                //dp[index]=1;
                return true;
            }
        }
        //dp[index]=0;
        return false;
    }
    public static void main(String[] args) {
        WordBreak aBreak = new WordBreak();
        String s = "aaaab";
        List<String> wordDict=Arrays.asList("a","aa","aaa");
        System.out.println(aBreak.wordBreak(s, wordDict));
    }
}
