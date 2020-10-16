package com.company.linked_list;

public class deleteMiddleNode {
    public ListNode middleNode(ListNode head) {
        int counter = 0;
        ListNode tmp = head;
        while(tmp != null){
            counter += 1;
            tmp = tmp.next;
        }

        if(counter <= 2) return head;
        int mid = 0;
        if (counter % 2 == 0) mid = (counter/2)+1;
        else mid = counter/2 ;

        ListNode slow = head;
        ListNode fast = head.next;
        int count = 0;

        while(fast != null){
            if(count+1 == mid){
                slow.next = fast.next;
                break;
            }
            slow = slow.next;
            fast = fast.next;
            count++;
        }
        return head;
    }
}
