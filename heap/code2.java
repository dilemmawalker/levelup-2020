import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class code2{
    public static void test1(){
        int[]arr={ 2, 3, 11, 5, -1, 1, 7, 23, 6, 2, 237};
        // PriorityQueue<Integer>pq=new PriorityQueue<>();  //min PQ  by default
        //  PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());  // max PQ

        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{    //comparator
           return a-b;   //this-other    for min PQ
        // return b-a;   //other-this    for max PQ
        });
        int n=arr.length;

        for(int i=0;i<n;i++)
        pq.add(arr[i]);

        while(pq.size()!=0)
        System.out.print(pq.remove()+" ");
    }
    public static int find_k_largest(int []arr,int k){
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int i=0;
        int n=arr.length;
        for(;i<k;i++)
            pq.add(arr[i]);

            for(;i<n;i++){
                if(arr[i]>pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
            return pq.peek();
    }
    class KthLargest {

        PriorityQueue<Integer>pq=new PriorityQueue<>();
    int a=0;
        public KthLargest(int k, int[] nums) {
            int n=nums.length;
            int i=0;
            while(i<n){
                pq.add(nums[i++]);
                if(pq.size()>k)
                pq.remove();
            }
            a=k;
        }
        
        public int add(int val) {
            pq.add(val);
            if(pq.size()>a)
            pq.remove();
            return pq.peek();
        }
    }
    ///////
    public static class val3{
        int val=0;
        int r=0;
        int c=0;
        val3(int val,int r,int c){
            this.val=val;
            this.r=r;
            this.c=c;
        }
        val3(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public static int kthSmallest(int[][] arr, int k) {
        PriorityQueue<val3>pq=new PriorityQueue<>((val3 a,val3 b)->{
            return a.val-b.val;
        });
        int n=arr.length;
        for(int i=0;i<n;i++){
            pq.add(new val3(arr[i][0],i,0));
        }
        int len=arr[0].length;
        k--;
        while(k--!=0){
            val3 a=pq.remove();
            if(a.c <len-1)
            pq.add(new val3(arr[a.r][a.c+1],a.r,a.c+1));
        }
        return pq.peek().val;
    }
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<val3>pq=new PriorityQueue<>((val3 a,val3 b)->{
            return ((a.r)/(a.c)) -((b.r)/(b.c));
        });
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            pq.add(new val3(i,n-1));
        }
        while(k--!=0){
            val3 a=pq.remove();
            int r=a.r;
            int c=a.c;
            if(c-1>r){
                pq.add(new val3(r,c-1));
            }
        }
        int[]an=new int[2];
        an[0]=arr[pq.peek().r];
        an[1]=arr[pq.peek().c];
        return an;
    }
   
    public static void main(String[]args){
        // test1();
        int[]arr={1,2,3,5};
        int k=3;
        int[]a=kthSmallestPrimeFraction(arr,k);
        // System.out.println(kthSmallest(arr,k));
        System.out.print(a[0]+" "+a[1]);
    }
}