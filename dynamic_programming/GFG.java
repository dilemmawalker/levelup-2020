import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     public static Scanner scn=new Scanner(System.in);
      public static int ma=0;
	public static void main (String[] args)
	 {
	     int t=scn.nextInt();
	     while(t-->0){
	         int a=scn.nextInt();
	         a=scn.nextInt();
	         String str1=scn.next();
	         String str2=scn.next();
	         int[][]dp=new int[str1.length()][str2.length()];
	         for(int i=0;i<str1.length();i++)
	         for(int j=0;j<str2.length();j++)
	         dp[i][j]=-1;
	         m=0;
	         longest_common_palindrome_substring(0,0,str1,str2,dp);
	 System.out.println(m);
	 }
	 }
	
     public static int longest_common_palindrome_substring(int si1,int si2,String str1,String str2,int[][]dp){
        if(si1==str1.length()||si2==str2.length())
        return 0;
    
        if(dp[si1][si2]!=0)
        return dp[si1][si2];
    
        longest_common_palindrome_substring(si1+1,si2,str1,str2,dp);
        longest_common_palindrome_substring(si1,si2+1,str1,str2,dp);
    
        if(str1.charAt(si1)==str2.charAt(si2)){
        ma=Math.max(ma,longest_common_palindrome_substring(si1+1,si2+1,str1,str2,dp)+1);
        return dp[si1][si2]=ma;
        }
    
        return 0;
    }
	 
}