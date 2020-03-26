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

class CartManager extends Cart implements Manager{
    CustomerManager customerManager = new CustomerManager();
    static Scanner sc = new Scanner(System.in);
    HashMap<String, Cart> cartList = new HashMap<String, Cart>();       
    ProductsManager productsManager = new ProductsManager();
    TransactionManager transactionManager = new TransactionManager();

    public void add() {
        
        
        customerManager.load();
        String id = customerManager.id;
        //카트가 자꾸 재생성됨 if문 추가해야 함
      
        cartList.put(id,new Cart()); //user의 id마다, 새로운 카트 생성.

        System.out.println("추가할 상품 번호를 입력해 주세요.");
        productsManager.load();
        int pnumber = Integer.parseInt(sc.nextLine()); //상품번호 입력  
        
        Product p =productsManager.productList.get(pnumber);  //입력한 상품 호출
        System.out.println(p.toString());
        cartList.get(id).cartArray.add(p); //고객 카트에 상품 추가
        p.setQuantity(p.getQuantity()-1);  //상품 수량 -1
     
        cartList.get(id).totalprice += p.getPrice();
        productsManager.save();
        save();
        cartList.get(id).show();
        
        System.out.println("장바구니에 상품이 추가되었습니다.");

        
    }
    public void remove() { //회원이 카트 자체를 삭제하는 일은 없으니 remove는 없음...
        String id = customerManager.id;
        System.out.println(id);
        
        Customer customer = (Customer)customerManager.customerList.get(id);
        
        customer.transactionArray.clear();
        
    }
    
    public void buy() {
        String id = customerManager.id;
        
        Customer customer = (Customer)customerManager.customerList.get(id);
        
        if(customer.transactionArray==null) {
            return;
        }
        for(Product p : cartList.get(id).cartArray) {
          
            System.out.println(customer);
            
            
            Transaction t = new Transaction(customer.getId(),p.getPname(), p.getPrice(), p.getQuantity());      
            customer.transactionArray.add(t);
            
            
            transactionManager.transactionList.put(id, customer.transactionArray);
           
            transactionManager.save();
            
            
            System.out.print(p.getPname()+", ");
            
            
            
        }customer.transactionArray.clear();
        System.out.println("을 구매하셨습니다.");
       
        
        
        
        
    }
    
    public void show() {
        cartList.get(customerManager.id).show();
    }
    
    //I/O를 위한 직렬화 저장
    private void save() {
        File file = new File("CartDB.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //직렬화 저장을 위한 보조스트림
            
            oos.writeObject(cartList); 
                                        // writeObject 메서드를 이용해서 직렬화 저장
            oos.close();
            bos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("에러발생!!!");
            e.printStackTrace();
        }
        System.out.println("저장되었습니다.");
    }
    //I/O를 위한 역직렬화 로드
    void load() {
        File file = new File("CartDB.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream oos = new ObjectInputStream(bis); //역직렬화를 위한 보조스트림
            
            cartList = (HashMap)oos.readObject(); //readObject메서드를 이용해서 역직렬화
                                                  //리턴값이 Object이므로 다운캐스팅
            
            oos.close();
            bis.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        }
    }
    
    
}