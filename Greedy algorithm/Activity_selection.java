import java.lang.String;
class Activity_selection
{
    public static int[][] sort(int[][] arr)  // Sort according to their endup timeunit
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if (arr[j][1]<arr[i][1])
                {
                    int temp1=arr[j][0];
                    int temp2=arr[j][1];
                    arr[j][0]=arr[i][0];
                    arr[j][1]=arr[i][1];
                    arr[i][0]=temp1;
                    arr[i][1]=temp2;
                }
            }
        } 
        return arr;       
    }
    public static int Atv_slt(int[][] arr)
    {
        arr=sort(arr);
        int count=1,pri=arr[0][1];
        for(int i=1;i<arr.length;i++)
        {
            if (arr[i][0]>=pri)
            {
                count++;
                pri=arr[i][1];
            }
        }
        return count;
    }
    public static void main(String args[])
    {
        int[][] arr={{1,2},{3,4},{0,6},{5,7},{8,9},{5,9}};     // Here arr[0][0]=1 and arr[0][1]=3
        int count=Atv_slt(arr);                                //means first job start at 1 unit time and endup at 3 unit time 
        System.out.println("Maximum number of activity that can be done is "+count);
    }
}