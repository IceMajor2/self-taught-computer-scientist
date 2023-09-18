import bin_tree.BinaryTree;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {

    @ParameterizedTest
    @MethodSource(value = {"params.TreeParameters#treesPlusInvertedTrees"})
    void shouldInvertBinaryTree(BinaryTree tree, BinaryTree invertedTree) {
        tree.invert();
        assertTrue(tree.identicalTrees(tree.root, invertedTree.root));
    }
}