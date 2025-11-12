package Day3;
import java.util.Scanner;

public class switchassignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number for the day: ");

        int day = scanner.nextInt();

        switch (day) {
            case 1:
                System.out.print("Sunday");
                break;
            case 2:
                System.out.print("Monday");
                break;
            case 3:
                System.out.print("Tuesday");
                break;
            case 4:
                System.out.print("Wednesday");
                break;
            case 5:
                System.out.print("Thursday");
                break;
            case 6:
                System.out.print("Friday");
                break;
            case 7:
                System.out.print("Saturday");
                break;
            default:
                System.out.print("Invalid input");
        }
    }
}