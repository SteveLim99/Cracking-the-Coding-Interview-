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

    
}
