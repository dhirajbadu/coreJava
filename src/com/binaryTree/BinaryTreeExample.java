package com.binaryTree;

public class BinaryTreeExample {

    public static BinaryTree makeTree(){
        BinaryTree bt = new BinaryTree();

        bt.add(1);
        bt.add(2);
        bt.add(3);
        bt.add(4);

        return bt;
    }

    public static void main(String[] args) {
        BinaryTree bt = makeTree();
        System.out.println(bt.cantains(5));
    }
}

class BinaryTree{
    Node root;

    private Node addRecursive(Node node , int value){
        if(node == null){
            return new Node(value);
        }

        if(value < node.value){
            node.left = addRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = addRecursive(node.right, value);
        } else {
            return node;
        }

        return node;
    }

    private boolean containsRecirsive(Node node , int value){

        if(node == null){
            return false;
        }

        if(node.value == value){
            return true;
        }


        return (node.value > value) ? containsRecirsive(node.left , value) : containsRecirsive(node.right , value);

    }

    public boolean cantains(int value){
        return containsRecirsive(root , value);
    }
    public void add(int value){
        root = addRecursive(root , value);
    }

}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }


}
