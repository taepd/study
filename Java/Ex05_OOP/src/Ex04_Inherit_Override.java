/*
 * Today Point
 * [상속 관계]에서 override: 상속 관계에서 메서드[재정의]
 * [상속 관계]에서 [자식 클래스]가 [부모 클래스]의 메서드를 재정의(내용 바꾼다)
 * 재정의: 틀의 변환(함수 이름, 타입)하는 것이 아니고 내용(조건부)만 바꿈
 * 문법)
 * 1. 부모 함수 이름과 동일
 * 2. 부모 함수 parameter 동일
 * 3. 부모함수 return Type 동일
 * 4. 조건부{}만 바꿈
 * 
 * 오버로딩과 오버라이딩의 차이
 * 오버로딩: 하나의 이름으로 여러 기능
 * 오버라이딩: 상속 관계에서 메서드 재정의
*/

class Point2{
    int x = 4;
    int y = 5;
    String getPosition() {
        return "x:"+this.x +" y:"+this.y;
    }
}

class Point3D extends Point2 {
    int z = 6;
    //부모의 함수와 틀이 동일 > 내용만 다름
    //재정의
    //Annotation은 Java code 만으로 전달할 수 없는 [부가적인 정보]를 컴파일러, 개발툴에 전달하는 기능을 함
    //@Override >> Annotation >> 컴파일러, 개발툴에게 재정의 검사를 하라고 지시
    @Override           //어노테이션
    String getPosition() {  //오버라이딩된 메서드
        return "x:"+this.x +" y:"+this.y+" z:"+this.z;
    }
}


public class Ex04_Inherit_Override {
    
    public static void main(String[] args) {
        Point3D po = new Point3D();
        System.out.println(po.getPosition());  //재정의한 함수가 호출
        
        
        
        
    }

}
