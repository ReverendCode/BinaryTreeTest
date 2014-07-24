package com.company;

import java.util.Stack;

/**
 * Created by Code on 7/23/14.
 */
public class MathTree {
    private Leaf root;
    private Stack<Leaf> theStack;

    public MathTree() {
        root = null;
        theStack = new Stack<Leaf>();
    }

    public void loadTree(String datum) {//this works for postfix
        for (int i=0;i<datum.length();i++) {
           if ((datum.charAt(i) >='a' && datum.charAt(i)<='z') ||
                   (datum.charAt(i) >= 'A' && datum.charAt(i) <= 'Z')) {
               theStack.push(new Leaf(datum.charAt(i)));
           }//end if
            else {//assuming clean inputs
               Leaf temp = new Leaf(datum.charAt(i));
               temp.right=theStack.pop();
               temp.left=theStack.pop();
               theStack.push(temp);
           }//end else
        }//end for
        root=theStack.pop();
    }

    public String postFixOutput() {
        return recPostFix(root);
    }

    private String recPostFix(Leaf current) {
        String output="";
        if (current==null) return output;

        output+=recPostFix(current.left);
        output+=recPostFix(current.right);
        output+=(char)current.value;
        return output;
    }
    public String inFix() {
        return recInFix(root);
    }
    private String recInFix(Leaf current) {
        String output="";
        if (current==null) return output;
        output+=recInFix(current.left);
        output+=(char)current.value;
        output+=recInFix(current.right);
        return output;
    }
}
