import java.util.PriorityQueue;
import java.util.Stack;

public class BSTree {
    public Node root;

    public BSTree() {
        root = null;
    }

    public void add(String d) {

        Node p = root;
        Node parent = null;//creates a empty parent node
        boolean left = false;
        while (p != null) {//while root is not empty
            if (p.data == d)//if the strings ==
                return;
            if (d.compareTo(p.data) < 0) {
                //instructions for when p.data comes before d (p.data is the parent)
                parent = p;//make parent node == p
                p = p.left;
                left = true;
            } else {//instructions for when d comes before p.data
                parent = p;
                p = p.right;
                left = false;
            }
        }
        if (parent == null)//if there is no parent node
            root = new Node(d);
        else if (left)
            parent.left = new Node(d);
        else
            parent.right = new Node(d);
    }

    public void printInOrder(Node root) {
        //in order traversal
        if (root != null) {
            printInOrder(root.left);

            System.out.println(root.data);

            printInOrder(root.right);


        }

    }

    public void InOrderTraversal(Node root){

        InOrderTraversal(root.left);

        System.out.println(root.data);

        InOrderTraversal(root.right);

    }

    public void PreOrderTraversal(Node root){

        System.out.println(root.data);

        PreOrderTraversal(root.left);

        PreOrderTraversal(root.right);
    }

    public void PostOrderTraversal(Node root){

        PostOrderTraversal(root.left);

        PostOrderTraversal(root.right);

        System.out.println(root.data);
    }

    public boolean DFSearch(int value){
        Stack <Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node p = stack.pop();
            if (p.data == value){//right just bs tree is not
                return true;
            }

            if (p.right != null){
                stack.push(p.right);
            }

            if (p.left != null){
                stack.push(p.left);
            }
        }
        return false;
    }

    public boolean BFSearch(int value){
        PriorityQueue q = new PriorityQueue();
        q.add(root);

        while (q.size() != 0){
            Node p = q.remove();
            if (p.data == value){
                return true;
            }
            if(p.left != null){
                q.add(p.left);
            }
            if (p.right != null){
                q.add(p.right);
            }

        }


    }

    private class Node {
        public Node left;
        public Node right;
        public String data;

        public Node(String d) {
            data = d;
            left = null;
            right = null;
        }

        public String toString(){
            //to be able to print data
            return data;
        }
    }

}
