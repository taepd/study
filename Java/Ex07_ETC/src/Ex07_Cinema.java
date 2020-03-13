import java.util.Scanner;

/*영화관 관리 프로그램
예약
취소
조회
기능 기본적으로 넣어서 만드세요*/

public class Ex07_Cinema {
	static Scanner sc = new Scanner(System.in);
	static String[][] seat;
	static String[][] seatWithCustomerName;
	static String customerName;

	public Ex07_Cinema() {

		seat = new String[3][5];
		seatWithCustomerName = new String[3][5];

		// 좌석 리셋
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = (i + 1) + "-" + (j + 1);
			}
		}

		// 좌석 고객명 리셋
		for (int i = 0; i < seatWithCustomerName.length; i++) {
			for (int j = 0; j < seatWithCustomerName[i].length; j++) {
				seatWithCustomerName[i][j] = "";
			}
		}

	}

	// 초기 메뉴

	int displayMenu() {
		System.out.println();
		System.out.println("**********************");
		System.out.println("*****영화 예매 시스템*****");
		System.out.println("**********************");
		System.out.println("1. 예매하기");
		System.out.println();
		System.out.println("2. 예매조회");
		System.out.println();
		System.out.println("3. 예매취소");
		System.out.println();

		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 3) {
					break;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("1~3번의 메뉴 중 하나를 선택하세요");
			}
		} while (true);
		return menu;
	}

	// 좌석정보 보여주기
	void showSeat() {
		System.out.println("*********좌석 현황**********");
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				System.out.printf("[%s]", seatWithCustomerName[i][j].equals("") ? (i + 1) + "-" + (j + 1) : "예매");
			}
			System.out.println();

		}
		System.out.println("-------------------------");
	}

	void nameInput() {

		System.out.println("예매를 위해 고객명을 입력해주세요. 예)홍길동");
		customerName = sc.nextLine();
	}

	void reservation() {
		int row = 0;
		int col = 0;
		outer: while (true) {

			nameInput();

			// 좌석 선택하기
			while (true) {
				String input;
				outer4: do {
					try {
						showSeat();
						System.out.println("좌석을 선택해주세요. 예)1-1");
						System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
						input = sc.nextLine();
						String[] inputArray = input.split("-");
						row = (Integer.parseInt(inputArray[0])) - 1;
						col = (Integer.parseInt(inputArray[1])) - 1;

						for (int i = 0; i < seat.length; i++) {
							for (int j = 0; j < seat[i].length; j++) {

								if (seat[i][j].contentEquals(input)) {
									break outer4;
								} else if (seat[i][j].contentEquals("예매")) {
									break outer4;
								}

							}
						}
						throw new Exception("입력 오류");

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("좌석 입력 형식이 잘못되었습니다.");
					}
				} while (true);

				if (!seat[row][col].contentEquals("예매")) {
					System.out.println("예약 가능합니다. 예약하시겠습니까?");

					outer2: do {
						System.out.println("네(1), 아니오(2)중 하나를 입력해주세요.");
						int choice = 0;
						choice = Integer.parseInt(sc.nextLine());
						try {
							if (choice == 1 || choice == 2) {
								if (choice == 1) {
									seat[row][col] = "예매";
									seatWithCustomerName[row][col] = customerName;
									System.out.println();
									System.out.printf("예약이 완료되었습니다. %s고객님이 선택하신 좌석은 %s입니다. 감사합니다.\n\n", customerName,
											input);
									break outer;
								} else {

									break outer2;
								}

							} else
								throw new Exception("잘못 입력하였습니다. 다시 입력해 주세요.");

						} catch (Exception e) {
							System.out.println(e.getMessage());

						}
					} while (true);

				} else {
					System.out.println();
					System.out.println("이미 예약된 좌석입니다");
				}
			}
		}

	}

	boolean reservationInquiry() {
		do {
			System.out.println("예약하실 때 사용한 이름을 입력해주세요. 예)홍길동");
			customerName = sc.nextLine();
			if (customerName.contentEquals("")) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				for (int i = 0; i < seat.length; i++) {
					for (int j = 0; j < seat[i].length; j++) {
						if (seatWithCustomerName[i][j].contentEquals(customerName)) {
							System.out.println();
							System.out.printf("%s님이 예매하신 좌석은 %s입니다.\n\n", seatWithCustomerName[i][j],
									(i + 1) + "-" + (j + 1));
							return true;
						}
					}
				}
				System.out.println();
				System.out.println("고객 이름과 일치하는 예매자명이 없습니다.");
				return false;
			}
		} while (true);
	}

	void canclation() {
		if (reservationInquiry()) {
			System.out.println("예매를 취소하시겠습니까?");
			outer2: do {
				System.out.println("네(1), 아니오(2)중 하나를 입력해주세요.");

				int choice = 0;
				choice = Integer.parseInt(sc.nextLine());
				try {
					if (choice == 1 || choice == 2) {
						if (choice == 1) {

							outer3: for (int i = 0; i < seat.length; i++) {
								for (int j = 0; j < seat[i].length; j++) {
									if (seatWithCustomerName[i][j].contentEquals(customerName)) {
										seatWithCustomerName[i][j] = "";
										seat[i][j] = (i + 1) + "-" + (j + 1);
										break outer3;
									}
								}

							}

							System.out.printf("예약이 취소되었습니다. 감사합니다.\n\n");
							break;
						} else {

							break outer2;
						}

					} else
						throw new Exception("잘못 입력하였습니다. 다시 입력해 주세요.");

				} catch (Exception e) {
					System.out.println(e.getMessage());

				}
			} while (true);
		}
	}

	public static void main(String[] args) {

		Ex07_Cinema cinema = new Ex07_Cinema();

		while (true) {
			switch (cinema.displayMenu()) {
			case 1: {
				cinema.reservation();
				break;
			}
			case 2: {
				cinema.reservationInquiry();
				break;
			}
			case 3: {
				cinema.canclation();
				break;
			}

			}

		}

	}

}
