 
public class StringApp {

	public static void main(String[] args) {
		
		// Character VS String
		System.out.println("Hello World"); //String : 캐릭터들이 모여있는 것이 스트링
		System.out.println('H'); //Character : 한 글자를 표현하는 데이터
		System.out.println("H"); // 이건 스트링이다

		System.out.println("Hello "
				+ "World");		// 정상작동이지만, 줄바꿈은 안된다
		
		// New line
		System.out.println("Hello \nWorld"); // \n: 줄바꿈하라
		
		// escape : 뒤에 나오는 문자를 그 역할에서 빠져나오게 해준다는 의미
		System.out.println("Hello \"World\""); // Hello "World"
	}

}
