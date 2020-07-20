/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static Scanner scn=new Scanner(System.in);
    public static void main (String[] args) throws java.lang.Exception
	{
        solve();
    }
    public static void solve(){
        int t=scn.nextInt();
        while(t-->0){
          HashMap<Integer,Integer>map=new HashMap<>();
          int n=scn.nextInt();
          PriorityQueue<Integer>pq=new PriorityQueue<>();
          PriorityQueue<Integer>pq2=new PriorityQueue<>(Collections.reverseOrder());
          boolean flag=true;
          for(int i=0;i<n;i++){
            int a=scn.nextInt();
            if(!map.containsKey(a)){
              pq.add(a);
              pq2.add(a);
              map.put(a,1);
            }
            else{
              int b=map.get(a);
              if(b==2)
              flag=false;
              map.put(a,b+1);
            }
          }
          if(flag==false){
            System.out.println("NO");
            continue;
          }
          int p=0;
          int m=0;
          ArrayList<Integer>ans=new ArrayList<>();
          while(pq.size()!=0){
            int a=pq.remove();
            int b=map.get(a);
            if(m++!=0)
            if(p+1!=a){
            flag=false;
            break;}
            p=a;
            map.put(a,b-1);
            ans.add(a);
          }
          p=pq2.remove();
          if(map.get(p)==1)
          flag=false;

          if(flag==false){
            System.out.println("NO");
            continue;
          }
          boolean f=false;
         while(pq2.size()!=0){
            int a=pq2.remove();
            int b=map.get(a);
            if(f==true && b==1){
              flag=false;break;
            }
            if(p-1!=a){
            flag=false;break;}
            p=a;
            if(b==1){
              ans.add(a);
            }
            else{
              f=true;
            }
          }
          if(flag==false){
            System.out.println("NO");
            continue;
          }
          System.out.println("YES");
          for(int i=0;i<ans.size();i++)
          System.out.print(ans.get(i)+" ");
         
          System.out.println();
        }
      }
}
