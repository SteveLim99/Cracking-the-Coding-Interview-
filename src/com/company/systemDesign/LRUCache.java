package com.company.systemDesign;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    HashMap<String, Integer> library;
    ArrayList<String> leastRecentlyUsed;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.library = new HashMap();
        this.leastRecentlyUsed = new ArrayList();
        this.size = 0;
    }

    public int get(int key) {
        String keyString = Integer.toString(key);
        if(this.library.containsKey(keyString)){
            this.leastRecentlyUsed.remove(keyString);
            this.leastRecentlyUsed.add(keyString);
            return library.get(keyString);
        }
        return -1;
    }

    public void put(int key, int value) {
        String keyString = Integer.toString(key);
        if(this.library.containsKey(keyString)){
            this.leastRecentlyUsed.remove(keyString);
            this.leastRecentlyUsed.add(keyString);
            this.library.put(keyString,value);
        } else {
            if(this.size + 1 > this.capacity){
                String removedItem = leastRecentlyUsed.get(0);
                this.leastRecentlyUsed.remove(0);
                this.leastRecentlyUsed.add(keyString);
                this.library.remove(removedItem);
                this.library.put(keyString,value);
            } else {
                this.leastRecentlyUsed.add(keyString);
                this.library.put(keyString,value);
                this.size++;
            }
        }
    }
}
