package com.company;
import com.company.arrays_and_strings.isUnique;
import com.company.arrays_and_strings.checkPerm;
import com.company.arrays_and_strings.URLify;
import com.company.arrays_and_strings.palindromePerm;
import com.company.treesAndGraphs.TreeNode;
import com.company.interviewPrep.fillTheTruck;
import com.company.interviewPrep.sharePurchases;

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

    public static void traverse(TreeNode treeNode){
        if(treeNode.left != null){
            traverse(treeNode.left);
        }
        System.out.println(treeNode.val);
        if(treeNode.right != null){
            traverse(treeNode.right);
        }
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
//        System.out.println(oneWay.oneWay("pale", "ple"));

        // String Compression
        // stringComp stringComp = new stringComp();
        // System.out.println(stringComp.compression("aabcccccaaac"));
        // System.out.println(stringComp.optimizedCompression("aabcccccaaac"));

        // Rotate Matrix
//        rotateMatrix rotateMatrix = new rotateMatrix();
//        int[][] tmp = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] rotated = rotateMatrix.rotateMatrix_imp_1(tmp);

        // Zero Matrix
//        zeroMatrix zeroMatrix = new zeroMatrix();
//        int[][] tmp = {{1,2,3,4,0},{4,2,6,2,3},{0,1,2,8,9}};
//        int[][] ans = zeroMatrix.zeroMatrix(tmp);
//        for(int[] i : ans){
//            StringBuilder sb = new StringBuilder();
//            for(int j : i){
//                sb.append(j);
//            }
//            System.out.println(sb.toString());
//        }

        // String Rotation
//        stringRotation stringRotation = new stringRotation();
//        System.out.println(stringRotation.stringRotation("watwaerbottle", "erbottlewatwa"));

        // Minimal Tree
//        minimalTree minimalTree = new minimalTree();
//        int[] tmp = {1,2,3,4,5,6,7,8,9};
//        TreeNode test = minimalTree.minimalTree(tmp);
//        traverse(test);

        // Sucessor Tree
//        TreeNode tmp = new TreeNode();
//        TreeNode iter = tmp;
//        iter.val = 3;
//        iter.left = new TreeNode(4);
//        iter.right = new TreeNode(5);
//        iter.left.left = new TreeNode(10);
//        iter.right.right = new TreeNode(11);
//        iter.left.right = new TreeNode(20);
//        iter.right.left = new TreeNode(30);
//        Sucessor sucessor = new Sucessor();
//        TreeNode ans = sucessor.successor(tmp,tmp);
//        if(ans == null) System.out.println("null");
//        else System.out.println(ans.val);

        // Magic Index
//        magixIndex magixIndex = new magixIndex();
//        int[] test = {-40,-20,-1,1,2,3,5,7,9,12,13};
//        System.out.println(magixIndex.magicIndex_BST("BST_NONDISTINCT",test));

//        int[] skills = {12, 4, 6, 13, 5, 10};
//        teams teams = new teams(6,skills,3,4,10);
//        System.out.println(teams.calcTeams());
//        System.out.println(teams.calcTeam_fact());

//        int[] tmp = {1,100,1,1,1,1,10,0,0};
//        cutOffRank cutOffRank = new cutOffRank(9,4,tmp);
//        System.out.println(cutOffRank.getCutOffRank());

        // Fill the truck
//        int[] boxes = {};
//        int[] unitsPerBox = {};
//        fillTheTruck fillTheTruck = new fillTheTruck(6,boxes,unitsPerBox,3,3);
//        System.out.println(fillTheTruck.getFillTheTruck());

        // share purchases
        sharePurchases sharePurchases = new sharePurchases();
        System.out.println(sharePurchases.analyzeSharePrices_backtrack("ABCCBA"));
    }
}
