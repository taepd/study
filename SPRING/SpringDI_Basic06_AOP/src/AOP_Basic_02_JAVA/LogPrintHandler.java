package AOP_Basic_02_JAVA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
 * 보조업무(공통관심) 별도의 클래스 분리
 * invoke: 하나의 함수가 여러 개의 함수를 대리 처리.. (대리 함수)
*/

public class LogPrintHandler implements InvocationHandler{
	
	private Object target; //실객체의 주소를 받아 주는 것
	public LogPrintHandler(Object target) {
		System.out.println("LogPrintHandler 생성자 호출");
		this.target = target; //실객체의 주소 return
	}
	
	//주업무(함수)
	//ADD, MUL, SUB 대리해서 처리
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoke 함수 호출");
		System.out.println("method 함수 명: "+ method);
		System.out.println("method parameter : "+ Arrays.toString(args));//parameter를 받아 준다. Object[]인 이유는 parameter가 몇 개일지 모르니
		
		//보조업무
		Log log = LogFactory.getLog(this.getClass());
		//System.currentTimeMillis(); 
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무(실객체의 함수 호출) ADD, MUL, SUB
		int result = (int)method.invoke(this.target, args); 
		System.out.println("계산했습니다");
		
		
		//보조업무
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method: Add]");
		log.info("[Time Log Method Time" + sw.getTotalTimeMillis()+"]");
		
		return result;
	}
	
}



















