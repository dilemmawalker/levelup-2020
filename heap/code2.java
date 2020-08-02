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
    public static void find_k_largest(int []arr,int k){
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
        public KthLargest(int k, int[] nums) {
            
        }
        
        public int add(int val) {
            
        }
    }
    public static void main(String[]args){
        // test1();
        int[]arr={3,2,1,5,6,4};
        int k=2;
        System.out.println(find_k_largest(arr,k));
    }
}