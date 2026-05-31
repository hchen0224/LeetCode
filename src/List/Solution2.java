package List;

/**
 * 2. 两数相加
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 解法2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        boolean addOne = false;
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while (l1 != null && l2 != null) {
            if (addOne) {
                l1.val = l1.val + 1;
                if (l1.val == 10) {
                    l1.val = 0;
                } else {
                    addOne = false;
                }
            }

            int nextval = l1.val + l2.val;

            if (nextval >= 10) {
                addOne = true;
                nextval = nextval - 10;
            }

            cur.next = new ListNode(nextval);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            cur.next = connectLeftOver(l1, addOne);
        } else if (l2 != null) {
            cur.next = connectLeftOver(l2, addOne);
        } else {
            if (addOne) {
                cur.next = new ListNode(1);
            }
        }

        return dummyNode.next;

    }

    private ListNode connectLeftOver(ListNode head, boolean addOne) {
        ListNode cur = head;
        while (cur.next != null) {
            if (addOne) {
                cur.val += 1;
                if (cur.val == 10) {
                    cur.val = 0;
                } else {
                    addOne = false;
                }
            }
            cur = cur.next;
        }
        if (addOne) {
            cur.val += 1;
            if (cur.val == 10) {
                cur.val = 0;
                cur.next = new ListNode(1);
            }

        }
        return head;
    }
}
