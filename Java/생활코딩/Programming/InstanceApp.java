import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class InstanceApp {

	public static void main(String[] args) throws IOException {
		
		PrintWriter p1 = new PrintWriter("result1.txt");
		p1.write("Helllo 1");
		p1.close();
		
		PrintWriter p2 = new PrintWriter("result2.txt");
		p2.write("Helllo 2");
		p2.close();

	}

}
/*
어떤 클래스를 사용할 때 일회성으로 사용하는 경우 ex)Math 가 있고, 여러 번 재사용해야 하는 경우
ex)PrintWriter 가 있다. 인스턴스는 여러 번 사용해야 하는 클래스에 대한 사용을 용이하게 하기 위해
필요하다. 이 때, 변수는 해당 클래스 아래 두어 ex) PrintWriter p1  그 클래스에 어떤 값이 올 수 있
는가를 규제하기 위해서 앞에 클래스 명을 적는다. 인스턴스 사용이 가능한 클래스는 Constructor가 존재하는데
new 뒤에 붙은 코드들이 Constructor에 해당한다. instance는 new + Constructor이다.
 */

/*
 필드 : 자바에서는 변수를 필드라고 함
메소드 : 클래스 안의 '기능'같은 것
클래스 : 비슷한 필드(변수)와 메소드들을 묶어 둔 것
패키지 : 비슷한 클래스들을 묶어 둔 것
인스턴스 : 일회성으로 사용되는 클래스들이 아니라 복잡하고 다양하게 쓰일 수 있는 클래스들을
사용할 때 생성되는 것으로
그런 클래스들을 사용하려면 그 클래스를 이용하여 인스턴스를 만들고 사용해야 한다.
그리고 그러한 클래스들은 생성자(constructor)을 가지고 있다.
상속 : 부모로부터 변수와 메소드들을 받아와서 그대로 사용할 수도 있고
또는 자기 입맛대로 수정하여(override) 사용할 수도 있다.
코드내에서는 extends를 써서 사용한다.	 ex)public class Student extends Teacher
 */