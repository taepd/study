import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03_Stream_ImageCopy {

    public static void main(String[] args) {
        
        String orifile = "D:\\tae\\IOTemp\\1.jpg";
        String targetfile = "copy.jpg";   //기본 경로인 프로젝트 폴더에 저장
        
        FileInputStream fs = null;
        FileOutputStream fos = null;
        
        try {
            fs = new FileInputStream(orifile);
            fos = new FileOutputStream(targetfile,false);  //기본값이 false라 false인 경우 생략 가능
            
            int data=0;
            while((data=fs.read())!=-1) {
                fos.write(data); //data값을 read해서 targetfile write 작업
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally {
            try {
                fs.close();
                fos.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
        }

        
        
        
        
    }

}
