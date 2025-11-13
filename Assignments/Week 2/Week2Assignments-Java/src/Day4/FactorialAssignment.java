package Day4;
import java.util.Arrays;
import java.util.Scanner;

//factorial of a number by a normal function and by recursion
public class FactorialAssignment {

    int factorial(int x){
        int fact = 1;

        for(int i = 0; i < x; i++){
            fact = (i + 1) * fact;
        }

        return fact;
    }

    int factorial_recursive(int x){

        if(x == 0 || x == 1){
            return 1;
        }
        else{
            return x * factorial_recursive(x - 1);
        }
    }

    void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");

        int num = scanner.nextInt();

        System.out.println("Factorial without recursion: " + factorial(num));

        System.out.println("Enter a number:");

        num = scanner.nextInt();

        System.out.println("Factorial with recursion: " + factorial_recursive(num));


    }
}
