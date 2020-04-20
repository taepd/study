package java_study_ex;

import java.util.Scanner;

public class Ex3_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		String grade;
		System.out.println("=== 성적입력 ===");
		if(score>=90) grade = "A";
		else if(score>=80) grade="B";
		else if(score>=70) grade="C";
		else if(score>=60) grade="D";
		else grade="E";
		
		switch (grade) {
		case "A":
			System.out.printf("학점은 %s입니다.\n참 잘하였습니다.",grade);
			break;
		case "B":
			System.out.printf("학점은 %s입니다.\n참 잘하였습니다.",grade);
			break;
		case "C":
			System.out.printf("학점은 %s입니다.\n조금 더 노력하세요.",grade);
			break;
		case "D":
			System.out.printf("학점은 %s입니다.\n조금 더 노력하세요.",grade);
			break;
		case "E":
			System.out.printf("학점은 %s입니다.\n다음에 다시 수강하세요.",grade);	
		default:
			break;
		}
		
		
	}

}
