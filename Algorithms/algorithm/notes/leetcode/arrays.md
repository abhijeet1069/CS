# Arrays

## Deletion of node from linked list

For deletion in a singly linked list there are 2 cases:
a) Delete from head - To remove this case, a dummy node is added at front of head.
b) Delete in between

```java
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

ListNode dummy = new ListNode(0,head);

return dummy.next;

```

