/*
 * 1. 자바는 시스템이 제공하는  기본 8가지 타입을 제공(자료형)
 * 2. 8가지 기본 타입은 값을 저장하는 타입
 * 3. 숫자 -> 정수 -> (음의 정수, 0, 양의 정수) -> byte(-128~127)
 * 									  -> char(한 문자를 표현하는 타입)
 * 									           한문자(2byte) >> 한글1자(2byte)
 * 														영문자, 특수, 공백(1byte)
 * 														합의 -> char(모든 문자 한 글자로 표현하자 -> unicode)
 * 									    -> short(C언어 호환성: 2byte)
 * 										-> int (-21억 ~ 21억: 4byte) **Java 정수 연산 기본 타입**
 * 										-> long (8byte)
 * 			실수(부동소수점) -> float(4byte) , double(8byte)
 * 			>> 정밀도 높다 -> 표현 범위가 크다.**Java 실수 연산의 기본 타입은 double**
 * 	논리 -> 참, 거짓 -> boolean >> 프로그램의 논리적 흐름 제어
 * 
 *  궁금한 점: 문자열을 표현할 수 있는 타입은? 클래스(참조타입) >> 사실 String s = new String("홍길동");이라 써야함
 * 
 * 
 * 자바는 크게 
 * 1. 값타입(value type): 숫자, 논리 등 8가지
 * 2. 참조타입(reference type): 클래스, 배열 등 > 변수에 값이 저장되는 것이 아니라 주소값 저장(참조값)
 * 
 * ** class == 설계도 == Type
 */

class Car { // Car는 type==설계도이다 > 구체화된 산물 > 객체화(메모리)
	String color;
	int window;

}

public class Ex03_DataType {
	public static void main(String[] args) {
		String str = "홍길동";
		int age = 100;

		Car c; // 선언. c도 main안에 있는 지역변수이므로 초기화를 해야 한다.
				// c 라는 변수의 초기화 > 주소를 갖기 위해서는
		c = new Car();
		System.out.println(c); // Car@15db9742

		Car c2 = new Car(); // 선언과 동시에 초기화
		System.out.println(c == c2); // false. 주소값이 서로 다르기 때문
		c2.window = 100;
		c2.color = "blue";

		int i = 10; // 선언과 할당

		int j; // 선언
		j = 20; // 할당 분리

		int k;
		k = j;
		System.out.println("k : " + k);
		k = 300;
		System.out.println("k : " + k);

		// int i = 200; // 같은 함수 안에 같은 변수명 존재 X

		int p, q; // 이렇게 할거면 Array 사용. int[] arr = new int[3];

		// int(표현범위: -21억~21억)
		// Today Point
		// literal >> 있는 그대로
		// 정수 리터럴: 1000000000 : 자바의 정수 리터럴값은 int가 default
		// 문자리터럴: ABC
		// int p = 10000000000; //out of range
		long num2 = 100;
		// long num3 = 10000000000; // long 타입을 선언했지만 리터럴이 out of range가 나오는 것은 리터럴값은
		// int가 default이기 때문
		long num3 = 10000000000L; // 따라서 long 타입을 표현하는 숫자는 뒤에 문자 L을 붙여줘야 한다.

		// int p = 10000000000L; // 이 땐 long type 리터럴 숫자를 int로 할당하려고 했기 때문에 에러. convert가
		// 불가하다

		// char : 2byte (정수값)
		// 한 문자를 표현하는 자료형(데이터 타입)
		// 일반적으로
		// 1. 한글 1자 : 2byte
		// 2. 영문자, 특수문자, 공백 : 1byte
		// unicode >> 한글, 영문 >> 2byte 취급
		// char 한 글자만 받는다
		// Today Point
		// 문자열: "가", "Hello"
		// 문자: 'A', '가'

		char single = '가';
		System.out.println(single);
		char ch = 'A';
		System.out.println(ch);
		// char는 문자를 저장하지만 내부적으로 정수값을 가지고 있다(아스키 코드표)기준
		// casting(타입변환)
		int intch = 'A'; // 자동으로(내부적으로) 암시적 형 변환. 작은 타입에서 더 큰 타입으로 변할 때는 자동 변환
		System.out.println("intch : " + intch); // intch : 65 가 출력. char리터럴이 자동적으로 int로 convert된 것

		System.out.println((int) ch); // type casting되어 65가 출력

		char ch2 = 'a';
		System.out.println(ch2);
		System.out.println((int) ch2);// char타입 ch2를 (int)ch2를 이용해 int타입으로 캐스팅. 명시적 형변환(Explicit Type Conversion) 97
										// 출력

		int intch2 = 65;
		// char ch3 = intch2; // intch2의 값은 65로 char타입에 들어가기에 충분히 작은 값이지만, 타입이 int이기 때문에
		// 메모리 할당에서 에러 발생
		char ch3 = (char) intch2; // 명시적 형변환 필요
		// Key Point : 더 큰 타입에서 더 작은 타입으로 변환할 때는 명시적 형변환 필요하다. 다만, 손실을 각오해야 한다.

		int intch3 = ch3; // 묵시적 형변환(Explicit Type Conversion) 더 작은 타입을 더 큰 타입으로 할당할 때는 자동으로 해준다.
							// int intch3 = (int)ch3;나 마찬가지
		System.out.println(intch3);

		// Today point
		// 1. 할당에서 변수가 가지고 있는 값을 보지말고 '변수의 타입'을 보자
		// 2. 변수의 타입 크기를 확인하자
		// 3. 큰타입에는 작은 타입을 넣을 수 있다.
		// 4. 작은 타입에는 큰 타입값을 못 넣는다.
		// 5. 작은 -> 큰 하려면 casting이 필요하다. 다만 손실을 각오해야 한다.
		// boolean은 형변환되지 않는다.

		int intValue = 10165468;
		byte byteValue = (byte) intValue; // 명시적 형 변환, casting
		System.out.println(byteValue); // 손실된 값 나옴

		// String(문자열) 타입으로 보자
		String name = "hello world";
		System.out.println(name);

		String name2 = name + " 안녕하세요";
		System.out.println(name2);
		// DB(oracle >> + 연산자(산술)로만 쓰고 , 결합 연산자는 '||'을 쓴다)

		// TIP java 특수문자 사용하기
		char sing = '\''; // 특수문자를 인지하기 위해 '\'를 사용

		// 홍"길"동 이라는 문자를 String 변수에 저장하고 화면에 출력해 보세요.
		String ename = "홍\"길\"동";
		System.out.println(ename);

		String str3 = "1000";
		String str4 = "10";

		String result = str3 + str4;

		System.out.println(100 + "100"); // 100100. int + String은 둘 다 string 취급 결합 연산
		System.out.println(100 + 100 + "100"); // 200100. 연산은 기본적으로 앞쪽이 우선적이다.
		System.out.println(100 + (100 + "100")); // 100100100. 괄호가 있으면 그 안이 우선적이다.
		System.out.println(100 + "100" + 100); // 100100100. 앞쪽부터 연산하므로 다 문자열 결합 연산에 해당된다

		
		//C:\temp 화면에 출력하세요 (String 변수에 넣고 화면 println 출력)
		  
		String temp = "C:\\temp"; // '\t'는 tab 명렁어임. 따라서 \를 앞에 써줘야 문자열이 그대로 출력된다. (\n-> new line) System.out.println(temp);
		
				
//		실수(부동소수점) : 떠다니는 점
//		float : 4byte
//		double : 8byte : **실수의 기본 타입(리터럴값)은 double**
		
		float f = 3.14f; //리터럴 3.14는 double타입. 따라서 f를 뒤에 붙여줘야 한다.
		
		float f2 = 1.123456789f;
		System.out.println("f2 : " + f2); // 1.1234568
//		float타입은 소수이하 7자리까지 표현가능하므로 이를 넘어설 경우 소수이하 8번째 자리에서 반올림해서 값을 보여줌
		
		double d = 1.123456789123456789; //대략 소수이하 16자리 표현
		System.out.println("d : " + d ); // 1.1234567891234568 반올림됨
		
		//Quiz
		//byte q = 128; //128이란 정수값은 기본적으로 int 그릇에 담겨져 있음
		byte bt = (byte)128;
		System.out.println(bt); // -128 (overflow시 순환값)
		
		//double d2 = 100; //묵시적 형변환
		double d2 = (double)100; // 원래는 이렇게 되는 것
		System.out.println(d2); //100.0  double 타입으로 캐스팅되었으므로 100이 아닌 100.0이 출력
		
		
		//Quiz
		double d3 = 100;
		int i5 = 100;
		//int result = d3 + i5; //int = int + double(정수 = 정수 + 실수)이므로 에러 정수타입+실수타입은 실수타입이다
		// 해결책
		//1. int -> double
		//double result2 = d3 + i5;
		
		//2. casting
		//int result2 = d3 + i5;
		
		//3. casting
		//int result2 =(int)(d3 + i5);
		
		//1번으로 해야 데이터 손실이 발생하지 않는다
		
		//Today Point
		//작은 타입 + 큰 타입 >> 큰 타입
		//타입간 변환 >> 변수가 가지는 값을 보지 말고 변수의 타입을 보고 판단하자
		//명시적 형변환(casting) (바꾸려는 타입)변수 또는 값
		
		int i6 = 100;
		byte b2 = (byte)i6; //명시적 형변환
		System.out.println(b2);
		
		byte b3 = 20;
		int i7 = b3;
		//컴파일러가 내부적으로 (int)b3 생성 : 암시적 형변환
		
		
		
			
			
				
		 
		  
		
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

	}

}
