package tree;

/**
 * @author huangtao54
 * @description 二叉树
 * @date 2018/7/26
 */
public class Node {
    public int value;

    public Node left;

    public Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
