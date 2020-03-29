package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import entity.Transaction;
import main.Mall;

public class TransactionManager implements Manager {

	public static HashMap<String, ArrayList<Transaction>> transactionList = new HashMap<String, ArrayList<Transaction>>();

	static Scanner sc = new Scanner(System.in);

	// 전체 회원 주문 내역 조회
	public void userTransactionList() {
		Set<String> set = CustomerManager.customerList.keySet();
		ArrayList<String> arraySet = new ArrayList<String>(set);
		Collections.sort(arraySet);
		for (String c : arraySet) {
			if (transactionList.get(c) == null) {
				if (c.equals("admin")) {
					continue;
				}else {
				System.out.println("회원 " + c + " 님은 구매내역이 없습니다.");
				}
			} else
				userTransactionHistory(c);
		}
	}

	// 특정 회원 주문 내역 조회
	public void userTransactionHistory(String userId) {
		if (CustomerManager.customerList.containsKey(userId)) {
			if (transactionList.get(userId) == null) {
				System.out.println(userId + " 회원님은 거래내역이 없습니다.");
				return;
			} else {
				System.out.println(userId + " 님의 거래내역 입니다.");
				System.out.println("--상품명----상품가격----수량----주문자성함-------거래일시-------");
				ArrayList list = transactionList.get(userId);
				for (Object e : list) {
					System.out.println(e);
				}
			}
		} else {
			System.out.println("일치하는 회원이 없습니다.");
		}
	}

	// 내 주문 내역 조회
	public void myTransactiontHistory() {
		System.out.println("**주문 내역**");
		String id = Mall.getId();

		if (transactionList.get(id) == null || transactionList.get(id).isEmpty()) {
			System.out.println("주문 내역이 없습니다.");
		} else {
			System.out.println("--상품명--상품가격--수량----주문자성함-------거래일시-------");
			for (Object o : transactionList.get(id)) {
				System.out.println(o);
			}
		}
	}

	@Override
	public void add() {

	}

	@Override
	public void remove() {
	}

	@Override
	public String toString() {
		return "TransactionManager [transactionList=" + transactionList + "]";
	}

	// I/O를 위한 직렬화 저장
	public void save() {
		File file = new File("TransactionDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

			oos.writeObject(transactionList);
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
		File file = new File("TransactionDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis); // 역직렬화를 위한 보조스트림

			transactionList = (HashMap) ois.readObject(); // readObject메서드를 이용해서 역직렬화

			ois.close();
			bis.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}
}
