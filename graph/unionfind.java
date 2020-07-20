import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
public class unionfind{
  
     public static class edge{
        int v=0;int w=0;
        edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    public static int N=7;  
    public static ArrayList<edge>[]graph;

    public static void constructgraph(){
        graph=new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<edge>();
        }
        addedge(graph,0,1,10);
        addedge(graph,0,3,10);
        addedge(graph,1,2,10);
        addedge(graph,2,3,40);
        addedge(graph,3,4,2);
        addedge(graph,4,5,2);
        addedge(graph,4,6,3);
        addedge(graph,5,6,8);
       // addedge(graph,2,5,8);

       // removeedge(graph,1,2);
     // removevertex(graph,1);
      //  display(graph);
    }
    public static void addedge(ArrayList<edge>[] gp,int u,int v,int w){
        gp[u].add(new edge(v,w));
        gp[v].add(new edge(u,w));
    }
    public static void display(ArrayList<edge>[]gp){
        for(int i=0;i<gp.length;i++){
            System.out.print(i+"->");
            for(edge ele:gp[i]){
                System.out.print("("+ele.v+","+ele.w+"), ");
            }
            System.out.println();
        }
    }
    public static int[]par;
    public static int[]size;
    public static int findparent(int vtx){
        if(par[vtx]==vtx)
        return vtx;
        return par[vtx]=findparent(par[vtx]);
    }
    public static void mergeset(int p1,int p2){
        if(size[p1]<size[p2]){
            par[p1]=p2;
            size[p2]+=size[p1];
        }
        else{
            par[p2]=p1;
            size[p1]+=size[p2];
        }
    } 
    public static void union_find(){
       
        }
    public static void lexicographically_smallest_equivalent(String a,String b,String c){
        par=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        
       for(int i=0;i<a.length();i++){
           int p1=findparent(a.charAt(i)-'a');
           int p2=findparent(b.charAt(i)-'a');
           
            par[p2]=Math.min(p1,p2);
            par[p1]=Math.min(p1,p2);
           
       }
       for(int i=0;i<26;i++)
       System.out.print(par[i]+"  ");

       String str="";
       for(int i=0;i<c.length();i++){
           int p=findparent(c.charAt(i)-'a');
           str+=(char)(p+'a');
       }
       System.out.print(str);
    }

    public static void kruskal(int[][]arr){
        ArrayList<edge>[]kgraph=new ArrayList[N];
        for(int i=0;i<N;i++)
        kgraph[i]=new ArrayList<edge>();

        size=new int[N];
        par=new int[N];
        for(int i=0;i<N;i++){
            par[i]=i;
            size[i]=1;
        }
        Arrays.sort(arr,(int[]a,int[]b)->{
            return a[2]-b[2];});

            for(int[]ar:arr){
                int x=findparent(ar[0]);
                int y=findparent(ar[1]);
                if(x!=y){
                    mergeset(x,y);
                    addedge(kgraph,x,y,ar[2]);
                }

            }
            display(kgraph);
        }
    public static void optimise_water_distribution(int n,int[]wells,int[][]pipes){
        par=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<n+1;i++){
        par[i]=i;
        size[i]=1;
        }
        ArrayList<ArrayList<Integer>>pipe=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<pipes.length;i++){
            ArrayList<Integer>a=new ArrayList<Integer>();
            for(int j=0;j<3;j++){
                a.add(pipes[i][j]);
            }
            pipe.add(a);
        }
        for(int i=0;i<wells.length;i++){
            ArrayList<Integer>a=new ArrayList<Integer>();
            a.add(0);
            a.add(i+1);
            a.add(wells[i]);
            pipe.add(a);
        }
        //pipe.add(new ArrayList<Integer>(0,i+1,wells[i]));

        Collections.sort(pipe,(ArrayList<Integer>a,ArrayList<Integer>b)->{
            return a.get(2)-b.get(2);
        });
        int count=0;
        for(ArrayList<Integer>arr:pipe){
            int p1=findparent(arr.get(0));
            int p2=findparent(arr.get(1));
            if(p1!=p2){
                mergeset(p1,p2);
                count+=arr.get(2);
            }
        }
        System.out.print(count);
    }

    public static class dpair{
        int src=0;
        int par=0;
        int w=0;
        int wsf=0;
        dpair(int src,int par,int w,int wsf){
            this.src=src;
            this.par=par;
            this.w=w;
            this.wsf=wsf;
        }
        dpair(int src,int par,int w){
            this.src=src;
            this.par=par;
            this.w=w;
        }
    }
    
   
  
    public static void dijkstra(int src){
      PriorityQueue<dpair>que=new PriorityQueue<>((dpair a,dpair b)->{
            return a.wsf-b.wsf;
          });
      ArrayList<edge>dijkstragraph[]=new ArrayList[N];
      for(int i=0;i<N;i++)
      dijkstragraph[i]=new ArrayList<edge>();

        que.add(new dpair(src,-1,0,0));
        boolean[]vis=new boolean[N];
        
        while(que.size()!=0){
            dpair rvtx=que.remove();
            
            if(vis[rvtx.src])
            continue;
            if(rvtx.par!=-1)
            addedge(dijkstragraph,rvtx.src,rvtx.par,rvtx.w);
            vis[rvtx.src]=true;
            for(edge e:graph[rvtx.src])
            if(!vis[e.v])
            que.add(new dpair(e.v,rvtx.src,e.w,rvtx.wsf+e.w));
        }
        display(dijkstragraph);
    }
    public static void prims(int src){
        PriorityQueue<dpair>que=new PriorityQueue<>((dpair a,dpair b)->{
              return a.w-b.w;
            });
        ArrayList<edge>primsgraph[]=new ArrayList[N];
        for(int i=0;i<N;i++)
    primsgraph[i]=new ArrayList<edge>();
  
          que.add(new dpair(src,-1,0));
          boolean[]vis=new boolean[N];
          
          while(que.size()!=0){
              dpair rvtx=que.remove();
              
              if(vis[rvtx.src])
              continue;
              if(rvtx.par!=-1)
              addedge(primsgraph,rvtx.src,rvtx.par,rvtx.w);
              vis[rvtx.src]=true;
              for(edge e:graph[rvtx.src])
              if(!vis[e.v])
              que.add(new dpair(e.v,rvtx.src,e.w));
          }
          display(primsgraph);
      }

      public static void bellmanford(ArrayList<edge>[] gp,int src){
          int n=graph.size();

          int[][]dp=new int[n][n+1];
          for(int i=0;i<n;i++){
              for(int j=0;j<n+1;j++)
              dp[i][j]=(int)1e8;
          }
          bool flag=false;
          for(int i=1;i<=n;i++){
              for(int j=0;j<n;j++)
              dp[j][i]=dp[j][i-1];

             for(ArrayList<edge>a:gp){
                int u=a.get(0);int v=a.get(1);int w=a.get(2);
                if(dp[u][i-1]==(int)1e8)
                continue;
                int temp=dp[v][i];
                dp[v][i]=Math.min(dp[v][i],(dp[u][i-1]+w));
                if(i==n && dp[v][i]!=temp)
                flag=true;
             }
          }
      }
      

    public static void main(String[]args){
        constructgraph();
       // union_find();
        // lexicographically_smallest_equivalent("leetcode","programs","sourcecode");
        int[]wells={1,2,2};
        int[][]pipe={{1,2,1},{2,3,1}};
        // optimise_water_distribution(3,wells,pipe);
        // int[][]arr={{0,1,4},{0,7,8},{1,7,11},{1,2,8},{7,6,1},{7,8,7},{2,8,2},{6,8,6},{5,6,2},{2,5,4},{2,3,7},{3,5,14},{3,4,9},{4,5,10}};
        // kruskal(arr);
       // dijkstra(0);
       prims(0);
    }
}