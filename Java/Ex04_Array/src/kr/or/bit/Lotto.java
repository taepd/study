package kr.or.bit;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
//(int)(Math.random()*45 + 1)
//lotto[0] = 44 , lotto[1] = 1 .... lotto[5] = 33
//2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요  (중복값 검증 :별찍기 비슷)
//3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요  (정렬 : 자리바꿈)
//4. 위 결과를 담고 있는 배열을 출력하세요 (화면 출력)

// 타입: 기본 8가지 + String + class + 배열(Array)

//설계도
//약속: **초기화는 생성자에서 하자** 필요하다면 오버로딩
public class Lotto {
//    public int[] numbers = new int[6]; 틀린코드는 아니지만 이왕이면 생성자를 활용하는게 좋다
    private int[] numbers;    
    private Scanner scanner;
    private Random r;
    int noNum;
    boolean a;
    int[] noNumArr;
   

    public Lotto() { // 목적: 초기화(member field)
//      
        numbers = new int[6];
        scanner = new Scanner(System.in); // 이것도 초기화에 해당하므로 생성자에서 하는게 좋다
        r = new Random();
        int noNum=0;
        a=true;
        noNumArr = new int [0];

        
    }

    // 기능 (method) >> 함수 하나당 기능 한 개만
    // 중복값이 나오면 안되요
    // 낮은 순으로 정렬 시키세요
    // 출력하세요(화면 출력)
    // 메뉴 기능... 선택...
    // 1>> 로또 추출
    // 2>> 프로그램 종료

    public void selectLottoNumber() {      
        loop_1: while (true) {
            String selectionNum = showMenu(scanner);
           
            switch (selectionNum) {
            case "1": 
                noNumberMenu();   
                do {                    
                    makeLottoNumber(r, numbers); // 번호 추출
                } while (!checkNumber());
                showLottoNumbers(); // 정렬 하고 출력하기
                break;
            case "2": // 프로그램 종료: return(함수 탈출), System.exit(0), 라벨값 사용
                System.out.println("Good Lucky^^");
                break loop_1;
            default:
                System.out.println("Not in Operation");
                break;
            }
        }
    }

    // private 한 이유: 내부에서만 사용하겠다
    private String showMenu(Scanner sc) { // 사실 스캐너를 매개변수로 안줘도 되지만 연습삼아
        System.out.println("*******************");
        System.out.println("*1. 당첨 예상 번호 추출*");
        System.out.println("*2. 프로그램 종료 ^^!*");
        System.out.println("*******************");
        System.out.println("원하는 작업 번호를 입력하세요:");
        String selectionNum = sc.nextLine();
        return selectionNum;
    }

    // 번호 추출(중복값 배제)  //기본 버전
    private void makeLottoNumber(Random r, int[] numbers) { // parameter 연습
        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = (int) (Math.random() * 45 + 1);
              numbers[i]=r.nextInt(45)+1;  
//              numbers[i]=(r.nextInt(22)+1)*2;  //짝수만 받기
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--; // 다시 돌리기
                    break;
                }
            }
        }
    }
    


    // 화면 출력기능
    private void showLottoNumbers() {
        System.out.println("[선택한 Lotto 번호]");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;

                }
            }

        }

        // 출력하기
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("[%2d]", numbers[i]);
        }
        System.out.println();
    }

    // 제약사항 규칙(배열의 합의 평균이 특정 범위를 벗어나면 재추출)
//    private boolean checkAverage() {
//        int sum = 0;
//        int average = 0;
//        for (int num : numbers) {
//            sum += num;
//        }
//        average = sum / numbers.length;
//        System.out.println("평균 : " + average);
//        return (average >= 15 && average <= 35); // true , false
//    }
    
    //제약사항 규칙 만들기
    
    private void noNumberMenu() {
        System.out.println("제외할 번호 입력(1~45) : 예) 3개 제외할 경우: 1,2,3");
        noNum = Integer.parseInt(scanner.nextLine());       
    }
    //번호 추출 및 중복값 배제
    private boolean checkNumber() {
        
        for (int num : numbers) {
            if(num==noNum) {
                a=false;
                break;
            }else
                a=true;
        }
        return a;
       
    }
    


}
