package cs10_week2;

public class RemoveDuplicatesFromSortedList {

    public ListNode first(ListNode head) {
        ListNode n = head;
        if (head == null) {
            return head;
        }
        while (n.next != null) {
            if (n.val == n.next.val) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        return head;
    }

    public ListNode second(ListNode head) {
        if (head == null) {
            return head;
        }
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList main = new RemoveDuplicatesFromSortedList();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // [1, 1, 2, 2, 3]
        // 중복값 제거 후 출력
        // first()의 경우 [1, 2, 3]
        // second()의 경우 [3]
        ListNode result = main.first(a);
        while (result.next != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(result.val);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
