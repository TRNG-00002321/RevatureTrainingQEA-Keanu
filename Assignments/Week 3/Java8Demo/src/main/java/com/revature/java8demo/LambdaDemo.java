package com.revature.java8demo;

public class LambdaDemo {
    static void main() {
        Calculator calculator = (n1,n2)->(n1+n2);

        System.out.println(calculator.operation(3,4));
    }
}
