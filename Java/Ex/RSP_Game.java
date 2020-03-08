//가위바위보 게임기
//- 가위바위보 승리 시 1~20 중 임의의 코인갯수 획득(가능하다면 2단계 코인획득 갯수 1,2,4,7,10,20으로 설정하고 각 확률값 주기)
//- 승리 시 얻은 코인으로 다시 게임 가능
//- 게임종료 시 현재까지 획득한 코인 수 출력 (게임종료 선택지가 있어서 잔여코인이 있는데도 종료할 경우)

//추가기능: 
//- 커스텀으로 확률값/코인획득갯수 조정
//- 획득 코인 수(범위)에 따라 상품 증정

import java.util.Scanner;

public class RSP_Game {

	static Scanner sc = new Scanner(System.in); //인스턴스 초기화 블럭
	private static int totalCoin;
	static void playGame() {
			
			while (true) {
			int you;
			System.out.println("************");
			System.out.println("가위~바위~보!");
			System.out.println("************");
			System.out.println("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.");
			int com = (int) (Math.random() * 3 + 1); // 컴퓨터의 랜덤 선택


			do {
				try { // try catch 문은 에러를 처리하는게 아니라 에러가 발생해도 우선 catch문으로 보내서 계속 프로그램이 실행될 수 있게 해주는 것
					you = Integer.parseInt(sc.nextLine());
					if (1 <= you && you <= 3) {
						break; // while탈출( 1<= menu <=3)
					} else {
						// 1보다 작거나 4보다 큰 값 < 프로그램적 오류는 아니지만 난 오류로 보겠다는 것
						// System.out.println("잘못 입력하였습니다");
						throw new Exception("잘못 입력하였습니다. 다시 입력해 주세요.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());			
					System.out.println("입력 문제 발생");
					System.out.println("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.");
				}

			} while (true);

			if (com == 1)
				System.out.print("컴퓨터는 가위, "); // 컴퓨터의 선택
			else if (com == 2)
				System.out.print("컴퓨터는 바위, ");
			else if (com == 3)
				System.out.print("컴퓨터는 보, ");
			if (you == 1)
				System.out.print("당신은 가위! "); // 당신의 선택
			else if (you == 2)
				System.out.print("당신은 바위! ");
			else if (you == 3)
				System.out.print("당신은 보! ");
			if (com == you) {
				System.out.println("비겼습니다."); // 결과
				System.out.println("다시 한 번 선택해주세요.");
			}
			else if ((you - com == -2) || (you - com == 1)) {
				System.out.println("당신이 이겼습니다.");
				roulette();
				reGame();
			}
			else if ((com - you == 1) || (com - you == -2)) {
				System.out.println("당신이 졌습니다.");
				reGame();				
			}
		}

	}
	
	private static void reGame() {
		System.out.println("현재 코인 합계: "+totalCoin);
		if(totalCoin>0) {			
			int re;
			System.out.println("다시 하시겠습니까?");
			System.out.println("네(1), 아니오(2) 중 하나를 입력하세요.");
			do {
				try { // try catch 문은 에러를 처리하는게 아니라 에러가 발생해도 우선 catch문으로 보내서 계속 프로그램이 실행될 수 있게 해주는 것
					re = Integer.parseInt(sc.nextLine());
					if (1 <= re && re <= 2) {
						break; // while탈출( 1<= menu <=2)
					} else {
						// 1보다 작거나 4보다 큰 값 < 프로그램적 오류는 아니지만 난 오류로 보겠다는 것
						// System.out.println("잘못 입력하였습니다");
						throw new Exception("잘못 입력하였습니다. 다시 입력해 주세요.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("입력 문제 발생");
					System.out.println("네(1), 아니오(2) 중 하나를 입력하세요.");
				}

			} while (true);
			if(re==1) {
				totalCoin-=1;
			}else {
				System.out.println("최종 획득 코인 갯수: "+totalCoin+"개");
				System.out.println("게임을 종료합니다. 감사합니다.");
				System.exit(0);
			}
			
		}else {			
			System.out.println("코인이 다 떨어졌습니다. 게임을 종료합니다. 감사합니다.");
			System.exit(0);
		}
	}
	
	private static void roulette() {
		int point = (int) (Math.random() * 100 + 1);
		int getCoin;
		if(1<=point&&point<=40) {
			getCoin=1;
			totalCoin+=getCoin;
		}else if(point<=65) {
			getCoin=2;
			totalCoin+=getCoin;
		}else if(point<=80) {
			getCoin=4;
			totalCoin+=getCoin;
		}else if(point<=90) {
			getCoin=7;
			totalCoin+=getCoin;
		}else if(point<=98) {
			getCoin=10;
			totalCoin+=getCoin;
		}else  {
			getCoin=20;
			totalCoin+=getCoin;
		}
		System.out.println("축하합니다. 코인 "+ getCoin+ "개 획득!");		
	}

	public static void main(String[] args) {
		playGame();		
	}
}
