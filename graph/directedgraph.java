import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class directedgraph{
    public static void main(String []args){
        constructgraph();
      //  topologicalsort();
      // kahns();
    //    toposort_dfs2();
   kosaraju_SCC();
    }
    public static int N=8;
    public static ArrayList<Integer>[]graph;

    public static void display(){
        for(int i=0;i<graph.length;i++){
            System.out.print(i+"->");
            for(int ele:graph[i])
            System.out.print(ele+",");
            System.out.println();
        }
        System.out.println();

    }
    public static void constructgraph(){
        graph=new ArrayList[N];
        for(int i=0;i<N;i++)
        graph[i]=new ArrayList<Integer>();

        graph[7].add(5);
        graph[7].add(6);
        graph[5].add(4);
        graph[5].add(2);
        graph[6].add(4);
        graph[6].add(3);
        graph[2].add(1);
        graph[3].add(1);
        graph[1].add(0);

      //  display();
    }

   public static void topologicalsort(){
       boolean []vis=new boolean [N];
       ArrayList<Integer>arr=new ArrayList<>();
       for(int i=0;i<N;i++){
           if(!vis[i])
           toposort(i,arr,vis);
       }
       for(int i=arr.size()-1;i>=0;i--)
       System.out.println(arr.get(i));
   }
   public static void toposort(int src,ArrayList<Integer>arr,boolean[]vis){
       vis[src]=true;
       for(int e:graph[src]){
           if(!vis[e])
           toposort(e,arr,vis);
       }
       arr.add(src);
   }

   public static void kahns(){
    int[]indegree=new int[N];
    for(int i=0;i<N;i++){
        for(int e:graph[i])
        indegree[e]+=1;
    }
    LinkedList<Integer>que=new LinkedList<>();
    for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0)
        que.addLast(i);
    }
    ArrayList<Integer>ans=new ArrayList<>();
    while(que.size()!=0){
        int size=que.size();
        while(size-->0){
            int rvtx=que.removeFirst();
            ans.add(rvtx);

            for(int e:graph[rvtx])
                if(--indegree[e]==0)
                que.addLast(e);
            
        }
    }
    if(ans.size()==N)
    System.out.println(ans);
    else
    System.out.println("cycle");
   }


public static void toposort_dfs1(){
    boolean[]vis=new boolean[N];
    boolean[] cycle=new boolean[N];
    ArrayList<Integer>ans=new ArrayList<>();
    boolean res=false;
    for(int i=0;i<N;i++)
    if(!vis[i])
    res=res||toposort_1(i,vis,cycle,ans);

    if(!res)
    for(int i=N-1;i>=0;i--)
    System.out.println(ans.get(i));
    else
    System.out.print("cycle");
}
public static boolean toposort_1(int src,boolean[]vis,boolean[]cycle,ArrayList<Integer>ans){
   if(cycle[src])return true;
    if(vis[src])return false;

    vis[src]=true;
    cycle[src]=true;
    boolean res=false;

    for(int e:graph[src])
        res=res||toposort_1(e,vis,cycle,ans);
    
    cycle[src]=false;
    ans.add(src);
    return res;
}

public static void toposort_dfs2(){
    int[]vis=new int[N];
    ArrayList<Integer>ans=new ArrayList<>();
    boolean res=false;

    for(int i=0;i<N;i++)
    if(vis[i]==0)
    res=res||toposort_2(i,vis,ans);

    if(!res){
        Collections.reverse(ans);
    System.out.print(ans);
    // for(int i=N-1;i>=0;i--)
    // System.out.println(ans.get(i));
    }
    else
    System.out.print("cycle");
}
public static boolean toposort_2(int src,int[]vis,ArrayList<Integer>ans){
    if(vis[src]==1)return true;
    if(vis[src]==2)return false;

    vis[src]=1;
    boolean res=false;

    for(int e:graph[src])
        res=res||toposort_2(e,vis,ans);

        vis[src]=2;
        ans.add(src);
        return res;
}

public static void toposort_SCC(int src,boolean []vis,ArrayList<Integer>ans){
    vis[src]=true;
    for(int e:graph[src])
    if(!vis[e])
    toposort_SCC(e,vis,ans);
    ans.add(src);
}

public static int dfs_SCC(int src,boolean[]vis,ArrayList<Integer>aa,ArrayList<Integer>[]revgraph){
    int count=0;
vis[src]=true;
for(int e:revgraph[src])
if(!vis[e])
count+=dfs_SCC(e,vis,aa,revgraph);
aa.add(src);
return count+1;
}

public static void kosaraju_SCC(){
    boolean []vis=new boolean[graph.length];
    ArrayList<Integer>ans=new ArrayList<>();
    for(int i=0;i<N;i++)
    if(!vis[i])
    toposort_SCC(i,vis,ans);

    ArrayList<Integer>[]revgraph=new ArrayList[10];
    for(int i=0;i<N;i++)
    revgraph[i]=new ArrayList<>();
    for(int i=0;i<N;i++){
        for(int e:graph[i]){
            revgraph[e].add(i);
        }
    }
    vis=new boolean[N];

    for(int i=0;i<N;i++){
        if(!vis[i]){
            ArrayList<Integer>aa=new ArrayList<>();
        System.out.println(dfs_SCC(i,vis,aa,revgraph));
        System.out.println(aa);
        }
    }
}

}
