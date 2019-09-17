import java.lang.String;
import java.util.Scanner;
class DriverLinkedList {
    public static void main(String args[]) {
        LinkedList obj = new LinkedList();
        Scanner scan=new Scanner(System.in);
        Integer f=1;
        while(f==1)
        {
            System.out.println("/t<<<MENU>>>\n"+"1.For insert at First position\n"+"2.For insert at last position\n"
            +"3.For insert at given position\n"+"4.For remove from First\n"+"5.For remove from last\n"+"6.For remove from given position\n"+
            "7.For search position of given number\n"+"8.Show and Exit\n"+"Choise position");
            Integer choise=scan.nextInt();
            switch(choise)
            {
            case 1:
            System.out.println("Enter the number that we want to add");
            obj.insertAtFirst(scan.nextInt());
            break;
            case 2:
            System.out.println("Enter the number that we want to add");
            obj.insertAtLast(scan.nextInt());
            break;
            case 3:
            System.out.println("Enter the number and position where you want to add");
            obj.insertAtPosition(scan.nextInt(),scan.nextInt());
            break;
            case 4:
            obj.removeAtFirst();
            break;
            case 5:
            obj.removeAtLast();
            break;
            case 6:
            System.out.println("Enter the position where you want to remove");
            obj.removeAtPosition(scan.nextInt());
            break;
            case 7:
            System.out.println("Enter the number that you want to search");
            int a=scan.nextInt();
            obj.search(a);
            case 8:
            obj.show();
            f=2;
            break;
            default:
            System.out.println("Please enter write number");

            }
        }
    }
}