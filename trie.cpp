// trie
#include<bits/stdc++.h>
using namespace std;

#define pb push_back

struct Node{
    int count;
    struct Node* child[26];
    Node(){
       count=0;
       for(int i=0;i<26;i++)
         child[i]=NULL;
    }   
};

struct Node *newNode() 
{ 
    struct Node *temp =  (struct Node *)malloc(sizeof(struct Node)); 
    for(int i=0;i<26;i++)
         temp->child[i]=NULL;
    return temp; 
} 

void insertion(struct Node *root,string str)
{
    Node *curr=root;
    for(int i=0;i<str.length();i++)
    {
        if (curr->child[str.at(i)-'a']==NULL)
        {
            Node *n=newNode();
            curr->child[str.at(i)-'a']=n;
        }
        curr=curr->child[str.at(i)-'a'];
    }
    curr->count++; 
}

bool search(Node* root,string str)
{
    Node *curr=root;
    int f=1;
    for(int i=0;i<str.length();i++)
    {
       if (curr->child[str.at(i)-'a']==NULL){
          f=0;  break;
       }
       else
          curr=curr->child[str.at(i)-'a'];
    }
    if (f==0||curr->count==0)
      return false;
    else return true;   
}

void stWith(Node *curr_node,string curr_str,vector<string> &v);

void startWith(Node* root,string str,vector<string> &v)
{
    Node *curr=newNode();
    curr=root;
    for(int i=0;i<str.length();i++)
    {
        curr=curr->child[str.at(i)-'a'];
        if (curr==NULL)
           break;
    }
    if (curr!=NULL)
       stWith(curr,str,v);
}

void stWith(Node *curr_node,string curr_str,vector<string> &v)
{
    for(int i=0;i<26;i++)
    {
       if (curr_node->child[i]!=NULL)
          stWith(curr_node->child[i],curr_str+char(i+97),v);
    }
    if (curr_node->count>0)
      v.pb(curr_str);
}

int main()
{
    struct Node *root=newNode();
    int flag=true;
    while(flag)
    {
       cout<<"~~~~~~~Menu~~~~~~~~"<<endl<<"-1 << for exits"<<endl<<" 1 << insert"<<endl<<" 2 << search"<<endl<<" 3 << startWith"<<endl;
       int f=0;
       cin>>f;
       if (f==-1)
          flag=false;
       else
       {
          cout<<"enter string"<<endl;
          while(true){
          string str;
          cin>>str;
          if (str.compare("-1")==0)
             break;
          if (f==1)
            insertion(root,str);
          else if (f==2)
            cout<<search(root,str)<<endl;   // true -> if given string is in trie else false
          else{
            vector<string> v;
            startWith(root,str,v);
            if (v.size()==0) 
               cout<<"None of string start with "<<str<<endl;
            else{
            cout<<"string start with "<<str<<" are - "<<endl;
            for(int i=0;i<v.size();i++)
               cout<<v[i]<<endl; 
            }
          }
          }
       }
    }
}
