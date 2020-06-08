package DI_Annotation_05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//만약 context.xml파일이 있다면
//<bean id="user" class="DI_Annotation_05.User">
//<bean id="user2" class="DI_Annotation_05.User2">

//@Bean 어노테이션을 사용 객체를 리턴

@Configuration //ConfigContext 자바 파일은 xml대체 할 수 있다(객체 생성 조립)
public class ConfigContext {
	
	 
	
	@Bean
	public User user() {
		return new User();
	}
	
	@Bean
	public User2 user2() {
		return new User2();
	}

}
