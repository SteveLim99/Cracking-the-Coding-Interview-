package com.company.linked_list;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), point = res;
        boolean addOne = false;

        while(l1 != null || l2 != null){
            int curr = 0;
            if(l1 == null || l2 == null) curr = (l1 == null) ? l2.val : l1.val;
            else curr = l1.val + l2.val;
            if(addOne) curr++;
            addOne = (curr < 10) ? false : true;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            if(addOne) curr = curr % 10;
            point.next = new ListNode(curr);
            point = point.next;
        }

        if(addOne) point.next = new ListNode(1);

        return res.next;
    }
}
