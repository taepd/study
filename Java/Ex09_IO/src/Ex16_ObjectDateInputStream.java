import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import kr.or.bit.UserInfo;

/*
 * userData.txt에 직렬화 된 객체가 2개
 * 객체를 read -> 원 상태로 복원 (역직렬화)
*/

public class Ex16_ObjectDateInputStream {

    public static void main(String[] args) {
        
        String filename = "UserData.txt";
        
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream in = null;
        
        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis);
            
//            UserInfo r1 = (UserInfo)in.readObject();
//            UserInfo r2 = (UserInfo)in.readObject();
//            System.out.println(r1.toString());
//            System.out.println(r2.toString());
            //포함된 객체 수를 모르거나 많을 때
            Object users = null;
            while((users = in.readObject())!=null) {
                System.out.println(((UserInfo)users).toString());
            }
      
        } catch (Exception e) {

        }finally {
            try {
                in.close();
                bis.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        
        
        
        
        
        

    }

}
