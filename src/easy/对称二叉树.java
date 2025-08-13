package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:30
 */
public class 对称二叉树 {
    private static class TreeNode {
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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }
    public static boolean dfs(TreeNode l,TreeNode r){
        if(l==null&&r==null) return true;//这个必须在最前边
        if(l==null||r==null) return false;
        if(l.val!=r.val) return false;
        return dfs(l.left,r.right)&&dfs(l.right,r.left);
    }
}
