package com.company;

public class Main {

    public static void main(String[] args) {
        Tree testTree = new Tree();
        testTree.addString("middle");
        testTree.addString("grape");
        testTree.addString("apple");
        testTree.addString("house");
        testTree.addString("pine");
        testTree.addString("tree");
        testTree.addString("never");

        System.out.println(testTree.preDisplay());
        System.out.println(testTree.inOrder());
        System.out.println(testTree.postOrder());



    }
}
