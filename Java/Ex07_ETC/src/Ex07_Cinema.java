import java.util.Scanner;

/*영화관 관리 프로그램
예약
취소
조회
기능 기본적으로 넣어서 만드세요*/

public class Ex07_Cinema {

    static String[][] seat;
    static String[][] customerSeat;
    static Scanner sc = new Scanner(System.in);

    public Ex07_Cinema() {

        seat = new String[3][5];
        customerSeat = new String[3][5];

        // 좌석 리셋
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                seat[i][j] = (i + 1) + "-" + (j + 1);
            }
        }
        
        // 좌석 고객명 리셋
        for (int i = 0; i < customerSeat.length; i++) {
            for (int j = 0; j < customerSeat[i].length; j++) {
                customerSeat[i][j] = "";
            }
        }

    }

    // 초기 메뉴

    int displayMenu() {
        System.out.println("****************");
        System.out.println("****영화관 메뉴*****");
        System.out.println("1. 예약");
        System.out.println();
        System.out.println("2. 예약조회");
        System.out.println();
        System.out.println("3. 예약취소");
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

    void reservation() {

   

        // 좌석정보 보여주기
       outer: while (true) {
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    System.out.printf("[%s]",
                            seat[i][j].equals((i + 1) + "-" + (j + 1)) ? (i + 1) + "-" + (j + 1) : "예매");
                }
                System.out.println();
            }

            // 좌석 선택하기
            String customerName = "";
            String customerSeatInput = "";
            int row, col;
            row = 0;
            col = 0;
            int i = 0;
            int j = 0;
            System.out.println("이름을 입력해주세요. 예)홍길동");
            customerName = sc.nextLine();

            while (true) {
                System.out.println("좌석을 선택해주세요. 예)1-1");

                customerSeatInput = sc.nextLine();
                row = (customerSeatInput.charAt(0) - '0') - 1;
                col = (customerSeatInput.charAt(2) - '0') - 1;

                if (seat[row][col].equals(customerSeatInput.charAt(0) + "-" + customerSeatInput.charAt(2))) {
                    System.out.println("예약 가능합니다. 예약하시겠습니까?");

                    outer2: do {
                        System.out.println("네(1), 아니오(2)를 입력해주세요.");
                        int choice = 0;
                        choice = Integer.parseInt(sc.nextLine());
                        try {
                            if (choice == 1 || choice == 2) {
                                if (choice == 1) {
                                    seat[row][col] = customerSeatInput;
                                    customerSeat[row][col] = customerName;

                                    System.out.printf(
                                            "예약이 완료되었습니다. %s고객님이 선택하신 좌석은 %s입니다. 감사합니다.\n",customerName,seat[i][j]);
                                    break outer;
                                } else {

                                    break outer2;
                                }

                            } else
                                throw new Exception("자릿수를 잘못 입력하였습니다. 다시 입력해 주세요.");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }
                    } while (true);

                } else {
                    System.out.println("이미 예약 되었습니다");
                }
            }
        }

    }

    void canclation() {
        String str = "";
        System.out.println("예약하실 때 사용한 이름을 입력해주세요. 예)홍길동");
        str = sc.nextLine();

     outer3:   for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (customerSeat[i][j].contentEquals(str)) {
                    System.out.printf("%s님이 예약하신 좌석은 %s입니다.", customerSeat[i][j], seat[i][j]);
                    break outer3;
                }else {
                    System.out.println("고객 이름과 일치하는 좌석이 없습니다.");
                    break;
                }
            }

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
                cinema.canclation();
                break;
            }
            case 3: {
                cinema.canclation();
                break;
            }
            case 4: {
                System.out.println("프로그램 종료");
                System.exit(0);
            }
            }

            // 좌석초기화
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    seat[i][j] = (i + 1) + "-" + (j + 1);
                }
            }
        }

    }

}
