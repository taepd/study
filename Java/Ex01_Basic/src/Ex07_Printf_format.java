import java.util.Scanner;
import java.util.function.IntPredicate;

public class Ex07_Printf_format {

    public static void main(String[] args) {
//       java: System.out.println();
//       C# : console.WriteLine(); 
//        
//        System.out.println();
//        System.out.print("A");
//        System.out.print("B"); //ln이 없으면 옆에 출력된다
//        
//        
//        
//        int num = 100;
//        System.out.println(num);
//        System.out.println("num 값은 : " + num + "입니다");
//        
//        //형식 format
//        System.out.printf("num 값은 : %d입니다 \n", num);
        //format 형식 문자 (약속)
        //%d (deciaml:10진수 형식의 정수) >> d라는 자리에
        //%f (float)
        //%s (String)
        //%c (char)
        // \t > tab , \n > 줄바꿈
//        System.out.printf("num 값은 [%d]입니다. 그리고 [%d]도 있어요 \n", num , 5555);
//        
//        float f = 3.14f;
//        System.out.println(f);
//        System.out.printf("f 변수값은 %f 입니다.\n", f);
        
        //반대로 
        //cmd (console) 창에서 데이터 입력 받기
        //java.util.Scanner 손쉽게 호출 하는 법: sc + shift + enter
        Scanner sc = new Scanner(System.in);
        //import 구문 자동생성 단축키
        //ctrl + shift + o
       
        //input -> read, output ->write (컴퓨터 입장에서)
//        System.out.println("값을 입력하세요");
//        String value = sc.nextLine(); //입력하고 엔터 할 때 까지 대기 , 문자열로 반환 
//        System.out.println(value);
//        
//        int number = sc.nextInt();  //정수값 입력받아 반환
//        System.out.println("정수값: " + number);
//        
//        float fnumber = sc.nextFloat();
//        System.out.println("실수값: " + fnumber);
        
        //권장사항 : nextInt, nextFloat 보다는 nextLine()으로 읽자
        //Today Point
        //[문자를 -> 숫자로(정수, 실수)]
//        Integer.parseInt("11"); //문자열을 정수로
//        Float.parseFloat("3.111");//문자열을 실수로
//        Double.parseDouble(s);
        
//        System.out.println("숫자 입력하세요");
        //sc.nextLine()으로 문자열을 받아 WrapperClass인 Integer.parseInt로 정수로 변환
        //
//        int num2 = Integer.parseInt(sc.nextLine()); 
//        System.out.println("정수값 : " + num2);  
        
        //숫자를  -> 문자로
//        String data = String.valueOf(10000);
//        System.out.println(data);
        

               



        
        
        
        
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
