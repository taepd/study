package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		
		/*
		NewRecordView view = new NewRecordView();
		NewRecord record = new NewRecord();
		view.setRecord(record); //주입 
		view.input();
		view.print();
		*/
		
		//**1. SpringFramework이 제공하는 컨테이너 생성(메모리 생성:IOC컨테이너)
		//**2. 컨테이너 만들고 그 메모리에 필요한 객체를 넣고 조립 작업 >>xml 구성
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		//이 한 줄의 코드로 컨테이너 만들고 >> xml파일 read << 컨테이너 객체 생성/조립
		
		//레고박스 생성, 레고 블럭이 생성
		//필요하면 박스에서 레고블럭 가지고 와서 놀면 됨
		
		RecordView view = context.getBean("view", RecordView.class);//리턴타입 Object라 다운캐스팅
		view.input();
		view.print();
		
		//Caused by: java.lang.ClassNotFoundException: org.apache.commons.logging.LogFactory
		
		
		
	}

}













