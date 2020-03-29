package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import entity.Product;

public class ProductsManager implements Manager {

	public static HashMap<Integer, Product> productList = new HashMap<Integer, Product>();// 상품products array

	static Scanner sc = new Scanner(System.in);

	@Override
	public String toString() {
		return "ProductsManager [productList=" + productList + "]";
	}

	// 상품내역 보여주기
	public void productList() {
		System.out.println("**상품 목록 조회**");
		Set<Integer> set = productList.keySet();
		System.out.println("----------VIP Product List-----------");
		System.out.println("    종류          상품명      상품번호          가격              수량");
		for (Integer num : set) {
			String name = productList.get(num).getPname();
			int price = productList.get(num).getPrice();
			String pFormat = String.format("%,d", price);
			int quantity = productList.get(num).getQuantity();
			String qFormat = String.format("%,d", quantity);
			int number = productList.get(num).getPnumber();
			String kind = productList.get(num).getKind();
			System.out.printf("%5s %10s %7d %10s %5s", kind, name, number, pFormat, qFormat);
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}

	// 수량변경
	public void changeQuantity() {
		do {
			try {

				System.out.println("**상품 재고 변경**");
				productList();
				System.out.println("변경할 상품의 번호를 입력하십시오");
				System.out.print(">>");
				int pKey = Integer.parseInt(sc.nextLine());
				int quantity = 0;
				if (productList.containsKey(pKey)) {
					System.out.println("변경할 상품의 수량을 입력하십시오");
					System.out.print(">>");
					quantity = Integer.parseInt(sc.nextLine());
					productList.get(pKey).setQuantity(quantity);
				} else {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
				String qFormat = String.format("%,d", quantity);

				System.out.println(productList.get(pKey).getPname() + "의 수량을 " + qFormat + "으로 변경하였습니다.");
				save();
				productList();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력가능합니다.");
			}
		} while (true);
	}

	// 상품 추가
	public void add() {
		System.out.println("**상품 추가**");
		String pname;
		int pnumber, price, quantity;

		// 상품명 입력
		outer: while (true) {
			System.out.println("상품명을 입력해주세요.");
			System.out.print(">>");
			pname = sc.nextLine();
			Set<Integer> pset = productList.keySet();
			if (pset.isEmpty()) {
				break;
			}
			for (int p : pset) {
				if (productList.get(p).getPname().equals(pname)) {
					System.out.println("이미 존재하는 상품명입니다.");
				} else {
					break outer;
				}
			}
		}

		// 상품 번호 입력
		do {
			try {
				System.out.println("상품 번호를 입력해주세요.");
				System.out.print(">>");
				pnumber = Integer.parseInt(sc.nextLine());
				if (productList.containsKey(pnumber)) {
					System.out.println("이미 존재하는 상품 번호입니다.");
				} else if (pnumber < 1) {
					System.out.println("상품 번호는 양수만 가능합니다.");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("상품 번호는 숫자만 가능합니다.");
			}
		} while (true);

		// 상품 가격 입력
		do {
			try {
				System.out.println("상품 가격를 입력해주세요.");
				System.out.print(">>");
				price = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("상품 가격은 숫자만 가능합니다.");
			}
		} while (true);

		// 상품 수량 입력
		do {
			try {
				System.out.println("상품 수량을 입력해주세요.");
				System.out.print(">>");
				quantity = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("상품 수량은 숫자만 가능합니다.");
			}
		} while (true);

		// 상품 종류 입력
		System.out.println("상품 종류를 입력해주세요");
		System.out.print(">>");
		String kind = sc.nextLine();
		productList.put(pnumber, new Product(pname, pnumber, price, quantity, kind));
		save();
		productList();
		System.out.println("상품이 추가되었습니다.");
	}

	// 상품 삭제
	public void remove() {
		int pnumber;
		do {
			try {
				System.out.println("**상품 삭제**");
				productList();
				System.out.println("삭제할 상품번호를 입력해주세요");
				System.out.print(">>");
				pnumber = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("상품 번호는 숫자만 가능합니다.");
			}
		} while (true);
		if (productList.containsKey(pnumber)) {
			productList.remove(pnumber);
			productList();
			System.out.println("상품이 삭제되었습니다.");
			save();
		} else {
			System.out.println("일치하는 상품번호가 없습니다.");
		}
	}

	// I/O를 위한 직렬화 저장
	public void save() {
		File file = new File("ProductDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

			oos.writeObject(productList);
			// writeObject 메서드를 이용해서 직렬화 저장
			oos.close();
			bos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
	}

	// I/O를 위한 역직렬화 로드
	public void load() {
		File file = new File("ProductDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis); // 역직렬화를 위한 보조스트림

			productList = (HashMap) ois.readObject(); // readObject메서드를 이용해서 역직렬화

			ois.close();
			bis.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}
}
