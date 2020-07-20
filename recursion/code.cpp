#include<bits/stdc++.h>
using namespace std;
vector<string>words={":,/","abc","def","ghi","jkl","mno","pqrs","tuv","wx","*#@","yz","+-"};
vector<string> nokiakeypad(string str){
    if(str.length()==0){
        vector<string>arr;
        arr.push_back("");
        return arr;
    }
    char ch=str[0];
    int idx=ch-'0';             //idx=ch-48;    48 is ASCII of zero.
    string word=words[idx];
    vector<string> smallans=nokiakeypad(str.substr(1));
    vector<string>myans;
    for(string s:smallans){
        for(int i=0;i<word.length();i++){
            myans.push_back(word[i]+s);
        }
    }
    return myans;
}
void nokiakeypad2(string str,string ans){
    if(str.length()==0){
        cout<<ans<<" ";
        return ;
    }
    int idx=str[0]-'0';
    string word=words[idx];
 
    for(int i=0;i<word.length();i++){
       nokiakeypad2(str.substr(1),ans+word[i]);
    }
    if(str.length()>1){
        int idx1=str[1]-'0';
        int num=idx*10+idx1;
        if(num>=10 && num<=11){
            word=words[num];
            for(int i=0;i<word.length();i++){
                nokiakeypad2(str.substr(2),ans+word[i]);
            }
        }
    }
}

int main(){
    // vector<string > res =nokiakeypad("1234");
    // for(auto x: res)
    //     cout<< x <<" ";
    nokiakeypad2("123","");
    cout<< endl;
}