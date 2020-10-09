package com.company;
import com.company.arrays_and_strings.isUnique;
import com.company.arrays_and_strings.checkPerm;
import com.company.arrays_and_strings.URLify;
import com.company.arrays_and_strings.palindromePerm;
import com.company.arrays_and_strings.oneWay;

import java.net.URL;

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

    public static void URLify(){
        URLify urLify = new URLify();
        System.out.println(urLify.URLify("        i", 9));
    }

    public static void palindromePermutation(String input){
        palindromePerm palindromePerm = new palindromePerm();
        System.out.println(palindromePerm.palindromePermuation(input));
    }

    public static void main(String[] args) {
	    // Arrays and Strings #1: isUnique
        // checkUnique("test")

        // Arrays and Strings #2: Check Permutation
        // checkPermutation("ajflsdk;asdfjkl;af;sdjkl","afjl;sdkasdfjklasdfl;jk");

        // URLify
        // URLify();

        // Palindrome Permutation
        // palindromePermutation("test");

        // One Way
//        oneWay oneWay = new oneWay();
//        System.out.println(oneWay.oneWay("pale", "pla"));
    }
}
