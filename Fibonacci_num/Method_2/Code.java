import java.lang.String;
import java.util.*;
class fib_two
{
    public static String fibo(String str,String str_arr[])
    {
        if (str_arr[Integer.valueOf(str)].equals("0"))
        {
            if (str.equals("0"))
               str_arr[Integer.valueOf(str)]="0";
            else if (str.equals("1"))
               str_arr[Integer.valueOf(str)]="1";
            else
                str_arr[Integer.valueOf(str)]=string_add(fibo(str_minus_one(str),str_arr),fibo(str_minus_two(str),str_arr));
        }
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
    public static String str_minus_one(String str)
    {
        int len=str.length()-1;
        while(len>=0)
        {
            if (str.charAt(len)=='0')
                str=str.substring(0,len)+'9'+str.substring(len+1,str.length());        // str.charAt(len)='9' this is not allow in java
            else
            { 
               str=str.substring(0,len)+(char)((str.charAt(len)-'1')+48)+str.substring(len+1,str.length());
               break;
            }
            len--;
        }
        int re=0;
        for(int i=0;i<str.length();i++)
        {
            if (str.charAt(i)!='0')
               break;
            re++;
        }
        if (re!=str.length())
           str=str.substring(re,str.length());
        else 
           str="0";    
        return str;
    }
    public static String str_minus_two(String str)
    {
        int len=str.length()-1;
        if (str.charAt(len)>49)
            str=str.substring(0,len)+(char)((str.charAt(len)-'2')+48);
        else if (str.charAt(len)=='0')
        {
            str=str.substring(0,len)+'8';
            String str1=str_minus_one(str.substring(0,len));
            str=str1+Character.toString(str.charAt(len));
        }
        else
        {
            str=str.substring(0,len)+'9';
            String str1=str_minus_one(str.substring(0,len));
            str=str1+Character.toString(str.charAt(len));
        }
        int re=0;
        for(int i=0;i<str.length();i++)
        {
            if (str.charAt(i)!='0')
               break;
            re++;
        }
        if (re!=str.length())
           str=str.substring(re,str.length());
        else 
           str="0";
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