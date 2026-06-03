package List;

public class Solution369 {
    int carryBit = 0;
    public ListNode plusOne(ListNode head) {
        helper(head);
        if(carryBit == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }else{
            return head;
        }
    }
    private ListNode helper(ListNode node){
        if(node == null){
            return node;
        }
        if(node.next == null){
            node.val += 1;
            if(node.val >= 10){
                node.val -= 10;
                carryBit = 1;
            }
            return node;
        }
        node.next = helper(node.next);
        if(carryBit == 1){
            node.val += 1;
            carryBit = 0;
            if(node.val >= 10){
                node.val -= 10;
                carryBit = 1;
            }
        }
        return node;
    }

    public ListNode plusOne2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = reverseList(head);
        ListNode cur = newHead;
        int carry = 1;
        while (cur != null) {
            cur.val += carry;
            carry = cur.val / 10;
            cur.val %= 10;
            if (cur.next == null && carry != 0) {
                cur.next = new ListNode(0);
            }
            cur = cur.next;
        }
        return reverseList(newHead);

    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
