package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//영문
		//MessageBean_en messagebean_en = new MessageBean_en();
		//messagebean_en.sayHello("hong");
		
		//한글
		//MessageBean_kr messagebean_kr = new MessageBean_kr();
		//messagebean_kr.sayHello("hong");
				
		//interface 하나의 참조 변수가 여러개의 주소를 가질 수 있다 (다형성)
		
		//MessageBean messagebean = new MessageBean_kr();
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		//GenericXml로 컨테이너 만들면 앞에 클래스패스를 써야 함. 하위 경로는 '/'로 구분?
		MessageBean messagebean = context.getBean("message",MessageBean.class);
		messagebean.sayHello("hong");

	}

}
/*
요구사항
영문버전 (hong) : Hello hong !
한글버전 (hong) : 안녕 hong !

MessageBean_kr > 함수 > sayHello
MessageBean_en > 함수 > sayHello

>>인터페이스 :  MessageBean  인터페이스 설계 >> kr , en 구현
*/

