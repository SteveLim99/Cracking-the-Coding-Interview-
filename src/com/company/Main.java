package com.company;
import com.company.arrays_and_strings.isUnique;
import com.company.arrays_and_strings.checkPerm;

public class Main {

    public static void checkUnique(String input){
        isUnique isUnique = new isUnique(input);
        System.out.println("My implementation: " + isUnique.checkUnique());
        System.out.println("Optimized implementation: " + isUnique.checkUniqueOpti());
    }

    public static void checkPermutation(String input, String compare){
        checkPerm checkPerm = new checkPerm();
        System.out.println(checkPerm.checkPermutation(input,compare));
    }

    public static void main(String[] args) {
	    // Arrays and Strings #1: isUnique
        // checkUnique("test")

        // Arrays and Strings #2: Check Permutation
        checkPermutation("","");
    }
}
