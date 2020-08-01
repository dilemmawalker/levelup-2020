import java.util.ArrayList;

public class heapsort{
    public static void downheapify(ArrayList<Integer>arr,int pi,int n){
        int lci=2*pi+1;
        int rci=2*pi+2;
        int max=pi;

        if(lci<=n && arr.get(lci)>arr.get(max))
        max=lci;
        if(rci<=n && arr.get(rci)>arr.get(max))
        max=rci;

        if(max!=pi){
            swap(arr,max,pi);
            downheapify(arr,max,n);
        }
    }
    public static void sort(ArrayList<Integer>arr){
        int n=arr.size()-1;
        for(int i=n;i>=0;i--)
        downheapify(arr,i,n);

        while(n>0){
            swap(arr,0,n--);
            downheapify(arr,0,n);
        }
        for(int ele:arr)
        System.out.print(ele+" ");
    }
    public static void swap(ArrayList<Integer>arr,int a,int b){
        int ele1=arr.get(a);
        int ele2=arr.get(b);

        arr.set(a,ele2);
        arr.set(b,ele1);
    }
    public static void main(String[]args){
        int[]list={ 2, 3, 11, 5, -1, 1, 7, 23, 6, 2, 237};
        ArrayList<Integer>arr=new ArrayList<>();
        int n=list.length;

        for(int i=0;i<n;i++)
        arr.add(list[i]);

        sort(arr);
    }
}