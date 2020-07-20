import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class code{
    public static void main(String[]args){
        //mystack st=new mystack(10);

        // for(int i=1;i<=10;i++){
        //     st.push(i);
        // }
        // while(st.size()!=0){
        //     System.out.print(st.pop()+" ");
        // }
        //System.out.print(st.pop());
            int[]arr={9,8,7,6,5,10,3,11};
            next_smallest_right2left(arr);
    }
    public static class mystack{
        private int N=10000;
        private int[]arr;
        private int sz=0;
        private int tos=-1;

        mystack(){
            this.arr=new int[N];
        }
        mystack(int n){
            this.arr=new int[n];
            this.N=n;
        }
        public int size(){
            return this.sz;
        }
        public boolean empty(){
            return this.sz==0;
        }
        public void push(int val){
            if(this.sz==N)return;
            this.tos++;
            this.sz++;
            arr[tos]=val;
        }
        public int pop(){
            if(this.sz==0)return -1;
            int rev=arr[tos];
            arr[tos]=-1;
            this.tos--;
            this.sz--;
            return rev;
        }
        public int top(){
            if(this.sz==0)return -1;
            return arr[tos];
        }
    }
    public static void next_largest_left2right(int []arr){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++)
        ans[i]=-1;
        for(int i=0;i<n;i++){
            if(st.size()==0)
            st.push(i);
            else if(arr[st.peek()]>arr[i])
            st.push(i);
            else{
                while(st.size()!=0 && arr[st.peek()]<arr[i]){
                    ans[st.pop()]=i;
                }
                st.push(i);
            }
        }
        for(int i=0;i<n;i++)
        System.out.print(ans[i]+" ");
    }
    public static void next_largest_right2left(int []arr){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++)
        ans[i]=-1;
        for(int i=n-1;i>=0;i--){
            if(st.size()==0)
            st.push(i);
            else if(arr[st.peek()]>arr[i])
            st.push(i);
            else{
                while(st.size()!=0 && arr[st.peek()]<arr[i]){
                    ans[st.pop()]=i;
                }
                st.push(i);
            }
        }
        for(int i=0;i<n;i++)
        System.out.print(ans[i]+" ");
    }
    public static void next_smallest_left2right(int []arr){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++)
        ans[i]=-1;
        for(int i=0;i<n;i++){
            if(st.size()==0)
            st.push(i);
            else if(arr[st.peek()]<arr[i])
            st.push(i);
            else{
                while(st.size()!=0 && arr[st.peek()]>arr[i]){
                    ans[st.pop()]=i;
                }
                st.push(i);
            }
        }
        for(int i=0;i<n;i++)
        System.out.print(ans[i]+" ");
    }
    public static void next_smallest_right2left(int []arr){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++)
        ans[i]=-1;
        for(int i=n-1;i>=0;i--){
            if(st.size()==0)
            st.push(i);
            else if(arr[st.peek()]<arr[i])
            st.push(i);
            else{
                while(st.size()!=0 && arr[st.peek()]>arr[i]){
                    ans[st.pop()]=i;
                }
                st.push(i);
            }
        }
        for(int i=0;i<n;i++)
        System.out.print(ans[i]+" ");
    }
}