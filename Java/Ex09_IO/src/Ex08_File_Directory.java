import java.io.File;
import java.util.Arrays;

public class Ex08_File_Directory {

    public static void main(String[] args) {
        //java Ex08_File_Directory aaa 엔터       //cli 상에서 파일 실행하면서 파일명 뒤에 입력한 값이 args로 전달됨
//        System.out.println(args.length);
//        System.out.println(args[0]);
          
          if(args.length !=1) {
              System.out.println("사용법: java 파일명[디렉토리명]");
              System.exit(0);  //강제 종료
          }
          File f = new File(args[0]);
          if(!f.exists()||!f.isDirectory()) { //존재하지 않거나 or 디렉토리(폴더)가 아니라면
              System.out.println("유효하지 않은 경로입니다.");           
          }
          
          
          //실제 존재하는 경로에 있는 폴더라면
          File[] files = f.listFiles(); //  f안의 모든 폴더와 파일의 경로가  >> 배열로 저장
          //C:\\Temp\\1.jpg >>하나 하나가 File 객체에 담김
          //c:\\Temp\\a.txt 
          for(int i=0; i<files.length; i++) {
              String name = files[i].getName(); //파일명, 폴더명
              System.out.println(files[i].isDirectory()?"[DIR]"+name:name);
          }

              
          
    }

}
