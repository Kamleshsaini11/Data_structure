import java.lang.String;
import java.util.*;
class Node implements Comparable<Node>
{
    int data;
    Node l_ref;
    Node r_ref;
    Node(int data)
    {
        this.data=data;
        l_ref=null;
        r_ref=null;
    }
    public int compareTo(Node n)
    {
        if (data>n.data)
           return 1;
        else if (data<n.data)
           return -1;
        else
           return 0;
    }  
} 
class Huffman_codes
{
    public static PriorityQueue hf_cd(PriorityQueue q)
    {
        int len=q.size();     // no. of nodes in priority queue
        for(int i=1;i<len;i++)
        {
            Node node=new Node(0);
            Node n1=(Node)q.poll();
            Node n2=(Node)q.poll();
            node.data=n1.data+n2.data;
            node.l_ref=n1;
            node.r_ref=n2;
            q.add(node); 
        }
        return q;
    }
    public static int show(Node node,String str,char[] ch,int i) 
    {
        if (node.l_ref==null&&node.r_ref==null){
            System.out.println(ch[i]+": "+str);
            return ++i;
        }
        else if (node.l_ref!=null)
            i=show(node.l_ref,str+"0",ch,i);
        if (node.r_ref!=null) 
            i=show(node.r_ref,str+"1",ch,i);
        return i;
    } 
    public static void main(String args[]) {
        PriorityQueue<Node> q=new PriorityQueue<Node>();
        q.add(new Node(45));
        q.add(new Node(13));
        q.add(new Node(12));
        q.add(new Node(18));
        q.add(new Node(9));
        q.add(new Node(5));
        char[] ch={'a','b','c','d','e','f'};
        q=hf_cd(q);
        Node node=q.poll();
        show(node,"",ch,0);
    }
}