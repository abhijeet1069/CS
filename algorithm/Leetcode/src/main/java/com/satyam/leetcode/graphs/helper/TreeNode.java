package com.satyam.leetcode.graphs.helper;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void prettyPrint(TreeNode root){
        print(root, "", true);
    }

    private static void print(TreeNode node, String prefix, boolean isTail){

        if(node == null){
            System.out.println(prefix + (isTail ? "└── " : "├── ") + "null");
            return;
        }

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);

        if(node.left != null || node.right != null){

            if(node.right != null){
                print(node.left,
                        prefix + (isTail ? "    " : "│   "),
                        false);

                print(node.right,
                        prefix + (isTail ? "    " : "│   "),
                        true);
            }
            else{
                print(node.left,
                        prefix + (isTail ? "    " : "│   "),
                        true);
            }
        }
    }

}
