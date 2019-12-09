import java.lang.String;
import java.util.*;
class BST2
{
    static Node head;
    BST2()
    {
        head=null;
    }
    public void add(int x)
    {
        Node n=new Node(x);
        head=insert(head,n);
    }
    public Node insert(Node node,Node n)
    {
        if (node==null)
            return n;
        else if (node.data>n.data)
            node.left=insert(node.left,n);
        else
            node.right=insert(node.right,n);
        return node;
    }
    public void Inorder(Node n)
    {
        if (n==null)
            return ;
        else
        {
            Inorder(n.left);
            System.out.print(n.data+" ");
            Inorder(n.right);
        }
    }
    public int tree_height(Node node)     // for find out height of tree
    {
        if (node==null)
            return 0;
        else
        {
            int a=tree_height(node.left)+1;
            int b=tree_height(node.right)+1;
            return a>b?a:b;
        }
    }
    public void LevelOrder(int h)             // level order traversal using height
    {
        for(int i=1;i<=h;i++)
        {
            Lotraverse(head,i);
            System.out.println("");
        }    
    }
    public void Lotraverse(Node node,int level)
    {
        if (node==null)
           return ;
        else if (level==1)
           System.out.print(node.data+" ");
        else{
            Lotraverse(node.left,level-1);
            Lotraverse(node.right,level-1);
        }
    }
    public void level_order_traverse(Node head)  // level order traversal using queue
    {
        Queue q=new LinkedList();
        q.add(head);
        while(!q.isEmpty())
        {
            Node n=q.poll();
            if (n.left!=null)
               q.add(n.left);
            if (n.right!=null)
               q.add(n.right);
            System.out.print(n.data+" ");
        }
    }
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        BST2 obj=new BST2();
        obj.add(20);        
        obj.add(10);
        obj.add(30);
        obj.add(7);
        obj.add(12);
        obj.add(25);
        obj.add(23);
        int h=obj.tree_height(head);
        //System.out.println("height is "+h);
        obj.Inorder(head);
        obj.LevelOrder(h);
        obj.level_order_traverse(head);
    }
}