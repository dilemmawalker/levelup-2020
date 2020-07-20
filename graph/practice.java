 import java.util.Scanner;
 import java.util.ArrayList;
 import java.util.LinkedList;

  public class practice{
      public static class edge{
          int v=0;
          int w=0;
          edge(int v,int w){
              this.v=v;
              this.w=w;
          }
      }
     public static int N=7;
      public static ArrayList<edge>[]graph; 

       public static void construct(){
        graph=new ArrayList[N];

         for(int i=0;i<N;i++)
         graph[i]=new ArrayList<edge>();

         addedge(0,1,10);
         addedge(1,2,10);
         addedge(2,3,40);
         addedge(0,3,10);
         addedge(3,4,2);
         addedge(4,5,2);
         addedge(4,6,3);
         addedge(5,6,8);
         addedge(2,5,1);

        // removeedge(3,4);
        // removevertex(3);

       }
       public static void addedge(int u,int v,int w){
           graph[u].add(new edge(v,w));
           graph[v].add(new edge(u,w));
       }

       public static void display(){
           for(int i=0;i<N;i++){
               System.out.print(i+" -> ");
               for(edge e:graph[i])
               System.out.print("("+e.v+","+e.w+") , ");
                System.out.println();
            }
       }
       public static void removeedge(int u,int v){
          for(int i=0;i<graph[u].size();i++)
          if(graph[u].get(i).v==v)
          graph[u].remove(i);

          for(int i=0;i<graph[v].size();i++)
          if(graph[v].get(i).v==u)
          graph[v].remove(i);
       }
       public static void removevertex(int v){
          for(int i=graph[v].size()-1;i>=0;i--){
              removeedge(graph[v].get(i).v,v);
          }
       }

       public static boolean haspath(int src,int dest,boolean[]vis){
        if(src==dest)
        return true;
        boolean res=false;
        vis[src]=true;
        for(edge e:graph[src])
            if(!vis[e.v])
            res=res||haspath(e.v,dest,vis);

            return res;      
       }

       public static int allpath(int src,int dest,int w,boolean[]vis,String ans){
        if(src==dest){
            System.out.println(ans+"->"+w);
        return 1;
        }
        int count=0;
        vis[src]=true;
        for(edge e:graph[src])
            if(!vis[e.v])
           count+=allpath(e.v,dest,w+e.w,vis,ans+e.v+" ");

           vis[src]=false;
            return count;      
       }
       public static int heavy=0;
       public static int light=(int)1e8;
       public static int floor=0;
       public static int ceil=(int)1e8;
       public static int data=30;

    public static int allpossiblepath(int src,int dest,int w,boolean[]vis,String ans){
        if(src==dest){
            heavy=Math.max(heavy,w);
            light=Math.min(light,w);
            if(w<data)
            floor=Math.max(floor,w);
            if(w>data)
            ceil=Math.min(ceil,w);
            System.out.println(ans+"->"+w);
        return 1;
        }
        int count=0;
        vis[src]=true;
        for(edge e:graph[src])
            if(!vis[e.v])
           count+=allpossiblepath(e.v,dest,w+e.w,vis,ans+e.v+" ");

           vis[src]=false;
            return count;      
       }
       public static void hamiltonian(int src,boolean[]vis,int count,String ans,int isrc){
            if(count==N){
               System.out.println("path "+ans); 
               for(edge e:graph[src])
               if(e.v==isrc)
                   System.out.println("cycle "+ans); 
                        return; 
            }
            vis[src]=true;
            for(edge e:graph[src])
            if(!vis[e.v])
            hamiltonian(e.v,vis,count+1,ans+e.v+" ",isrc);
           vis[src]=false;
            return;
       }
       public static class pair{
           int val=0;
           String str="";
           int level=0;
           pair(int val,String str){
               this.val=val;
               this.str=str;
           }
           pair(int val,String str,int level){
               this.val=val;
               this.str=str;
               this.level=level;
           }
       }

       public static void bfs(int src,boolean[]vis,int dest){
           LinkedList<pair>que=new LinkedList<>();
           que.push(new pair(src,src+""));
           while(que.size()!=0){
               pair rvtx=que.removeFirst();

               if(vis[rvtx.val]){
                   System.out.println("cycle"+rvtx.str);
                   continue;
               }
               if(rvtx.val==dest)
               System.out.println("destination"+rvtx.str);
               vis[rvtx.val]=true;
               for(edge e:graph[rvtx.val]){
                   if(!vis[e.v])
                   que.addLast(new pair(e.v,rvtx.str+e.v+""));
               }
           }
       }

       public static int bfs_2(int src,boolean[]vis,int dest){
        LinkedList<pair>que=new LinkedList<>();
        int level=0;
        que.addLast(new pair(src,src+""));
        que.addLast(null);
        while(que.size()!=1){
            pair rvtx=que.removeFirst();
            if(rvtx==null){
                level++;
                que.addLast(null);
                continue;
            }

            if(vis[rvtx.val]){
                System.out.println("cycle"+rvtx.str);
                continue;
            }
            if(rvtx.val==dest)
            System.out.println("destination"+rvtx.str);
            vis[rvtx.val]=true;
            for(edge e:graph[rvtx.val]){
                if(!vis[e.v])
                que.addLast(new pair(e.v,rvtx.str+e.v+""));
            }
        }
        return level;
    }
    public static void bfs_3(int src,boolean[]vis,int dest){
        LinkedList<pair>que=new LinkedList<>();
        que.addLast(new pair(src,src+"",1)); 
        while(que.size()!=0){
            pair rvtx=que.removeFirst();

            if(vis[rvtx.val]){
                System.out.println("cycle"+rvtx.str);
                continue;
            }
            if(rvtx.val==dest)
            System.out.println("destination"+rvtx.str+" "+rvtx.level);
            vis[rvtx.val]=true;
            for(edge e:graph[rvtx.val]){
                if(!vis[e.v])
                que.addLast(new pair(e.v,rvtx.str+e.v+"",rvtx.level+1));
            }
        }
    }
    public static void bfs_4(int src,boolean[]vis,int dest){
        LinkedList<Integer>que=new LinkedList<>();
        que.add(src);
        int level=0;
        int cycle=0;
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int rvtx=que.removeFirst();
                if(vis[rvtx]){
                    cycle++;
                    System.out.println("cycle"+cycle);
                    continue;
                }
                if(rvtx==dest)
                System.out.println("destination"+level);
                vis[rvtx]=true;
                for(edge e:graph[rvtx]){
                    if(!vis[e.v])
                    que.add(e.v);
                }
            }
            level++;
        }

    }

     
      public static void main(String []args){
        construct();
        // display();

        boolean []vis=new boolean[N];
        // System.out.println(allpossiblepath(0,6,0,vis,0+" "));
        // System.out.print(heavy+" "+light+" "+ceil+" "+floor);
        // hamiltonian(0,vis,1,0+" ",0);
        // bfs(0,vis,6);
        // System.out.println(bfs_2(0,vis,6));
        bfs_4(0,vis,6);
    }
  }