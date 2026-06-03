package List;

/**
 * 430. 扁平化多级双向链表
 */
public class Solution430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node cur = head;
        while(cur != null){
            if(cur.child != null){
                Node temp = cur.next;
                Node childHead = flatten(cur.child);
                Node childEnd = getEnd(childHead);
                childHead.prev = cur;
                cur.next = childHead;
                if(temp != null){
                    temp.prev = childEnd;
                }
                childEnd.next = temp;
                cur.child = null;
                cur = temp;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    private Node getEnd(Node node){
        while(node != null && node.next != null){
            node = node.next;
        }
        return node;
    }

    /**
     * 解法2
     * @param head
     * @return
     */
    public Node flatten2(Node head) {
        if (head == null) {
            return null;
        }
        Node dummyNode = new Node();
        dummyNode.next = head;
        head.prev = dummyNode;
        flattenTail(head);
        dummyNode.next.prev = null;
        return dummyNode.next;
    }

    /**
     *把以 node 开头的链表扁平化，并返回尾节点
     */
    private Node flattenTail(Node node) {
        if (node == null) {
            return null;
        }

        if (node.child == null) {
            if (node.next == null) {
                return node;
            } else {
                return flattenTail(node.next);
            }
        }

        Node child = node.child;
        Node next = node.next;
        node.next = child;
        child.prev = node;
        node.child = null;

        Node childTail = flattenTail(child);

        if (next != null) {
            childTail.next = next;
            next.prev = childTail;
            return flattenTail(next);
        } else {
            return childTail;
        }

    }
}

