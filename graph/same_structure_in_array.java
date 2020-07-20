import java.util.ArrayList;
import java.util.LinkedList;

public class same_structure_in_array{
    public static  
    int[][]arr={
    {1,1,0,0,0},
    {1,0,0,0,0},
    {0,1,1,0,0},
    {0,1,0,1,1},
    {0,0,0,1,0}};
    public static void main(String[]args){      
        same_structure(arr);
    }
    public static  ArrayList<String>aaa=new ArrayList<>();
    public static String ans="";

    public static void same_structure(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                   ans="";
                ans=same_structure_dfs(arr,i,j,n,m,ans);
                aaa.add(ans);
                }
            }
        }
        System.out.print(aaa);
        n=aaa.size();    
        boolean []vis=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String str1=aaa.get(i);
                String str2=aaa.get(j);
                if(str1.length()==str2.length()){
                    boolean flag=false;
                    for(int k=0;k<str1.length();k++){
                        if(str1.charAt(k)!=str2.charAt(k)){
                            flag=true;
                            break;
                        }
                    }
                    if(flag==false){
                        vis[j]=true;
                    System.out.println(str1);
                    }
                }
            }
        }    
    }
   public static String same_structure_dfs(int[][]arr,int i,int j,int n,int m,String ans){

        arr[i][j]=0;
        if(i+1<n && arr[i+1][j]==1){
            ans=same_structure_dfs(arr,i+1,j,n,m,ans+"D");
        }
        if(j+1<m && arr[i][j+1]==1)
        ans=same_structure_dfs(arr,i,j+1,n,m,ans+"R");

    if(i-1>=0 && arr[i-1][j]==1){
        ans=same_structure_dfs(arr,i-1,j,n,m,ans+"U");
    }
    if(j-1>=0 && arr[i][j-1]==1)
    ans=same_structure_dfs(arr,i,j-1,n,m,ans+"L");

    ans+="b";
    return ans;
}
}
