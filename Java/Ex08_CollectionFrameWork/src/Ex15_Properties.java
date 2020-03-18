import java.util.Properties;

/*
 * <Properties>
 * Map 인터페이스를 구현한 클래스
 * 특수한 목적의 map <String, String> 으로 고정된 Map
 * 사용목적
 * APP 전체를 관리, 환경 변수, 프로그램의 버전, 파일 경로, 공통 변수 등을 셋팅하고자
 * 
 * ex)
 * config.properties
*/


public class Ex15_Properties {

    public static void main(String[] args) {
        Properties  prop = new Properties();  // 제네릭이 이미 <String, String>으로 셋팅되어 있다
        prop.setProperty("master", "bit@bit.or.kr");
        prop.setProperty("version", "1.x.x.x");
        prop.setProperty("defaultpath", "C:\\Temp\\images");
        
        //각각의 개발 페이지에서
        System.out.println(prop.getProperty("master")); //이런 식으로 사용
        System.out.println(prop.getProperty("defaultpath"));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
