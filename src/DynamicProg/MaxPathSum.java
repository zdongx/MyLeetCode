package DynamicProg;

public class MaxPathSum {
    int result = Integer.MIN_VALUE; //含有负数，注意初始化不是0

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left  = node3;
        node2.right = node4;

        MaxPathSum obj = new MaxPathSum();
        int result = obj.maxPathSum(node);
        System.out.println(result);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left); // 先求子问题， 左子问题
        int right = dfs(root.right); //先求子问题，右子问题
        int curValue = root.val + (left<0 ? 0 : left) + (right < 0 ? 0 : right); //注意三元运算符对结果的影响
        if (curValue > result) {
            result = curValue; //更新最大值
        }
        //当全部子问题都处理完，并且处理完当前层的逻辑，递归处理左子树和右子树，按照同样的方式处理，

        maxPathSum(root.left);
        maxPathSum(root.right);
        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int max =  Math.max(left, right);
        return max >= 0 ? node.val + max : node.val;
    }
}
