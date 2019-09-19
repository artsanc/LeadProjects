public class BinaryTreeTester {
    public static void main(String args[]){
        BinaryTree b = new BinaryTree();

        b.addNode(50, "Boss");
        b.addNode(25, "VP");
        b.addNode(15, "Office Manager");
        b.addNode(30, "Secretary");
        b.addNode(75, "Sales Manager");
        b.addNode(85, "Salesman 1");

//        b.inOrderTraversal(b.root);
//          b.preOrderTraversal(b.root);
//        b.postOrderTraversal(b.root);

        System.out.println(b.findNode(50));
    }
}
