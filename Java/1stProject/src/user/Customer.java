package user;

import java.io.Serializable;
import java.util.ArrayList;
import entity.Transaction;

public class Customer extends User implements Serializable{
    
    private String name;
    private String tel;
    private String address;
    
    ArrayList<Transaction> transactionArray;
    
    
          
    public Customer(String id, String pwd, String name, String tel, String address) {
        setId(id);
        setPwd(pwd);
        this.name=name;
        this.tel=tel;
        this.address=address;
        transactionArray= new ArrayList<Transaction>();
      
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Customer [id=" + getId() + ", pwd=" + getPwd() + ", name=" + name + ", tel=" + tel + ", address=" + address + "]";
    }
    
    
    
}