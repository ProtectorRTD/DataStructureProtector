package binary_tree;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    /*
        Compare structure Node
    */
    public boolean compareNodes(TreeNode comparing) {
        if ((this.left == null && comparing.left == null) || (this.left != null && comparing.left != null)) {
            return (this.right == null && comparing.right == null) || (comparing.right != null && this.right != null);
        }
        return false;
    }
}
