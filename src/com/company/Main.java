package com.company;

public class Main {

    public static void main(String[] args) {
        WordTree testTree = new WordTree();
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

        MathTree postFixer = new MathTree();
        postFixer.loadTree("AB+CD-*");
        System.out.println(postFixer.postFixOutput());
        System.out.println(postFixer.inFix());
        postFixer.loadTree("ABC++D*");
        System.out.println(postFixer.postFixOutput());
        postFixer.loadTree("AB-DE*F-+");
        System.out.println(postFixer.postFixOutput());



    }
}
