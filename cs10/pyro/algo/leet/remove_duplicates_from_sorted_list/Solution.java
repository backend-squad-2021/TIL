// https://leetcode.com/problems/remove-duplicates-from-sorted-list

public class Solution {
    int hash(ListNode node) {
        return node.val + 100;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        boolean[] set = new boolean[201];
        set[hash(head)] = true;
        ListNode node = head.next;
        ListNode prevNode = head;
        while (node != null) {
            if (set[hash(node)]) {
                prevNode.next = node.next;
            } else {
                prevNode = prevNode.next;
            }
            set[hash(node)] = true;
            node = node.next;
        }
        return head;
    }

    private static class InputDto {
        final ListNode head;

        InputDto(int[] arr) {
            if (arr.length < 1) {
                head = null;
                return;
            }
            head = new ListNode(arr[0]);
            ListNode node = head;
            for (int i = 1; i < arr.length; i++) {
                node.next = new ListNode(arr[i]);
                node = node.next;
            }
        }
    }

    static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            sb.append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    private static void assertDeleteDuplicates(InputDto input, String expected) {
        ListNode head = input.head;
        String inputStr = toString(head);
        new Solution().deleteDuplicates(head);
        String actual = toString(head);
        if (expected.equals(actual)) {
            return;
        }
        System.err.println(System.lineSeparator());
        System.err.println("input: " + inputStr);
        System.err.println("actual: " + actual);
        System.err.println("expected: " + expected);
    }

    public static void main(String[] args) {
        assertDeleteDuplicates(new InputDto(new int[]{1, 1, 2}), "1 2 ");
        assertDeleteDuplicates(new InputDto(new int[]{1, 1, 2, 3, 3}), "1 2 3 ");
        assertDeleteDuplicates(new InputDto(new int[]{}), "");
    }
}
