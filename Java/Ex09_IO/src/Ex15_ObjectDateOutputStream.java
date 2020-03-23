import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kr.or.bit.UserInfo;

public class Ex15_ObjectDateOutputStream {

    public static void main(String[] args) {
        String filename = "UserData.txt";
        
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream out = null;
        
        try {
            fos = new FileOutputStream(filename,true);
            bos = new BufferedOutputStream(fos);
            
            //직렬화
            out = new ObjectOutputStream(bos);
            
            
            
            UserInfo u1 = new UserInfo("홍길동", "super", 500); //완제품
            UserInfo u2 = new UserInfo("scott", "tiger", 50); //완제품
            
            
            //직렬화 작업
            out.writeObject(u1); //분해해서 줄을 세워서 파일 write
            out.writeObject(u2);
            //파일에 Userinfo 객체 2개 write
           
            
            
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            try {
                out.close();
                bos.close();
                fos.close();
                System.out.println("파일 생성 -> buffer -> 직렬화 -> 파일 write");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
