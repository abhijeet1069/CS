package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

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

public class DeleteNodesFromLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list = modifiedList(new int[]{1,2,3},list);
        printList(list);
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        ListNode dummy = new ListNode(0,head); //this solved the edge case of deleting head
        ListNode left = dummy;
        ListNode right = head;
        while(right != null){
            if(set.contains(right.val))
                left.next = right.next;
            else
                left = right;
            right = right.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head){
        System.out.println();
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
