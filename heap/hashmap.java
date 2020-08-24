import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.lang.Math;

public class hashmap{
    public static void freqmap1(String str){
        int n=str.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(char ch:map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }
    public static void freqmap2(String str){
        int n=str.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }
    public static void freqmap3(String str){
        int n=str.length();
        HashMap<Character,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);

            // if(!map.containsKey(ch)){
            //     map.put(ch,new ArrayList<Integer>());
            // }
            map.putIfAbsent(ch,new ArrayList<Integer>());

            ArrayList<Integer>arr=map.get(ch);
            arr.add(i);
        }
        for(char ch:map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }
    public static int[] intersection(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer>map1=new HashMap<>();
        int n=arr1.length;
        for(int i=0;i<n;i++){
            int ch=arr1[i];
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        HashSet<Integer>arr=new HashSet<>();
        n=arr2.length;
        for(int i=0;i<n;i++){
            int ch=arr2[i];
            if(map1.containsKey(ch) && map1.get(ch)!=0){
                arr.add(ch);
                map1.put(ch,map1.get(ch)-1);
            }
        }
        n=arr.size();
        int[]ans=new int[n];
        int i=0;
        for(int ele :arr)
        ans[i++]=ele;

        return ans;
    }
    public static int[] intersect(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer>map1=new HashMap<>();
        int n=arr1.length;
        for(int i=0;i<n;i++){
            int ch=arr1[i];
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer>arr=new ArrayList<>();
        n=arr2.length;
        for(int i=0;i<n;i++){
            int ch=arr2[i];
            if(map1.containsKey(ch) && map1.get(ch)!=0){
                arr.add(ch);
                map1.put(ch,map1.get(ch)-1);
            }
        }
        n=arr.size();
        int[]ans=new int[n];

        for(int i=0;i<n;i++)
        ans[i]=arr.get(i);

        return ans;
    }
    public static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int ch=arr[i];
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(( a,  b)->{
            return map.get(b)-map.get(a);
        });

        for(int ele:map.keySet())
        pq.add(ele);

        int[]ans=new int[k];
        while(k-->0){
            ans[k]=pq.remove();
        }
        return ans;
    }
    public static List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        for(String str :arr){

            int[]ar=new int[26];
            for(int i=0;i<26;i++){
                char ch=str.charAt(i);
                ar[ch-'a']++;
            }

                String a="";
                for(int i=0;i<26;i++){
                    if(ar[i]>0)
                    a=a+('a'+i)+ar[i];
                }
                map.putIfAbsent(a,new ArrayList<String>());
            ArrayList<String>ans=map.get(a);
                ans.add(str);
                map.put(a,ans);
        }
        List<List<String>>ans=new ArrayList<>();
        for(String a:map.keySet()){
            ans.add(map.get(a));
        }
        return ans;
    }
    class RandomizedSet {
        HashMap<Integer,Integer>map;
        ArrayList<Integer>arr;
        public RandomizedSet() {
            map=new HashMap<Integer,Integer>();
            arr=new ArrayList<Integer>();
        }
        
        public boolean insert(int val) {
            if(map.containsKey(val))
            return false;
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }
        
        public boolean remove(int val) {
            if(!map.containsKey(val))
            return false;
            int a=map.get(val);
            map.remove(val);
            swap(a,arr.size()-1);
            arr.remove(arr.size()-1);
            map.put(arr.get(a),a);
            return true;
        }
        public void swap(int a,int b){
            int temp=arr.get(a);
            arr.set(a,arr.get(b));
            arr.set(b,temp);
        }
        
        public int getRandom() {
            int a=(int)(Math.random()*arr.size());
            return arr.get(a);
        }
    }
    class MedianFinder {
        PriorityQueue<Integer>pq1;
        PriorityQueue<Integer>pq2;
        public MedianFinder() {
            pq1=new PriorityQueue<>(Collections.reverseOrder());
            pq2=new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            int a=pq1.peek();
            int b=pq2.peek();
            if(num<=a){
                pq1.add(num);
                if(pq1.size()-pq2.size()>1){
                    pq2.add(pq1.remove());
                }
            }else{
                pq2.add(num);
                if(pq2.size()>pq1.size()){
                    pq1.add(pq2.remove());
                }
            }
        }
        
        public double findMedian() {
            int size=pq1.size()+pq2.size();
            if(size%2==0){
                double a=pq1.peek()+pq2.peek();
                a/=2; 
                return a;
            }else
            return pq1.peek();
        }
    }
    class Solution {
        public int trapRainWater(int[][] arr) {
            PriorityQueue<int[]>pq=new PriorityQueue<>((int[]a, int[]b)->{
               return a[0]-b[0];
            });
            int[][]dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            int n=arr.length;
            int m=arr[0].length;
            for(int i=0;i<m;i++){
                pq.add(new int[]{arr[0][i],0,i});
                arr[0][i]=-1;
                pq.add(new int[]{arr[n-1][i],n-1,i});
                arr[n-1][i]=-1;
            }
            for(int i=0;i<n;i++){
                pq.add(new int[]{arr[i][0],i,0});
                arr[i][0]=-1;
                pq.add(new int[]{arr[i][m-1],i,m-1});
                arr[i][m-1]=-1;
            }
            int max=0;
            int w=0;
            while(pq.size()!=0){
                int[] ele=pq.remove();
                max=Math.max(max,ele[0]);
                for(int i=0;i<4;i++){
                    int r=ele[1];
                    int c=ele[2];
                    r=r+dir[i][0];
                    c=c+dir[i][1];
                    if(r>=0 && r<n && c>=0 && c<m && arr[r][c]!=-1 ){
                        w+=Math.max(0,max-arr[r][c]);
                        pq.add(new int[]{arr[r][c],r,c});
                        arr[r][c]=-1;
                    }
                }
            }
            return w;
        }
    }
   
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


    public Node copyRandomList(Node head) {
       if(head==null)
       return null;

       Node n=head;
       //make new nodes in LL 
       while(head!=null){
           Node temp=head.next;
           head.next=new Node(head.val);
           head.next.next=temp;
           head=head.next.next;
       }
       head=n;
       //give values of random pointer
        while(head!=null){
            Node temp=head.random;
            head=head.next;
            if(temp!=null)
            head.random=temp.next;
            head=head.next;
        }
        head=n;
        Node hh=head.next;
        //make continuous list as requirement
       while(head!=null){
           Node n1=head;
           head=head.next;
           
           Node n2=head;
           head=head.next;
           n1.next=head;
           if(head!=null)
           n2.next=head.next;
       }
        return hh;
    }

public int swimInWater(int[][] arr) {
    PriorityQueue<int[]>pq=new PriorityQueue<>((int[]a,int[]b)->{
       return a[0]-b[0];
    });
    pq.add(new int[]{arr[0][0],0,0});
    arr[0][0]=-1;
    int max=0;
    int[][]dir={{-1,0},{0,1},{1,0},{0,-1}};
    int n=arr.length;
    int m=arr[0].length;
    while(pq.size()!=0){
        int[]a=pq.remove();
        int val=a[0];
        max=Math.max(max,val);
        int r=a[1];
        int c=a[2];
        if(r==n-1 && c==m-1)
        return max;
        for(int i=0;i<4;i++){
            int x=r+dir[i][0];
            int y=c+dir[i][1];
            if(x>=0 && y>=0 && x<n && y<m && arr[x][y]!=-1){
                pq.add(new int[]{arr[x][y],x,y});
                arr[x][y]=-1;
            }
        }
    }
    return max;
}
class LRUCache {
    HashMap<Integer,Integer>map=new HashMap<>();
    LinkedList<Integer>ll=new LinkedList<>();
    int c=0;
    public LRUCache(int capacity) {
        c=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        return -1;

          for(int i=0;i<ll.size();i++)
                if(ll.get(i)==key){
            ll.remove(i);
                    break;}
        ll.addFirst(key);
        return map.get(key);
    }
    
    public void put(int key, int val) {
        if(map.containsKey(key)){
            for(int i=0;i<ll.size();i++)
                if(ll.get(i)==key){
            ll.remove(i);
                    break;}
        }
        map.put(key,val);
        ll.addFirst(key);
        if(ll.size()>c){
           int a= ll.removeLast();
            map.remove(a);
        }
    }
}
   
    public static void main(String[]args){
        // String str= "aasbaabababababccc";
        // freqmap3(str);

        int[]ans=topKFrequent(new int []{1,1,1,2,2,3},2);
       
        for(int ele :ans)
        System.out.print(ele+" , ");
    }
}