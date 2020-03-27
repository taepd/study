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

class CartManager implements Manager, Serializable {
    static Scanner sc = new Scanner(System.in);
    HashMap<String, Cart> cartList = new HashMap<String, Cart>();
    
    
    ProductsManager productsManager = new ProductsManager();
    TransactionManager transactionManager = new TransactionManager();
    static int i;

    // 장바구니에 상품 추가
    public void add() {
        String id = Mall.id;  
        int pnumber;


        while (true) {
            System.out.println("추가할 상품 번호를 입력해 주세요.");
            System.out.printf("        ");
            pnumber = Integer.parseInt(sc.nextLine()); // 상품번호 입력
            if (!ProductsManager.productList.containsKey(pnumber)) {
                System.out.println("존재하지 않는 상품 번호입니다. 다시 선택해 주세요.");
            } else
                break;
        }
        
        

        Product p = ProductsManager.productList.get(pnumber); // 입력한 상품 호출
        if (p.getQuantity() < 1) {
            System.out.println("상품이 매진되어 구매할 수 없습니다.");

            return;
        }
        System.out.println(p.getPname() + "상품을 구매합니다.");
        System.out.println();
        int quantity;
        while (true) {
            System.out.println("구매할 수량을 입력해 주세요");
            System.out.printf("         ");
            quantity = Integer.parseInt(sc.nextLine());
            if (p.getQuantity() < quantity) {
                System.out.println("상품의 수량이 부족하여 구매할 수 없습니다.");

            } else
                break;

        }

        Set<Product> set = cartList.get(id).cartArray.keySet(); // 그 카트에 카트어레이의 프로덕트를 줄세움.

        if (set.isEmpty()) { // 카트가 비었으면,
            cartList.get(id).cartArray.put(p, quantity); // 고객 카트에 상품 추가
        } else { // 카트에 상품이 좀 있었던거면,
            outer: while (true) {
                for (Product s : set) { // 카트어레이의 프로덕트모두에게,
                    if (s.getPname().equals(p.getPname())) { // 검사해서, 이름이 일치하는상품이 있으면,
                        cartList.get(id).cartArray.replace(s, cartList.get(id).cartArray.get(s) + quantity);
                        break outer;
                    }
                }
                i = quantity;
                cartList.get(id).cartArray.put(p, quantity); // 해당카트의, 프로덕트 p랑 수량을 추가한다.
                break;
            }
        }

        Product p2 = (Product) p;
        p2.setQuantity(p2.getQuantity() - quantity);

        cartList.get(id).totalprice += p.getPrice() * quantity;
        productsManager.save();
        save();
        cartList.get(id).show();

        System.out.println("장바구니에 상품이 추가되었습니다.");

    }
    //장바구니 비우기
    public void remove() { 
        String id = Mall.id;
        System.out.println(id);

        cartList.get(id).cartArray.clear();
        cartList.get(id).totalprice = 0;
        System.out.println("장바구니를 비웠습니다.");
        save();

    }
    
    //장바구니에 담긴 물건 사기
    public void buy() {
        
        //결제 방식 선택
        while(true) {
        System.out.println("결제 방식을 선택해 주세요   1. 카드 결제   2. 계좌 이체");
        String choice = sc.nextLine();
        if(choice.equals("1")) {
            System.out.println("카드로 결제합니다.");
            System.out.println("결제가 완료되었습니다.");
            break;
        }else if(choice.equals("2")) {
            System.out.println("계좌 이체로 결제합니다.");
            System.out.println("계좌 이체 확인.");
            System.out.println("결제가 완료되었습니다.");
            break;
        }else {
            System.out.println("잘못 입력하였습니다.");
        }
        }
        
        
        String id = Mall.id;
        Customer customer = (Customer) CustomerManager.customerList.get(id);
        System.out.println(customer);

        Set<Product> set = cartList.get(id).cartArray.keySet();

        if (set.isEmpty()) {
            System.out.println("장바구니가 비었습니다.");
        } else {

            // 구매내역 생성
            for (Product p : set) {

                Transaction t = new Transaction(customer.getId(), p.getPname(), p.getPrice(),
                        cartList.get(id).cartArray.get(p));
                customer.transactionArray.add(t);
                TransactionManager.transactionList.put(id, customer.transactionArray);
                System.out.print(p.getPname() + ", ");
            }
            transactionManager.save();
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