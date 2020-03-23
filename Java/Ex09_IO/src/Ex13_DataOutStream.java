import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 보조 스트림
 * DataOutPutStream, DataInputStream
 * Java 8가지 기본타입(타입별로 write, read)
 * 단, DataOutPutStream/DataInputStream 끼리만 사용가능
 * txt: 100,30,80,60 >> split >> convert >> 연산 의 과정을 손쉽게 가능
*/


public class Ex13_DataOutStream {

    public static void main(String[] args) {

        int[] score = {100,60,55,94,23};
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("score.txt");
            dos = new DataOutputStream(fos);
            for(int i = 0; i<score.length;i++) {
                dos.writeInt(score[i]);  //정수값 write >> read 반드시 DataInputStream으로
//                dos.writeUTF(str); web 한글처리 할 때 사용
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                dos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    
        }
        
        
        
        
        
        
        
        
        
        
        
    }

}
