/*
 * 클래스는 설계도이다. 클래스는 타입이다
 * 클래스 == 설계도 == 타입
 * 클래스는 구체화(집을 짓는 행위)통해서 사용
 * 프로그램 세계에서 집을 짓는 행위는 new 연산자를 통해서 memory >> 객체(인스턴스)
 * 
 * 설계도
 * 클래스 2가지
 * 1. main 함수를 가지는 설계도 >> 독자적 실행 가능
 * 2. main 함수 없는 설계도 >> 도와주는 역할 > 라이브러리(lib)
 * 
*/

//class Apt {          // 에러가 난 이유: 같은 폴더에 있는 같은 클래스명은 사용할 수 없다
//	int door = 10;
//	int window = 20;
//}

class Apt2 {
	int door = 10;
	int window = 20;
}




public class Ex04_Ref_Type {

	public static void main(String[] args) {
		//Apt2 설계도는 구체화를 통해 사용 가능. 즉 , 메모리에 올려야 함 (new 연산자 이용)
		Apt2 lgApt = new Apt2(); //lgApt 변수는 참조 변수 = 객체 변수 = 주소를 가지고 있는 변수
		System.out.println(lgApt);
		
		Apt2 ssApt = lgApt; //할당도 주소를 가지는 방법 중에 하나
		ssApt.door = 555;
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
