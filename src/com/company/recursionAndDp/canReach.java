package com.company.recursionAndDp;

public class canReach {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr,start);
    }

    private boolean dfs(int[] arr, int start){
        if(start >= arr.length || start < 0 || arr[start] < 0) return false;
        if(arr[start] == 0) return true;
        arr[start] = -arr[start];
        return dfs(arr,start+arr[start]) || dfs(arr,start-arr[start]);
    }
}
