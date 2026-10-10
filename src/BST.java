public class BST {
    class Node {
        int value;
        Node left;
        Node right;
        Node (int value){
            this.value = value;
        }
    }
    Node root;
    public void insert(int value){
        root = insertNode(root , value);
    }

    Node insertNode(Node node, int value){
        if (node == null){
            return new Node(value);
        }
        if (value < node.value){
            node.left = insertNode(node.left , value);
        } else if (value > node.value) {
            node.right = insertNode(node.right , value);
        }
        return node;
    }
    public boolean search (int value){
        Node current = root;
        while (current != null){
            if (current.value == value){
                return true;
            }
            if (value < current.value){
                current = current.left;
            }
            else{
            current = current.right;
        }
        }
        return false;
    }
    public void delete (int value){
        root = deleteNode(root,value);
    }
    Node deleteNode(Node node, int value){
        if (node == null){
            return null;
        }
        if (value < node.value){
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right,value);
        }else {
            if (node.left == null){
                return node.right;
            }
            if (node.right == null){
                return node.left;
            }
            Node temp = node.right;
            while (temp.left != null){
                temp = temp.left;
            }
            node.value = temp.value;
            node.right = deleteNode(node.right, temp.value);
        }
        return node;
    }
}
