package 实验2;

public class seqSearch {
    public static int seqSearch(double[] array,double key){
        for(int i=0;i<array.length;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
}
