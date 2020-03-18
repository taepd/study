import java.util.ArrayList;

public class Account {
    private String accountNo;      //계좌번호
    private String name;    //소유자명
    private long balance;            //잔고    
    private ArrayList<String> Transactions;    //거래내역
    
    Account(String accountNo, String name){
        this.accountNo = accountNo;
        this.name=name;
        this.balance=0;
        this.Transactions = null;
        
        Transactions = new ArrayList<String>();
    }
    
    
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   

    @Override
    public String toString() {
        return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + ", Transactions="
                + Transactions + "]";
    }

    public void deposit(long amount) {      //입금한다
     
          this.balance+=amount;
          System.out.printf("%s계좌에 %d원을 입금. 현재 잔고: %d\n",accountNo,amount,balance);
          System.out.println(toString());
          this.Transactions.add(toString());
        
    }
    public void withdraw(long amount) {    //출금한다
        this.balance-=amount;
        System.out.printf("%s계좌에 %d원을 출금. 현재 잔고: %d\n",accountNo,amount,balance);
        System.out.println(toString());
        this.Transactions.add(toString());
    }
    public long getBalance() {    //잔고를 확인한다
        System.out.printf("%s계좌 잔고 확인. 현재 잔고: %d\n",accountNo,balance);
        System.out.println(toString());
        return balance;
    }
    
    public ArrayList<String> getTransactions() {   //거래내역을 확인한다
        System.out.println("***거래 내역***");
        System.out.println(Transactions.toString());
        return Transactions;
    }
    
    


        
    
    
    

}
