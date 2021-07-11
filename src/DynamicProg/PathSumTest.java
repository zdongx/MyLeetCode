package DynamicProg;

import java.util.ArrayList;
import java.util.List;

public class PathSumTest {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    /**
     * 以下代码是AC的，dfs1则有点问题，原因也是对回溯的过程没有清晰的认识。在回溯过程中，对每一层先进行处理，比如添加元素进
     * 数组，最后退出时还要进行回溯操作，将元素删除
     * @param node
     * @param target
     * @param path
     * @param result
     */

    public void dfs (TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (target - node.val == 0) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() -1);
            return;
        }

        if (node.left != null) {
            dfs(node.left, target - node.val, path, result);
        }

        if (node.right != null) {
            dfs(node.right, target - node.val, path, result);
        }

        path.remove(path.size() -1);
    }

    public void dfs1 (TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (target - node.val == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if (node.left != null) {
            dfs(node.left, target - node.val, path, result);
        }

        if (node.right != null) {
            dfs(node.right, target - node.val, path, result);
        }

        path.remove(path.size() -1);
    }
}
