import java.util.Scanner;

public class Ex12_do_while_Static_Menu_GroupAssignment {
	static Scanner sc = new Scanner(System.in);

	// 초기 메뉴 화면 함수
	static int displayMenu() {
		System.out.println("****************");
		System.out.println("****점심 메뉴*****");
		System.out.println("1. 한식");
		System.out.println();
		System.out.println("2. 양식");
		System.out.println();
		System.out.println("3. 중식");
		System.out.println();
		System.out.println("4. 나가기");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 4) {
					break; // while탈출( 1<= menu <=4)
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("메뉴 1~4번까지 입력");
			}
		} while (true);
		return menu;
	}

	// 한식메뉴 함수
	static int kFood() {
		System.out.println("****************");
		System.out.println("****한식 메뉴*****");
		System.out.println("1. 김치찌개");
		System.out.println();
		System.out.println("2. 된장찌개");
		System.out.println();
		System.out.println("3. 돌솥비빔밥");
		System.out.println();
		System.out.println("4. 제육볶음");
		System.out.println();
		System.out.println("5. 이전 메뉴로");
		System.out.println();
		System.out.println("6. 프로그램 종료");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					break;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("메뉴 1~6번까지 입력");
			}
		} while (true);
		// 여기가 실행됐다는 것은 사용자가 1~6까지 번호 중에서 하나를 선택한 것
		return menu;
	}

	static int wFood() {
		System.out.println("****************");
		System.out.println("****양식 메뉴*****");
		System.out.println("1. 돈까스");
		System.out.println();
		System.out.println("2. 피자");
		System.out.println();
		System.out.println("3. 스파게티");
		System.out.println();
		System.out.println("4. 햄버거");
		System.out.println();
		System.out.println("5. 이전 메뉴로");
		System.out.println();
		System.out.println("6. 프로그램 종료");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					break;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("메뉴 1~6번까지 입력");
			}
		} while (true);
		// 여기가 실행됐다는 것은 사용자가 1~6까지 번호 중에서 하나를 선택한 것
		return menu;
	}

	static int cFood() {
		System.out.println("****************");
		System.out.println("****중식 메뉴*****");
		System.out.println("1. 짜장면");
		System.out.println();
		System.out.println("2. 짬뽕");
		System.out.println();
		System.out.println("3. 볶음밥");
		System.out.println();
		System.out.println("4. 유산슬");
		System.out.println();
		System.out.println("5. 이전 메뉴로");
		System.out.println();
		System.out.println("6. 프로그램 종료");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					break;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("메뉴 1~6번까지 입력");
			}
		} while (true);
		// 여기가 실행됐다는 것은 사용자가 1~6까지 번호 중에서 하나를 선택한 것
		return menu;
	}

	// 선택메뉴 함수
	static void decision(String s, int p) {
		System.out.printf("%s은(는) %d원 입니다.\n", s, p);
		System.out.printf("%s를 선택하시겠습니까?\n", s);
		System.out.println("네(1), 아니오(2) 입력해 주세요.");
		int d;
		do {
			try {
				d = Integer.parseInt(sc.nextLine());
				if (1 <= d && d <= 2) {
					break; // while탈출( 1<= menu <=4)
				} else {
					throw new Exception("번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("네(1), 아니오(2) 입력해 주세요.");
			}
		} while (true);
		if (d == 1) {
			System.out.printf("%s를 주문하셨습니다. 감사합니다.\n", s);
			System.exit(0);
		} else {
			System.out.println("메뉴를 다시 선택하세요.");
		}
	}

	public static void main(String[] args) {
		// Ex12_do_while_Static_Menu ex11 = new Ex12_do_while_Static_Menu();
		while (true) {

			switch (Ex12_do_while_Static_Menu_GroupAssignment.displayMenu()) {
			case 1: {
				outer: while (true) {
					switch (Ex12_do_while_Static_Menu_GroupAssignment.kFood()) {
					case 1:
						Ex12_do_while_Static_Menu_GroupAssignment.decision("김치찌개", 5000);
						break;
					case 2:
						Ex12_do_while_Static_Menu_GroupAssignment.decision("된장찌개", 5000);
						break;
					case 3:
						decision("돌솥비빔밥", 4500);
						break;
					case 4:
						decision("제육볶음", 6000);
						break;
					case 5:
						System.out.println("초기 메뉴로 돌아갑니다");
						break outer;
					case 6: {
						System.out.println("프로그램 종료");
						System.exit(0);
					}
					}
					
				} break;
			}

			case 2:
			{
				outer: while (true) {
					switch (Ex12_do_while_Static_Menu_GroupAssignment.wFood()) {
					case 1:
						decision("돈까스", 6000);
						break;
					case 2:
						decision("피자", 10000);
						break;
					case 3:
						decision("스파게티", 8000);
						break;
					case 4:
						decision("햄버거", 5000);
						break;
					case 5:
						System.out.println("초기 메뉴로 돌아갑니다");
						break outer;
					case 6: {
						System.out.println("프로그램 종료");
						System.exit(0);
					}
					}
					
				} break;
			}
			case 3:
			{
				outer: while (true) {
					switch (Ex12_do_while_Static_Menu_GroupAssignment.cFood()) {
					case 1:
						decision("짜장면", 5000);
						break;
					case 2:
						decision("짬뽕", 5000);
						break;
					case 3:
						decision("볶음밥", 7000);
						break;
					case 4:
						decision("유산슬", 20000);
						break;
					case 5:
						System.out.println("초기 메뉴로 돌아갑니다");
						break outer;
					case 6: {
						System.out.println("프로그램 종료");
						System.exit(0);
					}
					}
					
				} break;
			}
			case 4:
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		}
	}
}