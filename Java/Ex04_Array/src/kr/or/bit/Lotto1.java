package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

/*
 *1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
      (int)(Math.random()*45 + 1)
      lotto[0] = 44 , lotto[1] = 1 .... lotto[5] = 33
 *2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요  (중복값 검증 :별찍기 비슷)
 *3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요  (정렬 : 자리바꿈)
 *4. 위 결과를 담고 있는 배열을 출력하세요 (화면 출력)

타입 : 8가지 + String + class + 배열(Array) 
  
 */
//설계도
//약속 :초기화는 생성자에서 ... 필요하다면 .. 오버로딩 ...
public class Lotto1 {
	//public int[] numbers = new int[6];  틀린코드 아니예요
	private int[] numbers;
	private Scanner scanner; //= new Scanner(System.in);
	private Random r; //= new Random();
	
	public Lotto1() {
		//초기화 (member field)
		numbers = new int[6];
		scanner = new Scanner(System.in);
		r = new Random();
	}
	
	//기능 ... (method) 안에서 >> 함수 하나당 기능 한개만 
	//실번호 추출해 주세요
	//중복값이 나오면 안되요
	//낮은 순으로 정렬 시키세요 
	//출력하세요 (화면 출력)
	//메뉴 기능 .... 선택 ....
	//1 >> 로또 추출
	//2 >> 프로그램 종료
	
	public void selectLottoNumber() {
	loop_1: while(true) {
			 String selectionnum = showMenu(scanner);
			 switch (selectionnum) {
			 	case "1":
			 			//makeLottoNumber(r,numbers); //실번호 추출
			 			//showLottoNumbers(); //정렬 하고 출력하기
			 			do {
			 				makeLottoNumber(r,numbers); //실번호 추출
			 			}while(!checkAverage());
			 			showLottoNumbers(); //정렬 하고 출력하기
					break;
			 	case "2": //프로그램 종료 : return (함수 탈출) , System.exit(0) , 라벨값 
					System.out.println("Good Lucky^^");
			 		break loop_1;
				default: 
					System.out.println("Not in Operation~~");
					break;
			}
		}
	}
	
	//private .. 내부에서만 사용
	private String showMenu(Scanner sc) { //연습이니까 (parameter)
		System.out.println("*******************");
		System.out.println("*1. 당첨 예상 번호 추출*");
		System.out.println("*2. 프로그램 종료 ^^!*");
		System.out.println("*******************");
		System.out.print("원하는 작업 번호를 입력하세요:");
		String selectionnum = sc.nextLine();
		return selectionnum;
	}
	
	//번호 추출 , 중복값 배제
	private void makeLottoNumber(Random r , int[] numbers) { //parameter 연습
		for(int i = 0 ; i < 6 ; i++) {
			numbers[i] = (int)(Math.random()*45 + 1);
			 for(int j = 0 ; j < i ; j++) { //j < i (채워진 개수 만큼 비교)
				 if(numbers[i] == numbers[j]) {
					 i--; //point 같은 방의 값을 바꾸어여 한다
					 break;
				 }
			 }
		}
	}
	//화면 출력기능
	private void showLottoNumbers() {
		System.out.println("[선택한 Lotto 번호]");
		
		for(int i = 0 ; i < numbers.length ;i++) {
			for(int j=i+1 ; j < numbers.length ; j++) {
				if(numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	
		//출력하기
		for(int i = 0 ; i < numbers.length ; i++) {
			System.out.printf("[%2d]",numbers[i]);
		}
		System.out.println();
	}
	
	//규칙 (배열의 합의 평균이 특정 범위에 벗어나면 재추출)
	private boolean checkAverage() {
		int sum = 0;
		int average = 0;
		for(int num : numbers) {
			sum+=num;
		}
		average = sum/numbers.length;
		System.out.println("평균 : " + average);
		return (average >= 15 && average <= 35); //true , false
	}
}












