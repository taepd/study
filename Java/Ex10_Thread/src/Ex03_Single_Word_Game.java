import javax.swing.JOptionPane;

/*
 * 단어 맞추기 게임
 * 구구단 게임
 * 일정 시간 >> 시간이 흐른다
 * 동시에 문제도 맞추어야 함
*/


public class Ex03_Single_Word_Game {

    public static void main(String[] args) {
        String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
        System.out.println("입력값 : "+inputdata);
        timer();  //동시에 실행되지 않는다

    }
    
    
    static void timer() {
        for (int i = 10; i > 0; i--) {
            try {
                System.out.println("남은 시간: "+ i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }

}
