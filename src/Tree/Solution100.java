package Tree;

/**
 * 100. 相同的树
 * @Author Hao Chen
 * @Create 2022/7/13 13:36
 */
public class Solution100 {
    boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p,q);
        return isSame;
    }
    private void check(TreeNode p,TreeNode q){
        if((p == null && q == null) || !isSame){
            return;
        }
        if(p == null || q == null || p.val != q.val){
            isSame = false;
            return;
        }
        check(p.left,q.left);
        check(p.right,q.right);
    }

    /**
     *更好的写法，不要成员变量，带返回值的递归
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
