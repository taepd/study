//여러개의 스레드 우선부여 .... 점유율(cpu)
//Min 1  ~  Max 10  >> default 5

class Pth extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("----------------");
		}
	}
}
class Pth2 extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("||||||||||||||||");
		}
	}
}
class Pth3 extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("***************");
		}
	}
}
public class Ex07_priority {
	public static void main(String[] args) {
		Pth pth = new Pth();
		Pth2 pth2 = new Pth2();
		Pth3 pth3 = new Pth3();
		
		System.out.println(pth.getPriority());    //우선순위 기본값은 5
		System.out.println(pth2.getPriority());   //마찬가지로 5
		System.out.println(pth3.getPriority());   //마찬가지로 5
		
		
		//우선순위값: 1~10 사이. 수가 클수록 높은 우선순위
		pth.setPriority(10);   //우선 순위를 높여줌
		pth3.setPriority(1);   //우선 순위를 낮춰줌
		
		pth.start();
		pth2.start();
		pth3.start();

	}

}








