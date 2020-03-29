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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entity.*;
import main.*;
import user.Customer;

public class CartManager implements Manager {
   
    public static HashMap<String, Cart> cartList = new HashMap<String, Cart>();
    
    static Scanner sc = new Scanner(System.in);
        
    
    
    // 장바구니에 상품 추가
    public void add() {
		System.out.println("장바구니에 상품 추가");
    	String id = Mall.getId();
        int pnumber;
        while (true) {
        	System.out.println("추가할 상품 번호를 입력해 주세요. (이전메뉴로: \"이전\")");
        	System.out.print(">>");
            try {				
            	String enter =sc.nextLine();
            	if(enter.equals("이전")){
            		return;
            	}
            	pnumber = Integer.parseInt(enter);
            if (!ProductsManager.productList.containsKey(pnumber)) {
                System.out.println("존재하지 않는 상품 번호입니다. 다시 선택해 주세요.");
            } else
                break;
            } catch (Exception e) {
            	
            	System.out.println("잘못 입력하였습니다.상품 번호를 입력해주세요.");
            }
        }
       
        
        Product p = ProductsManager.productList.get(pnumber); // 입력한 상품 호출
        if (p.getQuantity() < 1) {
            System.out.println("상품이 품절되어 구매할 수 없습니다.");

            return;
        }
        System.out.println(p.getPname() + "을(를) 구매합니다.");
        System.out.println();
        
        int quantity;
        while (true) {
            System.out.println("구매할 수량을 입력해 주세요");
        	System.out.print(">>");
            quantity = Integer.parseInt(sc.nextLine());
            if (p.getQuantity() < quantity) {
                System.out.println("상품의 수량이 부족하여 구매할 수 없습니다.");

            } else
                break;

        }
        Set<Product> set = cartList.get(id).cartArray.keySet(); // 그 카트에 카트어레이의 프로덕트를 줄세움.
    
        if (set.isEmpty()) { // 카트가 비었으면,
            cartList.get(id).cartArray.put(p, quantity); // 고객 카트에 상품 추가
        }else { // 카트에 상품이 좀 있었던거면,
            outer: while (true) {
                for (Product s : set) { // 카트어레이의 프로덕트모두에게,
                    if (s.getPname().equals(p.getPname())) { // 검사해서, 이름이 일치하는상품이 있으면,
                        cartList.get(id).cartArray.replace(s, cartList.get(id).cartArray.get(s) + quantity);
                        break outer;
                    }
                }
                cartList.get(id).cartArray.put(p, quantity); // 해당카트의, 프로덕트 p랑 수량을 추가한다.
                break;
            }
        }
        cartList.get(id).totalprice += p.getPrice() * quantity;
        save();
        cartList.get(id).show();

        System.out.println("장바구니에 상품이 추가되었습니다.");

    }
    //장바구니 비우기
    public void remove() { 
		System.out.println("**장바구니 상품 삭제**");
    	String id = Mall.getId();
        //장바구니가 비었을 때 
        if(cartList.get(id).cartArray.isEmpty()) {
            System.out.println("장바구니가 비었습니다.");
            return;
        }
//        cartList.get(id).cartArray.key
        cartList.get(id).cartArray.clear();
        cartList.get(id).totalprice = 0;
        System.out.println("장바구니를 비웠습니다.");
        save();

    }
    
    //장바구니에 담긴 물건 사기
    public void buy() {
		System.out.println("**장바구니 상품 구매**");
        //장바구니가 비었을 때 
    	String id = Mall.getId();
        if(cartList.get(id).cartArray.isEmpty()) {
            System.out.println("장바구니가 비었습니다. 결제할 상품이 없습니다.");
            return;
        }
        
        //결제 방식 선택
        while(true) {
        System.out.println("결제 방식을 선택해 주세요   1. 카드 결제   2. 계좌 이체");
    	System.out.print(">>");
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
        
        
   
        ArrayList<Transaction> tArray = TransactionManager.transactionList.get(id);
        ProductsManager productsManager = new ProductsManager();
        // 구입한 만큼 상품 수량 조정
        Set<Product> set = cartList.get(id).cartArray.keySet(); // 그 카트에 카트어레이의 프로덕트를 줄세움.       
                for (Product s : set) { // 카트어레이의 프로덕트모두에게,
                	 Product p= ProductsManager.productList.get(s.getPnumber());  //장바구니의 상품번호와 일치하는 상품목록의 상품
                     p.setQuantity(p.getQuantity()-cartList.get(id).cartArray.get(s));  //p에서 장바구니 수량만큼 뺀다 	
                     productsManager.save();
                }
        
        
       
        Customer customer = (Customer) CustomerManager.customerList.get(id);
        // 구매내역 생성      
        if (set.isEmpty()) {
            System.out.println("장바구니가 비었습니다.");
        }else {    
            for (Product p : set) {
                Transaction t = new Transaction(customer.getName(), p.getPname(), p.getPrice(),
                        cartList.get(id).cartArray.get(p));
                tArray.add(t);
//                customer.transactionArray.add(t);  // 이 경로를 거치면 안된다. 저장된 경로를 따라 가야함
                TransactionManager.transactionList.put(id, tArray);
                System.out.print(p.getPname() +"을 "+t.getQuantity()+"개 ");            
            }         
            System.out.println("구매하셨습니다.");
            TransactionManager transactionManager = new TransactionManager();
            transactionManager.save();
            remove();
        }
    }


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