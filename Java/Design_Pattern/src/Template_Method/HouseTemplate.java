package Template_Method;

public abstract class HouseTemplate {
	
	//final선언으로 Override 방지
	//한번에 실행하기 위해서 메소드 생성 후 함수 호출
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built");
	}
	
	//기본으로 구현 되는 메소드 
	public void buildWindows() {
		System.out.println("Bilding Glass Windows");
	}
	
	//서브클래스에서 직접 구현할 메소드 
	public abstract void buildWalls();
	public abstract void buildPillars();

	//기본으로 구현 되는 메소드
	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}
}