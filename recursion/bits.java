import java.util.Scanner;
import java.io.*;
public class bits{
    public static void main(String args[]){
     // System.out.print(  kofftoon(5,1));
     // System.out.print(  kontooff(5,2));
      System.out.print(  noofbitsset(7));


    }
    public static int kofftoon(int num,int k){
        int mask=(1<<k);
       return num|mask;
    }
    public static int kontooff(int num,int k){
        int mask=(~(1<<k));
        return (num & mask);
    }
    public static int noofbitsset(int num){
        int count=0;
        int totalbits=32;
        while(num!=0 && totalbits!=0){
            if((num & 1)!=0)
            count++;
            num>>=1;
            totalbits--;
        }
        return count;
    }
}