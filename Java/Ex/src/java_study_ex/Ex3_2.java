package java_study_ex;

import java.util.Scanner;

public class Ex3_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("목표 금액을 입력하세요(100만원 이하)");

		int goal = sc.nextInt();

		int a=0; 
		int sum = 0;
		while (true) {
			System.out.println("입금액을 입력하시오(20만원 이하)");
			a= sc.nextInt();
			if (a > 20) {
				System.out.println("20만원 이하의 금액을 입금하시오");
			} else {
				System.out.println(a + "만원을 입금하였습니다.");
				sum += a - 5;
				System.out.printf("현재 통장 잔액은 %d원입니다.\n", sum);
				if (sum > goal) {
					System.out.println("목표액을 달성하였습니다.");
				break;
				}
			}
		}

	}

}
