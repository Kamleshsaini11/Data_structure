// Dijkstra algo
#include<bits/stdc++.h>
using namespace std;

#define ll long long int
#define mp make_pair
#define pb push_back
#define fir first
#define sec second
#define pi pair<ll, ll>
#define f(a) for(int i=0;i<a;i++)
#define rep(i,a,b) for(int i=a;i<b;i++)
#define rrep(i,a,b) for(int i=a;i>=b;i--)
#define mod(a) a%(int)(1e9+7)
#define _fast_ ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);

set<int> s;

void shortest_path(vector<vector<int>> dis,vector<vector<int>> vec,int src)
{
    int n=dis.size();
    int d[n];
    fill(d,d+n,INT_MAX);
    d[0]=0;
    while(s.size()!=n)
    {
        int minVal=INT_MAX,minIndex=0;
        for(int i=0;i<vec.size();i++)
        {
            if (s.count(i)==0&&minVal>d[i])
            {
               minVal=d[i];
               minIndex=i;
            }
        }
        s.insert(minIndex);
        for(int i=0;i<vec[minIndex].size();i++)
        {
            if (s.count(vec[minIndex][i]))
               continue;
            else{
                if (d[vec[minIndex][i]]>minVal+dis[minIndex][vec[minIndex][i]])
                   d[vec[minIndex][i]]=minVal+dis[minIndex][vec[minIndex][i]];
            }
        }
    }
    for(int i=0;i<n;i++)
       cout<<d[i]<<" ";
} 

int main()
{
    int n=0,e=0;   // no. of vertex and edges
    cin>>n>>e;
    vector<vector<int>> dis(n);
    vector<int> vv(n,0);
    for(int i=0;i<n;i++)
       dis[i].insert(dis[i].end(),vv.begin(),vv.end());
    vector<vector<int>> vec;
    vector<int> vi;
    for(int i=0;i<n;i++)
       vec.pb(vi);
    while(e--)
    {
       int u=0,v=0,di=0;
       cin>>u>>v>>di;
       vec[u].pb(v);
       vec[v].pb(u);
       dis[u][v]=di;  dis[v][u]=di;  
    }
    shortest_path(dis,vec,0); 
}