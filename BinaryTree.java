public class BinaryTree {

    Node root;

    public void addNode(int key, String name){
        Node newNode = new Node(key,name);

        if(root == null){
            root = newNode;
        }
        else{
            Node focusNode = root;

            Node parent;

            while(true){
                parent = focusNode;

                if(key< focusNode.key){
                    focusNode = focusNode.leftChild;

                    if (focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }

                else{
                    focusNode = focusNode.rightChild;

                    if (focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }


            }
        }

    }


    public void inOrderTraversal(Node focusNode){
        if (focusNode != null){
            inOrderTraversal(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraversal(focusNode.rightChild);

        }
    }

    public void preOrderTraversal(Node focusNode){
        if (focusNode != null){

            System.out.println(focusNode);

            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    public void postOrderTraversal(Node focusNode){
        if (focusNode != null){

            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);

        }
    }

    public Node findNode(int key){
        System.out.println("Searching for " + key);

        Node focusNode = root;

        while (focusNode.key != key){

            if (key<focusNode.key){
                focusNode=focusNode.leftChild;
            }
            else{
                focusNode=focusNode.rightChild;
            }
        }

        if (focusNode == null){
            return null;
        }
        return focusNode;
    }

    public class Node{
        int key;
        String name;

        Node leftChild;
        Node rightChild;

        Node(int key,String name){
            this.key = key;
            this.name = name;
        }

        public String toString(){
            return name + " has a key " + key;
        }

    }


}
