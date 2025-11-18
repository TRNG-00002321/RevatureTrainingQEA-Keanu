package com.revature.collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    static void main() {
        Queue<String> myQ = new PriorityQueue<String>();

        myQ.add("Keanu");
        myQ.add("Bob");
        myQ.add("Sam");

        System.out.println("Queue: " + myQ);

        myQ.remove();
        System.out.println(myQ);

        System.out.println("First element: " + myQ.element());

        myQ.poll();
        System.out.println(myQ);

        System.out.println("First element: " + myQ.poll());

    }
}
