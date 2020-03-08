import kr.or.bit.AirPlane;

public class Ex07_Static_AirPlane {

    public static void main(String[] args) {
   
        AirPlane air1 = new AirPlane();
        air1.makeAirPlane(101, "대한항공");
        air1.airPlaneTotalCount();
        
        AirPlane air2 = new AirPlane();
        air2.makeAirPlane(102, "대한항공");
        air2.airPlaneTotalCount();
        
        AirPlane air3 = new AirPlane();
        air3.makeAirPlane(103, "대한항공");
        air3.airPlaneTotalCount();
        
        

    }

}
