package params;

import bin_tree.BinaryTree;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class TreeParameters {

    static Stream<Arguments> treesPlusInvertedTrees() {
        var trees = binaryTrees();
        var invertedTrees = invertedBinaryTrees();

        Stream.Builder<Arguments> streamBuilder = Stream.builder();
        for (int i = 0; i < trees.size(); i++) {
            BinaryTree tree = trees.get(i);
            BinaryTree invertedTree = invertedTrees.get(i);
            streamBuilder.add(Arguments.of(tree, invertedTree));
        }

        return streamBuilder.build();
    }

    private static List<BinaryTree> binaryTrees() {
/*
           4
        /    \
       2      13
      / \    / \
     9   3  0   6
*/
        BinaryTree treeA = new BinaryTree(4);
        treeA.root.left = new BinaryTree.TreeNode(2);
        treeA.root.right = new BinaryTree.TreeNode(13);
        treeA.root.left.left = new BinaryTree.TreeNode(9);
        treeA.root.left.right = new BinaryTree.TreeNode(3);
        treeA.root.right.left = new BinaryTree.TreeNode(0);
        treeA.root.right.right = new BinaryTree.TreeNode(6);
/*
          10
        /    \
       5      9
      / \    / \
     8   2  6   3
*/
        BinaryTree treeB = new BinaryTree(10);
        treeB.root.left = new BinaryTree.TreeNode(5);
        treeB.root.right = new BinaryTree.TreeNode(9);
        treeB.root.left.left = new BinaryTree.TreeNode(8);
        treeB.root.left.right = new BinaryTree.TreeNode(2);
        treeB.root.right.left = new BinaryTree.TreeNode(6);
        treeB.root.right.right = new BinaryTree.TreeNode(3);
        return List.of(treeA, treeB);
    }

    private static List<BinaryTree> invertedBinaryTrees() {
/*
           4
        /    \
       13      2
      / \    / \
     6   0  3   9
*/
        BinaryTree treeA = new BinaryTree(4);
        treeA.root.left = new BinaryTree.TreeNode(13);
        treeA.root.right = new BinaryTree.TreeNode(2);
        treeA.root.left.left = new BinaryTree.TreeNode(6);
        treeA.root.left.right = new BinaryTree.TreeNode(0);
        treeA.root.right.left = new BinaryTree.TreeNode(3);
        treeA.root.right.right = new BinaryTree.TreeNode(9);
/*
          10
        /    \
       9      5
      / \    / \
     3   6  2   8
*/
        BinaryTree treeB = new BinaryTree(10);
        treeB.root.left = new BinaryTree.TreeNode(9);
        treeB.root.right = new BinaryTree.TreeNode(5);
        treeB.root.left.left = new BinaryTree.TreeNode(3);
        treeB.root.left.right = new BinaryTree.TreeNode(6);
        treeB.root.right.left = new BinaryTree.TreeNode(2);
        treeB.root.right.right = new BinaryTree.TreeNode(8);
        return List.of(treeA, treeB);
    }
}
