import java.lang.String;
import java.util.*;
class fib_three
{
    public static String fibo(String str,String str_arr[])
    {
        str_arr[1]="1";
        for(int i=2;i<=Integer.valueOf(str);i++)
            str_arr[i]=string_add(str_arr[i-1],str_arr[i-2]);
        return str_arr[Integer.valueOf(str)];
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
        int len=Integer.valueOf(str);
        String str_arr[]=new String[len+1];
        for(int i=0;i<=len;i++)
             str_arr[i]="0";
        long startTime=System.nanoTime();
        String str_ans=fibo(str,str_arr);
        long endTime=System.nanoTime();
        System.out.println(str_ans); 
        long time=(endTime-startTime)/1000; 
        System.out.println("Time : "+time);
    }
}