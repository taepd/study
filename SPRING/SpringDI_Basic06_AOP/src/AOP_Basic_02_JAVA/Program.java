package AOP_Basic_02_JAVA;

import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		//NewCalc calc = new NewCalc();
		//calc.ADD(x,y)
		
		Calc calc = new NewClac(); //calc는 실 객체의 주소가 들어있음
		
		//가짜를 통해서 접근
		Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(), //실제 객체의 메타정보
												calc.getClass().getInterfaces(), //행위정보(인터페이스)
												new LogPrintHandler(calc));		 //보조 객체에 대한 정보
		//코드를 직접(프록시 사용)
		//사용자는 프록시인지 모르고 사용
		
		int result = cal.ADD(555, 555);
		System.out.println("Main Result: "+ result);
	}

}



















