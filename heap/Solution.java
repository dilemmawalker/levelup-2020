import java.util.Scanner;

public class Solution{
    public static Scanner scn=new Scanner(System.in);
    public static void solve(int n){
        System.out.println(n/2 +1);
    }
    public static void main(String[]args){
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
        solve(n);
        }
    }
}