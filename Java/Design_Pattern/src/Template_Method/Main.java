package Template_Method;

public class Main {

	public static void main(String[] args) {
		
		//템플릿 메소드 사용(Wooden House)
		//부모클래스 타입의 변수에 자식 클래스의 주소값 할당 
		HouseTemplate houseType = new WoodenHouse();
		
		houseType.buildHouse();
		
		//구분선 삽입 
		System.out.println();
		System.out.println("***************");
		System.out.println();
		
		//템플릿 메소드 사용(Glass House)
		//주소값 재 할당 
		houseType = new GlassHouse();
		
		houseType.buildHouse();
	}
}