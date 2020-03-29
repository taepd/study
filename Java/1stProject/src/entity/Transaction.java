package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import manager.CustomerManager;

public class Transaction implements Serializable{
      
    private String transactionDate;
    private String transactionTime;
    private String customerName;
    private String productName;
    private int price;
    private int quantity;    
    
    public Transaction(String customerName, String productName, int price, int quantity) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat dateformat2 = new SimpleDateFormat("HH시 mm분 ss초");
        this.transactionDate=dateformat.format(cal.getTime());
        this.transactionTime=dateformat2.format(cal.getTime());
        this.customerName = customerName;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;
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
    
    public int getQuantity() {
 		return quantity;
 	}

    @Override
    public String toString() {
        return "   "+productName+"     "+String.format("%,d", price)+
        		"    "+String.format("%,d", quantity)+"      "+customerName+"    "+
        		transactionDate+transactionTime;
    }
}
