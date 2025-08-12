import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),s,0);
        return result;
    }

    private void recursion(List<List<String>> result, List<String> current, String s, int index) {
        if(index==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<s.length();++i){

            if(isPalin(s,index,i)){
                current.add(s.substring(index,i+1));
                recursion(result,current,s,index+1);
                current.remove(current.size()-1);
            }

        }
    }

    private boolean isPalin(String str,int start,int end){

        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args){
        String s="aab";
        PalindromePartitioning pp=new PalindromePartitioning();
        System.out.println(pp.partition(s));
    }
}
