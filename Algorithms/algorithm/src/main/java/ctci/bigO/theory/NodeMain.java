package ctci.bigO.theory;

public class NodeMain {

    static class Node {
        Node left;
        int value;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static int sum(Node node){
        if(node == null)
            return 0;
        return sum(node.left) + node.value + sum(node.right);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node left = new Node(5);
        Node right = new Node(13);
        head.left = left;
        head.right = right;
        System.out.println(sum(head));
    }
}
