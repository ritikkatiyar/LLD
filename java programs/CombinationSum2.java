import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recursion(List<List<Integer>> result, int[] candidates, int target, int start, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;

            temp.add(candidates[i]);
            recursion(result, candidates, target - candidates[i], i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
