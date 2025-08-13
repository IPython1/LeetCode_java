package easy;


import config.TreeNode;

/**
 * @author dongyajie
 * @date 2025/8/7 10:30
 */
public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
    //这里确定为左闭右闭区间
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {//左闭右闭 边界条件
            return null;
        }
        int mid = (left+right)/ 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid-1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
