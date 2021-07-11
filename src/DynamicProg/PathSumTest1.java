package DynamicProg;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class PathSumTest1 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-2);
        TreeNode node6 = new TreeNode(-1);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node3.left = node6;
        node3.right = node4;

        PathSumTest1 obj = new PathSumTest1();
        int size = obj.pathSum(node, -1);
        System.out.println(size);
    }

    public int pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        solution(root, targetSum, result);
        for(List<Integer> list : result) {
            System.out.println(list.toString());
        }
        return result.size();
    }

    public void solution(TreeNode root, int target, List<List<Integer>> result) {
        if (root == null) return ;
        List<Integer> path = new ArrayList<>();
        dfs(root, target, result, path);
        //1. 双递归，注意递归的位置，一开始将solution递归的位置放到了dfs中，造成了递归的顺序不对
        solution(root.left, target, result);
        solution(root.right, target, result);
    }
    public void dfs(TreeNode node, int target, List<List<Integer>> result, List<Integer> path) {
        if (node == null) return;
        if (node.val == target) {
            path.add(node.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() -1);
            //2. return; 注意根据实际情况是否返回，当找到路径还需要继续往下找时，是不能返回的，这个题目就是
        }
        path.add(node.val);
        dfs(node.left, target - node.val,result, path);
        dfs(node.right, target - node.val, result, path);
        path.remove(path.size() -1);
    }
}
