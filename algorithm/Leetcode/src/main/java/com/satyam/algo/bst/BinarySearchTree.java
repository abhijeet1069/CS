package com.satyam.algo.bst;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value){
        root = insert(root,value);

    }

    private TreeNode insert(TreeNode node, int value){
        if(node == null)
            return new TreeNode(value);

        if(value < node.data)
            node.left = insert(node.left,value);

        else if(value > node.data)
            node.right = insert(node.right,value);

        return node;
    }

    public boolean search(int value){
        return search(root,value);
    }

    private boolean search(TreeNode node, int value){
        if(node == null)
            return false;

        if(node.data == value)
            return true;

        if(value < node.data)
            return search(node.left,value);

        return search(node.right,value);
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode node){
        if(node == null)
            return -1;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int countNodes(){
        return countNodes(root);
    }

    private int countNodes(TreeNode node){
        if(node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves(TreeNode node){
        if(node == null)
            return 0;

        if(node.left == null && node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }

    public String inorder(){
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        return sb.toString().trim();
    }

    private void inorder(TreeNode node, StringBuilder sb){
        if(node == null)
            return;
        inorder(node.left,sb);
        sb.append(node.data).append(" ");
        inorder(node.right,sb);
    }

    public String preorder(){
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString().trim();
    }

    private void preorder(TreeNode node, StringBuilder sb){
        if(node == null)
            return;
        sb.append(node.data).append(" ");
        preorder(node.left,sb);
        preorder(node.right,sb);
    }
}
