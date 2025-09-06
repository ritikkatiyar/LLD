import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;


        Map<Integer, List<Integer>> map = new LinkedHashMap<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i + j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        int[] result = new int[m * n];
        int index = 0;
        System.out.print(map);

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (entry.getKey() % 2 == 0) {

                for (int i = list.size() - 1; i >= 0; i--) {
                    result[index++] = list.get(i);
                }
            } else {

                for (int i = 0; i < list.size(); i++) {
                    result[index++] = list.get(i);
                }
            }
        }

        return result;
    }
}

