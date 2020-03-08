
public class Ex06 {
	//6-4
	//두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
//	static double getDistance(int x, int y, int x1, int y1) {
//		return Math.sqrt((Math.pow(x1-x,2)+Math.pow(y1-y, 2)));
//		
//	}
	
	public static void main(String[] args) {
//		
		//6-2
//		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
//		
//		String str = s.info();
//		System.out.println(str);
		
		
		//6-4
//		System.out.println(getDistance(1,1,2,2));
		
		
		//6-5
		//클래스 변수(static 변수): width, height
		//인스턴스 변수: kind, num
		//지역변수: k, n, (card, args) < 이 둘도 지역변수!
		
		//6-6
//		MyPoint p =new MyPoint(1,1);
//		System.out.println(p.getDistance(2, 2));
		
		//6-16
		//문자열은 내용변경 불가. 덧셈연산을 하면 새로운 메모리 참조하게 됨
		
		
	}

	

}
//6-1~3
//class Student {
//	
//	String name;
//	int ban, no, kor, eng, math;
//
//	Student (String name, int ban, int no, int kor, int eng, int math) {
//	this.name = name;
//	this.ban = ban;
//	this.no = no;
//	this.kor = kor;
//	this.eng = eng;
//	this.math = math;
//	}
//	
//	public String info() {
//	
//		return name+","+ban+","+no+","+kor
//				+","+eng+","+math+","+(kor+eng+math)+","
//				+((int)(((kor+eng+math)/3f+0.05f)*10))/10f;
//	}
//	public int getTotal() {
//		return kor+eng+math;
//	}
//	public float getAverage() {
//		return ((int)(((kor+eng+math)/3f+0.05f)*10))/10f;
//	}
//
//}
//6-6
class MyPoint {
	int x;
	int y;
	
	MyPoint(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	double getDistance(int x1, int y1) {
		return Math.sqrt((Math.pow(x,x1)+Math.pow(y, y1)));
	}
	
	
}

