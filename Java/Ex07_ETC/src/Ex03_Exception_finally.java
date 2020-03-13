import java.io.IOException;

public class Ex03_Exception_finally {
    
    static void startInstall() {
        System.out.println("START INSTALL");
    }
    
    static void copyFiles() {
        System.out.println("COPY FILES");
    }
    
    static void fileDelete() {
        System.out.println("DELETE FILES");
    }
    

	public static void main(String[] args) {
	    System.out.println("Main Start");
	    
	    try {
            copyFiles();
            startInstall();
            //throw : 개발자의 임의로 문제 발생시켜서 강제로 예외처리 하도록 하는 방법
            throw new IOException("Install 중 문제 발생");
        } catch (Exception e) {
            System.out.println("예외 메시지 출력: "+ e.getMessage());
        
        }finally { //강제적 실행 블럭 (예외가 발생과 무관, return문이 있더라도 finally는 실행됨)
            fileDelete();
        }

	    
	    System.out.println("Main End");
	    
	}

}
