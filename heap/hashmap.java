import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

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
    public int[] topKFrequent(int[] nums, int k) {
        
    }
    public static void main(String[]args){
        // String str= "aasbaabababababccc";
        // freqmap3(str);

        int[]ans=intersect(new int []{1,2,2,1},new int []{2,2});
       
        for(int ele :ans)
        System.out.print(ele+" , ");
    }
}