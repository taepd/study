import java.io.File;
import java.io.IOException;

/*
 * I/O 작업
 * 파일과 폴더를 다룰 수 있는 클래스
 * 
 * Java: 파일, 폴더 다루는 걸 하나의 클래스로 만듬: File
 * C# : 파일(File), 폴더(Directory) 따로
 * >> a.txt 생성, 수정, 삭제, 정보 read
 * >> Temp 생성, 삭제, 정보 read
 * 
 * 경로
 * 절대경로: C:\\, D:\\  >>C:\\Temp\\a.txt
 * 상대경로: 현재 파일을 중심으로 
 *
*/


public class Ex07_File_Directory {

    public static void main(String[] args) throws IOException { 
        String path = "C:\\Temp\\file.txt";
        File f = new File(path);
        f.createNewFile();  //함수를 호출할 때 파일이 생성
        //File 클래스를 통해서 (다양한 정보)
        String filename = f.getName();
        System.out.println("파일명: "+ filename);
        System.out.println("*전체 경로: "+f.getPath());   //입력한 전체 경로  ex) path에 입력한 문자열
        System.out.println("절대 경로: "+f.getAbsolutePath());  
        System.out.println("*너 폴더니: "+f.isDirectory());
        System.out.println("*너 파일이니: "+f.isFile());
        System.out.println("*파일크기: "+f.length());
        System.out.println("부모경로: "+f.getParent());
        System.out.println("*존재여부(파일,폴더): "+f.exists());
        
        //f.delete()  return >> true, false
        //f.canRead()
        //f.canWrite()
        
        
        
        
        
        

    }

}
