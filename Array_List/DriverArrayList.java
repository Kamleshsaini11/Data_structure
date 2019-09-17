import java.lang.String;
import java.util.Scanner;
class DriverArrayList {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        ArrayList obj = new ArrayList();
        int f=1;
        while (f==1) {
            //D value=null;
            Integer pos = 0;
            System.out.println(
                    "\t<<<Select the index for to do opertion>>>\t\n" + "1.For add number at last of the list\n"
                            + "2.For add number at a given position\n" + "3.For remove a number from a given position and get it\n"
                            + "4.For search a number and give position of that number\n"
                            + "5.For Exit or print the list\n" + "6.For reverse List\n" + "Enter your choise");
            Integer choise = scan.nextInt();
            switch (choise) {
            case 1:
                System.out.println("enter the value that you want to add");
                  
                obj.add(scan.nextInt());
                break;
            case 2:
                System.out.println("enter the value and pos of object that you want to add");
                obj.add(scan.nextInt(),scan.nextInt());
                break;
            case 3:
                System.out.println("enter the position from you want to remove");
                pos = scan.nextInt();
                System.out.println("remove number is"+obj.remove(pos));
                break;
            case 4:
                System.out.println("enter the value of object that you want to search");
                obj.search(scan.nextInt());
                break;
            case 5:
                obj.traverse();
                f=2;
                break;
            case 6:
                obj.reverse();
                break;
            default:
                System.out.println("Please select write position");
                break;
            }
        }
    }
}