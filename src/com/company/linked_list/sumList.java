package com.company.linked_list;

public class sumList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        StringBuilder sb = new StringBuilder();
        ListNode listNode = new ListNode();

        while(l1 != null){
            sb.append(l1.val);
            l1 = l1.next;
        }

        int count = Integer.parseInt(sb.toString());
        sb = new StringBuilder();

        while(l2 != null){
            sb.append(l2.val);
            l2 = l2.next;
        }

        count += Integer.parseInt(sb.toString());
        String countStr = Integer.toString(count);
        int len = countStr.length();

        ListNode tmp = listNode;
        for(int i = 0; i < len; i++){
            tmp.val = Character.getNumericValue(countStr.charAt(i));
            tmp = tmp.next;
        }
        return listNode;
    }
}
