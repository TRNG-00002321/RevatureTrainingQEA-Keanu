package hackerranks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class Student{
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}

class StudentComparator implements Comparator<Student>{

    //Making comparator class for priority queue
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getCgpa() < o2.getCgpa()){
            return -1;
        }
        else if(o1.getCgpa() > o2.getCgpa()){
            return 1;
        }
        else if(o1.getCgpa() == o2.getCgpa() && o1.getName().equalsIgnoreCase(o2.getName())) {
            return Integer.compare(o1.getId(), o2.getId());
        }
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

class Priorities{
    PriorityQueue<Student> queue = new PriorityQueue<Student>(new StudentComparator());

    public Priorities() {
    }

    //Get remaining students
    List<Student> getStudents(List<String> events){
        for(String event : events)
        {
            List<String> parts =  Arrays.asList(event.split(" "));

            if(parts.get(0).equalsIgnoreCase("ENTER")){
                queue.add(new Student(Integer.parseInt(parts.get(3)), parts.get(1), Double.parseDouble(parts.get(2))));
            }
            else if(parts.get(0).equalsIgnoreCase("SERVED")){
                queue.remove();
            }
        }

        return new ArrayList<Student>(queue);
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}