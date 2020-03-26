import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Transaction implements Serializable{
      
    private String transactionDate;
    private String transactionTime;
    String customerName;
    String productName;
    int price;
    int quantity;
    
    
    
    CustomerManager customerManager = new CustomerManager();
    
    public Transaction(String cutomerName, String productName, int price, int quantity) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년MM월dd일");
        SimpleDateFormat dateformat2 = new SimpleDateFormat("HH시mm분");
        this.transactionDate=dateformat.format(cal.getTime());
        this.transactionTime=dateformat2.format(cal.getTime());
        
        
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "Transaction [transactionDate=" + transactionDate + ", transactionTime=" + transactionTime
                + ", customerName=" + customerName + ", productName=" + productName + ", price=" + price + ", quantity="
                + quantity + ", customerManager=" + customerManager + "]";
    }

    

    
    
    

}
