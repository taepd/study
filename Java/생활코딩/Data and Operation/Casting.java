
public class Casting {

	public static void main(String[] args) {
		
		double a = 1.1;
		double b = 1;  // 손실이 없기 때문에 자동으로 Casting을 해준 것임 (double) 1;이나 마찬가지
		System.out.println(b);  // double형이므로 1.0으로 컨버팅됨
		
//		int c = 1.1;  // 오류. 손실이 일어나므로
		double d = 1.1;
		int e = (int) 1.1; // 강제로 인티저로 바꾸는 방법
		System.out.println(e); // 1이 된다
		
		// 1 to String
		String f = Integer.toString(1);
		System.out.println("f's class ="+f.getClass());
	}

}
