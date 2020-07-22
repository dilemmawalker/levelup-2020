import java.util.Scanner;
import java.util.ArrayList;
public class code{
    public static int mazepath_memo(int sr,int sc,int er,int ec,int[][]dp){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }

        int ans=0;
        if(sr+1<=er)
        ans+=mazepath_memo(sr+1,sc,er,ec,dp);
        if(sc+1<=ec)
        ans+=mazepath_memo(sr,sc+1,er,ec,dp);
        if(sc+1<=ec && sr+1<=er)
        ans+=mazepath_memo(sr+1,sc+1,er,ec,dp);


        return dp[sr][sc]=ans;
    }
    //new question -not really
    public static int mazepath_dp(int sr,int sc,int er,int ec,int[][]dp){
        for(sr=er;sr>=0;sr--){
            for(sc=ec;sc>=0;sc--){

        if(sr==er && sc==ec){
             dp[sr][sc]=1;
             continue;
        }
        // if(dp[sr][sc]!=0){
        //     continue;
        // }
        int ans=0;
        if(sr+1<=er)
        ans+=dp[sr+1][sc];
        if(sc+1<=ec)
        ans+=dp[sr][sc+1];
        if(sc+1<=ec && sr+1<=er)
        ans+=dp[sr+1][sc+1];

         dp[sr][sc]=ans;
    }
}
    return dp[0][0];
}
    public static int friends_problem(int n,int[]dp){
        if(n<=1){
            return dp[n]=1;
        }
        if(dp[n]!=0)
        return dp[n];

        int c=0;
        c+=friends_problem(n-1,dp);
        c+=friends_problem(n-2,dp)*(n-1);

        return dp[n]=c;
}
public static int friends_problem_dp(int n,int[]dp){
    for(int i=0;i<=n;i++){
        if(i==0||i==1){
            dp[i]=1;
            continue;
        }
        dp[i]=dp[i-1]+dp[i-2]*(i-1);
    }
    return dp[n];
}

public static int static fuy

    public  static void  display(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void display_1(int[]arr){
        int n=arr.length;
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
    public static void main(String[]args){
        int n=9,m=3;
        int[]dp=new int[n+1];
        for(int i=0;i<n;i++)
        //for(int j=0;j<m;j++)
        dp[i]=0;
        // System.out.println(mazepath_dp(0,0,n-1,m-1,dp));
        // display(dp);
        System.out.println(friends_problem_dp(n,dp));
        display_1(dp);
    }
}