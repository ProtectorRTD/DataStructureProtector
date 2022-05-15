package binary_tree;

//нахождение элемента в дереве +
//сравнение деревьев одинаковые или нет
//удаление элемента
//алгоритмы
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }

    public void addNode(int value) {
        recurciveAdd(root, value);
    }

    public TreeNode recurciveAdd(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (current.getValue() < value) {
            current.setRight(recurciveAdd(current.getRight(), value));
        } else if (current.getValue() > value) {
            current.setLeft(recurciveAdd(current.getLeft(), value));
        }
        return current;
    }

    public boolean contains(int value) {
        TreeNode current = root;
        if (value == root.getValue())
            return true;
        while (current != null) {
            if (value > current.getValue()) {
                current = current.getRight();
                if (current != null && current.getValue() == value) {
                    return true;
                }
            } else if (value < current.getValue()) {
                current = current.getLeft();
                if (current != null && current.getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
        Compares the current tree(by structure, not value) and
        the tree passed in the arguments
    */
    public boolean equalsTree(TreeNode root) {
        TreeNode current = this.root;
        TreeNode anotherCurrent = root;
        boolean checker = true;
        while (checker) {
            checker = equalsTreeNode(current, anotherCurrent);
        }
        return false;
    }

    public boolean equalsTreeNode(TreeNode expected, TreeNode actual) {
        return expected.compareNodes(actual);
    }
}
