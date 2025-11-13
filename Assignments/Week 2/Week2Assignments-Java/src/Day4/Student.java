package Day4;

public class Student {

    String name; //instance variable
    static int countofStudents; //static variable

    public Student(String name){
        this.name = name;
        countofStudents++;
    }

    public static void main(String[] args){
        Student s1 = new Student("William");

        System.out.println(s1.countofStudents);

        Student s2 = new Student("Gabe");

        System.out.println(s2.countofStudents);
    }

    //final variable naming convention is all caps separated by underscore
    //final methods cannot be overriden
    //final classes cannot be extended
    //What us autoboxxing and what is unboxing notes
}
