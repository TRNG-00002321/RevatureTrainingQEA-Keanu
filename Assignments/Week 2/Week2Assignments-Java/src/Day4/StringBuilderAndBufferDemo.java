package Day4;

public class StringBuilderAndBufferDemo {
    StringBuilder builder = new StringBuilder("String Builder");
    StringBuffer buffer = new StringBuffer("String Buffer");
//Buffer are used for single threaded environment while builders are multi-threaded
    void main(){
        builder.append(" more text");
        buffer.append(" more text");

        builder.insert(2, 's');

        buffer.deleteCharAt(0);

        builder.setCharAt(0,'T');

        String new_buffer = buffer.substring(0,5);

        System.out.println(builder);
        System.out.println(buffer);
        System.out.println(new_buffer);
    }
}
