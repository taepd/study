package java_study_ex;

import java.util.Scanner;

public class Ex4_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("=== 약수 최대공약수 ===");
		System.out.println("첫 번째 정수 입력 : ");
		int a = sc.nextInt();
		System.out.println("두 번째 정수 입력 : ");
		int b = sc.nextInt();
		System.out.printf("입력한 숫자 : %d %d\n",a,b);
		System.out.print(a+"의 약수는 : ");
		for(int i=1;i<=a;i++) {
			if(a%i==0) {
				System.out.print(i+" ");
			}
		}System.out.println();
		System.out.print(b+"의 약수는 : ");
		for(int i=1;i<=b;i++) {
			if(b%i==0) {
				System.out.print(i+" ");
			}
		}System.out.println();
		
		int c=(a>b)?a:b;
		
		for(int i=c;i>0;i--) {
			if(i==1) {
				System.out.println("두 수는 서로소입니다.");
				break;
			}
			else if(a%i==0&&b%i==0) {
				System.out.println("두 수의 최대공약수 : "+i);
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
