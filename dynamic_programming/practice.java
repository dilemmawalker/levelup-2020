import java.util.Scanner;
public class code2{


    public static int fibo(int s,int n,int[]dp){
        if(s==n){
            return 1;
        }
        int c=0;
        
        if(s+1<=n)
        c+=fibo(s+1,n,dp);
        if(s+2<=n)
        c+=fibo(s+2,n,dp);

        return c;
    }
    public static int fibo_memo(int s,int n,int[]dp){
        if(s>=n){
            if(s==n)
            return dp[s]=1;
            return 0;
        }
        int c=0;
        if(dp[s]!=0)
        return dp[s];
        
        //if(s+1<=n)
        c+=fibo_memo(s+1,n,dp);
        //if(s+2<=n)
        c+=fibo_memo(s+2,n,dp);

        return dp[s]=c;
    }
    public static int fibo_dp(int s,int N,int []dp){
        int n=dp.length;
        for(int i=n-1;i>=0;i--){
            if(i==n-1||i==n-2){
                dp[i]=1;
                continue;
            }
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
    public static int fibo_memo2(int s,int n,int[]dp){
        if(n<=1)
        return dp[n]=1;

        int c=0;
        if(dp[n]!=0)
        return dp[n];

        c+=fibo_memo2(s,n-1,dp);
        c+=fibo_memo2(s,n-2,dp);

        return dp[n]=c;
    }
    public static void display(int []arr){
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
    }
    public static void main(String[]args){
        int n=6;
        int[]dp=new int[n];
        System.out.println(fibo_memo(0,5,dp));
        display(dp);
    }
}