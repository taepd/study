import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class CustomerManager implements Manager, Serializable{
    static HashMap<String, User> customerList = new HashMap<String, User>();
    ProductsManager p = new ProductsManager();
    TransactionManager transactionManager = new TransactionManager();
    static String id;
    
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
        return customer;       
    }
  
    Customer signIn(String id, String pwd) {
        
        if(customerList.containsKey(id)&&
                ((customerList.get(id).getPwd()).equals(pwd))) {

            System.out.println("로그인 성공");
            this.id = id;
            return (Customer) customerList.get(id);
        }else {
            System.out.println("로그인 실패");
            return null;
        }        
    }
    
    
    void productList() {       
        p.load();
        p.productList();
    }


    void myTransactiontHistory() {
    	String id = Mall.id;     
        System.out.println(transactionManager.transactionList.get(id));       
  
    }
    
    public void userList() {
        Set<String> set= customerList.keySet();
        //방법2
        System.out.println("==========================Vip고객명단==========================");
        System.out.println("       ID    Password    성함           전화번호                     배송지");
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
        
//        System.out.println("회원님의 정보 입니다.");
//        load(); //임시로 둔 load
//        Set<String> set = customerList.keySet();
//        customerList.keySet();
//        
//        for(String a : set) {
//            String name = customerList.get(a).getId();
//            
//        }
        Customer my = (Customer)customerList.get(id); //(user)타입으로 있는 value값 다운캐스팅필요.
       System.out.println("회원님의 이름은 "+my.getName());
       System.out.println("회원님의 아이디는 "+my.getId());
       System.out.println("회원님의 비밀번호는"+my.getPwd());
       System.out.println("회원님의 전화번호는"+my.getTel());
       System.out.println("회원님의 주소는"+my.getAddress());

        
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
        System.out.println("저장되었습니다.");
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