package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//JAVA 코드
		/*
		MyBean mybean = new MyBean();
		MyBean mybean2 = new MyBean("hong");
		MyBean mybean3 = new MyBean();
		
		System.out.println("mybean :" + mybean);
		//DI_05_Spring.MyBean@15db9742
		System.out.println("mybean2 :" + mybean2);
		//DI_05_Spring.MyBean@6d06d69c
		System.out.println("mybean3 :" + mybean3);
		//DI_05_Spring.MyBean@7852e922
		
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		System.out.println("single :" + single);
		//DI_05_Spring.Singleton@4e25154f
		System.out.println("single2 :" + single2);
		//DI_05_Spring.Singleton@4e25154f
		//하나의 객체를 공유해서 사용하겠다
		*/
		
		 ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
		 //스프링 컨테이너(메모리) 가 구성되고 xml 파일 (read) 파싱 해서 ... 객체 생성 , 조립 , 소멸 
		 //컨테이너안 있는 필요한 객체를  얻어서 사용 
		 
		 //getBean() ... return type Object  >> downcasting 해서 작업
		 //***** 주으l사항 *****
		 //getbean() 함수 호출 새로운 객체를 만들지 않아요  (new (x))
		 //** 스프링 컨테이너가 가지는 객체의 타입 : default singleton
		 //** 예외적으로 getBean() 객체를 생성할 수 있는 방법도 있다 (거의 쓰지 않는다)
		 
		 MyBean mybean = context.getBean("mybean",MyBean.class);
		 MyBean mybean2 = context.getBean("mybean",MyBean.class);
		 MyBean mybean3 = context.getBean("mybean",MyBean.class);
		 System.out.println("주소값 : " + mybean + ", "+mybean2 + "," + mybean3);
		 MyBean mybean4 = context.getBean("mybean2",MyBean.class);
		 System.out.println("주소값2 : " + mybean4 );
		 
		 Singleton single = context.getBean("single",Singleton.class);
		 Singleton single2 = context.getBean("single",Singleton.class);
		 
		 System.out.println(single + " / " + single2);
	}

}


