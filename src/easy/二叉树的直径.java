package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:30
 */
public class 二叉树的直径 {
    public static class TreeNode {
        int val;
        TreeNode left;TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int ans = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        //叉树的 直径 是指树中任意两个节点之间最长路径的 长度
        //这条路径可能经过也可能不经过根节点 root
        //两节点之间路径的 长度 由它们之间边数表示
        dfs(root);
        return ans;
    }
    public static int dfs(TreeNode u) {
        if (u == null) return 0;
        int l = dfs(u.left), r = dfs(u.right);
        ans = Math.max(ans, l + r);//取任意两个节点的最长路径
        return Math.max(l, r) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
}
