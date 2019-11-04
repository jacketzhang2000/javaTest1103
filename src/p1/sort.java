package p1;

import java.util.Arrays;
import java.util.Random;


public class sort {
    public static void creatHeap(double[] array,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapify(array,size,i);
        }
    }

    private static void heapify(double[] array, int size, int index) {
        while(true){
            int left=2*index+1;
            if(size<=left){
                return;
            }
            int max=left;
            if(left+1<size){
                if (array[left + 1] > array[left]) {
                    max=left+1;
                }
            }
            if(array[index]>=array[max]){
                return;
            }
            swap(array,index,max);
            index=max;
        }
    }

    //堆排序
    public static void heapSort(double[] array) {
        creatHeap(array,array.length);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-1);
            heapify(array,array.length-1-i,0);
        }
    }

    //选择排序
    public static void selectSort(double[] array) {
        //无序区间[0,array.length-i-1)
        //有序区间[array.length-i,array.length)
        for(int i=0;i<array.length-1;i++){
            int max=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            swap(array,max,array.length-1-i);
        }
    }

    //希尔排序
    public static void insertSortwithgap(double[] array, int gap) {
        for(int i=0;i<array.length-gap;i++){
            double key=array[i+gap];
            int j;
            for(j=i;j>=0&&array[j]>key;j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }
    public static void shellSort(double[] array){
        int gap=array.length;
        while(true){
            gap/=3+1;
            insertSortwithgap(array,gap);
            if(gap==1){
                return;
            }
        }
    }

    //插入排序
    public static void insertSort(double[] array) {
        for(int i=0;i<array.length-1;i++){
            double key=array[i+1];
            int j;
            for(j=i;j>=0&&array[j]>key;j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }

    private static void swap(double[] array, int max, int i) {
        double s=array[max];
        array[max]=array[i];
        array[i]=s;
    }
    
    //冒泡排序
    public static void bubbleSort(double[] array) {
        for(int i=0;i<array.length-1;i++){
            boolean s=true;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    s=false;
                    swap(array,j,j+1);
                }
            }
            if(s){
                break;
            }
        }
    }

    //快速排序
    public static void quickSort(double[] array) {
        quickSortInternal(array,0,array.length-1);
    }

    private static void quickSortInternal(double[] array, int begin, int end) {
        if(begin>=end){
            return ;
        }
        int pivotIndex=partition(array,begin,end);
        quickSortInternal(array,begin,pivotIndex-1);
        quickSortInternal(array,pivotIndex+1,end);
    }

    private static int partition(double[] array, int begin, int end) {
        double pivot=array[end];
        int left=begin;
        int right=end;
        while(left<right){
            while (left<right&&array[left]<=pivot){
                left++;
            }
            while (right>left&&array[right]>=pivot){
                right--;
            }
            swap(array,left,right);
        }
        swap(array,left,end);
        return left;
    }

    //归并排序
    public static void mergeSort(double[] array) {
        mergeSortInternal(array,0,array.length);

    }

    private static void mergeSortInternal(double[] array, int low, int high) {
        if(low+1>=high){
            return;
        }
        int half=(low+high)/2;
        mergeSortInternal(array,low,half);
        mergeSortInternal(array,half,high);
        merge(array,low,half,high);
    }

    private static void merge(double[] array, int low, int half, int high) {
        int length = high - low;
        double[] ex = new double[length];
        int left = low;
        int right = half;
        int iex = 0;
        while (left < half && right < high) {
            if (array[left] <= array[right]) {
                ex[iex++] = array[left++];
            } else {
                ex[iex++] = array[right++];
            }
        }
        while(left<half){
            ex[iex++]=array[left++];
        }
        while (right<high){
            ex[iex++]=array[right++];
        }
        for(int i=0;i<length;i++){
            array[low+i]=ex[i];
        }

    }

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
        long begin=System.nanoTime();
        double[] a;
        for(int i=0;i<20;i++) {
            a = bulid(20);
            //selectSort(a);
            quickSort(a);
            System.out.println(Arrays.toString(a));
        }
        long end=System.nanoTime();
        System.out.printf("%.4f",(end-begin)*1.0/1000/1000);//毫秒

    }
}
