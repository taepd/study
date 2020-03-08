import java.util.Scanner;

/*
간단한 사칙 연산기 (+ , - , * , /)
입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자 변환)
목적 : Integer.parseInt() ,  **equals() 활용**
화면
>입력값:숫자
>입력값(기호): +
>입력값:숫자 
>연산결과 :200

-------------
>입력값:100
>입력값(기호): -
>입력값:100
>연산결과 :0


*/
public class Ex08_Operation_Quiz {

    public static void main(String[] args) {
        /*
       ■ if문은 조건값이 boolean형, switch문은 정수형(byte, short, int)과 문자형(char), 문자열(String)
       ■ long, boolean, float, double형 사용 불가
     
        Scanner sc = new Scanner(System.in);
        char ch =   sc.nextLine().charAt(0);
        switch (ch) {
        case '+':System.out.println("+ 입니다");
            break;
        default: System.out.println("다른 문자 입니다");
            break;
        }
        
        
        Scanner sc = new Scanner(System.in);
        String ch =   sc.nextLine();
        switch (ch) {
        case "+":System.out.println("+ 입니다");
            break;
        default: System.out.println("다른 문자 입니다");
            break;
        }
        */
        
        
        
        String opr="";//문자열 초기화
        int input_1=0;
        int input_2=0;
        int result=0;
        Scanner sc = new Scanner(System.in);
        
        
          System.out.print("숫자입력: ");
          input_1 = Integer.parseInt(sc.nextLine());
          
              
          System.out.print("연산기호(+,-,*,/): ");
          opr = sc.nextLine();

          System.out.print("숫자입력: ");
          input_2 = Integer.parseInt(sc.nextLine());

          
          
          if(opr.equals("+")) {  //POINT 문자열의 비교는 == 아니고 (x) , equals (String)
              result = input_1 + input_2;
              
          }else if(opr.equals("-")) {
              result = input_1 - input_2;
              
          }else if(opr.equals("*")) {
              result = input_1 * input_2;
              
          }else if(opr.equals("/")) {
              result = input_1 / input_2;
          }else {
              System.out.println("지원하지 않는 연산자 입니다");
              //key point (여기서는 main 함수)
              //return 키워드 :  [함수단위]의 종결자  > main 함수 탈출 > 종료
              return;
             
              //System.exit(0); //강제적인 프로그램 종료
              
          }
          
          System.out.printf("[%d %s %d = %d]",input_1,opr,input_2,result);
    }

}



/*
간단한 사칙 연산기(+, -, *, /)
입력값 3개 (입력값 nextLine() 받아서 필요하다면 숫자 변환)
목적: Integer.parseInt(), **equals() 활용**  데이터값을 비교 불리언 값을 반환
화면
>입력값: 숫자
>입력값(기호): +
>입력값:숫자
>연산결과: 200

------------------------
>입력값:100
>입력값:(기호): -
>입력값:100
>연산결과: 0
 
 
*/        
        //계산기
//	    Scanner sc = new Scanner(System.in);
//        System.out.println("입력값: ");
//        int num1 = Integer.parseInt(sc.nextLine());   //첫 번째 값
//        System.out.println("입력값(기호): ");
//        String operator = sc.nextLine(); //연산자 입력
//        System.out.println("입력값: ");
//        int num2 = Integer.parseInt(sc.nextLine()); //두 번째 값
//        int sum = 0;
//        if (operator.equals("+")) {  // 불리언 값이 반환되기 때문에 if문을 씀
//            sum = num1 + num2;
//           
//        }else if(operator.equals("-")) {
//            sum = num1 - num2;
//            
//        }else if(operator.equals("*")) {
//            sum = num1 * num2;
//          
//        }else if(operator.equals("/")) {
//            sum = num1 / num2;
//        }else {
//            System.out.printf("연산결과: %d입니다 \n", sum);
        
        //switch 활용
//      switch(operator) {
//      case("+"):
//          sum = num1 + num2;
//           break;
//      case("-"):
//          sum = num1 - num2;
//          break;
//      case("*"):
//          sum = num1 * num2;
//          break;
//      case("/"):
//          sum = num1 / num2;     
//          break;   
//      }
//         System.out.printf("연산결과: %d입니다 \n", sum);
        
        //계산기 개선
//        
//            System.out.println("입력값: ");
//            int num1 = Integer.parseInt(sc.nextLine());   //첫 번째 값
//            System.out.println("입력값(기호): ");
//            String operator = sc.nextLine(); //연산자 입력
//            System.out.println("입력값: ");
//            int num2 = Integer.parseInt(sc.nextLine()); //두 번째 값
//            int sum = 0;
//            if (operator.equals("+")) {  // 불리언 값이 반환되기 때문에 if문을 씀
//                sum = num1 + num2;
//               
//            }else if(operator.equals("-")) {
//                sum = num1 - num2;
//                
//            }else if(operator.equals("*")) {
//                sum = num1 * num2;
//              
//            }else if(operator.equals("/")) {
//                sum = num1 / num2;
//            }else {
//                System.out.printf("잘못 입력하셨습니다.");
//            }
//                System.out.printf("연산결과: %d입니다 \n", sum);
//                
//	}
//}