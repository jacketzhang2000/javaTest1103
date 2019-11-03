package 实验2;

import java.util.Arrays;
import java.util.Random;

public class p1 {
    public static double[] bulid(int n){
        Random random=new Random(20191016);
        double[] a=new double[n];
        double max=100;
        double min=0.0001;
        int scl=3;
        int pow=(int)Math.pow(10,scl);
        for(int i=0;i<n;i++){
            double m=Math.floor((Math.random()*(max-min)+min)*pow)/pow;
            a[i]=m;
        }
        return a;
    }
    public static void main(String[] args) {
        double[] a=bulid(20);
        long begin=System.nanoTime();
       // TreeNode head=binTree.createBinTree(a,0);
       // binTree.binTree(head,a[19]);
      //binSearch.binSearch(a,a[19]);
        seqSearch.seqSearch(a,a[19]);
        long end=System.nanoTime();
        System.out.printf("%.4f",(end-begin)*1.0/1000/1000);//毫秒

    }
}
