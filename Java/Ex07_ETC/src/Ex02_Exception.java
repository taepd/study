
public class Ex02_Exception {

    public static void main(String[] args) {

        int num = 100;
        int result = 0;
        System.out.println("Main Start");
        try {
            for (int i = 0; i < 10; i++) {
                result = num / (int) (Math.random() * 10); // 0~9
                System.out.println("result : " + result + " i: " + i);
            }

        } catch (ArithmeticException e) { // 문제가 발생하면 그 예외에 맞는 객체가 자동 생성
            System.out.println("연산예외 발생 [관리자에게 이메일]");
            System.out.println(e.getMessage());
            e.printStackTrace();
            // java.lang.ArithmeticException: / by zero
            // 문제가 발생하면 내부적으로
            // new ArithmeticException() >> 객체에다가 정보를 담는 것 >> 이 주소를 e변수가 받기
//            at Ex02_Exception.main(Ex02_Exception.java:11)
        } catch (NullPointerException e) {  ///NullPoint 예외는 내가 잡을게

        } catch (Exception e) { // 나머지 발생하는 모든 예외는 내가 처리할게

        }

        System.out.println("Main End");
    }

}
