import java.util.ArrayList;


public class Account {
    private String accountNo;      //계좌번호
    private String name;    //소유자명
    private long balance;            //잔고    
    private ArrayList<Transaction> transactions;    //거래내역
    
    
    Account(){
        this(null, null);
    }
    
    Account(String accountNo, String name){
        this.accountNo = accountNo;
        this.name=name;
        this.balance=0;       
        this.transactions = new ArrayList<Transaction>();
        
    }
    
    
    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   

    @Override
    public String toString() {
        return "Account [계좌번호=" + accountNo + ", 소유자명=" + name + ", 잔고=" + balance + "]";
    }

    public void deposit(long amount) {      //입금한다           
          this.balance+=amount;
          System.out.printf("[%s]계좌에 [%d]원을 입금. 현재 잔고: %d\n",accountNo,amount,balance);
          this.transactions.add(new Transaction("입금", amount, balance));
    }
    public void withdraw(long amount) {    //출금한다
        this.balance-=amount;
        System.out.printf("[%s]계좌에 [%d원]을 출금. 현재 잔고: %d\n",accountNo,amount,balance);
        this.transactions.add(new Transaction("출금", amount, balance));
    }
    public long getBalance() {    //잔고를 확인한다
        System.out.printf("%s계좌 잔고 확인. 현재 잔고: %d\n",accountNo,balance);
        return balance;
    }
    
    public ArrayList<Transaction> getTransactions() {   //거래내역을 확인한다
        System.out.println("***거래 내역***");
        for(Transaction tr : transactions) {
        	System.out.println(tr.toString());
        }
        return transactions;
    }
    
    


        
    
    
    

}
