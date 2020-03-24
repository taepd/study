/*
 * 데몬: Thread(보조)
 * Main Thread와 생명을 같이 함
 * 한글 >> 작업 >> 3초 간격으로 작업내용 저장
 * 한글작업 종료 >> 작업 종료 
*/


public class Ex08_Daemon_Thread implements Runnable {
    static boolean autosave = false;
    public static void main(String[] args) {
      
        Thread th = new Thread(new Ex08_Daemon_Thread());
        //th라는 스레드는 main스레드의 보조(Daemon)
        //main 하나의 스레드(non-daemon)
        //main 함수의 스레드와 운명을 같이 하겠다 (보조: th)
        th.setDaemon(true);  //기본값은 false(non-daemon)이므로 true로 인수값
        th.start();
        
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(1000); //1초
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Main Thread 동작: " +i);
            if(i==5) {  //i값이 5가 되는 시점부터
                System.out.println("i: "+ i);
                autosave = true;
            }
        }
        
    }
    public void autoSave() {
        System.out.println("문자가 3초 간격으로 자동 저장되었습니다.");
    }
    @Override
    public void run() {
        while (true) {
           try {
            Thread.sleep(3000);  //3초 간격
        } catch (Exception e) {

        }
           if(autosave) {  //static boolean autosave 가 true값이라면
               autoSave();
           }
            
        }
    }

}
