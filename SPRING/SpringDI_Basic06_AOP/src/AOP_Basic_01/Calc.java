package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/*
 * 간단한 사칙연산 계산기 프로그램
 * - 주관심(업무): 사칙연산(ADD, MUL) -> 기능(함수)
 * - 보조관심(공통관심): 연산에 걸린 시간
 * - log출력(console 출력 Red색으로 출력)
*/

public class Calc {
	public int Add(int x, int y) {
		
		Log log = LogFactory.getLog(this.getClass());
		//System.currentTimeMillis(); 
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x + y; //주관심
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method: Add]");
		log.info("[Time Log Method Time" + sw.getTotalTimeMillis()+"]");
		
		return result;
	}
	
	public int Mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		//System.currentTimeMillis(); 
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x * y; //주관심
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method: Add]");
		log.info("[Time Log Method Time" + sw.getTotalTimeMillis()+"]");
		
		return result;
	}

}
