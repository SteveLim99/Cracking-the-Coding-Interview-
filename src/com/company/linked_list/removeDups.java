package com.company.linked_list;

public class removeDups {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int counter = 0;
        while(tmp != null){
            counter += 1;
            tmp = tmp.next;
        }

        int index = counter - n;
        if(index == 0) return head.next;

        counter = 1;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            if(counter == index){
                slow.next = fast.next;
                break;
            }
            slow = slow.next;
            fast = fast.next;
            counter++;
        }

        return head;

    }
}
