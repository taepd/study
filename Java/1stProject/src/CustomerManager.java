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

public class CustomerManager implements Manager, Serializable{
    
	static HashMap<String, User> customerList = new HashMap<String, User>();
       
    static Scanner sc = new Scanner(System.in);
 
    
    //회원 가입
    Customer signUp(String id, String pwd, String name, String tel, String address) {
        Customer customer = new Customer(id, pwd, name, tel, address);
        customer.setId(id);
        customer.setPwd(pwd);
        customer.setName(name);
        customer.setTel(tel);
        customer.setAddress(address);

        customerList.put(id,customer);
           
        save();
        CartManager cartManager = new CartManager();
        cartManager.cartList.put(id, new Cart()); 
        cartManager.save();
        return customer;       
    }
  
    Customer signIn(String id, String pwd) {
        
        if(customerList.containsKey(id)&&
                ((customerList.get(id).getPwd()).equals(pwd))) {

            System.out.println("로그인 성공");
            Mall.id = id;
            return (Customer) customerList.get(id);
        }else {
            System.out.println("로그인 실패");
            return null;
        }        
    }
    
    
    void productList() {  
        ProductsManager p = new ProductsManager();
        p.load();
        p.productList();
    }


    void myTransactiontHistory() {

       

        if (TransactionManager.transactionList.get(Mall.id) == null) {
            System.out.println("주문 내역이 없습니다.");
        } else {
            System.out.println(TransactionManager.transactionList.get(Mall.id));
        }

    }
    
    public void userList() {
        Set<String> set= customerList.keySet();
        //방법2
        System.out.println("==========================Vip고객명단==========================");
        System.out.println("       ID    Password    성함           휴대폰 번호                     배송지");
        for(String c : set) {
            if(c.equals("admin")) {
                continue;
            }
            Customer user = (Customer)(customerList.get(c));
            System.out.printf("%10s %10s %5s %10s %17s",user.getId(),user.getPwd(),user.getName(),user.getTel(),user.getAddress());
            System.out.println();
        }
    }
    
    void MyInfo() {
        do {
            try {
                 System.out.println("비밀번호를 입력하십시오");
                 String password = sc.nextLine();
                 if(customerList.get(Mall.id).getPwd().equals(password)) {
                     Customer my = (Customer)customerList.get(Mall.id); //(user)타입으로 있는 value값 다운캐스팅필요.
                     System.out.printf("[이름 : %s]\n[아이디 : %s]\n[비밀번호 : %s]\n[전화번호 : %s]\n[주소 : %s]\n", my.getName(),my.getId(),my.getPwd(),my.getTel(),my.getAddress());
                      break;
                } else {
                    throw new Exception("");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<입력 오류>");
                System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.");
         
            }
        } while (true);

        
    }
    
    public void userTransactionList() {
        Set<String> set= customerList.keySet();
        for(String c: set) {
            if(TransactionManager.transactionList.get(c)==null) {
                if(c.equals("admin")) {
                    continue;
                }
            System.out.println("             회원 "+c+" 님은 구매내역이 없습니다.");
            }else userTransactionHistory(c);
        }   
    }
    
    void userTransactionHistory(String id) {
        if(TransactionManager.transactionList.get(id)==null){
            System.out.println(id+" 회원님은 거래내역이 없습니다.");
            return;
        }else {
            System.out.println(id+" 님의 거래내역 입니다.");
            System.out.println(TransactionManager.transactionList.get(id));
        }
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
    
    
    //I/O를 위한 직렬화 저장
    public void save() {
        File file = new File("CustomerDB.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //직렬화 저장을 위한 보조스트림
            
            oos.writeObject(customerList); 
                                        // writeObject 메서드를 이용해서 직렬화 저장
            oos.close();
            bos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("에러발생!!!");
            e.printStackTrace();
        }
    }
    //I/O를 위한 역직렬화 로드
    public void load() {
        File file = new File("CustomerDB.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream oos = new ObjectInputStream(bis); //역직렬화를 위한 보조스트림
            
            customerList = (HashMap) oos.readObject(); //readObject메서드를 이용해서 역직렬화
                                                  //리턴값이 Object이므로 다운캐스팅
            
            oos.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        }
    }


}