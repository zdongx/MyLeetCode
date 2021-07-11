package DynamicProg;

public class DuichenTest {
    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public static boolean dfs(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) &&
                dfs(left.left, right.right) &&
                dfs(left.right, right.left);
    }
}
