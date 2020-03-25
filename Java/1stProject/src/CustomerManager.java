import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public class CustomerManager implements Manager {
    HashMap<String, User> customerList = new HashMap<String, User>();

    
    
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
  
    Customer login(String id, String pwd) {
        
        if(customerList.containsKey(id)&&
                ((customerList.get(id).getPwd()).equals(pwd))) {

            System.out.println("로그인 성공");
            return (Customer) customerList.get(id);
        }else {
            System.out.println("로그인 실패");
            return null;
        }        
    }
    
    
    void watchProductList() {
        
    }

    void buy() {
        
    }



    void watchBuyHistory() {

    }

    void searchUserInfo() {

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
    private void save() {
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
    void load() {
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