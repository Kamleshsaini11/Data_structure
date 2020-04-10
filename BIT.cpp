// fenwick tree or binary index tree
#include<bits/stdc++.h>
using namespace std;

void updateBIT(int bit[],int size,int pos,int val);

void create_bit(int arr[],int bit[],int size){
   for(int i=1;i<size;i++){
      updateBIT(bit,size,i,arr[i]);
   }
}

void updateBIT(int bit[],int size,int pos,int val){      // val-> effective value means new value - previous value 
   int j=pos;
   while(size>j){
      bit[j]+=val;
      j+=j & -(j);
   }
}

int getPrefixSum(int bit[],int pos){
    int sum=0;
    while(pos>0){
       sum+=bit[pos];
       pos-=pos & -(pos);
    }
    return sum;
}

int main()
{
   int arr[]={0,3,2,-1,6,5,4,-3,3,7,2,3};
   int bit[12];
   memset(bit,0,sizeof(bit));
   create_bit(arr,bit,12);
   for(int i=0;i<12;i++)
      cout<<bit[i]<<" ";
   cout<<getPrefixSum(bit,1)<<endl;
}






