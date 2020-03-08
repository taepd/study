
public class ClassMaking_exercise {


    
//  [고유 데이터]
//  제작회사: 애플, 삼성
//  모델: 갤럭시, 10xs
//  색깔: 블랙,화이트
    
    String company = "apple";
    String model = "iphone";
    String color= "black";
  
//   [상태]
//   전원 on/off
//   밝기정도:
//   홈화면 상태: 전화/웹검색/앱실행
//   데이터모드: lte/wifi모드
    boolean power;
    double brightness;
    int homeScreenMode;
    int dataMode;
    
//   [부품]  = 하나의 데이터로 표현 안되는 것 (복합적인 것) 클래스로 나올 수 있는 것
//   액정 
//   cpu
//   메모리
//   각종 버튼
//   카메라
//   바디
    
     Cpu cpu;
     Memory memory;
     Camera camera;
     Frame frame;
     Button button;
    
     class Camera{}
     class Memory{}
     class Cpu{}
     class Frame{}
     class Button{}
    
    
    
    
    
    
    

}
