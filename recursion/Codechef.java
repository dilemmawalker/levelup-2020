import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
     public static Scanner scn=new Scanner(System.in);
	 public static void main (String[] args) throws java.lang.Exception
	{
        int t=scn.nextInt();
       while(t-->0){
               
          int n=scn.nextInt();
          boolean flag=true;
          HashMap<Integer,Integer>map=new HashMap<>();
          int[]arr=new int[n];
          for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
          }
          map.put(arr[0],1);
          int prev=arr[0];
          for(int i=1;i<n;i++){
                int a=arr[i];
                if(!map.containsKey(a)){
                        map.put(a,1);
                }
                else{
                        if(arr[i]!=prev){
                                flag=false;
                                System.out.println("NO");
                                break;
                        }
                        map.put(a,map.get(a)+1);
                }
                prev=arr[i];
        }
        if(flag==true){
                HashSet<Integer>h=new HashSet<Integer>();
                h.add(map.get(arr[0]));
                int pre=arr[0];
                for(int i=1;i<n;i++){
                        int a=arr[i];
                        int b=map.get(a);
                        if(a!=pre){
                        if( h.contains(b)){
                                System.out.println("NO");
                                flag=false;
                                break;
                        }
                        h.add(b);
                }
                        pre=arr[i];
                }
                if(flag)
                System.out.println("YES");
        }

        // if(flag)
        //          System.out.println("YES");
       }

	}
}
