import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public class Mall {

    Scanner sc = new Scanner(System.in);
    CustomerManager customerManager = new CustomerManager();
    ProductsManager productsManager = new ProductsManager();
    Admin admin = new Admin();

    Mall() {

        File file = new File("CustomerDB.txt");
        File file2 = new File("ProductDB.txt");

        if (file.exists()) {
            customerManager.load();
        } else {
            // customerList 파일 생성
            try {
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

                customerManager.customerList.put(admin.getId(), admin);
                oos.writeObject(customerManager.customerList);
                // writeObject 메서드를 이용해서 직렬화 저장
                oos.close();
                bos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("에러발생!!!");
                e.printStackTrace();
            }
        }
        if (file2.exists()) {
            productsManager.load();
        } else {
            // productsArray 파일 생성
            try {
                FileOutputStream fos = new FileOutputStream(file2);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

                oos.writeObject(productsManager.productsArray);
                // writeObject 메서드를 이용해서 직렬화 저장
                oos.close();
                bos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("에러발생!!!");
                e.printStackTrace();
            }
        }

    }

    void program() {
        while (true) {
            switch (MainMenu()) {
            case 1: {
                this.loginProgram();

                break;
            }
            case 2: {
                this.signinProgram();
                break;
            }
            case 3: {
                System.exit(0);
            }

            }

        }
    }

    // 회원가입
    void signinProgram() {
        System.out.println("**회원 가입**");
        System.out.println("ID를 입력해주세요");
        String id = sc.nextLine();
        String pwd = id;
        String name = id;
        String tel = id;
        String address = id;
        customerManager.signUp(id, pwd, name, tel, address); // 만들어진 customer 객체를 리턴
        System.out.println(customerManager.customerList.toString());
    } // 회원가입 마치면 로그인 이후 화면으로 진입해야 한다

    // 로그인
    void loginProgram() {

        System.out.println("**로그인**");
        System.out.println("ID를 입력해주세요");
        String id = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        String pwd = sc.nextLine();
        if (admin.getId().equals(id) && admin.getPwd().equals(pwd)) {
            System.out.println("관리자 로그인");
            AdminProgram();

        } else if (customerManager.login(id, pwd) != null) {
            CustomerProgram();

        } else {
            System.out.println("일치하는 정보가 없습니다.");
        }
    }

    void CustomerProgram() {

        outer: while (true) {
            switch (this.CustomerMenu()) {
            case 1: {
                System.out.println("**상품조회**");
                productsManager.add();
                productsManager.productsList();
                break;
            }
            case 2: {
                System.out.println("**장바구니**");
                CartProgram();
                break;
            }
            case 3: {
                System.out.println("**마이페이지**");
                MyPageProgram();

                break;
            }

            case 4: {
                break outer; // return하면 해당하는 가장 상위 메서드 블럭 탈출
            }
            case 5: {
                System.exit(0);
            }

            }

        }

    }

    void AdminProgram() {

        outer: while (true) {
            switch (this.AdminMenu()) {
            case 1: {
                System.out.println("**상품 리스트 조회**");
                productsManager.productsList();

                break;
            }
            case 2: {
                System.out.println("**상품 추가**");
                System.out.println("상품명을 입력해주세요");
                String pname = sc.nextLine();
                System.out.println("상품번호를 입력해주세요");
                int pnumber = Integer.parseInt(sc.nextLine());
                System.out.println("상품 가격을 입력해주세요");
                int price = Integer.parseInt(sc.nextLine());
                System.out.println("상품 수량을 입력해주세요");
                int quantity = Integer.parseInt(sc.nextLine());
                System.out.println("상품 종류를 입력해주세요");
                String kind = sc.nextLine();
                productsManager.add(pname, pnumber, price, quantity, kind);
                break;
            }
            case 3: {
                System.out.println("**상품 삭제**");

                break;
            }
            case 4: {
                System.out.println("**상품 재고 변경**");

                break;
            }
            case 5: {
                System.out.println("**회원 리스트 조회**");

                break;
            }

            case 6: {
                break outer; // return하면 해당하는 가장 상위 메서드 블럭 탈출
            }
            case 7: {
                System.exit(0);
            }

            }

        }

    }

    void CartProgram() {

        outer: while (true) {
            switch (this.MyPageMenu()) {
            case 1: {
                System.out.println("**장바구니 리스트**");

                break;
            }
            case 2: {
                System.out.println("**상품 구매**");

                break;
            }
            case 3: {
                System.out.println("**상품 삭제**");
                break;
            }

            case 4: {
                break outer; // return하면 해당하는 가장 상위 메서드 블럭 탈출
            }
            case 5: {
                System.exit(0);
            }

            }

        }

    }

    void MyPageProgram() {

        outer: while (true) {
            switch (this.MyPageMenu()) {
            case 1: {
                System.out.println("**회원 정보 조회**");

                break;
            }
            case 2: {
                System.out.println("**주문 내역**");

                break;
            }
            case 3: {
                System.out.println("**장바구니**");
                break;
            }

            case 4: {
                break outer; // return하면 해당하는 가장 상위 메서드 블럭 탈출
            }
            case 5: {
                System.exit(0);
            }

            }

        }

    }

    // 초기 메뉴

    int MainMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("***************************");
                System.out.println("*******VIP 애플스토어*******");
                System.out.println("***************************");
                System.out.println("1. 로그인");
                System.out.println();
                System.out.println("2. 회원 가입");
                System.out.println();
                System.out.println("3. 시스템 종료");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 3) {
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

    // 고객 메뉴 화면
    int CustomerMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****로그인 메뉴*****");
                System.out.println("*********************************");
                System.out.println("1. 상품 리스트 조회");
                System.out.println();
                System.out.println("2. 장바구니");
                System.out.println();
                System.out.println("3. 마이페이지");
                System.out.println();
                System.out.println("4. 이전 메뉴로");
                System.out.println();
                System.out.println("5. 시스템 종료");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 5) {
                    return menu;
                } else {
                    throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<입력 오류>");
                System.out.println("1~5번의 메뉴 중 하나를 선택하세요");
            }
        } while (true);

    }

    // 관리자 메뉴 화면
    int AdminMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****로그인 메뉴*****");
                System.out.println("*********************************");
                System.out.println("1. 상품 리스트 조회");
                System.out.println();
                System.out.println("2. 상품 추가");
                System.out.println();
                System.out.println("3. 상품 삭제");
                System.out.println();
                System.out.println("4. 상품 재고 변경");
                System.out.println();
                System.out.println("5. 회원 정보 조회");
                System.out.println();
                System.out.println("6. 이전 메뉴로");
                System.out.println();
                System.out.println("7. 시스템 종료");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 7) {
                    return menu;
                } else {
                    throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<입력 오류>");
                System.out.println("1~5번의 메뉴 중 하나를 선택하세요");
            }
        } while (true);

    }

    // 마이페이지 메뉴 화면
    int MyPageMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****마이 페이지 메뉴*****");
                System.out.println("*********************************");
                System.out.println("1. 회원 정보 조회");
                System.out.println();
                System.out.println("2. 주문 내역");
                System.out.println();
                System.out.println("3. 장바구니");
                System.out.println();
                System.out.println("4. 이전 메뉴로");
                System.out.println();
                System.out.println("5. 시스템 종료");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 5) {
                    return menu;
                } else {
                    throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<입력 오류>");
                System.out.println("1~5번의 메뉴 중 하나를 선택하세요");
            }
        } while (true);

    }

    public static void main(String[] args) {

        Mall mall = new Mall();

        mall.program();

    }

}
