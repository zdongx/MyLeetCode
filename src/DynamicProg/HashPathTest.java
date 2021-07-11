package DynamicProg;

public class HashPathTest {

    boolean found = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs1(root, targetSum);
    }

    public boolean dfs (TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && targetSum == 0){
            found = true;
            return true;}
        if (root.left == null && root.right == null) return false;
        return dfs(root.left, targetSum - root.val)
                && hasPathSum(root.right, targetSum - root.val);
    }

    public boolean dfs1 (TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            if (target - root.val == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (root.left != null) {
            if (dfs1(root.left, target - root.val)) return true;
        }

        if (root.right != null) {
            if (dfs1(root.right, target - root.val)) return true;
        }
        return false;
    }
}
