#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

int bs=0;
vector<int>blocks;

void update(int idx,int val){
    blocks[idx/bs]=blocks[idx/bs]-arr[idx]+val;
    arr[idx]=val;
}

void Query(int li,int ri){
    int sum=0;
    while(li%bs!=0 && li<=ri)sum+=arr[li++];

    while(li+bs<=rs){
        sum+=blocks[li/bs];
        li+=bs;
    }
    while(li<=ri)sum+=arr[li++];
}

void solve(){
    int n;
    cin>>n;
    bs=(int)sqrt(n);
    blocks.resize(bs+1,0);

    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        arr[i]=a;
        blocks[i/bs]+=a;
    }
    int q;
    cin>>q;
    while(q-->0){
        int c;
        cin>>c;
        if(c==1){
            int l,r;
            cin>>l>>r;
            cout<<Query(l,r);
        }
        else{
            int idx,val;
            cin>>idx>>val;
            update(idx,val);
        }
    }
} 
void main(){
    solve();

}