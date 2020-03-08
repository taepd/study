import java.util.Scanner;

public class Ex09_Statement {

    public static void main(String[] args) {
//        System.out.println("입력");
//        Scanner sc = new Scanner(System.in);
//
//        if (sc.hasNextInt()) { // 의문형. 입력값이 정수형이면 Ture, 아니면 False를 리턴
//            System.out.println("정수 입력");
//        } else {
//            System.out.println("정수가 아니네 다시 입력");
//        }

        // 암기하자 (월 암기 테스트)
        // 조건문 : if 종류(3가지), switch(조건){case 값: break;}
        // 반복문: for(반복횟수 명확}, while, do~while
        // 분기문: break(블럭 탈출), countinue(아래 구문 skip)

//      int count = 0;
//    if(count < 1) System.out.println("true");  //한 줄이면 중괄호 생략가능
//    if문
//    if(count < 1) {
//          System.out.println("true");
//    }
//    if else문
//    if(count < 1) {
//        System.out.println("true");
//    }else {
//        System.out.println("false");
//    }
        // if else if 문
        // 생략

        // 반복문
        // 1~100까지의 합을 sum이라는 변수에 담아서 출력하세요.
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.printf("1부터 100까지의 합은 %s입니다.\n", sum);

        // for문을 사용해서 1~10까지의 홀수의 합을 구해보세요. 단, for문 하나만 사용
        int sum2 = 0;
        for (int i = 1; i <= 10; i += 2) { // 증가 조건에 증감연산자만 가능하다는 생각을 버리자.
            sum2 += i;
        }
        System.out.printf("1부터 10까지의 홀수의 합은 %s입니다.\n", sum2);

        // if문 사용해서 1~100까지의 짝수의 합을 구하시오.
        int sum3 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) { // 연산자 == 임 주의!
                sum3 += i;
            }
        }
        System.out.printf("1부터 100까지의 짝수의 합은 %s입니다.\n", sum3);

        // 1~100까지 소수를 구해보라 소수: 1과 자기 자신 만을 인수로 갖는 수       
     
        
        int i,j,count;       
        for(i=2 ; i<=100 ; i++){

            count=0;   // count를 초기화

            for(j=2 ; j<i; j++) {

                if(i%j==0) {
                    count+=1;
                }
            }
            if(count==0) {
                System.out.print(i+", "); // 
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }
}