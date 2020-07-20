import java.io.*;
import java.util.*;

public class Solution {
 public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) {
        solution();
    }
    public static void solution(){
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++)
            arr[i]=scn.nextInt();

            if(solution(arr,0,0))
            System.out.println("YES");
            else 
            System.out.println("NO");
        }
    }
    public static boolean solution(int[]arr,int si,int idx){
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            int a=arr[i];
            if(a!=arr[i+1]-1){
            flag=true;
            break;}
        }
        if(flag==false)return true;
        //else return false;
        boolean res=false;
        for(int i=idx;i<arr.length-2;i++){
            for(int j=si;j<3;j++){
                int a=arr[i];
                int b=arr[i+1];
                int c=arr[i+2];
                arr[i]=c;
                arr[i+2]=b;
                arr[i+1]=a;
                if(j==2)
        res=res||solution(arr,0,i+1);
        else
        res=res||solution(arr,j+1,i);
            }
        }
        return res;
    }
}