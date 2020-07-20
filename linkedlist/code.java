import java.util.Scanner;
public class code{
    public static class linkedlist{
        public class Node{
            int data=0;
            Node next=null;
            Node(int data){
                this.data=data;
            }
        }
        Node head=null;
        Node tail=null;
         int size=0;
         public int size(){
             return this.size;
         }
         public boolean isempty(){
             return size==0;
         }
         @Override
         public String toString(){
             Node curr=this.head;
             String str="";
             while(curr!=null){
                str+=curr.data+"->";
                curr=curr.next;
             }
             return str;
         }
         public Node getnodeat(int pos){
            Node curr=this.head;
            if(pos>size)return null;
            while(pos-->0){
                curr=curr.next;
            }
            return curr;
         }
         public void add_first_node(Node node){
             if(this.size==0){
                 this.head=node;
                 this.tail=node;
             }else{
                 node.next=this.head;
                 this.head=node;
             }
             this.size++;
         }
         public void addFirst(int data){
            add_first_node(new Node(data));
         }
         public void add_last_node(Node node){
            if(this.size==0){
                this.head=node;
                this.tail=node;
            }else{
                this.tail.next=node;
                this.tail=node;
            }
            this.size++;
         }
         public  void addLast(int data){
            add_last_node(new Node(data));
         }
         public  void add_at_node(Node node,int pos){
             if(pos==0)
             add_first_node(node);
             else if(pos==this.size)
             add_last_node(node);
             else{
            Node curr=this.head;
            while(pos-->1)
            curr=curr.next;
            Node temp=curr.next;
            curr.next=node;
            node.next=temp;
             }
         }
         public  void addAt(int data,int pos){
             if(pos<0||pos>0){
             System.out.println("NullPointerException");
             return;
            }
            add_at_node(new Node(data),pos);
         }
         public  void removeFirst(){
             if(this.size==0){
                 System.out.println("EmptyList");
                 return;
             }
             Node temp=this.head;
             if(this.size==1){
                 this.head=null;
                 this.tail=null;
             }else{
                 this.head=this.head.next;
                 temp.next=null;
             }
             this.size--;
         }
         public  void removeLast(){
             if(this.size==0){
                System.out.println("EmptyList");
                 return; 
             }
             else if(this.size==1){
                 this.head=null;
                 this.tail=null;
             }else{
                 Node secondlastnode=getnodeat(this.size()-2);
                 secondlastnode.next=null;
                 this.tail=secondlastnode;
             }
             this.size--;
         }
         public  void removeAt(int pos){
             if(pos<0||pos>=this.size){
                System.out.print("NullPointerException");
                return;
             }
             if(pos==0)
             removeFirst();
             else if(pos==this.size-1)
             removeLast();
             else{
                 Node prev=getnodeat(pos-1);
                 Node temp=prev.next;
                 prev.next=prev.next.next;
                 temp.next=null;
                 this.size--;
             }
         }
         public  int getFirst(){
             if(this.size==0){
                 System.out.print("EmptyList");
                 return;
             }
             else this.head.data;
         }
         public  int getLast(){
             if(this.size==0){
                System.out.print("EmptyList");
                return; 
             }
              return this.tail.data;
         }
         public  int getAt(int pos){
             if(pos>=this.size||pos<0){
                 System.out.print("NullPointerException");
                 return;
             }
             return getnodeat(pos).data;
         }
    }
    public static void main(String[]args){
        linkedlist ll=new linkedlist();
        for(int i=1;i<10;i++){
            ll.addFirst(i*10);
        }
        for(int i=1;i<10;i++){
            ll.addLast(i*10);
        }    
        System.out.println(ll);
    }
}