package easy;

import java.util.Stack;

/**
 * @author dongyajie
 * @date 2025/8/7 10:29
 */
public class 二叉树的中序遍历 {
    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
          }
    }
    //中序遍历 左根右 递归实现
    public static void inorderTraversal(TreeNode root) {
        if(root==null) return;
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
        return;
    }
    //使用栈实现 中序遍历
    public static void inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){//当前节点不为空 或者 当前栈非空
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
        return;
    }
    //使用栈实现前序遍历
    public static void preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                System.out.println(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }
    //使用栈实现后序遍历 左右根（再看）
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(!stack.isEmpty() && root == stack.peek()){
                root = root.right;
            }else{
                System.out.println(root.val);
                root = null;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inorderTraversal2(root);
    }


}
