package com.revature.java8demo;

public class CalculatorLambda {
    static void main() {

        printResult(2,3,(x,y)->x+y);
        printResult(3,2,(a,b)->a-b);
    }

    public static void printResult(int a, int b, Calculator func){
        //perform operation, print result
        int result = func.operation(a,b);
        System.out.println(result);
    }
}
