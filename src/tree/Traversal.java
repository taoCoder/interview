package tree;

import java.util.LinkedList;

/**
 * @author huangtao54
 * @description 二叉树的遍历
 * @date 2018/7/26
 */
public class Traversal {
    /*
               6
        3               9
    1       5       7
      2   4           8

      */
    public static Node initTree() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //返回根节点
    }

    //前序遍历
    public static void preOrderTraversal(Node node) {
        LinkedList<Node> stack = new LinkedList<>();
        Node p = node;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                printNode(p);
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
        System.out.println();
    }

    //中序遍历
    public static void inOrderTraversal(Node node){
        LinkedList<Node> stack = new LinkedList<>();
        Node p = node;
        while (p!=null || !stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                printNode(p);
                p = p.right;
            }
        }
        System.out.println();
    }

    //后序遍历
    public static void postOrderTraversal(Node node){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Node> temp = new LinkedList<>();
        Node p = node;
        while (p!=null || !stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                temp.push(p);
                p = p.right;
            }else {
                p = stack.pop();
                p=p.left;
            }
        }
        while (temp.size() > 0) {
            printNode(temp.pop());
        }
        System.out.println();
    }

    public static void printNode(Node node){
        System.out.print(node.value+"\t");
    }

    public static void main(String[] args){
        Node tree = initTree();
        System.out.println("前序遍历：");
        preOrderTraversal(tree);
        System.out.println("中序遍历：");
        inOrderTraversal(tree);
        System.out.println("后序遍历：");
        postOrderTraversal(tree);
    }
}
