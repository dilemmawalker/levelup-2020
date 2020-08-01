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

        ArrayList<Integer>arr=new ArrayList<>();
        boolean maxheap=false;

        public heap(ArrayList<Integer>list,boolean maxheap){
            this.maxheap=maxheap;
            int n=list.size();
            for(int i=0;i<n;i++)
            arr.add(list.get(i));
            for(int i=n-1;i>=0;i--)
                downheapify(i,n);
            }
    public void swap(int a,int b){
        int ele1=arr.get(a);
        int ele2=arr.get(b);

        arr.set(a,ele2);
        arr.set(b,ele1);
    }
    public int compare_to(int a,int b){
        if(maxheap)
        return arr.get(a)-arr.get(b);
        return arr.get(b)-arr.get(a);
    }
    public void downheapify(int pi,int n){
        int lci=2*pi+1;
        int rci=2*pi+2;
        int max=pi;

        if(lci<n && compare_to(lci,max)>0)
            max=lci;
        if(rci<n && compare_to(rci,max)>0)
        max=rci;

        if(pi!=max){
        swap(pi,max);
        downheapify(max,n);
        }
    }
    public void upheapify(int ci){
        int pi=(ci-1)/2;
        int min=ci;

        if(pi>=0 && compare_to(pi,ci)<0)
        min=pi;

        if(ci!=min){
            swap(min,ci);
            upheapify(pi);
        }
    }
    public void upheapify_2(int ci){
        if(ci==0)return;
        int pi=(ci-1)/2;
        int max=ci;
        if(pi>=0 && arr.get(pi)>arr.get(ci))
        max=pi;

        if(ci==max){
            swap(pi,max);
            upheapify_2(pi);
        }
    }
    public boolean isempty(){
        if(arr.size()==0)
        return true;
        return false;
    }
    public int size(){
        return arr.size();
    }
    public int top(){
        if(arr.size()==0)
        return -1;

        return arr.get(0);
    }
    public int pop(){
        swap(0,arr.size()-1);
        int a=arr.remove(arr.size()-1);
        downheapify(0,arr.size());
        return a;
    }
    public void add(int val){
        arr.add(val);
        upheapify(arr.size()-1);
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
        heap pq=new heap(arr,false);
        pq.pop();
        pq.pop();
        pq.add(50);
        pq.add(100);
        int n=pq.size();
        for(int i=0;i<n;i++)
        System.out.print(pq.pop()+" ");

    }
}