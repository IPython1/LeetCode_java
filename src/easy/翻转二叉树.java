package easy;

import config.TreeNode;

/**
 * @author dongyajie
 * @date 2025/8/7 10:29
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class 翻转二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        //在创建节点的同时进行拼接
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(invertTree(root));

    }
    public static TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
