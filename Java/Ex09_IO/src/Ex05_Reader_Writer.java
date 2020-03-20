import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 문자기반의 데이터 처리
 * char[]를 가지고 놀자 (String 클래스 내부적으로 데이터 char[] 관리)
 * 
 * 한글 1자 >> 2byte >> Stream class론 해결 안됨(byte)
 * 
 * reader , write 추상 클래스
 * 
 * 대상 File이면, FileReader, FileWriter
 * 
*/

public class Ex05_Reader_Writer {

    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;
        
        try {
            fr = new FileReader("Ex01_Stream.java");  //이 파일을 읽겠다  //기본 경로는 현 자바파일의 루트폴더
            fw = new FileWriter("copy_Stream.txt");   //파일 생성 >> 여기에 write 작업 할 것
            
            int data = 0;
            while((data=fr.read())!=-1) {
//                System.out.println((char)data);  //char캐스팅을 안하면 아스키코드값으로 출력됨
                fw.write(data); //data값을 copy_Stream.txt에 write
                if(data != '\n' && data !='\r' && data !='\t' && data !=' ') {   //\r도 줄바꿈  유닉스는 \n, 윈도우는 \r\n
                    fw.write(data);  //압축파일(파일의 크기를 감소: 배포 버전)  // 공백이나 엔터가 모두 생략되었으므로
              
                }
            }fw.flush();  // Writer도 flush를 해줘야 한다
        } catch (Exception e) {

               
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
           
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
