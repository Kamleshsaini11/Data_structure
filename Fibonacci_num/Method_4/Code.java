import java.lang.String;
import java.util.*;
class fib_four
{
    public static String fibo(String str)
    {
        if (str.equals("0"))
           return "0";
        else{
            //str_arr[0]="0"; str_arr[1]="1";
            String pre="1";  String next_pre="0"; 
            for(int i=2;i<=Integer.valueOf(str);i++)
            {
               String temp=pre;
               pre=string_add(pre,next_pre);
               next_pre=temp;
            }
            return pre;
         }
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
        long startTime=System.nanoTime();
        String str_ans=fibo(str);
        long endTime=System.nanoTime();
        System.out.println(str_ans); 
        long time=(endTime-startTime)/1000; 
        System.out.println("Time : "+time);
    }
}