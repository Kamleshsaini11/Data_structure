// Segment tree
#include<bits/stdc++.h>
using namespace std;

void create_seg_tree(int st[],int prefix_sum[],int pos,int i,int j)
{
   //cout<<"hello"<<endl;
   if (i>0)
     st[pos]=prefix_sum[j]-prefix_sum[i-1];
   else
     st[pos]=prefix_sum[j];
    if (i==j)
       return ;
    create_seg_tree(st,prefix_sum,2*pos,i,(i+j)/2);
    create_seg_tree(st,prefix_sum,2*pos+1,(i+j)/2+1,j);
}

int sum(int st[],int pos,int ql,int qr,int i,int j)
{
   if (qr>j||ql<i||ql>qr)
      return -1;
   else if (ql==i&&qr==j)
      return st[pos];
   else if (ql>(i+j)/2)
      return sum(st,2*pos+1,ql,qr,(i+j)/2+1,j);
   else if (qr<=(i+j)/2)
      return sum(st,2*pos,ql,qr,i,(i+j)/2);
   else return sum(st,2*pos,ql,(i+j)/2,i,(i+j)/2)+sum(st,2*pos+1,(i+j)/2+1,qr,(i+j)/2+1,j);
}

int range_sum(int st[],int ql,int qr,int n)
{
   return sum(st,1,ql,qr,0,n-1);
}

void ud(int st[],int qpos,int pos,int i,int j,int e)   // for updating value of a perticuler array element
{
    st[pos]+=e;
    if (i==j)
       return ;
    else if (qpos<=(i+j)/2)
       ud(st,qpos,2*pos,i,(i+j)/2,e);
    else
       ud(st,qpos,2*pos+1,(i+j)/2+1,j,e);
}

void update(int st[],int qpos,int n,int e)
{
   ud(st,qpos,1,0,n-1,e);
}

void ud_range(int st[],int pos,int qi,int qj,int i,int j,int eff)
{
   if (i==j)
   {
      st[pos]+=eff;
      return ;  
   }
   else if (qj<=(i+j)/2)
      ud_range(st,2*pos,qi,qj,i,(i+j)/2,eff);
   else if (qi>(i+j)/2)
      ud_range(st,2*pos+1,qi,qj,(i+j)/2+1,j,eff);
   else{
       ud_range(st,2*pos,qi,(i+j)/2,i,(i+j)/2,eff);
       ud_range(st,2*pos+1,(i+j)/2+1,qj,(i+j)/2+1,j,eff);
   }
   st[pos]=st[2*pos]+st[2*pos+1];
}

int main()
{
    int n=6;
    int arr[n]={1, 3, 5, 7, 9, 11};
    int prefix_sum[n]={0};
    prefix_sum[0]=arr[0];
    for(int i=1;i<n;i++)
       prefix_sum[i]=prefix_sum[i-1]+arr[i];
    int len=2*pow(2,ceil(log2(n)))-1;
    int st[len+1]={0};
    create_seg_tree(st,prefix_sum,1,0,n-1);
   //  cout<<range_sum(st,0,4,n)<<" ";
   //  cout<<range_sum(st,3,5,n)<<" ";
   //  cout<<range_sum(st,1,2,n)<<" ";
   //  cout<<range_sum(st,5,2,n)<<" ";
    int qpos=2,val=6;  // val -> new value at position qpos
    int e=val-arr[qpos];
    //update(st,qpos,n,e);
    ud_range(st,1,0,2,0,n-1,2);
    cout<<"st before update "<<endl;
    for(int i=0;i<=len;i++)
       cout<<st[i]<<" ";
    cout<<endl;
    ud_range(st,1,1,3,0,n-1,1);
    cout<<"st after update "<<endl;
    for(int i=0;i<=len;i++)
       cout<<st[i]<<" ";
    cout<<endl;
}