package Day3;

import java.util.Scanner;

public class staircase_assignment {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");

        int num = scanner.nextInt();

        for(int i = 0; i < num; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }
}
