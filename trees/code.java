
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class code{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
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
     public static int size(Node node){
         if(node==null)return 0;
         return (size(node.left)+size(node.right)+1);
     }
     public static int height(Node node){
        if(node==null)return 0;
        return (Math.max(height(node.left),height(node.right))+1);
     }
     public static int max_data(Node node){
         if(node==null)return (int)-1e8;
         return Math.max(node.data,Math.max(max_data(node.left),max_data(node.right)));
     }
     public static int min_data(Node node){
        if(node==null)return (int)1e8;
        return Math.min(node.data,Math.min(min_data(node.left),min_data(node.right)));
    }
    public static boolean find(Node node,int data){
        if(node==null)return false;
        if(node.data==data)
        return  true;
        return find(node.left,data)||find(node.right,data);
    }
     public static boolean roottonodepath(Node node,int data,ArrayList<Node>path){
        if(node==null)return false;
        if(node.data==data){
            path.add(node);
            return true;
        }
        boolean res=roottonodepath(node.left,data,path)||roottonodepath(node.right,data,path);
        if(res)
        path.add(node);
        return res;
     }
     public static ArrayList<Node>roottonodepath_2(Node node,int data){
        ArrayList<Node>path=new ArrayList<>();
        if(node==null)return path;
        if(node.data==data){
            path.add(node);
            return path;
        }
        path=roottonodepath_2(node.left,data);
        if(path.size()!=0){
            path.add(node);
            return path;
        }
        path=roottonodepath_2(node.right,data);
        if(path.size()!=0){
            path.add(node);
            return path;
        }
        return new ArrayList<Node>();
     }

     public static Node LCA(Node root,Node p,Node q){
        ArrayList<Node>a=roottonodepath_2(root,p.data);
        ArrayList<Node>b=roottonodepath_2(root,q.data);
        Node prev=a.get(a.size()-1);
        int a1=a.size()-1;
        int a2=b.size()-1;
        while(a1>=0 && a2>=0){
            if(a.get(a1).data!=b.get(a2).data)
            break;
            prev=a.get(a1);
            a1--;
            a2--;
        }
        return prev;
     }


     public static Node LCAnode=null;
     public static boolean LCA_2(Node root,int p,int q){
        if(root==null)return false;
        boolean selfdone=false;
        if(root.data==p|| root.data==q){
            selfdone=true;
        }
        boolean leftdone=LCA_2(root.left,p,q);
        if(LCAnode!=null)
        return true;
        boolean rightdone=LCA_2(root.right,p,q);
        if(LCAnode!=null)
        return true;
        if((selfdone && leftdone)||(selfdone && rightdone)||(leftdone && rightdone))
        LCAnode=root;

        return leftdone||rightdone||selfdone;
     }

     public List<Integer>ans;
    //  public List<Integer> distanceK_1(TreeNode root, TreeNode target, int K) {
    //      ans=new ArrayList<Integer>();
    //      ArrayList<TreeNode>a=new ArrayList<TreeNode>();
    //      roottonodepath(root,target.val,a);
    //      TreeNode n=null;
    //      for(int i=0;i<a.size();i++){
    //          if(K-i<0)break;
    //          kdown(a.get(i),K-i,n);
    //          n=a.get(i);
    //      }
    //      return ans;
    //  }
    //  public boolean roottonodepath_(TreeNode node,int val,ArrayList<TreeNode>a){
    //      if(node==null)return false;
    //      if(node.val==val){
    //          a.add(node);
    //          return true;
    //      }
    //      boolean res=roottonodepath_(node.left,val,a)||roottonodepath_(node.right,val,a);
    //      if(res)
    //          a.add(node);
    //      return res;
    //  }
     
    //  public void kdown(TreeNode node,int level,TreeNode block){
    //      if(node==null||node==block)
    //          return;
    //      if(level==0){
    //          ans.add(node.val);
    //          return;
    //      }
    //      kdown(node.left,level-1,block);
    //      kdown(node.right,level-1,block);
    //  }

    //  public int allknodeaway_2(TreeNode node,int K,int data){
        
    //     if(node==null)return -1;
    //         if(node.val==data){
    //             kdown(node,K,null);
    //             return 1;
    //         }
    //         int left=allknodeaway_2(node.left,K,data);
    //             if(left!=-1){
    //                 if(K-left>=0)
    //                 kdown(node,K-left,node.left);
    //                 return left+1;
    //             }
    //         int right=allknodeaway_2(node.right,K,data);
    //         if(right!=-1){
    //             if(K-right>=0)
    //             kdown(node,K-right,node.right);
    //             return right+1;
    //         }
    //         return -1;
            
    //     }

        // public int allknodeaway_3(TreeNode node,int K,int data){
        
        //     if(node==null)return -1;
        //         if(node.val==data){
        //             kdown(node,K,null);
        //             return 1;
        //         }
        //         int left=allknodeaway_3(node.left,K,data);
        //             if(left!=-1){
                       
        //                     if(K-left==0)
        //                         ans.add(node.val);
        //                 else  if(K-left-1>=0)
        //                 kdown(node.right,K-left-1,null);
        //                 return left+1;
        //             }
        //         int right=allknodeaway_3(node.right,K,data);
        //         if(right!=-1){
                    
        //                 if(K-right==0)
        //                     ans.add(node.val);
        //             else if(K-right-1>=0)
        //             kdown(node.left,K-right-1,null);
        //             return right+1;
        //         }
        //         return -1;              
        //     }

            public static int diameter_1(Node node){
                if(node==null)return 0;
                int ld=diameter_1(node.left);
                int rd=diameter_1(node.right);

                int lh=height(node.left);
                int rh=height(node.right);
                int max=Math.max(lh+rh+2,Math.max(ld,rd));
                return max;
            }
            public static class dpair{
                int dia=0;
                int hei=0;
                dpair(int dia,int hei){
                    this.dia=dia;
                    this.hei=hei;
                }
            }
            public static dpair diameter_2(Node node){
                if(node==null)return new dpair(0,-1);

                dpair left=diameter_2(node.left);
                dpair right=diameter_2(node.right);

                dpair myans=new dpair(0,-1);
                myans.dia=Math.max(Math.max(left.hei,right.hei),left.dia+right.dia+2);
                myans.hei=Math.max(left.hei,right.hei)+1;
                return myans;
            }
            public static int dia=-100000;
            public static int diameter_3(Node node){
                if(node==null)return -1;

                int lh=diameter_3(node.left);
                int rh=diameter_3(node.right);

                dia=Math.max(dia,lh+rh+2);
                return Math.max(lh,rh)+1;
            }

            
            public static void levelorder_1(Node  root){
                LinkedList<Node>que=new LinkedList<>();
                que.add(root);
                while(que.size()!=0){
                    Node rvtx=que.removeFirst();
                    System.out.println(rvtx.data);
                   if(rvtx.left!=null) que.add(rvtx.left);
                   if(rvtx.right!=null) que.add(rvtx.right);
                }
            }
            public static void levelorder_2(Node node){
                LinkedList<Node>pque=new LinkedList<>();
                LinkedList<Node>cque=new LinkedList<>();
                int count=0;
                System.out.print("Level: "+count+"->");
                pque.add(node);
                while(pque.size()!=0){
                    Node rvtx=pque.removeFirst();
                    System.out.print(rvtx.data+" ");
                    if(rvtx.left!=null)cque.addLast(rvtx.left);
                    if(rvtx.right!=null)cque.addLast(rvtx.right);

                    if(pque.size()==0){
                        LinkedList<Node>temp=new LinkedList<>();
                        temp=pque;
                        pque=cque;
                        cque=temp;
                        count++;
                        System.out.print("\nLevel: "+count+"->");
                    }
                }
            }

            public static void levelorder_3(Node node){
                LinkedList<Node>que=new LinkedList<>();
                que.add(node);
                que.add(null);
                int count=0;
                System.out.print("Level: "+count+"->");
                while(que.size()!=1){
                    Node rvtx=que.removeFirst();
                    if(rvtx.left!=null)que.add(rvtx.left);
                    if(rvtx.right!=null)que.add(rvtx.right);

                    System.out.print(rvtx.data+" ");

                    if(que.getFirst()==null){
                        que.addLast(que.removeFirst());
                        count++;
                        System.out.print("\nLevel: "+count+"->");
                    }
                }
            }

            public static void levelorder_4(Node node){
                LinkedList<Node>que=new LinkedList<>();
                que.add(node);
                int count=0;
                while(que.size()!=0){
                    int size=que.size();
                    System.out.print("\nLevel: "+count+"->");
                    count++;
                    while(size-->0){
                        Node rvtx=que.removeFirst();
                        if(rvtx.left!=null)que.add(node.left);
                        if(rvtx.right!=null)que.add(node.right);
                        System.out.print(rvtx.data);
                    }
                }
            }

            public static void leftview(Node root){
                LinkedList<Node>que=new LinkedList<>();
                que.addLast(root);
                while(que.size()!=0){
                    System.out.println(que.getFirst().data+" ");
                    int size=que.size();
                    while(size-->0){
                        Node rvtx=que.removeFirst();
                        if(rvtx.left!=null)que.add(rvtx.left);
                        if(rvtx.right!=null)que.add(rvtx.right);
                    }
                }
            }
            public static void rightview(Node root){
                LinkedList<Node>que=new LinkedList<>();
                que.addLast(root);
                while(que.size()!=0){
                    int size=que.size();
                    Node rvtx=null;
                    
                    while(size-->0){
                        rvtx=que.removeFirst();
                        if(rvtx.left!=null)que.addLast(rvtx.left);
                        if(rvtx.right!=null)que.addLast(rvtx.right);
                    }
                    System.out.println(rvtx.data);
                }
            }
            public static class pairvo implements Comparable<pairvo>{
                Node node=null;
                int vl=0;
                pairvo(Node node,int vl){
                    this.node=node;
                    this.vl=vl;
                }
                @Override
                public int compareTo(pairvo o){
                    if(this.vl==o.vl)
                    return this.node.data-o.node.data;
                    return this.vl-o.vl;
                }
            }
            public static int leftminvalue=0;
            public static int rightmaxvalue=0;

            public static void width(Node node,int level){
                leftminvalue=Math.min(leftminvalue,level);
                rightmaxvalue=Math.max(rightmaxvalue,level);

                if(node.left!=null)width(node.left,level-1);
                if(node.right!=null)width(node.right,level+1);
            }

            public static void verticalorder(Node node){
                width(node,0);
                int n=rightmaxvalue-leftminvalue+1;
                ArrayList<Integer>[]ans=new ArrayList[n];
                for(int i=0;i<n;i++)
                ans[i]=new ArrayList<Integer>();

                LinkedList<pairvo>que=new LinkedList<>();
                que.addLast(new pairvo(node,-leftminvalue));

                while(que.size()!=0){
                    int size=que.size();
                    while(size-->0){
                        pairvo rvtx=que.removeFirst();
                        ans[rvtx.vl].add(rvtx.node.data);
                        if(rvtx.node.left!=null)que.add(new pairvo(rvtx.node.left,rvtx.vl-1));
                        if(rvtx.node.right!=null)que.add(new pairvo(rvtx.node.right,rvtx.vl+1));
                    }
                }
                for(int i=0;i<n;i++)
                System.out.println(ans[i]);
            }
            public static void bottomview(Node node){
                width(node,0);
                int n=rightmaxvalue-leftminvalue+1;
                int[]ans=new int[n];
                LinkedList<pairvo>que=new LinkedList<>();
                que.addLast(new pairvo(node,-leftminvalue));

                while(que.size()!=0){
                    int size=que.size();
                    while(size-->0){
                        pairvo rvtx=que.removeFirst();
                        ans[rvtx.vl]=rvtx.node.data;
                        if(rvtx.node.left!=null)que.add(new pairvo(rvtx.node.left,rvtx.vl-1));
                        if(rvtx.node.right!=null)que.add(new pairvo(rvtx.node.right,rvtx.vl+1));
                    }
                }
                for(int i=0;i<n;i++)
                System.out.println("Level: "+ans[i]);
            }

            public static void topview(Node node){
                width(node,0);
                int n=rightmaxvalue-leftminvalue+1;
                int[]ans=new int[n];
                LinkedList<pairvo>que=new LinkedList<>();
                que.addLast(new pairvo(node,-leftminvalue));
                Arrays.fill(ans,(int)-1e8);

                while(que.size()!=0){
                    int size=que.size();
                    while(size-->0){
                        pairvo rvtx=que.removeFirst();
                        if(ans[rvtx.vl]==(int)-1e8)
                        ans[rvtx.vl]=rvtx.node.data;
                        if(rvtx.node.left!=null)que.add(new pairvo(rvtx.node.left,rvtx.vl-1));
                        if(rvtx.node.right!=null)que.add(new pairvo(rvtx.node.right,rvtx.vl+1));
                    }
                }
                for(int i=0;i<n;i++)
                System.out.println("Level: "+ans[i]);
            }

           public static void diagonalview(Node node){
                width(node,0);
                int n=rightmaxvalue-leftminvalue+1;
                ArrayList<Integer>[]ans=new ArrayList[n];
                for(int i=0;i<n;i++)
                ans[i]=new ArrayList<Integer>();
                LinkedList<pairvo>que=new LinkedList<>();
                que.add(new pairvo(node,-leftminvalue));
                while(que.size()!=0){
                    int size=que.size();
                    while(size-->0){
                        pairvo rvtx=que.removeFirst();
                        ans[rvtx.vl].add(rvtx.node.data);
                        if(rvtx.node.left!=null)que.add(new pairvo(rvtx.node.left,rvtx.vl-1));
                        if(rvtx.node.right!=null)que.add(new pairvo(rvtx.node.right,rvtx.vl+0));
                    }
                }
                for(int i=0;i<n;i++)
                System.out.println("Level: "+i+" "+ans[i]);

           }

            public static void antidiagonalview(Node node){
                width(node,0);
                int n=rightmaxvalue-leftminvalue+1;
                ArrayList<Integer>[]ans=new ArrayList[n];
                for(int i=0;i<n;i++)
                ans[i]=new ArrayList<Integer>();

                LinkedList<pairvo>que=new LinkedList<>();
                que.addLast(new pairvo(node,-leftminvalue));

                while(que.size()!=0){
                    int size=que.size();
                    while(size-->0){
                        pairvo rvtx=que.removeFirst();
                        ans[rvtx.vl].add(rvtx.node.data);
                        if(rvtx.node.left!=null)que.add(new pairvo(rvtx.node.left,rvtx.vl+0));
                        if(rvtx.node.right!=null)que.add(new pairvo(rvtx.node.right,rvtx.vl+1));
                    }
                }
                for(int i=0;i<n;i++)
                System.out.println(ans[i]);
            }

            public static void verticaltraversal_1(Node node){
                width(node,0);
                int n=rightmaxvalue-leftminvalue+1;
                ArrayList<Integer>[]ans=new ArrayList[n];
                for(int i=0;i<n;i++)
                ans[i]=new ArrayList<Integer>();

                PriorityQueue<pairvo>que1=new PriorityQueue<>();
                PriorityQueue<pairvo>que2=new PriorityQueue<>();
                que1.add(new pairvo(node,-leftminvalue));
                while(que1.size()!=0){
                    int size=que1.size();
                    while(size-->0){
                        pairvo rvtx=que1.remove();
                        ans[rvtx.vl].add(rvtx.node.data);
                        if(rvtx.node.left!=null)que2.add(new pairvo(rvtx.node.left,rvtx.vl-1));
                        if(rvtx.node.right!=null)que2.add(new pairvo(rvtx.node.right,rvtx.vl+1));
                        if(que1.size()==0){
                            PriorityQueue<pairvo>temp=que1;
                            que1=que2;
                            que2=temp;
                        }
                    }
                }
                for(int i=0;i<n;i++)
                System.out.println(ans[i]);
            }
            public static class pairvo2 implements Comparable<pairvo2>{
                Node node;
                int vl=0;
                int hl=0;
                pairvo2(Node node,int vl,int hl){
                    this.node=node;
                    this.vl=vl;
                    this.hl=hl;
                }
                @Override
                public int compareTo (pairvo2 o){
                    if(this.hl==o.hl){
                        if(this.vl==o.vl)
                        return this.node.data-o.node.data;
                        else
                        return this.vl-o.vl;
                    }
                    else
                    return this.hl-o.hl;
                }
            }

            public static void verticaltraversal_2(Node node){
                width(node,0);
                int n=rightmaxvalue-leftminvalue+1;
                ArrayList<Integer>[]ans=new ArrayList[n];
                for(int i=0;i<n;i++)
                ans[i]=new ArrayList<Integer>();
                PriorityQueue<pairvo2>que=new PriorityQueue<>();
                que.add(new pairvo2(node,-leftminvalue,0));
                while(que.size()!=0){
                    int size=que.size();
                    while(size-->0){
                        pairvo2 rvtx=que.remove();
                        ans[rvtx.vl].add(rvtx.node.data);
                        if(rvtx.node.left!=null)que.add(new pairvo2(rvtx.node.left,rvtx.vl-1,rvtx.hl+1));
                        if(rvtx.node.right!=null)que.add(new pairvo2(rvtx.node.right,rvtx.vl+1,rvtx.hl+1));
                    }
                }
                for(int i=0;i<n;i++)
                System.out.println(ans[i]);
            }
            public static Node head=null;
            public static Node prev=null;

            public static void dll(Node node){

                if(node.left!=null)dll(node.left);

                if(head==null)head=node;
                else{
                    prev.right=node;
                    node.left=prev;
                }
                prev=node;

                if(node.right!=null)dll(node.right);
            }

            public static void dll_display(Node node){
                dll(node);
                while(head!=null){
                    System.out.print(head.data+" ");
                    head=head.right;
                }
            }

            public static void linearize(Node node){

                if(head==null)head=node;
                else{
                    prev.right=node;
                   // node.left=prev;
                }
                prev=node;
                if(node.left!=null) linearize(node.left);

                if(node.right!=null)linearize(node.right);          
            }

            public static void linearize_display(Node node){
                linearize(node);
                while(head!=null){
                    System.out.print(head.data+" ");
                    head=head.right;
                }
            }


     public static void main(String []args){
        int[]arr={10,20,40,-1,-1,50,-1,-1,30,60,80,-1,-1,-1,70,-1,-1};
        Node n=constructtree(arr);
        //display(n);
        ArrayList<Node >path=new ArrayList<Node>();
        //roottonodepath();
        // diameter_3(n);
        // System.out.print(dia);
        // levelorder_1(n);
        // levelorder_2(n);
        // levelorder_3(n);
        // rightview(n);
        // verticalorder(n);
        // bottomview(n);
        // diagonalview(n);
        // antidiagonalview(n);
        // verticaltraversal_2(n);
        // dll_display(n);
        linearize_display(n);
     }
}