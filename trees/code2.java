import java.util.ArrayList;
import java.util.LinkedList;

class code2{
    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(){
        }
        Node(int data){
            this.data=data;
        }
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static Node constructBST(int[]arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node node=new Node(arr[mid]);
        node.left=constructBST(arr,si,mid-1);
        node.right=constructBST(arr,mid+1,ei);
        return node;
    }

    public static void display(Node node){

        String str="";
        str+=(node.left!=null?node.left.data:".");
        str+="<-"+node.data+"->";
        str+=(node.right!=null?node.right.data:".");

        System.out.println(str);
        if(node.left!=null)
        display(node.left);
        if(node.right!=null)
        display(node.right);
     }
     //===========================max,min,find,height,size,LCA,swapping elements

     public static int height(Node node){
         if(node==null)return -1;
         return Math.max(height(node.left),height(node.right))+1;
     }
     public static int size(Node node){
         if(node==null)return 0;
         return size(node.left)+size(node.right)+1;
     }
     public static boolean find(Node node,int data){
         if(node==null)return false;
        if(node.data==data)
        return true;
        boolean res=false;
        if(data<node.data)res=res||find(node.left,data);
        else res=res||find(node.right,data);
        return res;
     }
     public static boolean find_itr(Node node,int data){
         while(node!=null){
             if(node.data==data)
             return true;
             if(data<node.data)node=node.left;
             else node=node.right;
         }
         return false;
     }
     public static int max_ele(Node node){
         int max=0;
         while(node!=null){
             max=node.data;
             node=node.right;
         }
         return max;
     }
     public static int min_ele(Node node){
         int min=10000000;
         while(node!=null){
             min=node.data;
             node=node.left;
         }
         return min;
     }

     public static int LCA(Node node,int a,int b){
        while(node!=null){
            if(node.data>=a && node.data<=b)return node.data;
            if(node.data>a && node.data>b)LCA(node.left,a,b);
            else LCA(node.right,a,b);
        }
        return -1;
     }

     public static ArrayList<Integer>ans=new ArrayList<>();
     public static void elements_in_range(Node node,int a,int b){
            if(node==null)return;
             if(node.data>=a && node.data<=b)
                ans.add(node.data);
             if(a<node.data && b<node.data)elements_in_range(node.left,a,b);
             else if(a>node.data && b>node.data)elements_in_range(node.right,a,b);
             else{
                elements_in_range(node.left,a,b);
                elements_in_range(node.right,a,b);
             }
     }
     public static class allsolution{
         int height=0;
         int size=0;
         boolean find=false;
         Node prev=null;
         Node pred=null;
         Node succ=null;
     }
     public static void allsol(Node node,int data,int level,allsolution pair){
         if(node==null)return;
         pair.size++;
         pair.height=Math.max(pair.height,level);
         pair.find=pair.find||node.data==data;

         if(node.data==data && pair.pred==null)pair.pred=pair.prev;
         if(pair.prev!=null && pair.prev.data==data && pair.succ==null)pair.succ=node;

         pair.prev=node;
         allsol(node.left,data,level+1,pair);
         allsol(node.right,data,level+1,pair);
     }
     public static void pred_suss(Node node,int data){
         Node pred=null;
         Node succ=null;
         while(node!=null){
             if(node.data==data){
                if(node.left==null)
                System.out.println("Predecessor: "+pred!=null?pred.data:-1);
                else{
                   pred=node.left;
                    while(pred.right!=null){
                         pred=pred.right;
                    }
                    System.out.println("Predecessor: "+pred!=null?pred.data:-1);
                }
                if(node.right==null)
                System.out.println("Successor: "+succ!=null?succ.data:-1);
                else{
                    succ=node.right;
                    while(succ.left!=null){
                        succ=succ.left;
                    }
                    System.out.println("Successor: "+succ!=null?succ.data:-1);
                }
                break;
             }
             else if(node.data<data){
                 succ=node;
                node=node.left;
             }
             else{
                pred=node;
                node=node.right;
             }
         }
     }
     public static int idx=0;
     public static Node BST_from_preorder(int[]arr,int ll,int rl){
         if(idx==arr.length||arr[idx]<ll||arr[idx]>rl)
         return null;

         Node node =new Node(arr[idx]);
         idx++;

         node.left=BST_from_preorder(arr,ll,arr[idx-1]);
         node.right=BST_from_preorder(arr,arr[idx-1],rl);
         return node;
     }

     public static int height_BST(int[]arr,int ll,int rl){
         if(idx==arr.length||arr[idx]<ll||arr[idx]>rl)return -1;

         idx++;
         int lh=height_BST(arr,ll,arr[idx-1]);
         int rh=height_BST(arr,arr[idx-1],rl);
         return Math.max(lh,rh)+1;
     }

     public static Node add_data(Node node,int data){
        if(node==null)return new Node(data);
        if(data<node.data)
        node.left=add_data(node.left,data);
        else
        node.right=add_data(node.right,data);
        return node;
     }
     public static int maxele(Node node){
         int max=0;
         while(node!=null){
             max=Math.max(node.data,max);
             node=node.right;
         }
         return max;
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
         return node;
     }
    
     public static void main(String[]args){

        int[]arr={10,20,30,40,50,60,70,80,90,100};
        Node n=constructBST(arr,0,arr.length-1);
        int[]ar={50,20,10,30,40,80,60,70,90,100};
        // display(n);
        // System.out.println(height(n));
        // System.out.println(size(n));
        // System.out.println(find_itr(n,70));
        // System.out.println(LCA(n,40,65));
        // elementst.println(ans);
        // System.out_in_range(n,40,59);
        // System.ou.println();
        // pred_suss(n,20);
    //    Node na= BST_from_preorder(ar,-100000,100000);
    //    display(na);
    //    int hei=height_BST(ar,-100000,100000);
    //    System.out.println(hei);
    // add_data(n,55);
    display(add_data(n,55));
     }
}