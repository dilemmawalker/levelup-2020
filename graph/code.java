import java.util.ArrayList;
import java.util.LinkedList;

public class code{
    public static class edge{
        int v=0;int w=0;
        edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    public static int N=7;  //N is no. of vertices
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
        addedge(graph,3,4,5);
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

    public static int findedge(ArrayList<edge>[]gp,int v1,int v2){
        int pos=-1;
        for(int i=0;i<gp[v1].size();i++){
            edge e=graph[v1].get(i);
            if(e.v==v2){
                pos=i;
                break;
            }
        }
        return pos;
    }
    public static void removeedge(ArrayList<edge>[]gp,int v1,int v2){
        int pos=findedge(gp,v1,v2);
        gp[v1].remove(pos);
         pos=findedge(gp,v2,v1);    
         gp[v2].remove(pos);
    }
    public static void removevertex(ArrayList<edge>[]gp,int v){
       for(int i=gp[v].size()-1;i>=0;i--){
           edge e=gp[v].get(i);
           removeedge(gp,v,e.v);          
       }
    }

    public static boolean haspath(ArrayList<edge>[]gp,int src,int dest,boolean[]vis){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        boolean res=false;
        for(edge e:gp[src]){
            if(!vis[e.v])
           res=res|| haspath(gp,e.v,dest,vis);
        }
        return res;
    }
    public static int allpath(ArrayList<edge>[]gp,int src,int dest,boolean[]vis,String ans,int wt){
        if(src==dest){
            System.out.println(ans+src+" @ "+wt);
            return 1;
        }
        vis[src]=true;
        int count=0;
        for(edge e:gp[src]){
            if(!vis[e.v])
           count+=allpath(gp,e.v,dest,vis,ans+src+" ",wt+e.w);
        }
        vis[src]=false;
        return count;
    }
    public static int heavyweight=0;
    public static int lightweight=1000000;
    public static int floor=0;
    public static int ceil=1000000;



    public static int allpossiblepath(ArrayList<edge>[]gp,int src,int dest,boolean[]vis,String ans,int wt,int data){
        if(src==dest){
            heavyweight=Math.max(heavyweight,wt);
            lightweight=Math.min(lightweight,wt);
            if(wt>data)
            ceil=Math.min(ceil,wt);
            if(wt<data)
            floor =Math.max(floor,wt);
           // System.out.println(ans+src+" @ "+wt);

            return 1;
        }
        vis[src]=true;
        int count=0;
        for(edge e:gp[src]){
            if(!vis[e.v])
           count+=allpossiblepath(gp,e.v,dest,vis,ans+src+" ",wt+e.w,data);
        }
        vis[src]=false;
        return count;
    }

 
    public static int hamiltonianpath(int src,int c,int osrc,boolean[]vis,String ans){
        if(c==N-1){
            System.out.println("Path: "+ans+src+" ");
            if(findedge(graph,osrc,src)!=-1){
            System.out.println("Cycle "+ans+src+" ");
            System.out.println();
            }
            return 1;
        }
        int count=0;
        vis[src]=true;
        for(edge e:graph[src]){
            if(!vis[e.v])
           count+= hamiltonianpath(e.v,c+1,osrc,vis,ans+src+" ");
        }
        vis[src]=false;
        return count;
    }

    public static int gcc_dfs(int src,boolean[]vis){

        vis[src]=true;
        int count=0;
        for(edge e:graph[src]){
            if(!vis[e.v])
         count+=gcc_dfs(e.v,vis);
        }
        return count+1;
    }
    public static int gcc(){
        boolean[]vis=new boolean[N];
        int max=0;
        int count=0;
        for(int i=0;i<N;i++){
            if(!vis[i]){
            max=Math.max(max,gcc_dfs(i,vis));
            count++;
            }
        }
        System.out.println(max);
        return count;
    }

    public static class pair{
        int vtx=0;
        String psf="";
        pair(int vtx,String psf){
            this.vtx=vtx;
            this.psf=psf;
        }
    }

    public static void BFS(int src,boolean []vis){
        int dest=6;
        LinkedList<pair>que=new LinkedList<>();

        que.addLast(new pair(src,src+""));
        while(que.size()!=0){
           pair rvtx=que.removeFirst();

           vis[rvtx.vtx]=true;
           for(edge e:graph[rvtx.vtx]){
               if(!vis[e.v])
               que.addLast(new pair(e.v,rvtx.psf+e.v));
           }
        }
    }

    public static void BFS_2(int src,boolean []vis){
        int dest=6;
        LinkedList<pair>que=new LinkedList<>();
        int cycle=0;

        que.addLast(new pair(src,src+""));
        while(que.size()!=0){
           pair rvtx=que.removeFirst();

           if(vis[rvtx.vtx]){
               cycle++;
               System.out.println("cycle:"+cycle+" "+rvtx.psf);
               continue;
           }
           if(rvtx.vtx==dest)
           System.out.println("destination : "+rvtx.psf);

           vis[rvtx.vtx]=true;
           for(edge e:graph[rvtx.vtx]){
               if(!vis[e.v])
               que.addLast(new pair(e.v,rvtx.psf+e.v));
           }
        }
    }

    public static void BFS_3(int src,boolean []vis){
        int dest=6;
        LinkedList<pair>que=new LinkedList<>();
        int cycle=0;
        int level=0;
        
        que.addLast(new pair(src,src+""));
        que.addLast(null);
        while(que.size()!=1){
           pair rvtx=que.removeFirst();

           if(vis[rvtx.vtx]){
               cycle++;
               System.out.println("cycle:"+cycle+" "+rvtx.psf);
               continue;
           }
           if(rvtx.vtx==dest)
           System.out.println("destination : "+rvtx.psf+"->"+level);

           vis[rvtx.vtx]=true;
           for(edge e:graph[rvtx.vtx]){
               if(!vis[e.v])
               que.addLast(new pair(e.v,rvtx.psf+e.v));
           }
           if(que.getFirst()==null){
               level++;
               que.addLast(que.removeFirst());
           }
        }
    }

   public static void BFS_4(int src,boolean []vis){
       LinkedList<Integer>que=new LinkedList<>();
       int cycle=0;
       int dest=6;
       int level=1;
       que.addLast(src);
       while(que.size()!=0){
        int size=que.size();
        while(size-->0){
            int rvtx=que.removeFirst();
            if(vis[rvtx]){
                cycle++;
                System.out.println("cycle "+cycle);
                continue;
            }
            if(rvtx==dest)
            System.out.println("destination "+level);

            vis[rvtx]=true;

            for(edge e:graph[rvtx]){
                if(!vis[e.v])
                que.push(e.v);
            }
        }
        level++;
       }
   }

    public static void BFS_5_no_cycle_required(int src,boolean []vis){
        LinkedList<Integer>que=new LinekdList<>();
        que.addLast(src);
        int dest=6;
        int level=0;
        vis[src]=true;

        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int rvtx=que.removeFirst();
                if(rvtx==dest)
                System.out.println("destination "+level);

                for(edge e:graph[rvtx]){
                    if(!vis[e.v]){
                        vis[e.v]=true;
                        que.addLast(e.v);
                    }
                }
            }
            level++;
        }
    }

   



    public static void main(String args[]){
        constructgraph();
        // boolean[]vis=new boolean[graph.length];
       // System.out.print(haspath(graph,0,6,vis));
        // System.out.println(allpossiblepath(graph,0,6,vis,"",0,20));
        // System.out.println(heavyweight+" "+lightweight+" "+ ceil+" "+floor);
       // for(int i=0;i<N;i++)
        // System.out.print(hamiltonianpath(0,0,0,vis,""));

        // System.out.print(gcc());
        boolean[]vis=new boolean [1000000];
        BFS_5_no_cycle_required(0,vis);
    }

}