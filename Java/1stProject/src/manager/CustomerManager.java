package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import entity.*;
import main.Mall;
import user.*;

public class CustomerManager implements Manager, Serializable {

	public static HashMap<String, User> customerList = new HashMap<String, User>();

	static Scanner sc = new Scanner(System.in);

	// È¸¿ø °¡ÀÔ
	public Customer signUp() {
		System.out.println("È¸¿ø °¡ÀÔ");
		String id, pwd, name, tel, address;

		// ID ÀÔ·Â
		while (true) {
			System.out.println("ID¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. (5~20ÀÚ. ¿µ¾î ´ë¼Ò¹®ÀÚ, ¼ıÀÚ, _ ¸¸ »ç¿ë°¡´É)");
			System.out.print(">>");
			String regExpaa = "^[a-zA-Z0-9_]{5,20}+$";
			id = sc.nextLine();
			Mall.setId(id);
			boolean b = id.matches(regExpaa); // true ,false

			if (b == true) {
				if (CustomerManager.customerList.containsKey(id)) {
					System.out.println("ÀÌ¹Ì Á¸ÀçÇÏ´Â IDÀÔ´Ï´Ù.");
				} else {
					break;
				}

			} else {
				System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}

		// ºñ¹Ğ¹øÈ£ ÀÔ·Â
		while (true) {
			System.out.println("ºñ¹Ğ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. (8~20ÀÚ.Àû¾îµµ ÇÏ³ªÀÇ ¿µ¾î´ë¹®ÀÚ ¼Ò¹®ÀÚ,¼ıÀÚ,Æ¯¼ö¹®ÀÚ°¡ °¢°¢ Æ÷ÇÔµÇ¾î¾ß ÇÔ)");
			System.out.print(">>");
			String regExp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$";
			;

			pwd = sc.nextLine();

			boolean b = pwd.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}
		// ÀÌ¸§ ÀÔ·Â
		while (true) {
			// ID ÀÔ·Â
			System.out.println("ÀÌ¸§À» ÀÔ·ÂÇØÁÖ¼¼¿ä. (ÇÑ±Û¸¸ »ç¿ë°¡´É)");
			System.out.print(">>");
			String regExp = "^[¤¡-¤¾°¡-ÆR]+$";

			name = sc.nextLine();

			boolean b = name.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}

		// ÈŞ´ëÆù ¹øÈ£ ÀÔ·Â
		while (true) {
			// ID ÀÔ·Â
			System.out.println("ÈŞ´ëÆù ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. ex) 010-123(4)-1234)");
			System.out.print(">>");
			String regExp = "(01[01679]{1})-(\\d{3,4})-(\\d{4})";

			tel = sc.nextLine();

			boolean b = tel.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			}
		}

		// ¹è¼ÛÁö ÁÖ¼Ò ÀÔ·Â
		System.out.println("¹è¼ÛÁö ÁÖ¼Ò¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");
		System.out.print(">>");
		address = sc.nextLine();

		Customer customer = new Customer(id, pwd, name, tel, address);
		customer.setId(id);
		customer.setPwd(pwd);
		customer.setName(name);
		customer.setTel(tel);
		customer.setAddress(address);

		customerList.put(id, customer);
		save();
		// °¡ÀÔ °í°´ Ä«Æ® »ı¼º
		CartManager cartManager = new CartManager();
		cartManager.cartList.put(id, new Cart());
		cartManager.save();

		// °¡ÀÔ °í°´ °Å·¡³»¿ª ¹è¿­ »ı¼º
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.transactionList.put(id, new ArrayList<Transaction>());
		transactionManager.save();
		return customer;
	}

	public Customer signIn(String id, String pwd) {

		if (customerList.containsKey(id) && ((customerList.get(id).getPwd()).equals(pwd))) {

			System.out.println("·Î±×ÀÎ ¼º°ø");
			Mall.setId(id);
			return (Customer) customerList.get(id);
		} else {
			System.out.println("·Î±×ÀÎ ½ÇÆĞ");
			return null;
		}
	}

	// °ü¸®ÀÚ ¸Ş´º >> È¸¿ø Á¤º¸ Á¶È¸
	public void userList() {
		System.out.println("**È¸¿ø ¸ñ·Ï Á¶È¸**");

		Set<String> set = customerList.keySet();
		ArrayList<String> arraySet = new ArrayList<String>(set);
		Collections.sort(arraySet);
		System.out.println("==========================Vip°í°´¸í´Ü==========================");
		System.out.println("       ID    Password    ¼ºÇÔ           ÈŞ´ëÆù ¹øÈ£                     ¹è¼ÛÁö");

		for (String c : arraySet) {
			if (c.equals("admin")) {
				continue;
			}
			Customer user = (Customer) (customerList.get(c));
			System.out.printf("%10s %10s %5s %15s %17s", user.getId(), user.getPwd(), user.getName(), user.getTel(),
					user.getAddress());
			System.out.println();
		}
	}

	// ¸¶ÀÌÆäÀÌÁö >> ³» Á¤º¸ Á¶È¸
	public void MyInfo() {
		System.out.println("**³» Á¤º¸ Á¶È¸**");
		do {
			try {
				System.out.println("ºñ¹Ğ¹øÈ£¸¦ ÀÔ·ÂÇÏ½Ê½Ã¿À");
				System.out.print(">>");
				String password = sc.nextLine();
				if (customerList.get(Mall.getId()).getPwd().equals(password)) {
					Customer my = (Customer) customerList.get(Mall.getId()); // (user)Å¸ÀÔÀ¸·Î ÀÖ´Â value°ª ´Ù¿îÄ³½ºÆÃÇÊ¿ä.
					System.out.printf("[ÀÌ¸§ : %s]\n[¾ÆÀÌµğ : %s]\n[ºñ¹Ğ¹øÈ£ : %s]\n[ÀüÈ­¹øÈ£ : %s]\n[ÁÖ¼Ò : %s]\n", my.getName(),
							my.getId(), my.getPwd(), my.getTel(), my.getAddress());
					break;
				} else {
					throw new Exception("");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<ÀÔ·Â ¿À·ù>");
				System.out.println("ºñ¹Ğ¹øÈ£¸¦ Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇÏ½Ê½Ã¿À.");

			}
		} while (true);
	}

	public String toString() {
		return null;
	}

	@Override
	public void add() {
	}

	@Override
	public void remove() {
	}

	// I/O¸¦ À§ÇÑ Á÷·ÄÈ­ ÀúÀå
	public void save() {
		File file = new File("CustomerDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // Á÷·ÄÈ­ ÀúÀåÀ» À§ÇÑ º¸Á¶½ºÆ®¸²

			oos.writeObject(customerList);
			// writeObject ¸Ş¼­µå¸¦ ÀÌ¿ëÇØ¼­ Á÷·ÄÈ­ ÀúÀå
			oos.close();
			bos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("¿¡·¯¹ß»ı!!!");
			e.printStackTrace();
		}
	}

	// I/O¸¦ À§ÇÑ ¿ªÁ÷·ÄÈ­ ·Îµå
	public void load() {
		File file = new File("CustomerDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream oos = new ObjectInputStream(bis); // ¿ªÁ÷·ÄÈ­¸¦ À§ÇÑ º¸Á¶½ºÆ®¸²

			customerList = (HashMap) oos.readObject(); // readObject¸Ş¼­µå¸¦ ÀÌ¿ëÇØ¼­ ¿ªÁ÷·ÄÈ­
			// ¸®ÅÏ°ªÀÌ ObjectÀÌ¹Ç·Î ´Ù¿îÄ³½ºÆÃ

			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("ºÒ·¯¿À´Âµ¥ ½ÇÆĞÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

}