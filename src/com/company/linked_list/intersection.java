package com.company.linked_list;

import java.util.HashMap;

public class intersection {
    public ListNode cutNode(ListNode head, int toCut){
        for(int i = 0; i < toCut; i++){
            head = head.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> dict = new HashMap<ListNode, Integer>();
        while(headA != null){
            dict.put(headA, 1);
            headA = headA.next;
        }
        while(headB != null){
            if(dict.get(headB) != null) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_Opti(ListNode headA, ListNode headB) {
        ListNode endA = null;
        ListNode endB = null;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        int lenA = 0;
        int lenB = 0;

        while(tmpA != null){
            if(tmpA.next == null) endA = tmpA;
            tmpA = tmpA.next;
            lenA++;
        }
        while(tmpB != null){
            if(tmpB.next == null) endB = tmpB;
            tmpB = tmpB.next;
            lenB++;
        }

        if(endA != endB) return null;
        int diff = Math.abs(lenA - lenB);
        if(diff != 0){
            if (lenA > lenB) headA = cutNode(headA, diff);
            else headB = cutNode(headB, diff);
        }

        while(headA != headB ){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
