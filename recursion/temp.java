
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
// import java.io.*;
import java.util.*;
public class temp{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); 
       int[]arr=new int[n];
       for(int i=0;i<n;i++)
       arr[i]=Integer.parseInt(st.nextToken());

       ans(arr,0,0,0);
        System.out.println(count);
       // display(dp);
    }
   public static long count=0;
    public static void ans(int[]arr,int vidx,long sum,int a){
    
        if(sum>count && a>=arr.length/2)
        count=sum;
        // if(sum>count && a>=arr.length/2 && vidx>=arr.length-1)
        // return count;
        if(vidx>=arr.length)
        return ;
    
      ans(arr,vidx+2,sum+arr[vidx],a+1);
     ans(arr,vidx+1,sum,a);

     
}
}