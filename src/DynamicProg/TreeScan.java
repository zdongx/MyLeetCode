package DynamicProg;

import java.util.*;

public class TreeScan {
    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;

        houxuScan(node);
    }

    //中序遍历
    public static void scanTreeZX(Node root) {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur);
                cur = cur.right;
            }
        }

        for(Node node : result) {
            System.out.printf(" " + node.val);
        }
    }

    //前序遍历
    public static void scanTreeQX(Node root) {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            result.add(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        for(Node node : result) {
            System.out.printf(" " + node.val);
        }
    }

    //后序遍历
    public static void scanTreeHX(Node root) {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null) {

        }
    }

    public static void levelOrder(Node root) {
        Deque<Node> list = new LinkedList<>();
        List<Node> result = new ArrayList<>();
        list.addLast(root);
        Node node ;
        while (!list.isEmpty()) {
            node = list.removeFirst();
            result.add(node);
            if (node.left != null) {
                list.addLast(node.left);
            }
            if (node.right != null) {
                list.addLast(node.right);
            }
        }
        for(Node node1 : result) {
            System.out.printf(" " + node1.val);
        }
    }

    public static void houxuScan(Node root) {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                System.out.println("val " + cur.val);
                cur = cur.left;
            } else {
                Node node = stack.peek();
                cur = node.right;
                if (cur == null) {
                    node = stack.pop();
                    result.add(node);
                }
            }
        }
        for(Node node1 : result) {
            System.out.printf(" " + node1.val);
        }
    }
}
