/*
 * 설계도 1개  >> 업무가 복잡하지 않으면 
 * 업무가 복잡해지면  1개 이상의 설계도 제작
 * 고민> 쇼핑몰> 회원관리, 주문관리, 배송관리 ... 설계도 5장
 * **기준점** (관계)
 * 
 * 1. 상속 관계(is ~ a:) 은~ 이다.
 * 
 * 2. 포함 관계(has ~ a:) 은~ 을 가지고 있다.
 * 
 * 예)
 * 원클래스  도형클래스
 * >> 원 extends 도형 (상속 관계)
 * 
 * 원클래스 점클래스
 * >>원은 점이다(x)
 * >>원은 점을 가지고 있다(o)
 * >>has ~ a 
 * >>class 원 {점 변수명} //멤버필드로 가짐
 * 
 * 경찰클래스 총클래스
 * 경찰은 총이다(x)
 * 경찰은 총을 가지고 있다(o)
 * class 경찰{권총 변수;}
 * 
 * 원, 삼각형, 사각형 만드는 설계도 작성
 * 
 * 원은 도형이다
 * 삼각형은 도형이다
 * 사각형은 도형이다
 * 
 * 도형: 추상화, 일반화 (그리다, 색상) >> 공통 자원
 * 
 * 원: 구체화, 특수화 (반지름, 점) >>본인 만이 가지는 특징
 * 
 * 점: 좌표값(x,y)
 * 원은 점을 가지고 있다
 * 삼각형은 점을 가지고 있다
 * 사각형은 점을 가지고 있다
 * 
 * class Shape: 일반화, 추상화, 공통(그리다, 색상)
 * class Point: 점
 * 
 * circle, triangle, square : 구체화, 특수화
*/
//추상화, 일반화, 공통
class Shape {
    String color = "gold";
    void draw() { //공통 기능
        System.out.println("그리다");
    }
}

//공통
class Point {
    int x;
    int y;
    Point(){
        this(1,1);
    }
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

//문제: 원을 만드세요(원의 정의; 원은 한 점과 반지름을 가지고 있다)
//1. 원은 도형이다 (is ~ a): 도형(shape)
//2. 원은 점을 가지고 있다(has ~ a): 점(point)
//3. 원은 반지름을 가지고 있다(특수성): r
//4. 원의 반지름은 default값으로 10을 가진다
//5. 점의 x, y 좌표는 default로(10,15)
//6. 기본값을 설정하지 않으면 반지름과 점의 값을 입력받을 수 있다(원이 만들어질 때)

class Circle extends Shape {
    Point point;
    int r;
    
    Circle(){
//        this.point = new Point(10,15);
//        this.r = 10;
        this(10, new Point(10,15));  //두 번째 매개변수로 new 생성자를 쓰는 것 Today Point.
    }
    Circle(int r, Point point){
        this.r =r;
        this.point = point;  //주소값 할당
    }
}
//문제 2)
//삼각형 클래스를 만드세요
//정의) 삼각형은 3개의 점과 색과  그리고 그리다라는 기능을 가지고 있다
//Shape, point 제공 받아요
//hint) (x,y)  (x,y)  (x,y) 3개의 좌표값 
//default 로 그릴 수 있고 , 3개의 좌표값을 받아서 그릴 수 있다
class Triangle extends Shape{
    Point point1;
    Point point2;
    Point point3;
    
    Triangle(){
        this(new Point(0,0),new Point(1,1),new Point(2,2));
        
    }
    
    Triangle(Point point1,Point point2,Point point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }
}





public class Ex02_Inherit_Composition {
    public static void main(String[] args) {
        
        Circle circle = new Circle();
        System.out.printf("반지름: %d / 점: (%d,%d)\n",circle.r,circle.point.x,circle.point.y);
        System.out.println("부모: "+circle.color);
        circle.draw();
        
        Circle circle2 = new Circle(20, new Point(2,5));
        System.out.printf("반지름: %d / 점: (%d,%d)\n",circle2.r,circle2.point.x,circle2.point.y);
        System.out.println("부모: "+circle2.color);
        circle2.draw();
        
        Triangle triangle = new Triangle();
        System.out.printf("꼭지점1: (%d,%d), 꼭지점2: (%d,%d), 꼭지점3: (%d,%d)%n",triangle.point1.x,triangle.point1.y,
                triangle.point2.x,triangle.point2.y,triangle.point3.x,triangle.point3.y);
        triangle.draw();
        
        Triangle triangle2 = new Triangle(new Point(3,3),new Point(4,4),new Point(5,5));
        System.out.printf("꼭지점1: (%d,%d), 꼭지점2: (%d,%d), 꼭지점3: (%d,%d)%n",triangle2.point1.x,triangle2.point1.y,
                triangle2.point2.x,triangle2.point2.y,triangle2.point3.x,triangle2.point3.y);
        triangle2.draw();
                
        
        
        
        
        
    }

}
