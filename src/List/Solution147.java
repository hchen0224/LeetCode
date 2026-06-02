package List;

/**
 * 147. 对链表进行插入排序
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode lastSorted = head;
        ListNode cur = lastSorted.next;
        while(cur != null){
            if(lastSorted.val <= cur.val){
                lastSorted = lastSorted.next;
            }else{
                ListNode pre = dummyNode;
                while(pre.next.val <= cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyNode.next;
    }
    //dummy, 5, 2, 4, 1, 6, 7
}
