import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

class code{

    public static 
    ArrayList<String>subsequence_ret(String str){
        if(str.length()==0){
            ArrayList<String> my= new ArrayList<String>();
            my.add("");
            return my;
        }

        char ch=str.charAt(0);
        String nstr=str.substring(1);

        ArrayList<String>smallans=subsequence_ret(nstr);
        ArrayList<String> myans= new ArrayList<String>();
        myans.addAll(smallans);     //call to not get in ans
                                     //(can also be done within for loop)

        for(String s:smallans){
            //myans.add(s);          //no need to add here as it is done directly before
            myans.add(ch+s);        //call to get in ans
        }
        return myans;
    }

    public static int subseq_void(String str,String ans){

        if(str.length()==0){
            System.out.print(ans+" ");
            return 1;
        }
        int count=0;
        count+=subseq_void(str.substring(1),ans);
        count+=subseq_void(str.substring(1),ans+str.charAt(0));

        return count;
    }

    public static ArrayList<String> permutationwithdupli(String str){
        if(str.length()==0){
            ArrayList<String> my= new ArrayList<String>();
            my.add("");
            return my;
        }
        char ch=str.charAt(0);
        ArrayList<String> smallans=permutationwithdupli(str.substring(1));
        ArrayList<String> myans= new ArrayList<String>();

        for(String s:smallans){
            for(int i=0;i<=s.length();i++){
                myans.add(s.substring(0,i)+ch+s.substring(i));
            }
        }
        return myans;
    }
    public static int permutationwithdupli_void(String str,String ans){

        if(str.length()==0){
           System.out.print(ans+" ");
           return 1;
        }
        int count=0;
        for(int i=0;i<str.length();i++){
            String nstr=str.substring(0,i)+str.substring(i+1);
            count+=permutationwithdupli_void(nstr,ans+str.charAt(i));
        }
        return count;
    }

    public static int permuwithoutdupli(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return 1;
        }
        boolean []arr=new boolean[26];
       // Arrays.fillAll(arr,false);
       int count=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!arr[ch-'a']){
                arr[ch-'a']=true;
               count+= permuwithoutdupli(str.substring(0,i)+str.substring(i+1),ans+ch);
            }
        }
        return count;
    }

  public static   ArrayList<String> mazepath_hv(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            ArrayList<String>arr=new ArrayList<>();
            arr.add(ans);
            return arr;
        }
        ArrayList<String>myans=new ArrayList<>();
        ArrayList<String>horizontal=new ArrayList<>();
        ArrayList<String>vertical=new ArrayList<>();
        if(sr+1<=er)
        horizontal=mazepath_hv(sr,sc+1,er,ec,ans+"H");
        for(String s:horizontal)
        myans.add(s);
         if(sc+1<=ec)
        vertical=mazepath_hv(sr+1,sc,er,ec,ans+"V");
        for(String s:vertical)
         myans.add(s);
         return myans;
    }
    
    public static   ArrayList<String> mazepath_hvd(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            ArrayList<String>arr=new ArrayList<>();
            arr.add(ans);
            return arr;
        }
        ArrayList<String>myans=new ArrayList<>();
        ArrayList<String>horizontal=new ArrayList<>();
        ArrayList<String>vertical=new ArrayList<>();
        ArrayList<String>diagonal=new ArrayList<>();

        if(sc+1<=ec)
        horizontal=mazepath_hvd(sr,sc+1,er,ec,ans+"H");
        for(String s:horizontal)
        myans.add(s);
         if(sr+1<=er)
        vertical=mazepath_hvd(sr+1,sc,er,ec,ans+"V");
        for(String s:vertical)
         myans.add(s);
         if(sr+1<=er && sc+1<=ec)
        diagonal=mazepath_hvd(sr+1,sc+1,er,ec,ans+"D");
        for(String s:diagonal)
        myans.add(s);

         return myans;
    }

    public static   ArrayList<String> mazepath_hvdmulti(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            ArrayList<String>arr=new ArrayList<>();
            arr.add(ans);
            return arr;
        }
        ArrayList<String>myans=new ArrayList<>();
        ArrayList<String>horizontal=new ArrayList<>();
        ArrayList<String>vertical=new ArrayList<>();
        ArrayList<String>diagonal=new ArrayList<>();

        for(int i=1;i<=ec;i++){
        if(sc+1<=ec)
        horizontal=mazepath_hvdmulti(sr,sc+1,er,ec,ans+"H");
        for(String s:horizontal)
        myans.add(s);
        }
        for(int i=1;i<=ec;i++){
         if(sr+1<=er)
        vertical=mazepath_hvdmulti(sr+1,sc,er,ec,ans+"V");
        for(String s:vertical)
         myans.add(s);
        }
        for(int i=1;i<=ec;i++){
         if(sr+1<=er && sc+1<=ec)
        diagonal=mazepath_hvdmulti(sr+1,sc+1,er,ec,ans+"D");
        for(String s:diagonal)
        myans.add(s);
        }

         return myans;
    }


    public static   int mazepath_hvdmulti02(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
           System.out.print(ans+" ");
           return 1;
        }
       
        int count=0;
        for(int i=1;i<=ec;i++){
        if(sc+1<=ec)
       count+=mazepath_hvdmulti02(sr,sc+1,er,ec,ans+"H");
        }
        for(int i=1;i<=ec;i++){
         if(sr+1<=er)
        count+=mazepath_hvdmulti02(sr+1,sc,er,ec,ans+"V");
        }
        for(int i=1;i<=ec;i++){
         if(sr+1<=er && sc+1<=ec)
        count+=mazepath_hvdmulti02(sr+1,sc+1,er,ec,ans+"D");
        }

         return count;
    }


      public static  int dir[][]={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
      public static  String dirn[]={"E","S-E","S","S-W","W","N-W","N","N-E"};
        public static int floodfill(int sr,int sc,int er,int ec,String ans,boolean[][]vis){
            if(sr==er && sc==ec){
                System.out.print(ans+" ");
                return 1;
             }
             int count=0;
            
             vis[sr][sc]=true;
             for(int i=0;i<8;i++){
                int r=sr+dir[i][0];
                int c=sc+dir[i][1];
                if(isvalid(r,c,vis))
                count+=floodfill(r,c,er,ec,ans+dirn[i],vis);
             }
             vis[sr][sc]=false;
             return count;
        }

    public static int floodfillmulti(int sr,int sc,int er,int ec,String ans,boolean[][]vis){
            if(sr==er && sc==ec){
                System.out.print(ans+" ");
                return 1;
             }
             int count=0;
            
             vis[sr][sc]=true;
             for(int i=0;i<8;i++){
                 for(int mag=1;mag<=Math.max(er,ec);mag++){
                int r=sr+(mag*dir[i][0]);
                int c=sc+(mag*dir[i][1]);
                if(isvalid(r,c,vis))
                count+=floodfillmulti(r,c,er,ec,ans+dirn[i]+mag,vis);
                 }
             }
             vis[sr][sc]=false;
             return count;
    }
    public static String shortestpathfloodfill(int sr,int sc,int er,int ec,String ans,boolean[][]vis){
        if(sr==er && sc==ec){
           // System.out.print(ans+" ");
            return "";
         }
         int count=0;
        int min=10000000;
        String aa="";
        String shortest="";
         vis[sr][sc]=true;
         for(int i=0;i<8;i++){
            int r=sr+dir[i][0];
            int c=sc+dir[i][1];
            if(isvalid(r,c,vis))
            aa=shortestpathfloodfill(r,c,er,ec,ans+dirn[i],vis);
           if(aa.length()+1<min){
               min=aa.length()+1;
              shortest=dirn[i]+aa;

           }
         }
         vis[sr][sc]=false;
         return shortest;
    }

    public static class pair{
        int val=0;
        String str="";
        pair(int val,String str){
            this.val=val;
            this.str=str;
        }
    }
    


public static pair floodfill_longestpath(int sr,int sc,int er,int ec,boolean[][]vis){
        if(sr==er && sc==ec){
            return new pair(0,"");
        }
        vis[sr][sc]=true;
        pair mypair=new pair(0,"");
        pair ans=new pair(0,"");
        for(int i=0;i<8;i=i+2){
            int r=sr+dir[i][0];
            int c=sc+dir[i][1];
            if(isvalid(r,c,vis)){
            ans=floodfill_longestpath(r,c,er,ec,vis);

            if(ans.val+1>mypair.val){
                String a=ans.str+dirn[i]+"";
                mypair.val=a.length()+1;
                mypair.str=a;
            }
        }
    }
        vis[sr][sc]=false;
        return mypair;
}



    public static int numIslands(char[][] grid) {
      return numofislands(grid,0,0,grid.length-1,grid[0].length-1);
    }


    public static int numofislands(char[][]arr,int sr,int sc,int er,int ec){
        if(sr==er && sc==ec)
        return 1;

        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){

                if(arr[i][j]=='1'){
                    if(sr+1<=er)
                   count+= numofislands(arr,sr+1,sc,er,ec);
                    if(sc+1<=ec)
                   count+= numofislands(arr,sr,sc+1,er,ec);
                }
        
            }
        }
        return count;
        
    }


//     public static int floodfillmulti_height(int sr,int sc,int er,int ec,String ans,boolean[][]vis){
//         if(sr==er && sc==ec){
//             return 0;
//          }
//          int temp=0;
//         int max=0;
//          vis[sr][sc]=true;
//          for(int i=0;i<8;i++){
//             int r=sr+dir[i][0];
//             int c=sc+dir[i][1];
//             if(isvalid(r,c,vis))
//            temp=floodfillmulti_height(r,c,er,ec,ans+dirn[i]+mag,vis);
//             max=Math.max(max,temp);
//              }
//          }
//          vis[sr][sc]=false;
//          return max+1;
// }
public static int coinchangepermuinfi(int[]arr,int tar,String str){
    if(tar==0){
        System.out.println(str);
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.length;i++){
        if(tar-arr[i]>=0)
        count+=coinchangepermuinfi(arr,tar-arr[i],str+arr[i]+"");
    }
    return count;
}
public static int coinchangecombiinfi(int[]arr,int tar,String str,int vidx){
    if(tar==0){
        System.out.println(str);
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.length;i++){
        if(tar-arr[i]>=0)
        count+=coinchangecombiinfi(arr,tar-arr[i],str+arr[i]+"",i);
    }
    return count;
}

public static int coinchangecombionecoin(int[]arr,int tar,String str,int vidx){
    if(tar==0){
        System.out.println(str);
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.length;i++){
        if(tar-arr[i]>=0)
        count+=coinchangecombionecoin(arr,tar-arr[i],str+arr[i]+"",i+1);
    }
    return count;
}

public static int coinchangepermuonecoin(int[]arr,int tar,String str,int vidx,boolean[]vis){
    if(tar==0){
        System.out.println(str);
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.length;i++){
        if(tar-arr[i]>=0 && !vis[i]){
            vis[i]=true;
        count+=coinchangepermuonecoin(arr,tar-arr[i],str+arr[i]+"",i+1,vis);
        vis[i]=false;
        }
    }
    return count;
}

public static int coinchangecombionecoin_subsequence(int[]arr,int tar,String str,int idx,boolean []vis){
if(tar==0)
{
    System.out.println(str);
    return 1;
}
int count=0;
if(idx>=arr.length)return 0;
    if(tar-arr[idx]>=0)
count+=coinchangecombionecoin_subsequence(arr,tar-arr[idx],str+arr[idx],idx+1,vis);
count+=coinchangecombionecoin_subsequence(arr,tar,str,idx+1,vis);
return count;
}

public static int coinchangecombiinfi_subsequence(int[]arr,int tar,String str,int idx,boolean []vis){
    if(tar==0)
    {
        System.out.println(str);
        return 1;
    }
    int count=0;
    if(idx>=arr.length)return 0;
        if(tar-arr[idx]>=0)
    count+=coinchangecombiinfi_subsequence(arr,tar-arr[idx],str+arr[idx],idx,vis);
    count+=coinchangecombiinfi_subsequence(arr,tar,str,idx+1,vis);
    return count;
    }


    public static int coinchangepermuinfi_subsequence(int[]arr,int tar,String str,int idx,boolean []vis){
        if(tar==0)
        {
            System.out.println(str);
            return 1;
        }
        int count=0;
        if(idx>=arr.length)return 0;
            if(tar-arr[idx]>=0)
        count+=coinchangepermuinfi_subsequence(arr,tar-arr[idx],str+arr[idx],0,vis);
        count+=coinchangepermuinfi_subsequence(arr,tar,str,idx+1,vis);
        return count;
    }

    public static int coinchangepermuonecoin_subsequence(int[]arr,int tar,String str,int idx,boolean []vis){
        if(tar==0)
        {
            System.out.println(str);
            return 1;
        }
        int count=0;
        if(idx>=arr.length)return 0;
            if(tar-arr[idx]>=0 && !vis[idx]){
                vis[idx]=true;
        count+=coinchangepermuonecoin_subsequence(arr,tar-arr[idx],str+arr[idx],0,vis);
        vis[idx]=false;
            }
        count+=coinchangepermuonecoin_subsequence(arr,tar,str,idx+1,vis);
        return count;
    }

    public static int combinationqueen1D(boolean[]arr,int qpsf,int tnq,int idx,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++){
     
        count+=combinationqueen1D(arr,qpsf+1,tnq,i+1,ans+"Box"+i+"  "+"Queen"+qpsf);
        }
        return count;
    }

    public static int permutationqueen1D(boolean[]vis,int qpsf,int tnq,int idx,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<vis.length;i++){
      if(!vis[i]){
          vis[i]=true;
        count+=permutationqueen1D(vis,qpsf+1,tnq,idx,ans+"Box"+i+" "+"Queen"+qpsf+"     ");
        vis[i]=false;
    }
    }
        return count;
    } 

    public static int permutationqueen1Dsubseq(boolean[]vis,int qpsf,int tnq,int idx,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        if(idx>=vis.length)
        return 0;
        int count=0;

      if(!vis[idx]){
          vis[idx]=true;
        count+=permutationqueen1Dsubseq(vis,qpsf+1,tnq,0,ans+"Box"+idx+" "+"Queen"+qpsf+"     ");
        vis[idx]=false;
    }
    count+=permutationqueen1Dsubseq(vis,qpsf,tnq,idx+1,ans);
    
        return count;
    }


public static int combinationqueen2D(boolean[][]vis,int qpsf,int tnq,int idx,String ans){
    if(qpsf==tnq){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=idx;i<vis.length*vis[0].length;i++){
        int x=i/vis[0].length;
        int y=i%vis[0].length;
        count+=combinationqueen2D(vis,qpsf+1,tnq,i+1,ans+"BOX ("+x+","+y+")"+ "  queen "+qpsf+"       ");
    }
    return count;
}

public static int permutationqueen2D(boolean[][]vis,int qpsf,int tnq,int idx,String ans){
    if(qpsf==tnq){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=idx;i<vis.length*vis[0].length;i++){
        int x=i/vis[0].length;
        int y=i%vis[0].length;
        if(!vis[x][y]){
            vis[x][y]=true;
        count+=permutationqueen2D(vis,qpsf+1,tnq,0,ans+"BOX ("+x+","+y+")"+ "  queen "+qpsf+"       ");
            vis[x][y]=false;
    }
}
    return count;
}

public static int permutationqueen2d(boolean[][]arr,int qpsf,int tnq,String ans){
    if(qpsf==tnq){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.length*arr[0].length;i++){
        int r=i/arr[0].length;
        int c=i%arr[0].length;
        if(!arr[r][c]){
            arr[r][c]=true;
            count+=permutationqueen2d(arr,qpsf+1,tnq,ans+"("+r+","+c+")");
            arr[r][c]=false;
        }
    }
    return count;
}

public static int nqueen(boolean[][]arr,int qpsf,int tnq,String ans,int idx){
    if(qpsf==tnq){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=idx;i<arr.length*arr[0].length;i++){
        int r=i/arr[0].length;
        int c=i%arr[0].length;
        if(isvalid(arr,r,c)){
            arr[r][c]=true;
            count+=nqueen(arr,qpsf+1,tnq,ans+"("+r+","+c+")",i+1);
            arr[r][c]=false;
        }
    }
    return count;
}

public static boolean isvalid(boolean[][]arr,int r,int c){
int[][]dir={{0,-1},{-1,-1},{-1,0},{-1,1}};
for(int d=0;d<4;d++){
    for(int rad=1;rad<=arr.length;rad++){
        int row=r+rad*dir[d][0];
        int col=c+rad*dir[d][1];
        if(row>=0 && col>=0 && row<arr.length && col<arr[0].length){
            if(arr[row][col])
            return false;
        }
        else
        break;
       }
}
return true;
}


public static boolean[]row;
public static boolean[]col;

public static boolean[]dig;
public static boolean[]adig;


public static int nqueen2(int n,int m,int qpsf,int tnq,String ans,int idx){
    if(tnq==0){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=idx;i<n*m;i++){
        int r=i/m;
        int c=i%m;
        if(!row[r] && !col[c] && !dig[r-c+m-1] && !adig[r+c]){
            row[r]=true;
            col[c]=true;
            dig[r-c+m-1]=true;
            adig[r+c]=true;
            count+=nqueen2(n,m,qpsf+1,tnq-1,ans+"("+r+","+c+")",i+1);
            row[r]=false;
            col[c]=false;
            dig[r-c+m-1]=false;
            adig[r+c]=false;
        }
    }
    return count;
}

public static int row_=0;
public static int col_=0;
public static int dig_=0;
public static int adig_=0;

public static int nqueen3(int n,int m,int qpsf,int tnq,String ans,int idx){
    if(tnq==qpsf){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=idx;i<n*m;i++){
        int r=i/m;
        int c=i%m;
        if((row_ &(1<<r))==0 && (col_ & (1<<c))==0 && (dig_ & (1<<(r-c+m-1)))==0 && (adig_ & (1<<(r+c)))==0){
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
            count+=nqueen3(n,m,qpsf+1,tnq,ans+"("+r+","+c+")",i+1);
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
        }
    }
    return count;
}


public static int nqueen3_(int n,int m,int qpsf,int tnq,String ans,int idx){
    if(tnq==qpsf || idx==n*m){
        if(tnq==qpsf){
        System.out.println(ans);
        return 1;
        }
        else return 0;
    }
    int count=0;
  
        int r=idx/m;
        int c=idx%m;
        if((row_ &(1<<r))==0 && (col_ & (1<<c))==0 && (dig_ & (1<<(r-c+m-1)))==0 && (adig_ & (1<<(r+c)))==0){
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
            count+=nqueen3_(n,m,qpsf+1,tnq,ans+"("+r+","+c+")",idx+1);
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
        }
            count+=nqueen3_(n,m,qpsf,tnq,ans,idx+1);

    return count;
}



public static int nqueen4(int n,int m,int qpsf,int tnq,String ans,int idx){
    if(tnq==qpsf || idx==n){
        if(tnq==qpsf){
        System.out.println(ans);
        return 1;
        }
        else return 0;
    }
    int count=0;
    for(int i=0;i<m;i++){
        int r=idx;
        int c=i;
        if((row_ &(1<<r))==0 && (col_ & (1<<c))==0 && (dig_ & (1<<(r-c+m-1)))==0 && (adig_ & (1<<(r+c)))==0){
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
            count+=nqueen4(n,m,qpsf+1,tnq,ans+"("+r+","+c+")",idx+1);
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
        }
    }
    return count;
}


public static int nqueen4_(int n,int m,int qpsf,int tnq,String ans,int idx){
    if(tnq==qpsf || idx==n){
        if(tnq==qpsf){
        System.out.println(ans);
        return 1;
        }
        else return 0;
    }
    int count=0;
    for(int i=0;i<m;i++){
        int r=idx;
        int c=i;
        if((row_ &(1<<r))==0 && (col_ & (1<<c))==0 && (dig_ & (1<<(r-c+m-1)))==0 && (adig_ & (1<<(r+c)))==0){
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
            count+=nqueen4_(n,m,qpsf+1,tnq,ans+"("+r+","+c+")",idx+1);
            row_^=(1<<r);
            col_ ^=(1<<c);
            dig_ ^=(1<<(r-c+m-1));
            adig_ ^=(1<<(r+c));
        }
    }
        count+=nqueen4_(n,m,qpsf,tnq,ans,idx+1);
    return count;
}

public static int sudoku(int[][]arr,int idx){
    if(idx==81)
    return 1;

   int r=idx/9;
   int c=idx%9;
   int count=0;
   if(arr[r][c]==0){
   for(int num=1;num<=9;num++){
       if(issafetoplacesudoku(arr,r,c,num)){
        arr[r][c]=num;
        count+=sudoku(arr,idx+1);
        arr[r][c]=0;
       }
   }
}
else
{
    count+=sudoku(arr,idx+1);
}
return count;
}

public static boolean sudoku2(int[][]arr,int idx){
    if(idx==81){
        display2d(arr);
        return true;
    }

   int r=idx/9;
   int c=idx%9;
//    int count=0;
boolean res=false;
   if(arr[r][c]==0){
   for(int num=1;num<=9;num++){
       if(issafetoplacesudoku(arr,r,c,num)){
        arr[r][c]=num;
        res=res||sudoku2(arr,idx+1);
        arr[r][c]=0;
       }
   }
}
else
{
   res=res||sudoku2(arr,idx+1);
}
return res;
}
public static int rowa[];
public static int cola[];
public static int matrixa[][];

public static int sudoku3(int[][]arr,ArrayList<Integer>a,int idx){

        if(idx==a.size()){
            display2d(arr);
            return 1;
        }
    
       int r=a.get(idx)/9;
       int c=a.get(idx)%9;
        int count=0;
        for(int num=1;num<=9;num++){
            int mask=(1<<num);
            if((rowa[r]&mask)==0 && (cola[c]& mask)==0 && ((matrixa[r/3][c/3] & mask)==0)){
                arr[r][c]=num;
                rowa[r]^=mask;
                cola[c]^=mask;
                matrixa[r/3][c/3]^=mask;
                count+=sudoku3(arr,a,idx+1);
                arr[r][c]=0;
                rowa[r]^=mask;
                cola[c]^=mask;
                matrixa[r/3][c/3]^=mask;
            }
        }
        return count;
}

public static boolean issafetoplacesudoku(int[][]arr,int r,int c,int num){
    
    for(int i=0;i<=8;i++){
        if(arr[r][i]==num)
        return false;
        if(arr[i][c]==num)
        return false;
    }
    int x=(r/3)*3;
    int y=(c/3)*3;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(arr[x+i][y+j]==num)
            return false;
        }
    }
    return true;
}

public static void display2d(int[][]arr){
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++)
        System.out.print(arr[i][j]+" ");
        System.out.println();
    }
}


        public static boolean isvalid(int r,int c,boolean[][]arr){
            if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || arr[r][c]==true)
            return false;
            else
            return true;
        }


        public static HashSet<String>map=new HashSet<>();
        public static int wordbreak(String str,String ans){
            if(str.length()==0){
                System.out.println(ans);
                return 1;
            }
            int count=0;
            for(int i=1;i<=str.length();i++){
                String smallstr=str.substring(0,i);
                if(map.contains(smallstr)){
                    count+=wordbreak(str.substring(i),ans+smallstr+" ");
                }
            }
            return count;
        }

        public static String str1="send";
        public static String str2="more";
        public static String str3="money";
        public static int []mapping=new int[26];
       
        public static int numused=0;

        public static int string2no(String str){
            int res=0;
            for(int i=0;i<str.length();i++){
                int idx=str.charAt(i)-'a';
                res=res*10+mapping[idx];
            }
            return res;
        }

        public static String unique(String str){
            int num=0;
            for(int i=0;i<str.length();i++){
                int mask=(1<<(str.charAt(i)-'a'));
                num|=mask;
            }
            String ans="";
            for(int i=0;i<32;i++){
                int mask=(1<<i);
                if((num & mask)!=0){
                    ans+=(char)(i+'a');
                }
            }
            return ans;
        }

        public static int crypto(String str,int idx){ 
            if(idx==str.length()){
                int num1=string2no(str1);
                int num2=string2no(str2);
                int num3=string2no(str3);
              
                if(num1+num2==num3){
                   System.out.println(num1+" "+num2+" "+num3);
                   return 1;
                }
                return 0;
            }
            int count=0;
            for(int num=0;num<=9;num++){
                int mask=(1<<num);
                if((numused & mask)==0){
                    numused^=mask;
                    mapping[str.charAt(idx)-'a']=num;
                    count+=crypto(str,idx+1);
                    numused^=mask;
                    mapping[str.charAt(idx)-'a']=0;
                }
            }
            return count;
        }

   public static char[][] board= {{'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};

public static String[] words = {"agra", "norway", "england", "gwalior"};

public static boolean crossword(int idx){
if(idx==words.length){
for (char[] ar : board)
{
for (char ch : ar)
System.out.print(ch+" ");
System.out.println();
}
return true;
}
String word=words[idx];
boolean res=false;
for(int i=0;i<board.length;i++){
for(int j=0;j<board[0].length;j++){
if(board[i][j]=='-' || board[i][j]==word.charAt(0)){
 if(canplaceH(i,j,word)){
     boolean[]mark=placeH(i,j,word);
     res=res||crossword(idx+1);
     unplaceH(i,j,word,mark);
 }

 if(canplaceV(i,j,word)){
     boolean[]mark=placeH(i,j,word);
     res=res||crossword(idx+1);
     unplaceV(i,j,word,mark);
 }
}
}
}
return res;
}
public static boolean canplaceH(int r,int c,String word){
for (int i = 0; i < word.length(); i++)
{
if ((c + i) < board[0].length && board[r][c + i] != '-' && board[r][c + i] != word.charAt(i))
{
return false;
}
}
return true;
}
public static boolean[] placeH(int r,int c,String word){
boolean[]mark=new boolean[word.length()];
for (int i = 0; i < word.length(); i++)
{
if (board[r][c + i] == '-')
{
mark[i] = true;
board[r][c + i] = word.charAt(i);
}
}
return mark;
}


public static void unplaceH(int r, int c, String word, boolean[]mark)
{
for (int i = 0; i < word.length(); i++)
{
if (mark[i])
board[r][c + i] = '-';
}
}


public static boolean canplaceV(int r, int c, String word){
for (int i = 0; i < word.length(); i++)
{
if ((r + i) < board.length && board[r + i][c] != '-' && board[r + i][c] != word.charAt(i))
{
return false;
}
}
return true;
}


public static boolean[] placeV(int r, int c, String word)
{
boolean[]mark=new boolean[word.length()];
for (int i = 0; i < word.length(); i++)
{
if (board[r + i][c] == '-')
{
mark[i] = true;
board[r + i][c] = word.charAt(i);
}
}
return mark;
}


public static void unplaceV(int r, int c, String word, boolean[]mark)
{
for (int i = 0; i < word.length(); i++)
{
if (mark[i])
board[r + i][c] = '-';
}
}





    public static void main(String[]args){
        //System.out.println(subsequence_ret("abcd"));
        // System.out.println(subseq_void("abcd",""));
//  System.out.println( permutationwithdupli_void("abc",""));
    //System.out.println(permuwithoutdupli("abc",""));
   // System.out.println(mazepath_hvdmulti02(0,0,2,2,""));
//    boolean [][]vis=new boolean[3][3];
//    System.out.println(floodfillmulti(0,0,2,2,"",vis));
    
//     boolean[][]vis=new boolean[3][3];
//    pair m=floodfill_longestpath(0,0,2,2,vis);
//    System.out.print(m.str+"->"+m.val);

    // int[]arr={2,3,5,7};
    // String str="";
    // boolean [] []vis=new boolean[3][3];
   // System.out.print(coinchangepermuonecoin_subsequence(arr,10,str,0,vis));

//    System.out.print(permutationqueen2D(vis,0,5,0,""));
//         boolean[][]arr=new boolean[4][4];
// System.out.print(nqueen(arr,0,arr.length,"",0));

// int r=4;
// int c=4;
// row=new boolean[r];
// col=new boolean[c];

// dig=new boolean[r+c-1];

// adig=new boolean[r+c-1];
// System.out.print(nqueen4_(r,c,0,4,"",0));

int n=9;
// int[][]arr=new int[n][n];
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<9;j++)
        //     arr[i][j]=0;
        // }

    //   int[][]  arr={{3,0,6,5,0,8,4,0,0},
    //          {5,2,0,0,0,0,0,0,0},
    //          {0,8,7,0,0,0,0,3,1},
    //          {0,0,3,0,1,0,0,8,0},
    //          {9,0,0,8,6,3,0,0,5},
    //          {0,5,0,0,9,0,6,0,0},
    //          {1,3,0,0,0,0,2,5,0},
    //          {0,0,0,0,0,0,0,7,4},
    //          {0,0,5,2,0,6,3,0,0}};

// System.out.println(sudoku2(arr,0));
//  display2d(arr);
// ArrayList<Integer>a=new ArrayList<>();

// rowa=new int[9];
// cola=new int[9];
// matrixa=new int[3][3];

// for(int i=0;i<9;i++){
//     for(int j=0;j<9;j++){
//         if(arr[i][j]==0)
//         a.add(i*9+j);
//         else{
//         rowa[i]|=(1<<arr[i][j]);
//         cola[i]|=(1<<arr[j][i]);
//         matrixa[i/3][j/3]|=(1<<(arr[i][j]));
//         }
//     }
// }
// System.out.println(sudoku3(arr,a,0));
// display2d(arr);


// String[] words={"samsung","i","like","ilike","sam","sung","and","man","go","mango"};
// String word="ilikesamsungandmango";

// for(String ele:words){
//     map.add(ele);
// }
// System.out.println(wordbreak(word,""));


// for(int i=0;i<26;i++)
// mapping[i]=0;
// String str=str1+str2+str3;
// String a=unique(str);
// System.out.println(a);
// System.out.println(crypto(a,0));

System.out.print(crossword(0));

    }
}