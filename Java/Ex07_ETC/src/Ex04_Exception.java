import java.io.IOException;

import kr.or.bit.ExceptionClass;

public class Ex04_Exception {

    public static void main(String[] args) {
        ExceptionClass ex = null;   //lv는 초기화 필요
        try {
            ex = new ExceptionClass("world");
        } catch (NullPointerException| IOException e1) {

            e1.printStackTrace();
        }
        try {
            ex.call();
        } catch (Exception e) {

        }
        
       
    }

}
