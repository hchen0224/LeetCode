package Tree;

/**
 * 110. 平衡二叉树
 */
public class Solution110 {
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        if(root == null){
            return isBalanced;
        }
        int left = dfs(0,root.left);
        int right = dfs(0,root.right);
        if(!isBalanced || Math.abs(left-right) > 1){
            return false;
        }
        return true;
    }
    private int dfs(int depth,TreeNode root){
        if(root == null || !isBalanced){
            return 0;
        }
        ++depth;
        int left = dfs(depth,root.left);
        int right = dfs(depth,root.right);
        if(Math.abs(left-right) > 1){
            isBalanced = false;
        }
        return Math.max(left,right)+1;
    }


    /**
     * 更清晰的解法
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = getHeight(root.left);
        if (leftH == -1) {
            return -1;
        }

        int rightH = getHeight(root.right);
        if (rightH == -1) {
            return -1;
        }

        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }
}
