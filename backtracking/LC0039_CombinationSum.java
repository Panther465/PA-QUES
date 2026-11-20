import java.util.ArrayList;
import java.util.List;

public class LC0039_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] candidates, int remain, int start, List<Integer> curr, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) continue;
            curr.add(candidates[i]);
            // same number can be used again so pass i not i+1
            backtrack(candidates, remain - candidates[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
        int[] candidates2 = {2, 3, 5};
        System.out.println(combinationSum(candidates2, 8));
    }
}
