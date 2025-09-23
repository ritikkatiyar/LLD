import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            lst.add(new ArrayList<>());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int value = entry.getValue();
            List<Integer> tempLst = lst.get(value);
            tempLst.add(num);
        }
        int[] result = new int[k];

        for (int i = lst.size() - 1; i >= 0; i--) {
            if (!lst.get(i).isEmpty()) {
                for (int num : lst.get(i)) {
                    if (index < k) {
                        result[index] = num;
                        index++;
                    }
                }
            }
        }
        return result;
    }
}
