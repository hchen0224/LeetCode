package List;

/**
 * 61. 旋转链表
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode countNode = dummyNode;
        while(countNode.next != null){
            countNode = countNode.next;
            ++count;
        }
        int reversedIndexOfNewHead = k % count;
        if(reversedIndexOfNewHead == 0){
            return head;
        }
        int indexOfNewHead = count - reversedIndexOfNewHead;
        ListNode pre = head;
        for(int i = 0; i < indexOfNewHead-1; ++i){
            pre = pre.next;
        }
        ListNode newHead = pre.next;
        pre.next = null;
        ListNode temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }

    /**
     * 解法2
     * 结合19. 删除链表的倒数第 N 个结点
     * k % count 是倒数第 n 个节点，也就是新的头结点
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            ++count;
            cur = cur.next;
        }

        int n = k % count;
        if (n == 0) {
            return head;
        }

        ListNode[] arr = findNewHead(head, n);
        ListNode pre = arr[0];
        ListNode newHead = arr[1];
        pre.next = null;

        ListNode p = newHead;
        while (p.next != null) {
            p = p.next;
        }

        p.next = head;

        return newHead;

    }

    private ListNode[] findNewHead(ListNode head, int n) {
        ListNode[] arr = new ListNode[2];
        ListNode dummyNode = new ListNode(0, head);
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        arr[0] = slow;
        arr[1] = slow.next;
        return arr;
    }
}
