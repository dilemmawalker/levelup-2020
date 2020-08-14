import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

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
    public static void main(String[]args){
        String str= "aasbaabababababccc";
        freqmap3(str);
    }
}