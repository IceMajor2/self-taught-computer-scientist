package bin_tree;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree(int rootValue) {
        this.root = new TreeNode(rootValue);
    }

    public void invert() {
        this.invert(root);
    }

    private void invert(TreeNode node) {
        if (node == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        this.invert(node.left);
        this.invert(node.right);
    }

    public boolean identicalTrees(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null)
            return true;
        if (rootA != null && rootB != null)
            return (rootA.value == rootB.value
                    && identicalTrees(rootA.left, rootB.left)
                    && identicalTrees(rootA.right, rootB.right));
        return false;
    }

    public static class TreeNode {

        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}