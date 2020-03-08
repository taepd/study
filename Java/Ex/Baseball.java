import java.util.Arrays;
import java.util.Scanner;

//3가지의 랜덤 숫자와 사용자가 입력한 수를 비교하여
//숫자도 같고 자리도 같으면 STRIKE를
//숫자는 같지만 자리가 다르면 BALL을
//숫자가 다르면 OUT을 출력하는 야구게임 만들기.

public class Baseball {
	static int pickNumber() {
		// return (int) (Math.random() * 10); //0~9까지
		return (int) (Math.random() * 9) + 1; // 1~9까지
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int q1 = pickNumber();
		int q2 = pickNumber();
		while (q1 == q2) {
			q2 = pickNumber();
		}
		int q3 = pickNumber();
		while (q1 == q2 || q2 == q3 || q1 == q3) {
			q3 = pickNumber();
		}

		int player;
		int p1, p2, p3;
		int count = 0; // 플레이 횟수
		int[] log = new int[9];

//		System.out.println(q1);
//		System.out.println(q2);
//		System.out.println(q3);

		System.out.println("************");
		System.out.println("   숫자야구 게임");
		System.out.println("************");

		while (true) {
			System.out.println("세 개의 다른 숫자를 입력해 주세요.");

			do {
				try { // try catch 문은 에러를 처리하는게 아니라 에러가 발생해도 우선 catch문으로 보내서 계속 프로그램이 실행될 수 있게 해주는 것
					player = Integer.parseInt(sc.nextLine());
					p1 = player / 100;
					p2 = player % 100 / 10;
					p3 = player % 10;
					if ((0 <= player && player <= 999) && p1 != p2 && p2 != p3 && p3 != p1) {
						break;
					} else {
						throw new Exception("잘못 입력하였습니다. 다시 입력해 주세요.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("입력 문제 발생");
					System.out.println("세 개의 다른 숫자를 입력해 주세요.");
				}

			} while (true);

			int strike = 0;
			int ball = 0;
			int[] quiz = { q1, q2, q3 };
			int[] play = { p1, p2, p3 };

			for (int i = 0; i < quiz.length; i++) {
				if (quiz[i] == play[i]) {
					strike++;
				}
				for (int j = 0; j < play.length; j++) {
					if (quiz[i] != play[i] && quiz[i] == play[j]) {
						ball++;
					}
				}
			}
			System.out.printf("%dSTRIKE, %dBALL %dOUT입니다.%n", strike, ball, 3 - (strike + ball));
			log[count] = player;
			count++;
			System.out.println("남은 플레이 횟수: " + (9 - count));
			System.out.println("플레이 기록: " + Arrays.toString(log));
			if (9 - count == 0) {
				System.out.println("남은 플레이 횟수를 다 쓰셨습니다. 게임오버");
				System.exit(0);
			}
			if (q1 == p1 && q2 == p2 && q3 == p3) {
				System.out.println("*****정답입니다!*****");
				System.exit(0);
			}
		}
	}

}
