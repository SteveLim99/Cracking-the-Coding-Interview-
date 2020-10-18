package com.company.treesAndGraphs;

import com.company.linked_list.ListNode;

import java.util.ArrayList;

public class listOfDepths {
    public ArrayList<ListNode> listOfDepths(TreeNode tree){
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        arr.add(tree);
        ArrayList<ListNode> listNodes = new ArrayList<ListNode>();
        while(arr.size() != 0){
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            ListNode curr = new ListNode();
            ListNode tmp = curr;
            for(int i = 0; i < arr.size(); i++){
                TreeNode currTree = arr.get(i);
                tmp.val = currTree.val;
                if(i!=arr.size()-1) {
                    tmp.next = new ListNode();
                    tmp = tmp.next;
                }
                if(currTree.left != null) nextLevel.add(currTree.left);
                if(currTree.right != null) nextLevel.add(currTree.right);
            }
            arr = nextLevel;
            listNodes.add(curr);
        }
        return listNodes;
    }
}
