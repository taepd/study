package main;

import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import user.*;
import manager.*;

public class Mall {

	Scanner sc = new Scanner(System.in);
	CustomerManager customerManager = new CustomerManager();
	ProductsManager productsManager = new ProductsManager();
	CartManager cartManager = new CartManager();
	TransactionManager transactionManager = new TransactionManager();
	Admin admin = new Admin();
	private static String id;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Mall.id = id;
	}

	Mall() {

		File file = new File("CustomerDB.txt");
		File file2 = new File("ProductDB.txt");
		File file3 = new File("CartDB.txt");
		File file4 = new File("TransactionDB.txt");

		if (file.exists()) {
			customerManager.load();
		} else {
			// customerList 파일 생성
			try {
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

				CustomerManager.customerList.put(admin.getId(), admin);
				oos.writeObject(CustomerManager.customerList);
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

				oos.writeObject(productsManager.productList);
				// writeObject 메서드를 이용해서 직렬화 저장
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e) {
				System.out.println("에러발생!!!");
				e.printStackTrace();
			}
		}

		if (file3.exists()) {
			cartManager.load();
		} else {
			// productsArray 파일 생성
			try {
				FileOutputStream fos = new FileOutputStream(file3);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

				oos.writeObject(cartManager.cartList);
				// writeObject 메서드를 이용해서 직렬화 저장
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e) {
				System.out.println("에러발생!!!");
				e.printStackTrace();
			}
		}

		if (file4.exists()) {
			transactionManager.load();
		} else {

			try {
				FileOutputStream fos = new FileOutputStream(file4);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

				oos.writeObject(transactionManager.transactionList);
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

	void mallMain() {
		while (true) {
			switch (mallMainMenu()) {
			case 1: {
				this.signIn();

				break;
			}
			case 2: {
				customerManager.signUp();
				break;
			}
			case 3: {
				System.exit(0);
			}

			}
		}
	}

	// 초기 메뉴
	int mallMainMenu() {
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

	// 로그인
	void signIn() {

		System.out.println("**로그인**");
		System.out.println("ID를 입력해주세요");
		System.out.print(">>");
		id = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		System.out.print(">>");
		String pwd = sc.nextLine();
		if (admin.getId().equals(id) && admin.getPwd().equals(pwd)) {
			System.out.println("관리자 로그인");
			admin();

		} else if (customerManager.signIn(id, pwd) != null) {
			customer();

		} else {
			System.out.println("일치하는 정보가 없습니다.");
		}
	}

	void customer() {

		while (true) {
			switch (this.customerMenu()) {
			case 1: {
				productsManager.productList();
				addCart();
				break;
			}
			case 2: {
				cart();
				break;
			}
			case 3: {
				myPage();
				break;
			}
			case 4: {
				return; // return하면 해당하는 가장 상위 메서드 블럭 탈출
			}
			case 5: {
				System.exit(0);
			}
			}
		}
	}

	// 고객 메뉴 화면
	int customerMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****고객 메뉴*****");
				System.out.println("*********************************");
				System.out.println("1. 상품 목록 조회");
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

	// 관리자 프로그램
	void admin() {

		while (true) {
			switch (this.adminMenu()) {
			case 1: {
				productsManager.productList();

				break;
			}
			case 2: {
				productsManager.add();
				break;
			}
			case 3: {
				productsManager.remove();
				break;
			}
			case 4: {
				productsManager.changeQuantity();
				break;
			}
			case 5: {
				customerManager.userList();
				break;
			}
			case 6: {
				lookup();
				break;
			}
			case 7: {
				return; // return하면 해당하는 가장 상위 메서드 블럭 탈출
			}
			case 8: {
				System.exit(0);
			}
			}
		}
	}

	// 관리자 메뉴 화면
	int adminMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("******     관리자 메뉴           ********");
				System.out.println("*********************************");
				System.out.println("1. 상품 목록 조회");
				System.out.println();
				System.out.println("2. 상품 추가");
				System.out.println();
				System.out.println("3. 상품 삭제");
				System.out.println();
				System.out.println("4. 상품 재고 변경");
				System.out.println();
				System.out.println("5. 회원 정보 조회");
				System.out.println();
				System.out.println("6. 판매 내역 조회");
				System.out.println();
				System.out.println("7. 이전 메뉴로");
				System.out.println();
				System.out.println("8. 시스템 종료");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 8) {
					return menu;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<입력 오류>");
				System.out.println("1~8번의 메뉴 중 하나를 선택하세요");
			}
		} while (true);

	}

	void lookup() {
		System.out.println("*판매 내역 조회");
		while (true) {
			switch (lookUpMenu()) {
			case 1: {
				transactionManager.userTransactionList();
				return;
			}
			case 2: {
				System.out.println("회원 아이디를 입력하세요.");
				System.out.print(">>");
				String userId = sc.nextLine();
				transactionManager.userTransactionHistory(userId);
			}
			case 3: {
				return; // return하면 해당하는 가장 상위 메서드 블럭 탈출
			}
			}
		}
	}

	int lookUpMenu() {
		int menu = 0;
		do {
			try {
				System.out.println("1. 모든 회원 구매 내역");
				System.out.println();
				System.out.println("2. 특정 회원 구매 내역");
				System.out.println();
				System.out.println("3. 이전 메뉴로");
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

	void addCart() {

		while (true) {
			switch (this.addCartMenu()) {
			case 1: {
				productsManager.productList();
				cartManager.add();
				break;
			}
			case 2: {
				cart();
				break;
			}
			case 3: {
				return; // return하면 해당하는 가장 상위 메서드 블럭 탈출
			}
			case 4: {
				System.exit(0);
			}

			}
		}

	}

	// 상품 조회 페이지 메뉴 화면
	int addCartMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("1. 장바구니에 상품 추가");
				System.out.println();
				System.out.println("2. 장바구니");
				System.out.println();
				System.out.println("3. 이전 메뉴로");
				System.out.println();
				System.out.println("4. 시스템 종료");
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 4) {
					return menu;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<입력 오류>");
				System.out.println("1~4번의 메뉴 중 하나를 선택하세요");
			}
		} while (true);

	}

	void cart() {
		System.out.println("**장바구니**");
		while (true) {

			cartManager.cartList.get(id).show();

			// 장바구니 보여주기
			switch (this.cartMenu()) {
			case 1: {
				cartManager.buy();
				break;
			}
			case 2: {
				cartManager.remove();
				break;
			}
			case 3: {
				return; // return하면 해당하는 가장 상위 메서드 블럭 탈출
			}
			case 4: {
				System.exit(0);
			}

			}
		}
	}

	// 카트 메뉴 화면
	int cartMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****장바구니 메뉴*****");
				System.out.println("*********************************");
				System.out.println("1. 장바구니 상품 구매");
				System.out.println();
				System.out.println("2. 장바구니 상품 삭제");
				System.out.println();
				System.out.println("3. 이전 메뉴로");
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
				System.out.println("1~4번의 메뉴 중 하나를 선택하세요");
			}
		} while (true);

	}

	void myPage() {
		System.out.println("**마이페이지**");
		while (true) {
			switch (this.myPageMenu()) {
			case 1: {
				customerManager.MyInfo();
				break;
			}
			case 2: {
				transactionManager.myTransactiontHistory();
				break;
			}
			case 3: {
				cart();

				break;
			}
			case 4: {
				return; // return하면 해당하는 가장 상위 메서드 블럭 탈출
			}
			case 5: {
				System.exit(0);
			}

			}

		}

	}

	// 마이페이지 메뉴 화면
	int myPageMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****마이 페이지 메뉴*****");
				System.out.println("*********************************");
				System.out.println("1. 내 정보 조회");
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

		mall.mallMain();

	}
}
