import java.lang.String;
import java.util.Scanner;
class Fraction_knapsack
{
    public static double fcn_kpk(double w,int n,double[] arr)
    {
        for(int i=0;i<2*n;i=i+2)
	    {
	        arr[i+1]=arr[i+1]/arr[i];
	    }
	    for(int i=1;i<2*n;i=i+2)
	    {
	        for(int j=i+2;j<2*n;j=j+2)
	        {
	            if (arr[j]<arr[i])
	            {
	                double temp1=arr[j-1];
	                double temp2=arr[j];
	                arr[j-1]=arr[i-1];
	                arr[j]=arr[i];
	                arr[i-1]=temp1;
	                arr[i]=temp2;
	            }
	        }
	    }
	    for(int i=0;i<2*n;i=i+2)
	        arr[i+1]=arr[i+1]*arr[i];
	   double val=0.0;
	   int i=1;
	   while(w>0&&i<2*(int)n)
	   {
	       if (arr[i]>w)
	       {
	           val=val+(arr[i-1]/arr[i])*w;
	           w=0;
	       }
	       else
	       {
	           val=val+arr[i-1];
	           w=w-arr[i];
	       }
	       i=i+2;
	   }
       return val;
    }
    public static void main(String args[]) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the weight that man can carry");
        double w=scan.nextDouble();
        double[] arr={60 ,10 ,100 ,20 ,120 ,30};       //(value1,weight1,value2,weight2,value3,weight3) like that
        double val=fcn_kpk(w,(arr.length)/2,arr);
        System.out.println("Maximum value that can be earn is "+val);
    }
}