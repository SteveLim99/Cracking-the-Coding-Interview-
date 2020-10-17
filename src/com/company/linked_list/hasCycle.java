package com.company.linked_list;

import java.util.HashMap;

public class hasCycle {
    public boolean hasCycle_1(ListNode head) {
        HashMap<ListNode, Integer> dict = new HashMap<ListNode, Integer>();
        while(head != null){
            if(dict.get(head) != null) return true;
            else dict.put(head,1);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle_opti(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
