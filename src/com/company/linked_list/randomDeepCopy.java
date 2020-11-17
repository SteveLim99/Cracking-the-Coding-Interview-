package com.company.linked_list;

import java.util.HashMap;

public class randomDeepCopy {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node,Node> mapping = new HashMap<Node,Node>();
        Node tmp = head;

        while(tmp != null){
            mapping.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }

        tmp = head;
        Node newHead = new Node(-1);
        Node tmpNew = newHead;
        while(tmp!= null){
            tmpNew.next = mapping.get(tmp);
            tmpNew.next.random = mapping.get(tmp.random);
            tmpNew = tmpNew.next;
            tmp = tmp.next;
        }

        return newHead.next;
    }
}
