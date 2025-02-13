import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) { 
        val = x; 
    }

    public static ListNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("[]")) {
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head; 

        ListNode current = head; 

        while (current.next != null) { 
            if (current.val == current.next.val) { 
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
        }

        return head; 
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String input = "[1, 1, 2]";
        ListNode head = ListNode.deserialize(input);
        
        System.out.print("Original list: ");
        solution.printList(head);
        
        head = solution.deleteDuplicates(head);
        
        System.out.print("List after removing duplicates: ");
        solution.printList(head);
    }
}
//Input: head={1,1,2}
//Output: {1,2}
