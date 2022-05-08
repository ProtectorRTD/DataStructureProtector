import binary_tree.BinaryTree;


public class Main
{
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(4);
        binaryTree.addNode(6);
        binaryTree.addNode(3);
        binaryTree.addNode(7);
        binaryTree.addNode(2);
        System.out.println(binaryTree.contains(3));
        System.out.println("");
    }
}
