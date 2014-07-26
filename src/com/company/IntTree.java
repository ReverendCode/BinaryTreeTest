package com.company;

import java.util.Stack;

/**
 *This was written before the change to the assignment. The algorithm
 * to find the smallest largest should work, but it is untested.
 */
public class IntTree {

    private Leaf root;
    private Leaf marker;

    public IntTree() {
    root=null;
    marker=null;
    }

    public void insertItem (int val) {
        if (root==null) root = new Leaf(val);
        else {
            Leaf temp = root;
            while (true) {
                if (val <= temp.value) {
                    if (temp.left != null) temp=temp.left;
                    else {
                        temp.left = new Leaf(val);
                        break;
                    }//end else
                }//end if
                else {
                    if (temp.right != null) temp=temp.right;
                    else {
                        temp.right = new Leaf(val);
                        break;
                    }
                }

            }//end while
        }//end else
    }
    public boolean findItem(int val) {
        return false;
    }
    public boolean deleteItem(int val) {
        return false;
    }
    public void displayTree() {

    }
    public int findNext(int val) {//for positive ints only
        if (root==null)return -1;
        marker=null;
        for (Leaf temp=root;temp!=null;) {
            if (temp.value==val) {
                marker=temp;
                return marker.value;//found exact, return exact
            }
            if (temp.value<val)temp=temp.right;
            if (temp.value>val) {
                if(marker==null)marker=temp;
                if (marker.value > temp.value) marker=temp;
                temp=temp.left;
            }
        }
        if (marker!=null)return marker.value;//marker should be pointing to the largest smaller that was encountered
        else return -1;//unless nothing larger was found
    }
    public int deleteNext(int val) {
        if (findNext(val)!=-1) {
            int temp = marker.value;
            if (marker.left ==null && marker.right==null) marker=null;
            
            return temp;
        }
        else return -1;
    }
}
