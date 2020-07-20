import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Scanner;
public class code3{
    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(int data){
            this.data=data;
        }
        Node(){}
    }
    public static class tpair{
        Node node=null;
        boolean selfdone=false;
        boolean leftdone=false;
        boolean rightdone=false;
        int ldata=-1;
        int rdata=-1;
        int selfdata=-1;
        boolean isleft=false;
        tpair(Node node,boolean selfdone,boolean leftdone,boolean rightdone,boolean thisleft){
            this.node=node;
            this.selfdone=selfdone;
            this.leftdone=leftdone;
            this.rightdone=rightdone;
            this.isleft=isleft;
        }
        tpair(Node node,boolean selfdone,boolean leftdone,boolean rightdone){
            this.node=node;
            this.selfdone=selfdone;
            this.leftdone=leftdone;
            this.rightdone=rightdone;
        }
    }
    public static void iterative_traversal(Node node){
        Stack<tpair>st=new Stack<>();
        st.add(new tpair(node,false,false,false));
        while(st.size()!=0){
            if(st.peek().selfdone==false){
                st.peek().selfdone=true;
                System.out.print(st.peek().node.data+" ");
            }
            else if(st.peek().leftdone==false){
                st.peek().leftdone=true;
                if(st.peek().node.left!=null)
                st.add(new tpair(st.peek().node.left,false,false,false));
            }
            else if(st.peek().rightdone==false){
                st.peek().rightdone=true;
                if(st.peek().node.right!=null)
                st.add(new tpair(st.peek().node.right,false,false,false));
            }
            else{
                st.pop();
            }
        }
    }
    public static void iterative_height_of_tree(Node node){
        Stack<tpair>st=new Stack<>();
        st.add(new tpair(node,false,false,false,false));
        tpair rpair=null;
        while(st.size()!=0){          
             if(st.peek().leftdone==false){
                st.peek().leftdone=true;
                if(st.peek().node.left!=null)
                st.add(new tpair(st.peek().node.left,false,false,false,true));
            }
            else if(st.peek().rightdone==false){
                st.peek().rightdone=true;
                if(st.peek().node.right!=null)
                st.add(new tpair(st.peek().node.right,false,false,false,false));
            }
            else if(st.peek().selfdone==false){
                st.peek().selfdone=true;
                st.peek().selfdata=Math.max(st.peek().ldata,st.peek().rdata)+1;
                //System.out.print(st.peek().node.data+" ");
            }
            else{
                rpair=st.pop();
                if(st.size()!=0){
                if(st.peek().isleft)
                st.peek().ldata=rpair.selfdata;
                else
                st.peek().rdata=rpair.selfdata;
                }
            }
        }
        System.out.println(rpair.node.data);
    }
    public static void morris_in_order(Node node){
        Node curr=null;
       while(node!=null){
           if(node.left!=null){
               curr=node.left;
               while(curr.right!=null && curr.right!=node){
                   curr=curr.right;
               }
               if(curr.right==null){
                   curr.right=node;
                   node=node.left;
               }
               else{
                   curr.right=null;
                    System.out.print(node.data+" ");
                   node=node.right;
               }
           }else{
               System.out.print(node.data+" ");
               node=node.right;
        }
       }
    }
    public static void morris_pre_order(Node node){
        Node curr=null;
        while(node!=null){
            if(node.left!=null){
                curr=node.left;
                while(curr.right!=null && curr.right!=node){
                    curr=curr.right;
                }
                if(curr.right==null){
                    curr.right=node;
                    System.out.print(node.data+" ");
                    node=node.left;
                }else{
                    curr.right=null;
                    node=node.right;
                }
            }else{
                System.out.print(node.data+" ");
                node=node.right;
            }
        }
    }
    public static Node construct_from_pre_and_in(int[]pre,int psi,int pei,int[]in,int isi,int iei){
        if(psi>pei||isi>iei)return null; 

        Node node=new Node(pre[psi]);
        int idx=0;
        while(pre[psi]!=in[idx]){
            idx++;
        }
        int tnel=idx-isi;

        node.left=construct_from_pre_and_in(pre,psi+1,psi+tnel,in,isi,idx-1);
        node.right=construct_from_pre_and_in(pre,psi+tnel+1,pei,in,idx+1,iei);

        return node;
    }
    public static Node construct_from_post_and_in(int[]post,int psi,int pei,int[]in,int isi,int iei){
        if(psi>pei||isi>iei)return null;

        Node node=new Node(in[pei]);
        int idx=isi;
        while(post[psi]!=in[idx])
        idx++;
        int tnel=idx-isi;

       node.left=construct_from_post_and_in(post,psi,pei+tnel-1,in,isi,idx-1);
       node.right=construct_from_post_and_in(post,psi+tnel,pei-1,in,idx+1,iei);
        return node;
    }
    public static Node construct_from_pre_and_post(int[]pre,int psi,int pei,int[]post,int ppsi,int ppei){
        if(psi>pei||ppsi>ppei)return null;
        if(psi==pei)
        return new Node(pre[psi]);

        Node node=new Node(pre[psi]);
        int idx=ppsi;
        while(pre[psi+1]!=post[idx])
        idx++;
        int tne=idx-ppsi+1;

        node.left=construct_from_pre_and_post(pre,psi+1,psi+tne,post,ppsi,idx);
        node.right=construct_from_pre_and_post(pre,psi+tne+1,pei,post,idx+1,ppei-1);
        return node;
    }
    public static int idx=0;
    public static Node constructtree(int[]arr){
        if(idx>=arr.length || arr[idx]==-1){
            idx++;
            return null;
        }
        Node node=new Node(arr[idx++]);
        node.left=constructtree(arr);
        node.right=constructtree(arr);

        return node;
    }
    public static void main(String[]args){
        int[]arr={10,20,40,-1,-1,50,-1,-1,30,60,80,-1,-1,-1,70,-1,-1};
        Node n=constructtree(arr);
        // iterative_traversal(n);
        // iterative_height_of_tree(n);
        morris_pre_order(n);
    }
}