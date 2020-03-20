import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * File처리 (in Disk) read, write
 * 기본은 한 Byte read, write를 한다 >>효율적이지 않음
 * 모아서 한 번에 가져가서 read, write 하고자 함 (버스타고 한 번에 가자)
 * 버스 >> Buffer
 * File read, write 중간 [Buffer] >> I/O
 * 
 * 1. I/O 성능개선
 * 2. Line 단위(엔터)
 * 
 * 독자적인 객체 생성 불가(주 클래스에 의존)
 *  
*/


public class Ex04_Stream_Buffer {

    public static void main(String[] args) {
        
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {                            //예외처리 권장(거의 강제)
            fos = new FileOutputStream("data.txt");  //default: false : 파일 생성
            bos = new BufferedOutputStream(fos);    // 기본 생성자가 없고 매개변수로 outputStream(추상클래스)를 갖음 >> 독자적 객체 생성 불가
            
            for (int i = 0; i < 10; i++) {
                bos.write('A');                
            }
            //bos에서 내리라는 작업을 지시하지 않았기 때문에 파일이 생성되도 내용입력 X
            //Java Buffer 크기 > 8kbtye => 8192byte
            //1. buffer 안의 내용이 8kb가 채워지면 스스로 비우는 작업 >>내부적으로 flush가 발생
            //2. buffer 강제로 비우기(flush 또는 close)
            //3. bos.close() 자원해제  >> close() >> 내부적으로 flush 호출
//            bos.flush();       // 내리라는 명령어
            
        } catch (Exception e) {

        }finally {
            try {
                bos.close();  //flush 기능 포함
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
