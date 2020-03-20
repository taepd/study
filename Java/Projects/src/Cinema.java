import java.util.Scanner;

/*영화관 관리 프로그램
예약
취소
조회
기능 기본적으로 넣어서 만드세요*/

public class Cinema {

    private static String[][] seatArr; // 좌석 배열. 공석일 땐 좌석명이, 예매된 자리일 땐 "예매"가 입력됨
    private static int[][] reservationNumberArr; // 예매번호 배열. 해당 자리가 예매가 되면 예매번호가 입력됨
    private String reservationNumber; // 예매번호 변수

    public Scanner sc;

    public Cinema() { // 기본 생성자 3행 5열 영화관 생성
        this(3, 5);
    }

    public Cinema(int row, int col) { // 행과 열을 매개변수로 갖는 생성자
        seatArr = new String[row][col];
        reservationNumberArr = new int[row][col];
        sc = new Scanner(System.in);

        // 좌석과 예매번호 초기화
        for (int i = 0; i < seatArr.length; i++) {
            for (int j = 0; j < seatArr[i].length; j++) {
                seatArr[i][j] = (i + 1) + "-" + (j + 1);
                reservationNumberArr[i][j] = 0;
            }
        }
    }

    // 프로그램 메인 구조

    void program() {
        while (true) {
            switch (this.displayMenu()) {
            case 1: {
                this.reservation();
                break;
            }
            case 2: {
                this.reservationInquiry();
                break;
            }
            case 3: {
                this.canclation();
                break;
            }
            case 4: {
                System.exit(0);
            }

            }

        }
    }

    // 초기 메뉴

    int displayMenu() {
        int menu = 0;
        do {
            try {
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
                System.out.println("4. 시스템 종료");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 4) {
                    return menu;
                } else {
                    throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<입력 오류>");
                System.out.println("1~3번의 메뉴 중 하나를 선택하세요");
            }
        } while (true);

    }

    // 좌석정보 보여주기
    void showseatArr() {
        System.out.println();
        System.out.println("*********좌석 현황**********");

        for (int i = 0; i < seatArr.length; i++) {
            for (int j = 0; j < seatArr[i].length; j++) {
                System.out.printf("[%s]", reservationNumberArr[i][j] == 0 ? (i + 1) + "-" + (j + 1) : "예매");
            }
            System.out.println();

        }
        System.out.println("-------------------------");
    }

    // 예매하기
    void reservation() {
        int row = 0;
        int col = 0;
        String inputseatArrNumber; // 사용자에게 좌석번호를 입력받는 변수

        while (true) {
            // 좌석 선택하기
            while (true) {

                // 예외처리
                outer1: do {
                    try {
                        showseatArr();
                        System.out.println("좌석을 선택해주세요. 예)1-1");
                        System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
                        inputseatArrNumber = sc.nextLine();
                        String[] inputArray = inputseatArrNumber.split("-"); // 입력받은 좌석값을 스플릿으로 잘라 배열을 만든다
                        row = (Integer.parseInt(inputArray[0])) - 1; // 배열 index값은 0부터 시작하므로 입력받은 좌석번호에서 1씩 빼준다
                        col = (Integer.parseInt(inputArray[1])) - 1;
                        // 개선된 for문 사용
                        for (String[] arr : seatArr) {
                            for (String str : arr) {
                                if (str.contentEquals(inputseatArrNumber)) { // 사용자 입력 좌석번호와 일치하는 좌석이 있으면 예외처리를 위한 do
                                                                             // while문 탈출
                                    break outer1;
                                } else if (str.contentEquals("예매")) { // 예매인 경우도 예외처리를 위한 do while문 탈출
                                    break outer1;
                                }
                            }
                        }
                        // 일반 for문 사용
//						for (int i = 0; i < seatArr.length; i++) {
//							for (int j = 0; j < seatArr[i].length; j++) {
//								if (seatArr[i][j].contentEquals(inputseatArrNumber)) {  //사용자 입력 좌석번호와 일치하는 좌석이 있으면 예외처리를 위한 do while문 탈출
//									break outer2;
//								} else if (seatArr[i][j].contentEquals("예매")) {	//예매인 경우도 예외처리를 위한 do while문 탈출
//									break outer2;
//								}
//
//							}
//						}
                        throw new Exception("<입력 가능한 범위 초과>");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("좌석 입력 형식이 잘못되었습니다. 다시 입력해주세요.");
                        System.out.println();
                    }
                } while (true);

                // 예외처리를 정상통과한 요청에 대해 예매 진행
                if (!seatArr[row][col].contentEquals("예매")) { // 좌석이 예매된 좌석인지 아닌지 검사
                    System.out.println("예매 가능합니다. 예매하시겠습니까?");
                    // 예매 진행에 대한 예외처리
                    outer2: do {
                        System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");

                        try {
                            int choice = 0;
                            choice = Integer.parseInt(sc.nextLine());
                            if (choice == 1 || choice == 2 || choice == 0) { // 1, 2, 0 이외의 입력을 예외처리 해준다
                                if (choice == 1) {
                                    seatArr[row][col] = "예매";
                                    int hash = (int) ((Math.random() * 90000000) + 10000000); // 총 8자리 예매번호를 랜덤 생성
                                    for (int i = 0; i < seatArr.length; i++) {
                                        for (int j = 0; j < seatArr[i].length; j++) { // 예매번호 중복 제거
                                            if (reservationNumberArr[i][j] == hash) {
                                                hash = (int) ((Math.random() * 90000000) + 10000000);
                                                i = -1;
                                                break;
                                            }
                                        }
                                    }
                                    reservationNumberArr[row][col] = hash;
                                    System.out.println();
                                    System.out.printf("예매가 완료되었습니다.\n예매한 좌석번호:[%s]/ 예매번호:[%s]\n감사합니다.\n",
                                            inputseatArrNumber, reservationNumberArr[row][col]);
                                    return;
                                } else if (choice == 0) {
                                    return;
                                } else {
                                    break outer2;
                                }
                            } else
                                throw new Exception("<입력 범위 초과>");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("잘못 입력하였습니다. 다시 입력해 주세요.");

                        }
                    } while (true);

                } else { // 예매된 좌석인 경우
                    System.out.println();
                    System.out.println("이미 예매된 좌석입니다");
                }
            }
        }
    }

    // 예매 조회
    boolean reservationInquiry() {
        // 예외처리
        do {
            try {
                System.out.println("예매번호를 입력해주세요.");
                reservationNumber = sc.nextLine();
                if (reservationNumber.contentEquals("")) {
                    System.out.println("잘못 입력하셨습니다.");
                } else {
                    for (int i = 0; i < seatArr.length; i++) {
                        for (int j = 0; j < seatArr[i].length; j++) {
                            if (reservationNumberArr[i][j] == Integer.parseInt(reservationNumber)) {
                                System.out.println();
                                // 예매된 좌석엔 이미 "예매"라 입력되어 있으므로 i,j를 활용해서 예매좌석을 알려준다
                                System.out.printf("고객님이 예매하신 좌석은 %s입니다.\n\n", (i + 1) + "-" + (j + 1));
                                return true;
                            }
                        }
                    }
                    System.out.println();
                    System.out.println("일치하는 예매번호가 없습니다.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("잘못 입력하였습니다. 다시 입력해 주세요.");
            }
        } while (true);
    }

    // 예매 취소
    void canclation() {
        if (reservationInquiry()) {
            System.out.println("예매를 취소하시겠습니까?");
            // 예외처리
            do {
                System.out.println("네(1), 아니오(2)중 하나를 입력해주세요.");

                int choice = 0;
                choice = Integer.parseInt(sc.nextLine());
                try {
                    if (choice == 1 || choice == 2) {
                        if (choice == 1) {

                            outer: for (int i = 0; i < seatArr.length; i++) {
                                for (int j = 0; j < seatArr[i].length; j++) {
                                    if (reservationNumberArr[i][j] == Integer.parseInt(reservationNumber)) {
                                        reservationNumberArr[i][j] = 0; // 좌석의 예매번호를 초기화
                                        seatArr[i][j] = (i + 1) + "-" + (j + 1); // 좌석의 이름을 초기화
                                        break outer;
                                    }
                                }
                            }
                            System.out.printf("예매가 취소되었습니다. 감사합니다.\n\n");
                            break;
                        } else {
                            return;
                        }
                    } else
                        throw new Exception("<입력 범위 초과>");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("잘못 입력하였습니다. 다시 입력해 주세요.");
                    System.out.println();
                }
            } while (true);
        }
    }

    public static void main(String[] args) {

        Cinema cinema = new Cinema(4, 5); // 오버로딩 생성자를 이용해 영화관 좌석을 커스텀할 수 있다

        cinema.program();

    }

}
