import javax.swing.JOptionPane;

class WordTime extends Thread {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                System.out.println("남은 시간: "+ i);
                sleep(1000);  //1초간 휴게실에 가 있다 나와 sleep(milisecond)
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
    
}



public class Ex04_Multi_Thread_Word_Game {

    public static void main(String[] args) {
        WordTime timer = new WordTime();
        timer.start();
        
        String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
        System.out.println("입력값 : "+inputdata);


    }

}
