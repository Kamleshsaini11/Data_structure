import java.lang.String;
import java.util.*;
class fib_five
{
    public static String[][] Matrix_pow_recu(String M[][],int n)
    {
        if (n>1)
        {
            if (n%2==0)
            {
                String c[][]=Matrix_pow_recu(M,n/2);
                M=square_matrix_multi(c,c);
            }
            else
            {
                String c[][]=Matrix_pow_recu(M,n-1);
                M=square_matrix_multi(M,c);
            }
        }
        return M;       
    }
    public static String[][] square_matrix_multi(String M1[][],String M2[][])
    {
        String M[][]=new String[2][2];
        M[0][0]=string_add(multi(M1[0][0],M2[0][0]),multi(M1[0][1],M2[1][0]));
        M[0][1]=string_add(multi(M1[0][0],M2[0][1]),multi(M1[0][1],M2[1][1]));
        M[1][0]=string_add(multi(M1[1][0],M2[0][0]),multi(M1[1][1],M2[1][0]));
        M[1][1]=string_add(multi(M1[1][0],M2[0][1]),multi(M1[1][1],M2[1][1]));
        return M;
    }
    public static String multi(String str1,String str2)
    {
        int len1=str1.length(),len2=str2.length();
        int arr1[]=new int[len1];
        int i=0,j=0;
        for(i=len1-1;i>=0;i--)
        {
           arr1[j]=str1.charAt(i)-'0';    j++;
        }
        int arr2[]=new int[len2];
        j=0;
        for(i=len2-1;i>=0;i--)
        {
           arr2[j]=str2.charAt(i)-'0';    j++;
        }
        int temp[]=new int[len1+len2];
        for(i=0;i<(len1+len2);i++)
          temp[i]=0;
        int size=0,c=0;
        for(i=0;i<len1;i++)
        {   size=i;  c=0;
           for(j=0;j<len2;j++)
           {
              int multi=arr1[i]*arr2[j];
              multi=temp[size]+multi+c;
              temp[size]=multi%10;
              size++;
              c=multi/10;
           }
           temp[size]=c;
        }
        int length=temp.length;
        int f=0;
        String str="";
        for(i=length-1;i>=0;i--)
        {
           if (temp[i]!=0)
             f=1;
           if (temp[i]==0&&f==0)
             continue;
           str=str+Integer.toString(temp[i]);
        }
        return str;
    }
    public static String string_add(String str1,String str2)
    {
        int len1=str1.length();
        int len2=str2.length();
        int min=len1>=len2?len2:len1;
        int max=len1>len2?len1:len2;
        int carry=0,a=0;
        String str="";
        for(int i=0;i<min;i++)
        {
            a=str1.charAt(len1-1)+str2.charAt(len2-1)-'0'-'0';
            a=a+carry;
            str=Integer.toString(a%10)+str;
            carry=a/10;
            len1--; len2--;
        }
        if (str1.length()==max)
        {
            for(int i=min;i<max;i++)
            {
                a=str1.charAt(len1-1)-'0';
                a=a+carry;
                str=Integer.toString(a%10)+str;
                carry=a/10;
                len1--;
            }
        }
        else
        {
            for(int i=min;i<max;i++)
            {
                a=str2.charAt(len2-1)-'0';
                a=a+carry;
                str=Integer.toString(a%10)+str;
                carry=a/10;
                len2--;
            }
        }
        if (carry>0)
           str=Integer.toString(carry)+str;
        return str;
    }
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        String str=scan.nextLine();
        String M[][]=new String[2][2];
        M[0][0]="1";  M[0][1]="1";  M[1][0]="1";  M[1][1]="0";
        long startTime=System.nanoTime();
        M=Matrix_pow_recu(M,Integer.valueOf(str)-1);
        long endTime=System.nanoTime();
        if (str.equals("0"))
            System.out.println("0");
        else 
            System.out.println(M[0][0]);
        long time=(endTime-startTime)/1000; 
        System.out.println("Time : "+time);
    }
}