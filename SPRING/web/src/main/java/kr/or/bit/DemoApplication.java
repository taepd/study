package kr.or.bit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); //default 내장톰캣 실행하는 웹어플리케이션 방식
		
		//외부 프로퍼티 사용시 아래 방식으로 하지 않아도 된다
		/*
		 * SpringApplication application = new SpringApplication(DemoApplication.class);
		 * application.setWebApplicationType(WebApplicationType.NONE);//내장톰캣 사용안하는
		 * 자바어플리케이션 방식 application.run(args);
		 */
	}

}
