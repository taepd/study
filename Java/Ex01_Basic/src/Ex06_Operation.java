
public class Ex06_Operation {

	public static void main(String[] args) {

		int sum = 0;
		// 대입연산자: +=, -+, *=, ....
		sum += 1; // sum = sum + 1;
		sum -= 1; // sum = sum - 1;
		System.out.println(sum);

		// 간단한 학점 계산기
		// 학점: A+, A-, B+, B-, ..... F
		// 데이터 점수: 94점

		// 판단기준 : 90점 이상? ... A
		// 그런데 95점이상? .... A+
		// 아닌데... A-

		int score = 92;
		String grade = ""; // 문자열의 초기화
		System.out.println("당신의 점수는 : " + score);

		// 학점계산 로직
		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 70) {
			grade = "C";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		System.out.println("당신의 학점은 : " + grade);

//		if(score >= 90) {          //3항 연산자 사용
//			grade =(score >= 95)? "A+" : "A-";			
//		}else if(score >= 80) {
//			grade =(score >= 85)? "B+" : "B-";			
//		}else if(score >= 70) {
//			grade =(score >= 75)? "C+" : "C-";			
//		}else {
//			grade = "F";			
//		}
//		System.out.println("당신의 학점은 : " + grade);

		// Tip: 소스 정렬하기
		// Ctrl+Shift+f (자동정렬)

		// switch문

		int data = 80;
		switch (data) {
		case 100:
			System.out.println("100입니다");
			break;
		case 90:
			System.out.println("90입니다");
			break;
		case 80:
			System.out.println("80입니다");
			break;
		default:
			System.out.println("defalut");
		}

		// break는 강제사항 아님
		// break 조건 만족하는 그 이후부터 모두 실행

		int month = 2;
		String res = "";
		switch (month) {
		case 1:
			; // 실행할게 없으면 사실 ;는 안써도 된다
		case 3:
			;
		case 5:
			;
		case 7:
			;
		case 8:
			;
		case 10:
			;
		case 12:
			res = "31";
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			res = "30";
			break;
		case 2:
			res = "29";
			break;
		default:
			System.out.println("월 데이터가 아닙니다.");
		}
		System.out.println(month + "월은 " + res + "일 입니다.");

		// 난수(랜덤값: 임의의 추출값)
		// https://docs.oracle.com/javase/8/docs/api/index.html
		// 검색
		// java.lang.Math (Math 클래스)
		// Math.Random() 함수: 호출에 의해서 실행됨
		// java 페이지에서 default로 열어놓은 폴더가 있다. (java.lang)
		// 따라서 import java.lang 생략하고 Math.random()으로 호출할 수 있다
		// static: 객체를 생성하지 않아도 사용 가능한 함수
		// random의 리턴 내용: greater than or equal to 0.0 and less than 1.0
		// 결과: double 실수 : 0.0 <= random < 1.0

		System.out.println("Math.random() : " + Math.random());
		System.out.println("Math.random() * 10 :" + Math.random() * 10);
		
		System.out.println("(int)Math.random() * 10 :" + (int)(Math.random() * 10)); // 0~9까지 정수만
		
		System.out.println("(int)Math.random() * 10 :" + (int)(Math.random() * 10 + 1)); // 1~10가지의 정수만
		// 로또
		System.out.println("로또 번호 추출 :" + (int) (Math.random() * 44 + 1));

		/*
		 * 문제를 풀어 보세요 --3분 또는 2분이 같이 풀어보세요 --문제를 푸시면 지금까지 배운 것 이해 하고 있으신 거죠 우리는 백화점 경품
		 * 시스템을 만들려고 한다 경품 시스템은 나오는 점수에 따라 경품을 지급하는 시스템이다 경품 추첨시 1000 점수가 나오면 경품으로 TV ,
		 * NoteBook , 냉장고 , 한우세트 , 휴지 경품 추첨시 900 점수가 나오면 경품으로 NoteBook , 냉장고 , 한우세트 , 휴지
		 * 경품 추첨시 800 점수가 나오면 경품으로 냉장고 , 한우세트 , 휴지 경품 추첨시 700 점수가 나오면 경품으로 한우세트 , 휴지 경품
		 * 추첨시 600 점수가 나오면 경품으로 휴지 그외 점수는 100 ~ 500 까지는 칫솔 경품시스템의 점수 범위는 100 ~ 1000 점까지
		 * 한정되어 있다 사용자가 경품 시스템을 사용시 랜덤하게 100 ~ 1000까지의 값이 나오게 되어 있습니다.
		 * 
		 */

		// 백화점 경품 시스템
		String gift = "";
		int point = ((int) (Math.random() * 10 + 1) * 100);
		switch (point) {
			case (1000):
				gift += "TV, ";
			case (900):
				gift += "NoteBook, ";
			case (800):
				gift += "냉장고, ";
			case (700):
				gift += "한우세트, ";
			case (600):
				gift += "휴지";
				break;
			default:
				gift += "칫솔";
		}
		System.out.println("축하합니다!! 당신의 점수는 " + point + "입니다. 받으실 경품은 " + gift + "입니다~^^");

		// 선생님 해답
		int jumsu = ((int) (Math.random() * 10) + 1) * 100;
		System.out.println("추첨번호 : " + jumsu);
		String msg = ""; // 초기화
		msg += "고객님의 점수는 " + jumsu + "이고 상품은 ";
		switch (jumsu) {
			case (1000):
				msg += "TV, ";
			case (900):
				msg += "NoteBook, ";
			case (800):
				msg += "냉장고, ";
			case (700):
				msg += "한우세트, ";
			case (600):
				msg += "휴지";
				break;
			default:
				msg += "칫솔";
		}
		System.out.println(msg + "입니다.");

	}

}
