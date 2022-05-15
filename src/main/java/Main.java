import binary_tree.BinaryTree;
import binary_tree.TreeNode;


public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(6);
        binaryTree.addNode(3);
        binaryTree.addNode(5);
        binaryTree.addNode(4);
        //right
        binaryTree.addNode(7);
        binaryTree.addNode(8);
        binaryTree.addNode(9);
        System.out.println("");
    }
}
