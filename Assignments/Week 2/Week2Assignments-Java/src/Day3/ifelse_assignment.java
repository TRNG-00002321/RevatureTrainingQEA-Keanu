package Day3;
import java.util.Scanner;

public class ifelse_assignment {
    static public void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 3 numbers: ");

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if(num1 > num2 && num1 > num3){
            System.out.println(num1);
        }
        else if (num2 > num1 && num2 > num3){
            System.out.println(num3);
        }
        else {
            System.out.println(num3);
        }
    }
}
