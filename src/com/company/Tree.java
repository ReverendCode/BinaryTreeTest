package com.company;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;

/**
 * Created by Code on 7/16/14.
 */
public class Tree {
    private StringNode root;

    public Tree() {
        root=null;
    }

    public void addString(String words) {// **Left == Less**
        if (root==null) root = new StringNode(words);
        else {
            StringNode temp = root;
            boolean notSet = true;//there is probably a cleaner way to implement this
            while (notSet) {     //but I don't know it.
                if (words.compareTo(temp.value) <= 0) {
                    if (temp.left != null) temp = temp.left;
                    else {
                        temp.left = new StringNode(words);
                        notSet=false;
                    }
                }
                if (words.compareTo(temp.value) >0) {
                    if (temp.right != null) temp = temp.right;
                    else {
                        temp.right = new StringNode(words);
                        notSet=false;
                    }
                }
            }
        }

        }


    public boolean findString(String words) {
        if (root==null) return false;
        for (StringNode temp = root;!temp.value.equals(words);) { //increment statement in loop
            if (words.compareTo(temp.value)<0) {//go left if words < temp
                if (temp.left==null) return false;//can't go left, you have run out of things to search
                temp=temp.left;//move the temp pointer to the left
            }//end if
            if (words.compareTo(temp.value)>0) {//same same, just to the right
                if (temp.right==null) return false;
                temp=temp.right;
            }//end if
        }//end for
        //if you make it out of the for loop
        //temp is pointing to the string you want now

        return true;
    }
}
