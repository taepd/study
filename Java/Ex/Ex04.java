import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		//4-2
//		int sum=0;
//		for(int i=1;i<=20;i++) {
//			if(i%2!=0&&i%3!=0) {
//				sum += i;
//			}
//		}System.out.println(sum);
				
	    //4-3
//		int sum1=0, sum2=0;
//		
//		for(int i=1;i<=10;i++) {
//			sum1 +=i;
//			sum2 +=sum1;
//		}System.out.println(sum2);
		
		//4-4
//		int sum=0;
//		int i=0;
//		while(sum<100) {
//			i++;               //sum 이전에 i값이 증가해야 함
//			if(i%2!=0) {
//				sum+=i;
//			}else {
//				sum+=-i;
//			}
//		}System.out.println(i);
		
		//4-5  for문을 while문으로
//		for(int i=0;i<=10;i++) {
//			for(int j=0;j<=i;j++) {
//				System.out.print("*");
//			}System.out.println();
//		}
		
		
//		int i=0;
//		while(i<=10) {
//			int j=0;           //j 초기화 스코프 주의
//			while(j<=i) {				
//				System.out.print("*");
//				j++;
//			}i++;
//			System.out.println();
//		}
		
		//4-6  두 주사위 눈의 합이 6인 경우의 수 출력
//		for(int i=1;i<=6;i++) {
//			for(int j=1;j<=6;j++) {
//				if(i+j==6) {
//					System.out.printf("(%d,%d)\t",i,j);
//				}
//			}
//		}
		
		//4-7
//		String str = "12345";
//		int sum = 0;
//		
//		for(int i=0; i<str.length();i++) {
//			sum += str.charAt(i)-'0';
//		}
//		System.out.println("sum= "+sum);
		
		//4-8
//		int value =(int)(Math.random()*6)+1;
//				
//		System.out.println("value:"+value);
		
		//4-9
//		int num = 12345;
//		int sum = 0;
//		
//		while(true) {
//			sum += num%10;
//			num /=10;			
//			if(num==0) break;
//		}
//		
//		System.out.println("sum="+sum);
		
//		4-10 숫자 맞히기 게임
		
		//1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int)(Math.random()*100)+1;
		int input = 0;   //사용자입력을 저장할 공간
		int count = 0;   //시도횟수를 세기 위한 변수
		
		//화면으로부터 사용자 입력을 받기 위해서 Scanner클래스 사용
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			count++;
			System.out.println("1과 100사이의 값을 입력하세요 :");
			input = s.nextInt();   //입력받은 값을 변수 input에 저장한다.
			
			if(input<answer) {
				System.out.println("더 큰 수를 입력하세요.");
			}else if(input>answer) {
				System.out.println("더 작은 수를 입력하세요.");
			}else {
				System.out.println("맞혔습니다.");
				System.out.printf("시도횟수는 %d번입니다.%n",count);
				break;
			}
		}while(true);   //무한반복문
		
		
		
		
		


	}
}