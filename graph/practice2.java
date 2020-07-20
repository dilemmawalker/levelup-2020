import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class practice2{
    public static int N=8;
    public static ArrayList<Integer>[]graph=new ArrayList[N];
    public static void construct(){
        for(int i=0;i<N;i++)
        graph[i]=new ArrayList<Integer>();

        graph[7].add(5);
        graph[7].add(6);
        graph[5].add(4);
        graph[6].add(4);
        graph[6].add(3);
        graph[5].add(2);
        graph[2].add(1);
        graph[3].add(1);
        graph[1].add(0);
    }
    public static void display(){
        for(int i=0;i<N;i++){
            System.out.print(i+"->");
            for(int e:graph[i])
            System.out.print(e+",");
            System.out.println();
        }
    }
    public static void toposort(){
        boolean[]vis=new boolean[N];
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<N;i++){
            if(!vis[i])
            topo_dfs(i,vis,ans);
        }
        Collections.reverse(ans);
        System.out.print(ans);
    }
    public static boolean khans_bfs(){
        int[]indegree=new int[N];
        for(int i=0;i<N;i++){
            for(int e:graph[i])
            indegree[e]++;
        }
        LinkedList<Integer>que=new LinkedList<>();
        for(int i=0;i<N;i++)
        if(indegree[i]==0)
        que.add(i);
        LinkedList<Integer>ans=new LinkedList<>();
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
        return true;
        else
        return false;

    }
    public static void khans_dfs(){
        int[]indegree=new int[N];
        for(int i=0;i<N;i++){
            for(int e:graph[i])
            indegree[e]++;
        }
        LinkedList<Integer>que=new LinkedList<>();
        for(int i=0;i<N;i++)
        if(indegree[i]==0)
        que.add(i);
        LinkedList<Integer>ans=new LinkedList<>();

        
    }
    public static void topo_dfs(int src,boolean[]vis,ArrayList<Integer>ans){
        vis[src]=true;
        for(int e:graph[src])
        if(!vis[e])
        topo_dfs(e,vis,ans);
        ans.add(src);
    }
    public static void main(String[]args){
        construct();
        display();
        // toposort();
        System.out.println(khans_bfs());
    }
}