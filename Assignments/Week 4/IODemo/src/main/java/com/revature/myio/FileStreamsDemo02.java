package com.revature.myio;

import java.io.*;

public class FileStreamsDemo02 {
    static FileReader fileInputStream = null;
    static FileWriter fileOutputStream = null;

    static void main(String[] args) throws IOException {

        try{
            fileInputStream = new FileReader("example.txt");
            fileOutputStream = new FileWriter("characteroutput.txt");

            int c;
            //c = fileInputStream.read();

            while((c = fileInputStream.read()) != -1){
                //System.out.write(c);
                fileOutputStream.write(c);
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fileInputStream != null){
                fileInputStream.close();
            }

            if(fileOutputStream != null){
                fileOutputStream.close();
            }
        }
    }
}
