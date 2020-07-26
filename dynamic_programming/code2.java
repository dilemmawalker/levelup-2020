public class code2{
    public static int fibo_memo(int s,int n,int[]dp){
        if(s>=n){
            if(s==n)
            return dp[s]=1;
            return 0;
        }
        if(dp[s]!=0)
        return dp[s];

        int c=0;
        c+=fibo_memo(s+1,n,dp);
        c+=fibo_memo(s+2,n,dp);

        return dp[s]=c;
    }
    public static int fibo_dp(int s,int n,int []dp){
        for(int i=n;i>=0;i--){
            if(i==n||i==n-1){
                dp[i]=1;
                continue;
            }

                dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
    public static int fibo_memo2(int s,int n,int []dp){
        if(n<=1){
            if(n==1)
            return dp[n]=1;
            return 0;
        }
        if(dp[n]!=0)return dp[n];

        int c=0;
        c+=fibo_memo2(s,n-1,dp);
        c+=fibo_memo2(s,n-2,dp);

        return dp[n]=c;
    }
    public static int fibo_dp2(int s,int n,int []dp){
        for(int i=1;i<=n;i++){
            if(i==1||i==2){
                dp[i]=1;
                continue;
            }
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    } 
    public static void display_1(int[]arr){
        int n=arr.length;
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
    public static int mazepath(int sr,int sc,int er,int ec,int[][]dp){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0)
        return dp[sr][sc];

        int c=0;
        if(sc+1<=ec)
        c+=mazepath(sr,sc+1,er,ec,dp);
        if(sr+1<=er)
        c+=mazepath(sr+1,sc,er,ec,dp);
        if(sr+1<=er && sc+1<=ec)
        c+=mazepath(sr+1,sc+1,er,ec,dp);

        return dp[sr][sc]=c;
    }
    public static int mazepath_dp(int sr,int sc,int er,int ec,int[][]dp){
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[i].length-1;j>=0;j--){
                if(i==dp.length-1||j==dp.length-1){
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j]=dp[i+1][j] + dp[i][j+1] + dp[i+1][j+1];
            }
        }
        return dp[0][0];
    }
    public static int mazepath_multi(int sr,int sc,int er,int ec,int [][]dp){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0)
        return dp[sr][sc];
        int c=0;
        for(int i=1;i<=er;i++)
        if(sr+i<=er)
        c+=mazepath_multi(sr+i,sc,er,ec,dp);
        else break;
        for(int i=1;i<=ec;i++)
        if(sc+i<=ec)
        c+=mazepath_multi(sr,sc+i,er,ec,dp);
        else break;
        for(int i=1;i<=er && i<=ec;i++)
        if(sr+i<=er && sc+i<=ec)
        c+=mazepath_multi(sr+i,sc+i,er,ec,dp);
        else break;

        return dp[sr][sc]=c;
    }
    public static int mazepath_multi_2(int sr,int sc,int er,int ec,int [][]dp){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }

        if(dp[sr][sc]!=0)
        return dp[sr][sc];
        int c=0;
        for(int i=1;sr+i<=er;i++)
        c+=mazepath_multi_2(sr+i,sc,er,ec,dp);
        
        for(int i=1;sc+i<=ec;i++)
        c+=mazepath_multi_2(sr,sc+i,er,ec,dp);
       
        for(int i=1;sr+i<=er && sc+i<=ec;i++)
        c+=mazepath_multi_2(sr+i,sc+i,er,ec,dp);

        return dp[sr][sc]=c;
    }
    public static int mazepath_multi_dp(int sr,int sc,int er,int ec,int[][]dp){
        for(int i=er;i>=0 ;i--){
            for(int j=ec;j>=0 ;j--){

                if(i==er && j==ec){
                    dp[i][j]=1;
                    continue;
                }
                for(int k=1;j+k<=ec;k++)
                dp[i][j]+=dp[i][j+k];

                for(int k=1;k+i<=er;k++)
                dp[i][j]+=dp[i+k][j];

                for(int k=1;k+i<=er && k+j<=ec;k++)
                dp[i][j]+=dp[i+k][j+k];

            }
        }
        return dp[0][0];
    }
    public static int boardpath(int sr,int sc,int er,int ec,int[][]dp){
        if(sr==er-1 && sc==ec-1){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0)
        return dp[sr][sc];
        int c=0;
        for(int i=1;i<=6;i++){
            
            int a=sr*ec+sc;
            a=a+i;
            if(a<=ec*er-1){
                c+=boardpath(a/ec,a%ec,er,ec,dp);
            }
        }
        return dp[sr][sc]=c;
    }
    public static int boardpath_dp(int sr,int sc,int er,int ec,int [][]dp){
        for(int i=er-1;i>=0;i--){
            for(int j=ec-1;j>=0;j--){
                if(i==er-1 && j==ec-1){
                    dp[i][j]=1;
                    continue;
                }
                int c=0;
                for(int k=i*ec+j+1,l=1;k<=(er*ec-1) && l<=6;l++,k++){
                    c+=dp[k/ec][k%ec];
                }
                dp[i][j]=c;
            }
        }
        return dp[0][0];
    }
    public static int boardpath_arr(int sr,int sc,int er,int ec,int[][]dp,int []arr){
        if(sr==er-1 && sc==ec-1){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0)
        return dp[sr][sc];

        int c=0;
        for(int i=0;i<arr.length;i++){
            int a=sr*ec+sc;
            a+=arr[i];
            if(a<=(er*ec-1)){
                c+=boardpath_arr(a/ec,a%ec,er,ec,dp,arr);
            }
        }
        return dp[sr][sc]=c;
    }
    public static int friends_pairing(int n,int[]dp){
        if(n==0||n==1){
            return dp[n]=1;
        }
        if(dp[n]!=0)
        return dp[n];
        int c=0;
        c+=friends_pairing(n-1,dp);

        // for(int i=1;i<=n-1;i++)
        c+=friends_pairing(n-2,dp)*(n-1);
        return dp[n]=c;
    }
    public static int friends_pairing_dp(int n,int[]dp){
        for(int i=0;i<=n;i++){
            if(i==0||i==1){
             dp[i]=1;
             continue;}

            if(dp[i]!=0)
           continue;

           dp[i]=dp[i-1]+dp[i-2]*(i-1);
        }
        return dp[n];
    }
    public static int goldmine(int sr,int sc,int er,int ec,int [][]arr,int[][]dp){
        if(sr==er && sc==ec){
            return dp[sr][sc]=arr[sr][sc];
        }
        int a=0;
        int b=0;
        int c=0;
        if(sr-1>=0 && sc+1<=ec)
        a=goldmine(sr-1,sc+1,er,ec,arr,dp);
        if(sc+1<=ec)
        b=goldmine(sr,sc+1,er,ec,arr,dp);
        if(sr+1<=er && sc+1<=ec)
        c=goldmine(sr+1,sc+1,er,ec,arr,dp);

        return dp[sr][sc]=Math.max(Math.max(a,b),c)+arr[sr][sc];
    }
    // public static int n_person_in_k_groups(int n,int k,int kk,int[]dp){
    //     if(k==1||n==k)
    //     return dp[n]=1;

    //     if(dp[n]!=0)
    //     return dp[n];
    //     int c=0;
    //     c+=n_person_in_k_groups(n-1,k-1,kk,dp);
    //     c+=n_person_in_k_groups(n-1,k,kk,dp)*k;

    //     return dp[n]=c;
    // }
    public static int n_person_in_k_groups_2(int n,int k,int kk,int[][]dp){
        if(k==1||n==k)
        return dp[n][k]=1;

        if(dp[n][k]!=0)
        return dp[n][k];
        int c=0;
        c+=n_person_in_k_groups_2(n-1,k-1,kk,dp);
        c+=n_person_in_k_groups_2(n-1,k,kk,dp)*k;

        return dp[n][k]=c;
    }
    public static int n_person_in_k_groups_dp(int N,int K,int kk,int[][]dp){
        for(int n=1;n<=N;n++){
            for(int k=1;k<=K;k++){

        if(k==1||n==k){
         dp[n][k]=1;
         continue;}

        int c=0;
        c+=dp[n-1][k-1];
        c+=dp[n-1][k]*k;

         dp[n][k]=c;
            }
        }
        return dp[N][K];
    }
    public static boolean[][] is_palindrome_substring(String str){
        int n=str.length();
        boolean[][]dp=new boolean[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;i<n && j<n;i++,j++){
                if(gap==0)
                dp[i][j]=true;
                else if(gap==1){
                    if(str.charAt(i)==str.charAt(j))
                    dp[i][j]=true;
                }
                else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1])
                    dp[i][j]=true;
                }
            }
        }
        return dp;
    }
    public static int[][] longest_palindrome_substring(String str){
        int n=str.length();
        int[][]dp=new int[n][n];
        int max=1;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;i<n && j<n;i++,j++){
                if(gap==0)
                dp[i][j]=1;
                else if(gap==1){
                    if(str.charAt(i)==str.charAt(j)){
                    dp[i][j]=2;
                    max=Math.max(max,dp[i][j]);
                    }
                }
                else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]>0){
                    dp[i][j]=gap+1;
                    max=Math.max(max,dp[i][j]);
                    }
                }
            }
        }
        System.out.println(max);
        return dp;
    }
    public static int count_all_palindrome_substring(String str){
        int n=str.length();
        int[][]dp=new int[n][n];
        int count=0;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;i<n && j<n;i++,j++){
                if(gap==0)
                dp[i][j]=1;
                else if(gap==1){
                    if(str.charAt(i)==str.charAt(j)){
                    dp[i][j]=2;
                    }
                }
                else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]>0){
                    dp[i][j]=gap+1;
                    }
                }
                if(dp[i][j]!=0)
                count++;
            }
        }
       return count;
    }

    public static int longest_palindrome_subsequence(int si,int ei,String str,int [][]dp,boolean [][]ispal){
        if(ispal[si][ei])
        return ei-si+1;

        if(dp[si][ei]!=0)
        return dp[si][ei];

        int len=0;
        if(str.charAt(si)==str.charAt(ei))
        len=longest_palindrome_subsequence(si+1,ei+1,str,dp,ispal)+2;
        else
        len=Math.max(longest_palindrome_subsequence(si+1,ei,str,dp,ispal),longest_palindrome_subsequence(si,ei-1,str,dp,ispal));

        return dp[si][ei]=len;
    }
    public static int longest_palindrome_subsequence_dp(int si,int ei,String str,int [][]dp,boolean [][]ispal){
        int n=str.length();
        for(int gap=0;gap<n;gap++){
            for( si=0,ei=gap;si<n && ei<n;si++,ei++){
                if(ispal[si][ei]){
                dp[si][ei]= ei-si+1;
                continue;
                }

                    int len=0;
                    if(str.charAt(si)==str.charAt(ei))
                    len=dp[si+1][ei+1]+2;
                    else
                    len=Math.max(dp[si+1][ei],dp[si][ei-1]);

                     dp[si][ei]=len;
             }
         }
         return dp[0][n-1];
    }

    public static int distinct_subsequence(int si1,int si2,String str,String t,int[][]dp){
        if(si2==t.length())
            return dp[si1][si2]=1;
        if(str.length()==si1)
            return 0;
        
        if(dp[si1][si2]!=-1)
            return dp[si1][si2];
        
        int c=0;
        if(str.charAt(si1)==t.charAt(si2))
        c+=distinct_subsequence(si1+1,si2+1,str,t,dp);
            c+=distinct_subsequence(si1+1,si2,str,t,dp);
        
        return dp[si1][si2]=c;
    }

    public static int [][]distinct_subsequence_dp(int si1,int si2,String str,String t,int[][]dp){
        for(si1=str.length();si1>=0;si1--){
            
            for(si2=t.length();si2>=0;si2--){
                
        if(si2==t.length()){
             dp[si1][si2]=1;
            continue;
        }
        // if(si2>si1)
        //      continue;
        if(str.length()==si1)
            continue;
     
        int c=0;
        if(str.charAt(si1)==t.charAt(si2))
        c+=dp[si1+1][si2+1];
            c+=dp[si1+1][si2];
        
         dp[si1][si2]=c;
    }
}
        return dp;
    }
    public static int count_palindromic_subsequence(String str,int s1,int s2,int[][]dp){
        if(s1>s2)
        return 0;
        if(s1==s2)
        return 1;

        if(dp[s1][s2]!=0)
        return dp[s1][s2];

        int a=count_palindromic_subsequence(str,s1+1,s2-1,dp);
        int b=count_palindromic_subsequence(str,s1+1,s2,dp);
        int c=count_palindromic_subsequence(str,s1,s2-1,dp);

        int ans=0;
        if(str.charAt(s1)==str.charAt(s2))
        ans=b+c+1;
        else
        ans=b+c-a;
        return dp[s1][s2]=ans;
    }
    public static int count_palindromic_subsequence_dp(String str,int s1,int s2,int[][]dp){
        int n=str.length();
        for(int gap=0;gap<str.length();gap++){
            for( s1=0,s2=gap;s1<n && s2<n;s1++,s2++){

            if(s1>s2)
            continue;
            if(s1==s2){
            dp[s1][s2]=1;
            continue;}

            int a=dp[s1+1][s2-1];
            int b=dp[s1][s2-1];
            int c=dp[s1+1][s2];

            int ans=0;
            if(str.charAt(s1)==str.charAt(s2))
            ans=b+c+1;
            else
            ans=b+c-a;
             dp[s1][s2]=ans;
      }
    }
    return dp[0][n-1];
 }
        public static int lcs(int si1,int si2,String str1,String str2,int[][]dp){
            if(si1==str1.length()||si2==str2.length())return 0;

            if(dp[si1][si2]!=0)return dp[si1][si2];

            int max=0;
            if(str1.charAt(si1)==str2.charAt(si2)){
                max=Math.max(max,lcs(si1+1,si2+1,str1,str2,dp))+1;
            }else{
                max=Math.max(max,Math.max(lcs(si1+1,si2,str1,str2,dp),lcs(si1,si2+1,str1,str2,dp)));
            }
            return dp[si1][si2]=max;
        }
        public static int lcs_dp(int si1,int si2,String str1,String str2,int[][]dp){
            for(si1=str1.length();si1>=0;si1--){
                for(si2=str2.length();si2>=0;si2--){

            if(si1==str1.length()||si2==str2.length())
               continue;

            int max=0;
            if(str1.charAt(si1)==str2.charAt(si2)){
                max=Math.max(max,dp[si1+1][si2+1])+1;
            }else{
                max=Math.max(max,Math.max(dp[si1+1][si2],dp[si1][si2+1]));
            }
             dp[si1][si2]=max;
        }
    }
    return dp[0][0];
}

public static int ma=0;
public static int longest_common_palindrome_substring(int si1,int si2,String str1,String str2,int[][]dp){
    if(si1==str1.length()||si2==str2.length())
    return 0;

    if(dp[si1][si2]!=0)
    return dp[si1][si2];

    longest_common_palindrome_substring(si1+1,si2,str1,str2,dp);
    longest_common_palindrome_substring(si1,si2+1,str1,str2,dp);

    if(str1.charAt(si1)==str2.charAt(si2)){
    ma=Math.max(ma,longest_common_palindrome_substring(si1+1,si2+1,str1,str2,dp)+1);
    return dp[si1][si2]=ma;
    }

    return 0;
}

public static int longest_common_palindrome_substring_dp(int si1,int si2,String str1,String str2,int[][]dp){
    int max=0;
    for(si1=str1.length();si1>=0;si1--){
        for(si2=str2.length();si2>=0;si2--){

    if(si1==str1.length()||si2==str2.length())
    continue;

    if(str1.charAt(si1)==str2.charAt(si2)){
    max=Math.max(max,dp[si1+1][si2+1]+1);
    dp[si1][si2]=max;
    }
    }
    }
    return max;
}
public static int coin_change_permutation_infinite(int []arr,int tar,int[]dp){
if(tar==0)
return dp[tar]=1;

if(dp[tar]!=0)
return dp[tar];

int c=0;
for(int i=0;i<arr.length;i++){
if(tar-arr[i]>=0)
c+=coin_change_permutation_infinite(arr,tar-arr[i],dp);
}
return dp[tar]=c;
}
public static int coin_change_permutation_infinite_dp(int []arr,int Tar,int[]dp){
    for(int tar=0;tar<=Tar;tar++){
    if(tar==0){
     dp[tar]=1;
     continue;
    }
    
    int c=0;
    for(int i=0;i<arr.length;i++){
    if(tar-arr[i]>=0)
    c+=dp[tar-arr[i]];
    }
     dp[tar]=c;
    }
    return dp[Tar];
}
public static int coin_change_combination_infinite(int []arr,int idx,int tar,int[]dp){
    if(tar==0)
    return dp[tar]=1;
    
    if(dp[tar]!=0)
    return dp[tar];
    
    int c=0;
    for(int i=idx;i<arr.length;i++){
    if(tar-arr[i]>=0)
    c+=coin_change_combination_infinite(arr,i,tar-arr[i],dp);
    }
    return dp[tar]=c;
    }
    public static int coin_change_combination_infinite_dp(int []arr,int Tar,int[]dp){
        for(int i=0;i<arr.length;i++){
            int tar=0;
        for( tar=0;tar<=Tar;tar++){
            int c=0;
        if(tar==0){
         dp[tar]=1;
         continue;
        }
        if(tar-arr[i]>=0)
        c+=dp[tar-arr[i]];
        dp[tar]+=c;
        } 
        }
        return dp[Tar];
    }
    public static int coin_change_one_coin_combination(int []arr,int idx,int tar,int[][] dp){
        if(tar==0)return dp[idx][tar]=1;
        if(idx==arr.length){
           return 0; 
        }
        if(dp[idx][tar]!=0)
        return dp[idx][tar];

        int c=0;   
            if(tar-arr[idx]>=0)
            c+=coin_change_one_coin_combination(arr,idx+1,tar-arr[idx],dp);
            c+=coin_change_one_coin_combination(arr,idx+1,tar,dp);

           return dp[idx][tar]=c;
    }
    public static int coin_change_one_coin_combination_02(int []arr,int idx,int tar,int[][] dp){
        if(tar==0)return dp[idx][tar]=1;
        if(idx==0){
           return 0;
        }
        if(dp[idx][tar]!=0)
        return dp[idx][tar];

        int c=0;   
            if(tar-arr[idx-1]>=0)
            c+=coin_change_one_coin_combination_02(arr,idx-1,tar-arr[idx-1],dp);
            c+=coin_change_one_coin_combination_02(arr,idx-1,tar,dp);

           return dp[idx][tar]=c;
    }
    public static int coin_change_one_coin_combination_dp(int []arr,int Idx,int Tar,int[][] dp){
        for(int idx=0;idx<=Idx;idx++){
            for(int tar=0;tar<=Tar;tar++){

        if(tar==0){ 
            dp[idx][tar]=1;
            continue;
        }
        if(idx==0){
           continue;
        }
       
        int c=0;   
            if(tar-arr[idx-1]>=0)
            c+=dp[idx-1][tar-arr[idx-1]];
            c+=dp[idx-1][tar];

            dp[idx][tar]=c;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static int print_path_of_target_sum(int[]arr,int idx,int tar,int [][]dp,String ans){
        if(tar==0){
            System.out.println(ans);
        return 1;
        }
        if(idx==0)return 0;

        int c=0;
        if(tar-arr[idx-1]>=0 && dp[idx-1][tar-arr[idx-1]]>0)
            c+=print_path_of_target_sum(arr,idx-1,tar-arr[idx-1],dp,ans+(arr[idx-1]));
            if(dp[idx-1][tar]>0)
            c+=print_path_of_target_sum(arr,idx-1,tar,dp,ans);

           return c;
    }
    public static int knapsack(int[]val,int[]wt,int idx,int w,int n,int[][]dp){//can also be done by 1-D DP
        if(idx==0){
            return 0;
        }
        if(dp[idx][w]!=0)
        return dp[idx][w];

        int max=0;
        if(w-wt[idx-1]>=0)
        max=Math.max(max,knapsack(val,wt,idx-1,w-wt[idx-1],n,dp)+val[idx-1]);
        max=Math.max(max,knapsack(val,wt,idx-1,w,n,dp));

        return dp[idx][w]=max;
    }
    public static int knapsack_dp(int[]val,int[]wt,int Idx,int W,int n,int[][]dp){//can also be done by 1-D DP
        for(int idx=0;idx<=Idx;idx++){
            for(int w=0;w<=W;w++){

        if(idx==0){
           continue;
        }
        int max=0;
        if(w-wt[idx-1]>=0)
        max=Math.max(max,dp[idx-1][w-wt[idx-1]]+val[idx-1]);
        max=Math.max(max,dp[idx-1][w]);

         dp[idx][w]=max;
            }
        }
return dp[Idx][W];
    }

    public static int knapsack_unbounded(int[]val,int[]wt,int idx,int w,int n,int[][]dp){
        if(idx==0){
            return 0;
        }
        if(dp[idx][w]!=0)
        return dp[idx][w];

        int max=0;
        if(w-wt[idx-1]>=0)
        max=Math.max(max,knapsack_unbounded(val,wt,idx,w-wt[idx-1],n,dp)+val[idx-1]);
        max=Math.max(max,knapsack_unbounded(val,wt,idx-1,w,n,dp));

        return dp[idx][w]=max;
    }
    public static int knapsack_unbounded_dp(int[]val,int[]wt,int Idx,int W,int n,int[][]dp){
        for(int idx=0;idx<=Idx;idx++){
            for(int w=0;w<=W;w++){

        if(idx==0){
           continue;
        }
        
        int max=0;
        if(w-wt[idx-1]>=0)
        max=Math.max(max,dp[idx][w-wt[idx-1]]+val[idx-1]);
        max=Math.max(max,dp[idx-1][w]);

         dp[idx][w]=max;
    }
}
return dp[Idx][W];
}
public static int LIS_left_to_right(int[]arr,int[]dp){
    int omax=0;
    for(int i=0;i<arr.length;i++){
        int max=0;
        for(int j=0;j<i;j++){
            if(arr[i]>arr[j] && max<dp[j])
            max=dp[j];
        }
        dp[i]=max+1;
        omax=Math.max(omax,max+1);
    }
    return omax;
}

public static int LDS_left_to_right(int[]arr,int[]dp){
    int omax=0;
    for(int i=arr.length-1;i>=0;i--){
        int max=0;
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j] && max<dp[j])
            max=dp[j];
        }
        dp[i]=max+1;
        omax=Math.max(omax,max+1);
    }
    return omax;
}
public static int LBS(int[]arr){
    int max=0;
    int n=arr.length;
    int[]dp1=new int[n];
    int[]dp2=new int[n];
    LIS_left_to_right(arr,dp1);
    LDS_left_to_right(arr,dp2);
    for(int i=0;i<n;i++){
        max=Math.max(max,dp1[i]+dp2[i]);
    }
    return max-1;
}
public static int LIS_right_to_left(int[]arr,int[]dp){
    int omax=0;
    for(int i=0;i<arr.length;i++){
        int max=0;
        for(int j=0;j<i;j++){
            if(arr[i]<arr[j] && max<dp[j])
            max=dp[j];
        }
        dp[i]=max+1;
        omax=Math.max(omax,max+1);
    }
    return omax;
}
public static int inverse_LBS(int[]arr){
    int max=0;
    int n=arr.length;
    int[]dp1=new int[n];
    int[]dp2=new int[n];
    LIS_right_to_left(arr,dp1);
    LIS_left_to_right(arr,dp2);
    for(int i=0;i<n;i++){
        max=Math.max(max,dp1[i]+dp2[i]);
    }
    return max-1;
}
public static int max_increasing_sum_subseq(int[]arr,int[]dp){
    int omax=0;
    for(int i=0;i<arr.length;i++){
        int max=0;
        for(int j=0;j<i;j++){
            if(arr[i]>arr[j] && max<dp[j])
            max=dp[j];
        }
        dp[i]=max+arr[i];
        omax=Math.max(omax,dp[i]);
    }
    return omax;
}
public static int max_decreasing_sum_subseq(int[]arr,int[]dp){
    int omax=0;
    for(int i=arr.length-1;i>=0;i--){
        int max=0;
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j] && max<dp[j])
            max=dp[j];
        }
        dp[i]=max+arr[i];
        omax=Math.max(omax,dp[i]);
    }
    return omax;
}
public static int max_sum_biotonic_subseq(int[]arr){
    int max=0;
    int n=arr.length;
    int[]dp1=new int[n];
    int[]dp2=new int[n];
    max_increasing_sum_subseq(arr,dp1);
    max_decreasing_sum_subseq(arr,dp2);
    for(int i=0;i<n;i++){
        max=Math.max(max,dp1[i]+dp2[i]-arr[i]);
    }
    return max;
}
public static int mcm(int []arr,int si,int ei,int[][]dp){
    if(si+1==ei)
    return dp[si][ei]=0;

    if(dp[si][ei]!=0)return dp[si][ei];

    int ans=1000000;
    for(int cut=si+1;cut<ei;cut++){
        int left=mcm(arr,si,cut,dp);
        int right=mcm(arr,cut,ei,dp);
        int cost=left+ arr[si]*arr[cut]*arr[ei] +right;
        if(cost<ans)
        ans=cost;
    }
    return dp[si][ei]=ans;
}
    public static int mcm_dp(int []arr,int si,int ei,int [][]dp){
    int n=arr.length;
    for(int gap=1;gap<n;gap++){
        for(si=0,ei=gap;ei<n;si++,ei++){
            if(si+1==ei)
            continue;

            int ans=1000000;
            for(int cut =si+1;cut<ei;cut++){
                int left=dp[si][cut];
                int right=dp[cut][ei];
                int cost=left + arr[si]*arr[cut]*arr[ei] + right;
                if(cost<ans)
                ans=cost;
            }
            dp[si][ei]=ans;
        }
    }
    return dp[0][n-1];
}
public static String mcm_dp_ans(int []arr,int si,int ei,int [][]dp){
    int n=arr.length;
    String[][]sdp=new String[n][n];
    for(int gap=1;gap<n;gap++){
        for(si=0,ei=gap;ei<n;si++,ei++){
            if(si+1==ei){
                sdp[si][ei]=((char)('A'+si))+"";
            continue;
            }

            int ans=1000000;
            String a="";
            for(int cut=si+1;cut<ei;cut++){
                int left=dp[si][cut];
                int right=dp[cut][ei];
                int cost=left+arr[si]*arr[cut]*arr[ei]+right;
                if(cost<ans){
                ans=cost;
                a="("+sdp[si][cut]+sdp[cut][ei]+")";
                }
            }
            dp[si][ei]=ans;
            sdp[si][ei]=a;
        }
    }
    return sdp[0][n-1];
}
public static int OBST(int[]freq,int si,int ei,int [][]dp){
    
    int ans=1000000;
    for(int cut =si;cut<=ei;cut++){
        int left=si==cut?0:OBST(freq,si,cut-1,dp);
        int right=ei==cut?0:OBST(freq,cut+1,ei,dp);
        int cost=left+cost_calc(freq,si,ei)+right;
        if(cost<ans)
        ans=cost;
    }
    return dp[si][ei]=ans;
}
public static int cost_calc(int[]freq,int si,int ei){
    int sum=0;
    for(int i=si;i<=ei;i++)
    sum+=freq[i];
    return sum;
}
public static int OBST_DP(int[]freq,int si,int ei,int [][]dp){
    int n=freq.length;
    int []psa=new int[n+1];
    for(int i=1;i<=n;i++)
    psa[i]=psa[i-1]+freq[i-1];

    for(int gap=0;gap<n;gap++){
        for(si=0,ei=gap;ei<n;si++,ei++){
            int ans=1000000;
    for(int cut =si;cut<=ei;cut++){
        int left=si==cut?0:dp[si][cut-1];
        int right=ei==cut?0:dp[cut+1][ei];
        int cost=left+psa[ei+1]-psa[si]+right;
        if(cost<ans)
        ans=cost;
    }
    dp[si][ei]=ans;
        }
    }
    return dp[0][n-1];
}
public static int burst_balloons(int[]arr,int si,int ei,int[][]dp){

    if(dp[si][ei]!=0)
    return dp[si][ei];

    int lv=si==0?1:arr[si-1];
    int rv=ei==arr.length-1?1:arr[ei+1];
    int ans=0;
    for(int cut=si;cut<=ei;cut++){
        int left=cut==si?0:burst_balloons(arr,si,cut-1,dp);
        int right=cut==ei?0:burst_balloons(arr,cut+1,ei,dp);
        int cost=left+ lv*arr[cut]*rv +right;
        if(cost<ans)
        ans=cost;
    }
    return dp[si][ei]=ans;
}
public static int decode_ways (String str,int si,int ei,int[]dp){
    if(si>=ei){
        return dp[si]=1;
    }
   
    if(dp[si]!=0)
        return dp[si];
    
    int c=0;
         int a=str.charAt(si)-'0';
    if(a!=0)
        c+=decode_ways(str,si+1,ei,dp);
   
    int b=str.charAt(si+1)-'0';
    int z=a*10+b;
    if(z<=26 && z>=1 && a!=0)
        c+=decode_ways(str,si+2,ei,dp);
    
    return dp[si]=c;
}
public static int decode_ways_dp(String str,int si,int ei,int[]dp){
    int n=str.length();
    for(int i=n-1;i>=0;i--){
        int a=str.charAt(i)-'0';
        if(i==n-1 && a!=0)
        dp[i]=1;
        else if(i==n-2 && a!=0 && (a*10+(str.charAt(i+1)-'0'))<=26){
            dp[i]=1+dp[i+1];
        }
        else if(i==n-1 && a!=0 ){
            dp[i]=1;
        }
        else if(a!=0 && (a*10+(str.charAt(i+1)-'0'))<=26){
            dp[i]=dp[i+1]+dp[i+2];
        }
        else if(a!=0){
            dp[i]=dp[i+1];
        }
    }
    return dp[0];
}
public static int dis_subseq(String str,int vidx,int[]dp){
    if(vidx==str.length())
    return dp[vidx]=1;

    if(dp[vidx]!=0)
    return dp[vidx];

    int c=0;
    c+=dis_subseq(str.vidx+1,dp);
    c+=dis_subseq(str)
}
    
    public static void display(int[][]arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
        for(int j=0;j<arr[i].length;j++)
        System.out.print(arr[i][j]+" ");
        System.out.println();
        }
    }
    public static void main(String[]args){
        int n=3;
        
        // System.out.println(fibo_memo2(0,n,dp));
        // display_1(dp);
        
        // System.out.println(boardpath_arr(0,0,n,n,dp,new int[]{2,3,5,7}));
        // int[][]arr=distinct_subsequence_dp(0,0,"rabbbit","rabbit",dp);
        // String str1="ABCDGH";
        // String str2="ACDGHR";
        // int[][]dp=new int[str1.length()][str2.length()];
        // System.out.println(longest_common_palindrome_substring(0,0,str1,str2,dp));
        // int[][]dp=new int[4+1][10+1];
        // System.out.println(coin_change_one_coin_combination_dp(new int[]{2,3,5,7},4,10,dp));
        //  display(dp);
        //  print_path_of_target_sum(new int[]{2,3,5,7},4,10,dp,"");
        //  System.out.println(ma);
        // int []val={0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15,8};
        // int[]wt={10,20,30};
        //writing in different contexts
        int[]arr={2,5,6,3,4};
        String str="12";
        int[]dp=new int[str.length()+1];
        System.out.println(decode_ways_dp(str,0,dp));
        display_1(dp);
    }
}