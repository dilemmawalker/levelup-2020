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
    }
    public static class heap{
        
        public heap(ArrayList<Integer>arr){
            int n=arr.size();
            for(int i=n-1;i>=0;i--){
                downheapify(arr,i,n);
            }
            for(int i=0;i<n;i++)
            System.out.print(arr.get(i)+" ");
        }
    public void swap(ArrayList<Integer>arr,int a,int b){
        int ele1=arr.get(a);
        int ele2=arr.get(b);

        arr.set(a,ele2);
        arr.set(b,ele1);
    }
    public void downheapify(ArrayList<Integer>arr,int pi,int n){
        int lci=2*pi+1;
        int rci=2*pi+2;
        int max=pi;

        if(lci<n && arr.get(lci)>arr.get(max))
            max=lci;
        if(rci<n && arr.get(rci)>arr.get(max))
        max=rci;

        if(pi!=max){
        swap(arr,pi,max);
        downheapify(arr,max,n);
        }
    }
}
    public static void main(String[]args){
        ArrayList<Integer>arr=new ArrayList<Integer>();
        // { 2, 3, 11, 5, -1, 1, 7, 23, 6, 2, 237};
        arr.add(2);
        arr.add(3);
        arr.add(11);
        arr.add(5);
        arr.add(-1);
        arr.add(1);
        arr.add(7);
        arr.add(23);
        arr.add(6);
        arr.add(2);
        arr.add(237);

        // System.out.println(size(arr,0));
        heap(arr);
    }
}