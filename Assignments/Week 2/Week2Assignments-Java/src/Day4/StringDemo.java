package Day4;

public class StringDemo {

    String demo = " -Hello World!- ";

    void main(){

        demo = demo.strip();
        System.out.println(demo);

        demo = demo.replace('-','0');
        System.out.println(demo);

        demo = demo.concat("New String");
        System.out.println(demo);

        demo = demo.toUpperCase();
        System.out.println(demo);

        demo = demo.toLowerCase();
        System.out.println(demo);

        int index = demo.charAt(5);
        System.out.println(index);

        if(demo.equals("0hello world!0new string")){
            System.out.println("True");
        }

        if(demo.equalsIgnoreCase("0HELLO WORLD!0new string")){
            System.out.println("True");
        }

        System.out.println(demo.length());

    }
}
