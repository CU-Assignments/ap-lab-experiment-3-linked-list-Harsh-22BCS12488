class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { 
        val = x; 
    }

    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }
        
        String[] values = data.replaceAll("[\\[\\] ]", "").split(",");
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }
        
        return head;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next; 
            current.next = prev; 
            prev = current;     
            current = next;
        }
        return prev; 
    }
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       
        String input = "[1,2,3,4,5]";
        ListNode head = ListNode.deserialize(input);
        
        System.out.print("Original list: ");
        printLinkedList(head);
        
        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);
        
        System.out.print("Reversed list: ");
        printLinkedList(reversedHead);
    }
}
//Input:  head={1,2,3,4,5}
//Output:  {5,4,3,2,1}
