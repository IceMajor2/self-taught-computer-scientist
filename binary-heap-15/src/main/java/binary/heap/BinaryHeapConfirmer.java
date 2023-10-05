package binary.heap;

import bin_tree.BinaryTree;

public class BinaryHeapConfirmer {

    public static boolean isMinHeap(BinaryTree binaryTree) {
        int i = 0;
        return isMinHeap(binaryTree.root, i, size(binaryTree.root));
    }

    private static boolean isMinHeap(BinaryTree.TreeNode root, int i, int n) {
        if (root == null) return true;
        if (i >= n) return false;
        if ((root.left != null && root.left.value <= root.value)
                || root.right != null && root.right.value <= root.value)
            return false;

        return isMinHeap(root.left, 2 * i + 1, n) &&
                isMinHeap(root.right, 2 * i + 2, n);
    }

    private static int size(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
}
