package Tree;

/**
 * 226. 翻转二叉树
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 更清晰的递归解法
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        //1. 边界条件
        if (root == null) {
            return null;
        }

        //2. 完成 1 步
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        //3. 推广到 n 步
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
