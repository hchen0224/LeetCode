package List;

/**
 * 382. 链表随机节点
 * @Author Hao Chen
 * @Create 2022/9/29 13:06
 */
public class Solution382 {
    private ListNode head;

    public Solution382(ListNode head) {
        this.head = head;
    }

    /**
     *  核心算法：蓄水池抽样（Reservoir Sampling）
     *  关键思想： 遍历到第 i 个节点时，以 1/i 的概率替换当前选中的节点
     * @return
     */
    public int getRandom() {
        int val = 0;
        ListNode cur = head;

        int i = 1;
        while (cur != null) {
            if (Math.random() < 1.0 / i) {
                // 有 1/i 的概率 进入这个分支
                val = cur.val;
            }
            ++i;
            cur = cur.next;
        }

        return val;
    }

    /**
     * 推广：
     * 从长度未知的数据流中随机选取 k 个元素，保证每个元素被选中的概率相等
     *
     *   前 k 个元素：全部放入蓄水池
     *   第 i 个元素（i > k）：以 k/i 的概率选中
     *     如果选中：随机替换蓄水池中的一个
     *
     *   // 从数据流中随机选 k 个
     *   int[] pool = new int[k];
     *   int i = 0;
     *
     *   while (还有数据) {
     *       if (i < k) {
     *           pool[i] = 当前元素;        // 前 k 个直接放进去
     *       } else {
     *           int r = random(0, i);      // 生成 [0, i] 的随机整数
     *           if (r < k) {
     *               pool[r] = 当前元素;    // 以 k/i 的概率替换
     *           }
     *       }
     *       i++;
     *   }
     */
}
