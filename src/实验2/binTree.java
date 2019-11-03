package 实验2;

import java.util.Arrays;
import java.util.Random;

class TreeNode{
    double val;
    TreeNode left;
    TreeNode right;
    TreeNode(double val){
        this.val=val;
    }
}
public class binTree {
    public static TreeNode createBinTree(double[] array,int index){
        TreeNode tn=null;
        if(index<array.length){
            Double val=array[index];
            if(val==null){
                return null;
            }
            tn=new TreeNode(val);
            tn.left=createBinTree(array,2*index+1);
            tn.right=createBinTree(array,2*index+2);
            return tn;
        }
        return tn;
    }

    public static void disPlay(TreeNode head){
        if(head==null){
            return;
        }
        System.out.println(head.val);
        disPlay(head.left);
        disPlay(head.right);
    }
    public static TreeNode binTree(TreeNode head,double key) {
        if (head == null) {
            return null;
        }
        if (key == head.val) {
            return head;
        } else if (key < head.val) {
            return binTree(head.left, key);
        } else return binTree(head.right, key);
    }

}
