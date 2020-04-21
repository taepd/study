package java_study_ex;

import java.util.Scanner;

public class Ex4_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("출력할 피라미드의 층 수를 입력하시오 : ");
		int n = sc.nextInt();
		for(int i=1; i<=n;i++) {
			for(int j=n-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				System.out.print("*");
			}System.out.println();
		}
	}
}
