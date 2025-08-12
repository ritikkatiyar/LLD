public class WaysToExpressAnIntegerAsSumOfPowers {
    int count = 0;
    public int numberOfWays(int n, int x) {
        recursion(1, 0, n, x);
        return count;
    }

    private void recursion(int index, int currentSum, int n, int x) {
        if (currentSum == n) {
            count++;
            return;
        }

        int power = (int) Math.pow(index, x);
        if (power > n - currentSum) return; // 🚀 Stop early if it can't fit

        // Include this number
        recursion(index + 1, currentSum + power, n, x);

        // Skip this number
        recursion(index + 1, currentSum, n, x);
    }

    public static void main(String[] args) {
        WaysToExpressAnIntegerAsSumOfPowers solver = new WaysToExpressAnIntegerAsSumOfPowers();
        System.out.println(solver.numberOfWays(102, 1)); // ✅ 1
    }
}
