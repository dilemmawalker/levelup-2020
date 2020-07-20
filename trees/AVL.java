import java.util.ArrayList;
import java.util.LinkedList;
public class AVL{
    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        int hei=0;
        int bal=0;
        Node(int data){
            this.data=data;
            this.hei=hei;
            this.bal=bal;
        }
        Node(){
        }
    }
    public static Node constructBST(int[]arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node node=new Node(mid);
        node.left=constructBST(arr,si,mid-1);
        node.right=constructBST(arr,mid+1,ei);
        return getrotation(node);
    }

    public static Node ll(Node A){
        Node B=A.left;
        Node bkaright=B.right;

        B.right=A;
        A.left=bkaright;
        updateheightbalance(A);
        updateheightbalance(B);
        return B;
    }
    public static Node rr(Node A){
        Node B=A.right;
        Node bkaleft=B.left;

        B.left=A;
        A.right=bkaleft;
        updateheightbalance(A);
        updateheightbalance(B);
        return B;
    }
    public static Node lr(Node A){
        A.left=ll(A.left);
        return rr(A); 
    }
    public static Node rl(Node A){
        A.right=ll(A.right);
        return rr(A);
    }

    public static void updateheightbalance(Node node){
        int lh=node.left!=null?node.left.hei:-1;
        int rh=node.right!=null?node.right.hei:-1;
        node.bal=lh-rh;
        node.hei=Math.max(lh,rh)+1; 
    }

    public static Node getrotation(Node node){
        updateheightbalance(node);
        if(node.bal==2){
            if(node.left.bal==1){//ll
                return ll(node);
            }else{  //lr
               return lr(node);
            }
        }
        else if(node.bal==-2){
            if(node.right.bal==-1){//rr
                return rr(node);
            }else{//rl
                return rl(node);
            }
        }
        return node;
    }
    public static Node add_data(Node node,int data){
        if(node==null)return new Node(data);
        if(data<node.data)
        node.left=add_data(node.left,data);
        else
        node.right=add_data(node.right,data);
        return getrotation(node);
     }
     public static Node removedata(Node node,int data){
        if(node==null)return null;

        if(data<node.data)
        node.left=removedata(node.left,data);
        if(data>node.data)
        node.right=removedata(node.right,data);
        else{
            if(node.left==null||node.right==null){
                return node.left==null?node.right:node.left;
            }
            int max=maxele(node.left);
            node.data=max;
            node.left=removedata(node.left,max);
        }
        return getrotation(node);
    }
    public static int maxele(Node node){
        int max=0;
        while(node!=null){
            max=Math.max(node.data,max);
            node=node.right;
        }
        return max;
    }

    public static void display(Node node){
        if(node==null)return;
        String str="";
        str+=node.left!=null?node.left.data:".";
        str+="<-"+node.data+"->";
        str+=node.right!=null?node.right.data:".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static void main(String[]args){
        int[]arr={10,20,30,40,50,60,70,80,90,100,110,120,130};
        Node n=constructBST(arr,0,arr.length-1);
        add_data(n,25);
        add_data(n,28);
        add_data(n,29);
        add_data(n,26);
        display(n);
    }

}