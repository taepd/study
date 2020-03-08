/*
1. Ex02_Variable 클래스 >> 설계도
2. public static void main(String[] args) 함수를 가지고 있는 클래스: 프로그램의 시작점, 진입점
*클래스의 종류는 2가지
-class Test {public static void main(String[] args){}}
-class Test{} 메인함수 없는 클래스. 독자적인 실행x :다른 클래스를 도와주는 클래스(lib)

Tip)
C# > public static void Main()
수업을 마치고 서점에 가서 C# 책을 보면 70%가 이해가 된다. 둘 다 객체지향언어

변수: variable
데이터를 담을 수 있는 공간의 이름
변수는 타입(공간의 크기=자료형=데이터타입)을 가진다

변수가 선언되는 위치(scope : 유효 범위)
1. instance variable : 객체변수 >> class person {int age}
2. local variable : 지역변수(함수 안에 있는 변수) class Person {public void run() {int speed}} 이 때 speed는 지역변수 run이 실행되고 나면 사라진다
                                             함수 안에 if블럭, for 블럭 안에 있는 변수도 지역변수
3. static variable : 공유변수(자원) : 객체간 공유자원

 */

//class는 설계도이다 == class Type이다 (여러 개의 작은 타입을 가지고 있는 큰 타입)
class Test {
	int iv = 500; //instance variable
	//instance variable은 초기화하지 않아도 된다 (기본값: default)
	int window; // default에 0을 배정
	//초기화: 처음 값을 갖는 것(할당을 통해서)
	//왜 초기화를 하지 않아도 사용 가능할까
	//(hint) : 설계도는 하나... 설계도를 기반으로 아파트를 여러개.... 지은 아파트마다 창문 개수는 다를 수 있다)
	//답) 아파트(객체)마다 다른 값을 가질 수 있다
	
	Test(){ //생성자(constructor, 초기자)함수의 이름이 클래스 이름과 같은 함수
			//객체가 생성과 동시에 자동으로 함수 호출된다
	}
	
	Test(int data){ //오버로딩(overloading) : 하나의 이름으로 여러가지 기능을 수행
		window = data; //창문의 개수 초기화
	}
	
	void write() {
		int num = 100; //local variable
					   // 함수가 호출되면 그 때 메모리에 올라가고 함수가 종료되면 사라진다
		// 함수 안에서도 window(객체 변수)를 초기화해서 사용할 수 있다
		window = 111;
		
		int age; //함수 안에 있으므로 지역변수
		//System.out.println(age); // 지역변수는 초기화 해야 함. 단 쓰지 않을 때 까진 오류 안남
	}
	void print() {
		System.out.println("iv : "+iv); //
		//System.out.println("num : "+ num); num은 write함수의 local variable이기 때문에 실행 안됨
	}
}

class Apt {
	int window;
}


public class EX02_variable {
	public static void main(String[] args) { //main도 함수(진입점을 갖는 특수한 함수)
		Test t = new Test();
		t.print();
		t.window = 10;
		System.out.println("t.window : "+t.window);
		
		Test t2 = new Test(100);
		System.out.println(t2.window);
		
		Test t3 = new Test(2);
		System.out.println(t3.window);
		t3.write();
		System.out.println("window 함수 호출한 다음 t3.window :"+t3.window);
	
		
		int lv = 500; // "=" 할당연산자 ";"여기까지 한 문장으로 보겠다는 것
					  // "lv" local variable(지역 변수)
		System.out.println("lv 변수값 : "+lv);
		//Ex02 Variable > javac 컴파일 > class > java > 실행 > JVM
		// 단축기: ctrl + F11 (컴파일>>실행)
		
		/* 오늘의 포인트:
		1. local variable은 반드시 initialize하고 사용해야 함
		 initialize: 변수에 처음 값을 할당하는 것
		2. 함수 안의 변수는 반드시 초기화하자. main도 함수다.
		*/
		
		
		int number = 0; //초기화
		number = 100;
		number = 200;
		System.out.println("number : "+number);
		
		//선언과 할당(초기화) 분리 가능
		int a; //선언
		int b;
		//System.out.println(a);// 지역 변수 a 초기화되지 않았으므로 에러 
		a = 10; //초기화
		b = 20;
		System.out.println(a); 
		
		Apt ssung = new Apt(); // ssung은 객체타입 변수가 된다
		System.out.println(ssung.window);
		Apt ppark = ssung;
		ppark.window = 100;
		System.out.println(ssung.window); //얘도 100개가 된다
		System.out.println(ppark); //설계도 이름 +@+주소값 출력 :Apt@15db9742
		
		Apt c = new Apt(); //새로운 객체 인스턴스이므로 주소값 생성
		System.out.println(c); //Apt@6d06d69c
		c = ppark;
		System.out.println(c); // 객체 c를 ppark로 변환했으므로 참조값이 변경
	}

}
