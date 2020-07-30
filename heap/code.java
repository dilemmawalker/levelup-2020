import java.util.Scanner;
import java.util.ArrayList;

public class code{
    public static int height(int []arr,int idx){
        if(idx>=arr.length)
        return -1;

        int lch=height(arr,2*idx+1);
        int rch=height(arr,2*idx+2);
        return Math.max(lch,rch)+1;
    }
    public static int size(int[]arr,int idx){
        if(idx>=arr.length)
        return 0;

        int ls=size(arr,2*idx+1);
        int rs=size(arr,2*idx+2);
        return ls+rs+1;
    }=
    public static void main(String[]args){
        int[]arr={ 2, 3, 11, 5, -1, 1, 7, 23, 6, 2, 237};
        System.out.println(size(arr,0));
    }
}