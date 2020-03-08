package kr.or.bit;
/*
우리 회사는 비행기를 주문 제작 판매 하는 회사입니다
우리 회사는 비행기를 생산하는 설계도를 작성 하려고 합니다
요구사항
1.비행기를 생산하고 비행기의 이름과 번호를 부여해야 합니다
2.비행기가 생산되면 비행기의 이름과 번호 맞게 부여되었는 확인 하는 작업이 필요합니다 (출력정보 확인)
3.공장장은 현재까지 만들어진 비행기의 총대수 (누적)을 확인 할 수 있습니다

AirPlane air = new AirPlane();
AirPlane air2 = new AirPlane();
AirPlane air3 = new AirPlane();

사실 아래 코드는 50점 >> 생성자 쓰지 않음
그런데 지금까지 배운 코드로 99점>> 함수 기반
  
2~3일 뒤에 코드 수정해서 100점으로 변환


*/

public class AirPlane{
    private int airnum;               //private으로 해서 보안
    private String airname;           //private으로 해서 보안  
    private static int airTotalCount; //private으로 하여 makeAirPlane함수를 사용하지 않으면 못 씀 
    
    public void makeAirPlane(int num, String name) {
        airnum=num;
        airname=name;
        //강제로 누적
        airTotalCount++;
        System.out.printf("번호:[%d], 이름:[%s]\n", airnum, airname); //따로 번호, 이름 값을 얻고 싶으면 getter를 사용하면 됨        
    }
    public void airPlaneTotalCount() {
        System.out.printf("총 비행기 제작 대수 :[%d]\n",airTotalCount);
    }
}




//public class AirPlane{
//    public static void main(String[] args) {
//        
//        AirPlaneM air = new AirPlaneM();
//        air.number=1;
//        air.name="bita";
//        air.info();
//       
//        
//        
//        AirPlaneM air2 = new AirPlaneM();
//        air.number=2;
//        air.name="bito";
//        air.info();
//        
//        
//        AirPlaneM air3 = new AirPlaneM();
//        air.number=3;
//        air.name="bitu";
//        air.info();
//        
//        air.totalAP();
//        
//    }
//}
//
//
//
//
//class AirPlaneM {
//
//    public int number;
//    public String name;
//    public static int total;  
//    public AirPlaneM() {
//        total++;
//    }
//    
//    
//    public void info() {
//        System.out.printf("비행기 번호: %d, 비행기 이름: %s\n", number,name);
//    }
//    
//    public void totalAP() {
//  
//        System.out.println("총 누적 대수는 "+total+"입니다.");
//        
//    }
//    
//    
//}


