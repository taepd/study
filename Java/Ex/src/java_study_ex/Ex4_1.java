package java_study_ex;

public class Ex4_1 {

	public static void main(String[] args) {
		
		byte num1 = (byte)-89;
		byte num2 = (byte)108;
		
		byte result1 = (byte)(num1>>2);
		byte result2 = (byte)(num1>>3);
		byte result3 = (byte)(num1<<4);
		byte result4 = (byte)(num1^num2);
		byte result5 = (byte)(num1&num2);
		byte result6 = (byte)(num1|num2);
		byte result7 = (byte)(~num1);
		byte result8 = (byte)(~num2);
		
		
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		System.out.println(result7);
		System.out.println(result8);
		
	}

}
