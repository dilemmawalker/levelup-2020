import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class generic{
    public static class Node{
        int data=0;
        ArrayList<Node>childs=new ArrayList<>();
        Node(int data){
            this.data=data;
        }
        Node(){}
    }
    public static Node construct(int[]arr){
         Stack<Node> st=new Stack<>();
        st.add(new Node(arr[0]));
        int i=1;
        Node rvtx=null;
        while(st.size()!=0){
            if(arr[i]==-1){
            rvtx=st.pop();
            if(st.size()!=0)
            st.peek().childs.add(rvtx);
            }else
            st.push(new Node(arr[i])); 
            i++;
        }
        return rvtx;
    }
    public static void display(Node node){
        if(node==null)return;

        String str="";
        str+=node.data+"->";
        for(int i=0;i<node.childs.size();i++){
            str+=node.childs.get(i).data+" ";
        }
        System.out.println(str);
        for(int i=0;i<node.childs.size();i++){
           display(node.childs.get(i));
        }
    }
    public static void levelorder(Node node){
        LinkedList<Node>que=new LinkedList<>();
        que.addLast(node);
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                Node rvtx=que.removeFirst();
                System.out.print(rvtx.data+" ");

                for(Node child:rvtx.childs){
                    que.addLast(child);
                }
            }
            System.out.println();
        }
    }
    public static int height(Node node){
        if(node.childs.size()==0)return 0;

        int max=0;
        for(int i=0;i<node.childs.size();i++){
            max=Math.max(max,height(node.childs.get(i)));
        }
        return max+1;
    }
    public static int size(Node node){
        if(node.childs.size()==0)return 1;

        int s=0;
        for(Node child:node.childs){
            s+=size(child);
        }
        return s+1;
    }
    public static boolean find(Node node,int data){
        if(node.data==data)return true;
        boolean res=false;
        for(Node child:node.childs){
        res=res||find(child,data);
        }
        return res;
    }
    public static ArrayList<Integer>path=new ArrayList<>();
    public static boolean roottonodepath(Node node,int data){
        if(node.data==data){
            path.add(node.data);
            return true;
        }
        boolean res=false;
        for(Node child:node.childs){
            res=res||roottonodepath(child,data);
            if(res){
            path.add(node.data);
            return true;}
        }
        return res;
    }
    public static boolean ismirror(Node node1,Node node2){
        if(node1.childs.size()!=node2.childs.size()||node1.data!=node2.data)return false;
        boolean res=true;
        for(int i=0,j=node1.childs.size()-1;i<=node1.childs.size()-1;i++,j--){
           res=res && ismirror(node1.childs.get(i),node2.childs.get(j));
        }
        return res;
    }
    public static Node linearize(Node node){
        if(node.childs.size()==0)return node;
        int n=node.childs.size();
        Node lasttail=linearize(node.childs.get(n-1));
        for(int i=n-2;i>=0;i--){
            Node secondlasttail=linearize(node.childs.get(i));
            secondlasttail.childs.add(node.childs.remove(node.childs.size()-1));
           // node.childs.remove(node.childs.size()-1);
        }
        return lasttail;
    }
    public static void flattern(Node node){
        ArrayList<Node>nchilds=new ArrayList<>();
        for(Node child:node.childs){
            flattern(child);

            nchilds.add(child);
            for(Node ch:child.childs){
                nchilds.add(ch);
            }
            child.childs.clear();
        }
         //node.childs.clear();
         node.childs=nchilds;
    }
    public static void main(String[]args){
        int[]arr={10,20,30,-1,40,-1,50,-1,-1,60,70,-1,80,90,-1,100,-1,-1,110,-1,-1,120,130,-1,-1,-1};
        Node n=construct(arr);
       // display(n);
    //    levelorder(n);
    // System.out.print(height(n));
    // System.out.print(size(n));
    // System.out.print(find(n,90));
    // roottonodepath(n,100);
    // System.out.println(path);
        // linearize(n);
        flattern(n);
        display(n);
    }

}