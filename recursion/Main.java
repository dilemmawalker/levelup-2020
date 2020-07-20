import java.io.*;
import java.util.*;
public class Main{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String args[]){
        int n=scn.nextInt();
        
       int[]arr=new int[n];
       for(int i=0;i<n;i++)
       arr[i]=scn.nextInt();

      long[]dp=new long[n];
      for(int i=0;i<n;i++)
      dp[i]=0;
        long a=ans(arr,0,0,0,dp);
        System.out.println(count);
        display(dp);
    }
   public static long count=0;
    public static long ans(int[]arr,int vidx,long sum,int a,long[]dp){
    
        if(sum>count && a>=arr.length/2)
        count=sum;
        if(sum>count && a>=arr.length/2 && vidx>=arr.length-1)
        return count;
        if(vidx>=arr.length)
        return 0;
        if(dp[vidx]!=0)
         return dp[vidx];

         long c=0;
         long b=0;
      c=  ans(arr,vidx+2,sum+arr[vidx],a+1,dp);
       b= ans(arr,vidx+1,sum,a,dp);

      return  dp[vidx]=Math.max(c,b);
}
public static void display(long[]arr){
    for(int i=0;i<arr.length;i++)
    System.out.print(arr[i]+" ");
}
}