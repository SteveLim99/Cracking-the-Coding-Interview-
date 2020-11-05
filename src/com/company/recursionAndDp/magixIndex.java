package com.company.recursionAndDp;

public class magixIndex {
    public int magicIndex_bruteForce(int[] input){
        int len = input.length;
        for (int i = 0; i < len; i++ ){
            int curr = input[i];
            if (curr == i) return i;
        }
        return -1;
    }

    public int magicIndex_BST(String Optimized, int[] input){
        if(Optimized.equals("BST_OPTIMIZED")) return bst_opti(input,0,input.length-1);
        else if(Optimized.equals("BST_NONDISTINCT")) return bst_nonDistinct(input,0,input.length-1);
        else return bst(input,0,input.length-1);
    }

    private int bst(int[] input, int start, int end){
        if(end < start) return -1;

        int mid = (end + start) / 2;
        int curr = input[mid];
        int magic = -1;

        if(curr == mid) magic = mid;

        if(curr > mid){
            int tmp = bst(input,start,mid-1);
            if(tmp != -1) magic = tmp;
        }

        if(curr < mid){
            int tmp = bst(input,mid+1,end);
            if(tmp != -1) magic = tmp;
        }

        return magic;
    }

    private int bst_opti(int[] input, int start, int end) {
        if (end < start) return -1;

        int mid = (start + end) / 2;
        int curr = input[mid];

        if (curr == mid) return mid;
        else if (curr > mid) return bst_opti(input, start, end - 1);
        else return bst_opti(input, mid + 1, end);
    }

    private int bst_nonDistinct(int[] input, int start, int end){
        if(end < start) return -1;

        int mid = (start + end)/2;
        int curr = input[mid];

        if(mid == curr) return mid;

        int leftIndex = Math.min(mid-1,curr);
        int left = bst_nonDistinct(input,start,leftIndex);
        if(left >= 0) return left;

        int rightIndex = Math.max(mid+1,curr);
        int right = bst_nonDistinct(input,rightIndex,end);
        return right;
    }
}
