// Brust force approch for shortest path b/w single source and single destination(dp)
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
#define fast ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);

set<int> s;

int shortest_path(vector<vector<int>> &dp,vector<vector<int>> dis,vector<vector<int>> vec,int src,int dec)   // dec -> destination vertex
{
    if (src==dec)
       return 0;
    s.insert(src);
    int min=INT_MAX;
    for(int i=0;i<vec[src].size();i++)
    {
        int a=INT_MAX;
        if (s.count(vec[src][i])==0)
            a = dis[src][vec[src][i]]+shortest_path(dp,dis,vec,vec[src][i],dec);
        else if (dp[vec[src][i]][dec]!=0)
            a=dis[src][vec[src][i]]+dp[vec[src][i]][dec];
        if (min>a)
            min=a;
    }
    dp[src][dec]=min;
    return min;
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
    vector<vector<int>> dp(n,vv);
    cout<<shortest_path(dp,dis,vec,0,2)<<endl; 
}
