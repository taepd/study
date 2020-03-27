import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class CartManager implements Manager {
	static Scanner sc = new Scanner(System.in);
	HashMap<String, Cart> cartList = new HashMap<String, Cart>();
	ProductsManager productsManager = new ProductsManager();
	TransactionManager transactionManager = new TransactionManager();
	static int i;

	// 장바구니에 상품 추가
	public void add() {

		String id = Mall.id;
		// 카트가 자꾸 재생성됨 if문 추가해야 함

		if (!cartList.containsKey(id)) {

			cartList.put(id, new Cart()); // user의 id마다, 새로운 카트 생성.
		}

		System.out.println("추가할 상품 번호를 입력해 주세요.");
		int pnumber = Integer.parseInt(sc.nextLine()); // 상품번호 입력

		Product p = ProductsManager.productList.get(pnumber); // 입력한 상품 호출
		System.out.println(p.toString());

		Set<Product> set = cartList.get(id).cartArray.keySet();

		if (set.isEmpty()) {
			i = 1;
			cartList.get(id).cartArray.put(p, i); // 고객 카트에 상품 추가
		} else {
			outer: while (true) {
				for (Product s : set) {
					if (s.getPname().equals(p.getPname())) {

						cartList.get(id).cartArray.replace(s, cartList.get(id).cartArray.get(s) + 1);
						break outer;
					}

				}
				i = 1;
				cartList.get(id).cartArray.put(p, i);
				break;
			}
		}

		Product p2 = (Product) p;
		p2.setQuantity(p2.getQuantity() - 1); // 상품 수량 -1

		cartList.get(id).totalprice += p.getPrice();
		productsManager.save();
		save();
		cartList.get(id).show();

		System.out.println("장바구니에 상품이 추가되었습니다.");

	}

	public void remove() { // 회원이 카트 자체를 삭제하는 일은 없으니 remove는 없음...
		String id = Mall.id;
		System.out.println(id);

		cartList.get(id).cartArray.clear();
		cartList.get(id).totalprice = 0;
		System.out.println("장바구니를 비웠습니다.");
		save();

	}

	public void buy() {
        String id = Mall.id;     
        Customer customer = (Customer)CustomerManager.customerList.get(id);
        System.out.println(customer);
        

        Set<Product> set = cartList.get(id).cartArray.keySet();
        

		if (set.isEmpty()) {
			System.out.println("장바구니가 비었습니다.");
		}else {

        for(Product p : set) {
          
            
            
            Transaction t = new Transaction(customer.getId(),p.getPname(), p.getPrice(), cartList.get(id).cartArray.get(p));      
            customer.transactionArray.add(t);
            
            
            TransactionManager.transactionList.put(id, customer.transactionArray);
           
        
            
            
            System.out.print(p.getPname()+", ");
            
            
            
        }transactionManager.save();
        System.out.println("을 구매하셨습니다.");
        remove();
		}
       
	}

//	public void show() {
//		cartList.get(CustomerManager.id).show();
//	}

	// I/O를 위한 직렬화 저장
	public void save() {
		File file = new File("CartDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

			oos.writeObject(cartList);
			// writeObject 메서드를 이용해서 직렬화 저장
			oos.close();
			bos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
		System.out.println("저장되었습니다.");
	}

	// I/O를 위한 역직렬화 로드
	public void load() {
		File file = new File("CartDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis); // 역직렬화를 위한 보조스트림

			cartList = (HashMap) ois.readObject(); // readObject메서드를 이용해서 역직렬화
													// 리턴값이 Object이므로 다운캐스팅

			ois.close();
			bis.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}

}