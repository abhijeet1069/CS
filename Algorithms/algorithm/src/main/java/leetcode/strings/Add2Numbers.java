package leetcode.strings;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *<p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *</p>
 *<p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *</p>
 * The solution addTwoNumbers is similar to merge operation in merge sort.
 * */
public class Add2Numbers {

    private static ListNode insertAtEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;
        ListNode res = null;

        while(l1 != null && l2 != null){
            sum = l1.val + l2.val+carry;
            res = insertAtEnd(res,sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum = l1.val + carry;
            res = insertAtEnd(res,sum%10);
            carry = sum/10;
            l1 = l1.next;
        }
        while(l2 != null){
            sum = l2.val + carry;
            res = insertAtEnd(res,sum%10);
            carry = sum/10;
            l2 = l2.next;
        }
        //this was the edge case, take care of the last carry generated.
        if(carry > 0)
            res = insertAtEnd(res,carry);

        return res;
    }

    private static void printList(ListNode head){
        System.out.println();
        while(head != null){
            System.out.print(head.getVal()+" ");
            head = head.next;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = null, l2 = null;

        l1 = insertAtEnd(l1,2);
        l1 = insertAtEnd(l1,4);
        l1 = insertAtEnd(l1,3);

        l2 = insertAtEnd(l2,5);
        l2 = insertAtEnd(l2,6);
        l2 = insertAtEnd(l2,4);

        ListNode res = addTwoNumbers(l1,l2);
        printList(res);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal(){
        return val;
    }
}