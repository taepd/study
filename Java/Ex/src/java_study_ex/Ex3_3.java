package java_study_ex;

public class Ex3_3 {

	public static void main(String[] args) {

		char a = 'A';
		int count=0;
		String s="";
		do {
			String b=String.valueOf(a);
			s+= b;
			a++;
			count++;
		} while (count<26);
		System.out.println(s);
		
	}

}
