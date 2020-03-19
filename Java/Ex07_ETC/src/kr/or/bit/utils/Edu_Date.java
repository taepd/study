package kr.or.bit.utils;

import java.util.Calendar;

//설계도
//사용자 편하게...
//많이 사용할까.. 유지 보수(함수 이름).. 다형성.. 고려



public class Edu_Date {
    public static String DateString(Calendar date) {
        return date.get(Calendar.YEAR) + "년" +
               (date.get(Calendar.MONTH)+1) + "월" +
               date.get(Calendar.DATE) + "일"; 
    }
    
    public static String DateString(Calendar date, String opr) {  //구분 기호를 매개변수로 넣어서 오버로딩
        return date.get(Calendar.YEAR) + opr +
                (date.get(Calendar.MONTH)+1)+ opr +
               date.get(Calendar.DATE); 
    }
    
    //요구사항
    //2020-3-19
    //1~9월까지는 >> 01,02 식으로
    //10~12월 >> 그냥
    public static String monthFormat_DateString(Calendar date, String opr) {
         if(date.get(Calendar.MONTH)<9) {
             return date.get(Calendar.YEAR) + opr +
                    "0"+(date.get(Calendar.MONTH)+1) + opr +
                    date.get(Calendar.DATE); 
        }else {
               return 
                date.get(Calendar.YEAR) + opr +
                (date.get(Calendar.MONTH)+1) + opr +
                date.get(Calendar.DATE); 
     }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
