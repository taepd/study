
public class Ex05_Operation {

	public static void main(String[] args) {

		int result = 100/100;
		System.out.println(result);
		
		result = 13/2;
		System.out.println(result); // 몫만 리턴함
		
		//나머지를 구하는 연산자(%)
		result = 13%2;
		System.out.println(result);
		
		//증가, 감소(증가감 연산자: ++, --)
		// ++ : 1씩 증가
		int i = 10;
		//i = i +1; 
		
		++i; //전치증가
		System.out.println("전치 i : " + i);
		
		i++; //후치증가
		System.out.println("후치 i :" + i);
		
		//변수 혼자 있을 땐, 전치, 후치가 차이가 없다
		
		//Point. 연산자 전치, 후치 성질
		int i2 = 5;
		int j2 = 4;
		
		int result2 = i2 + ++j2;
		System.out.println("result2 : "+ result2 + ", j2 : " + j2);  
		//result2 : 10, j2 : 5   전치는 증감연산 먼저하고 주연산이 적용된다
		
		result2 = i2 + j2++; 
		System.out.println("result2 : "+ result2 + ", j2 : " + j2);
		//result2 : 10, j2 : 6  후치는 주연산 먼저하고 값을 변수에 넘긴 후, 증감연산이 적용된다
		
		//Today Point
		//자바의 연산규칙
		//[정수]의 모든 연산은 [int]로 변환 후 처리된다
		//byte + byte 를 하면 컴파일러가 int + int 변환해서 연산 -> 기본 계산이 정수 기본으로 되어있음
		byte b = 100; // -128~127
		byte c = 1;
		//byte d = b + c; //b+c는 정수 계산이 적용되기 때문에 에러
		//byte d =(byte)(b + c); //손실 발생
		int d = b + c; 
		System.out.println("d : " + d); 
		// 손실이 발생하지 않는 계산을 해야 한다
		
		//byte + short -> 컴파일러가 int + int
		//char + char -> 컴파일러가 int + int
		//연산 처리 시 point : 정수연산에 int보다 작은 타입은 int 변환(long 제외)
		//(byte, char, short 연산 -> int)
		
		//byte + short -> int + int
		//char + int -> int + int
		//int + long -> long + long
		
		//정수 + 실수 > 타입크기 상관없이 > 실수 승자
		long ll = 1000000000L;
		float ff = 1.2f;
		float fresult = ll + ff; //  float타입으로 연산
		System.out.println(fresult);
		
		float num2 = 10.45f;
		int num3 = 20;
		//num2 + num3
		//float + int >> float + float
		//float result5 = num2 + num3;
		//System.out.println(result5);
		
		int result5 = (int)(num2 + num3);
		System.out.println("정수값만 출력 : " +  result5);
		
		char c2 = '!'; //char 정수 타입
		char c3 = '!';
		
		int result6 = c2 + c3; //int 연산이 되므로
		System.out.println("result6 : " + result6);
		System.out.println((char)result6); //66이라는 값은 아스키 코드표 문자 B임
		
		//제어문
		//중소기업의 시험문제(구구단 출력) >> 응용 별찍기 (삼각형)
		
		int sum = 0;
		for(int j = 1; j <= 100; j++ ) {
			//System.out.println("j : " + j);
			if(j%2 == 0) {   //짝수만
				sum += j;
			}
		}
		System.out.println(sum);  //짝수의 합
		//System.out.println(j);// 에러. 변수 j는 for문이 실행되면 생성되었다가 for문이 끝나면 사라짐
		
		
		//== 연산자 (값을 비교하는 연산자)
		if(10 == 10.0f) {  
			System.out.println("True");
		}else {
			System.out.println("False"); 
		}  // 연산 결과 True. ==는 값을 비교하는 연산자이기 때문
		
		// ! 부정 연산자 
		if('A' != 65) {
			System.out.println("True");
		}else {
			System.out.println("False");
		} // 연산 결과 True. 'A'가 65와 같지 않기 때문에
		
		//암기하자(Today Point)
		//삼항연산자
		int p = 10;
		int k = -10;
		int result8 =(p == k)? p : k;  //괄호 안이 참이면 :앞을 취하고, 거짓이면 k를 취함
		System.out.println("result8 : " + result8);
		
		//삼항 연산자는 제어문 if
		if(p==k) {
			result8 = p;
		}else {
			result8 = k;
		} // 위  3항 연산자는  이 if문과 같다
				
//		논리연산
//		0 : false
//		1 : True
		
//		Oracle (sql)
//		
//		select *
//		form emp
//		where empno = 1000 and sal > 2000; 
//		
//		0과 1로 변환해서 bit 연산
		
//		|| 논리연산(or)
//		&& 논리연산(AND)
		
		
		//비트연산
		int x = 3;
		int y = 5;
		System.out.println("x|y : " + (x|y)); //7 ->이진수로 
		//십진수 -> 2진수화
		//128 64 32 16 8 4 2 1
		//             0 0 1 1 //십진수 3은 2진수 0011이다
		//             0 1 0 1 //십진수 5는 2진수 0101이다
		//             0 1 1 1 //x|y는 결과적으로 0111, 즉 10진수 7이 된다
		
		//Today Point (&&(and) , ||(or))
//		if(10 > 0 && -1 > 1 && 100 >2 && 1>-1) {실행문} 
//		if(10 > 0 || -1 > 1 || 100 >2 || 1>-1) {실행문} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
