package SortClass;

public class TreeSort {
    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    private static void inorderTraversal(Node root, int[] arr, int[] index) {
        if (root != null) {
            inorderTraversal(root.left, arr, index);
            arr[index[0]] = root.data;
            index[0]++;
            inorderTraversal(root.right, arr, index);
        }
    }

    public static void treeSort(int[] arr) {
        Node root = null;
        for (int i : arr) {
            root = insert(root, i);
        }
        int[] index = {0};
        inorderTraversal(root, arr, index);
    }
}
