import java.util.Scanner;

public class temp2 {

	public static void main(String[] args) {
  
		Scanner sc = new Scanner(System.in); 		

		
		int[] num = new int[3];
		int[] ran = new int[3];

		System.out.println("숫자 3자리를 입력하세요");
		int data= Integer.parseInt(sc.nextLine());
		num[0] = data/100;
		num[1] = data%100/10;
		num[2] = data%100%10;       //각 자리수의 숫자추출
		
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);

	    for(int i=0;i<ran.length;i++) {
	    	ran[i]=(int)(Math.random()*10);
	    	System.out.print(ran[i]);
	    }                            //랜덤 숫자 출력
	    System.out.println();      
		
		 if(ran[0]==num[0]) {
			 System.out.println("STRIKE");
		 }
		 else if(ran[1]==num[1]) {
			 System.out.println("STRIKE");
		 }
		 else if(ran[2]==num[2]) {
			 System.out.println("STRIKE");
		 }
		 else if(ran[0]==num[1]||ran[0]==num[2]) {
			 System.out.println("BALL");
		 }
		 else if(ran[1]==num[0]||ran[1]==num[2]) {
			 System.out.println("BALL");
		 }
		 else if(ran[2]==num[0]||ran[2]==num[1]) {
			 System.out.println("BALL");
		 }
		 else System.out.println("OUT");

		

		 }
}