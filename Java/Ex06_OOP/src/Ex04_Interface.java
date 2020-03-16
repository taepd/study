//서로 다른 클래스를 하나의 부모로 묶어주는 역할
interface Irepairable {

}

class Unit2 {
    int hitpoint; // 기본 에너지
    final int MAX_HP;

    Unit2(int hp) {
        this.MAX_HP = hp;
    }
}

//지상유닛
class GroundUnit extends Unit2 {

    GroundUnit(int hp) {
        super(hp);
    }

}

class CommandCenter implements Irepairable {

}

//공중유닛
class AirUnit extends Unit2 {
    AirUnit(int hp) {
        super(hp);
    }
}

class Tank2 extends GroundUnit implements Irepairable {
    Tank2() {
        super(500);
        this.hitpoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "Tank2";
    }
}

class Marine2 extends GroundUnit{
    Marine2() {
        super(50);
        this.hitpoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "Marine2";
    }
}

class Scv extends GroundUnit implements Irepairable {

    Scv() {
        super(60);
        this.hitpoint = this.MAX_HP;
    }



    @Override
    public String toString() {
        return "Scv";
    }
    // Scv 구체화, 특수화, 고유한 기능
    // repair(수리하다)
//    void repair(Tank2 tank) {
//        if(tank.hitpoint!=tank.MAX_HP) {
//            tank.hitpoint+=5;
//        }
//    }
//    
//    void repair(Scv scv) {
//        if(scv.hitpoint!=scv.MAX_HP) {
//            scv.hitpoint+=5;
//        }
//    }
    /*
     * Scv가 repair하는 Unit 개수가 증가하면 Unit 개수만큼 repair 함수 추가 고민: 하나의 repair 함수가 모든
     * repair 가능한 Unit을 수리할 수 없을까 다형성 활용하면 될텐데, 우리가 가지고 있는 모든 Unit이 repair 대상이 아니다
     */

//    void repair(GroundUnit unit) {   //이렇게 하면 마린도 리페어하게 됨. 우리의 조건과 안맞음. 
//        if(unit.hitpoint!=unit.MAX_HP) {
//            unit.hitpoint+=5;
//        }
//    }

//    void repair(Unit2 unit) {   //이렇게 하면 AirUnit과 마린도 리페어하게 됨. 게다가 커맨드센터는 포함하지 않음 
//        if(unit.hitpoint!=unit.MAX_HP) {
//            unit.hitpoint+=5;
//        }
//    }

    // 야 결국에는 서로 연관성이 없네

    // 해결사: Interface
    // 1. 서로 연관성이 없는 클래스에 대해서 하나로 묶는 기능 제공(상위 부모 역할)
    // -> interface도 하나의 타입이기 때문

    void repair(Irepairable repairableUnit) {
        // repairableUnit 변수는 Tank2, CommandCenter, Scv

        /*
         * repair하는 대상에 CommandCenter가 올 수 있지만 Unit은 아니다 >> 충전 방식이 다르다 reparableUnit은 자기
         * 것이 없다 부모는 자식의 것만 Unit2 >> hitpoint, MAX_HP 소유 (Irepairable repairableUnit) 을
         * Tank2 타입으로 다운캐스팅 필요 downcasting -> Tank2 tank =(Tank2)repairableInit (상위 타입을
         * 하위 타입으로) downcasting -> Scv scv = (Scv)repariableUnit(상위 타입을 하위 타입으로)
         * 
         * 요약 Tank2 > GroundUnit > Unit2 Scv > GroundUnit > Unit2 공통점: Unit2
         * 
         * CommandCenter > Unit2(x)
         */
        // 수리 가능한 유닛만 parameter로 받는데
        // 그 parameter는 다른 충전방식도 존재
        if (repairableUnit instanceof Unit2) {
            Unit2 unit = (Unit2) repairableUnit;    // 다운캐스팅해서 hitpoint와 MAX_HP를 사용 가능하게 하는 것이 포인트.>> Irepairable은 아무 내용이 없는 인터페이스이기 때문
            if (unit.hitpoint != unit.MAX_HP) {
                unit.hitpoint = unit.MAX_HP;
            } else { // Unit2를 부모로 가지고 있지 않으면
                     // 코드 구현
                System.out.println("Unit2가 아니예요. 다른 방식으로 repair합니다.");
            }

        }

    }
}

public class Ex04_Interface {

    public static void main(String[] args) {
        
        Tank2 tank = new Tank2();
        Marine2 marine = new Marine2();
        Scv scv = new Scv();
        CommandCenter commandCenter = new CommandCenter();
        
        //전투
        tank.hitpoint -=20;
        System.out.println("탱크: "+ tank.hitpoint);
        System.out.println("Scv 수리 요청");
        scv.repair(tank);   // repari 메서드 하나로 tank, scv, commandCenter 모두 수리 가능해졌다.
        System.out.println("탱크 수리 완료: "+tank.hitpoint);
        
        
        
 
        
        
        
        
        
        
        
        
        
        

    }

}
