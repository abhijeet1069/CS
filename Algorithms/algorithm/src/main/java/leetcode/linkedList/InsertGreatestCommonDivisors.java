package leetcode.linkedList;

class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class InsertGreatestCommonDivisors {

    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void printList(ListNode head){
        System.out.println();
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return head;
        ListNode left = head;
        ListNode right = head.next;
        while(right != null){
            ListNode mid = new ListNode(gcd(left.val, right.val));
            mid.next = right;
            left.next = mid;
            left = right;
            right = right.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        printList(head);
        head = insertGreatestCommonDivisors(head);
        printList(head);
    }
}
