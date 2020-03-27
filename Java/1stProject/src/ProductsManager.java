import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ProductsManager implements Manager, Serializable{

    static HashMap<Integer, Product> productList = new HashMap<Integer, Product>();// 상품products array

    static Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return "ProductsManager [productList=" + productList + "]";
    }

    // 상품내역 보여주기
    public void productList() {

        Set<Integer> set = productList.keySet(); // 상품번호가 다 set에 저장되어 있고,
        System.out.println("----------VIP Product List-----------");
        System.out.println("    종류          상품명      상품번호      가격     수량");
        for (Integer num : set) {
            String name = productList.get(num).getPname();
            int price = productList.get(num).getPrice();
            int quantity = productList.get(num).getQuantity();
            int number = productList.get(num).getPnumber();
            String kind = productList.get(num).getKind();
            System.out.printf("%7s %10s %5d %7d %3d", kind, name, number, price, quantity);
            System.out.println();
        }
        System.out.println("-------------------------------------");

    }

    // 구매내역 ********user 클래스 필요*******
    public void buyHistory() {

    }

    // 구매자 정보불러오기 ******user 클래스 필요*****
    public void userInfo(Customer customer) {

        System.out.println("");
        System.out.println(customer.getName() + "회원님 안녕하세요 ^^");
        System.out.println("회원님의 아이디는: " + customer.getId() + " 입니다.");
        System.out.println("회원님의 비밀번호는: " + customer.getPwd() + " 입니다.");
        System.out.println("회원님의 휴대폰 번호는: " + customer.getTel() + " 입니다.");
        System.out.println("회원님의 주소는: " + customer.getAddress() + " 입니다.");
    }

    // 수량변경
    public void changeQuantity() {

        System.out.println("상품 재고 변경");
        productList();
        System.out.println("변경할 상품의 번호를 입력하십시오");
        int pKey = Integer.parseInt(sc.nextLine());
        int quantity = 0;
        if (productList.containsKey(pKey)) {
            System.out.println("변경할 상품의 수량을 입력하십시오");
            quantity = Integer.parseInt(sc.nextLine());
            productList.get(pKey).setQuantity(quantity);
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println(productList.get(pKey).getPname() + "의 수량을" + quantity + "으로 변경하였습니다.");
        save();
        productList();
    }

    public void add() {
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
        productList.put(pnumber, new Product(pname, pnumber, price, quantity, kind));
        save();
        productList();
        System.out.println("상품이 추가되었습니다.");
    }

    public void remove() {
        productList();
        System.out.println("삭제할 상품번호를 입력해주세요");
        int pnumber = Integer.parseInt(sc.nextLine());
        if (productList.containsKey(pnumber)) {
            productList.remove(pnumber);
            productList();
            System.out.println("상품이 삭제되었습니다.");
            save();
        }else {
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
        System.out.println("저장되었습니다.");
    }

    // I/O를 위한 역직렬화 로드
    public void load() {
        File file = new File("ProductDB.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis); // 역직렬화를 위한 보조스트림

            productList = (HashMap) ois.readObject(); // readObject메서드를 이용해서 역직렬화
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
