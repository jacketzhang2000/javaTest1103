package 实验2;

import java.util.Arrays;

public class binSearch {
    public static int binSearch(double[] array,double key){
        Arrays.sort(array);
        int low=0;
        int high=array.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(array[mid]<key){
                low=mid+1;
            }else if(array[mid]>key){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
