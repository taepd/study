import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {
	
	private String transactionDate;
	private String transactionTime;
	private String kind;
	private long amount;
	private long balance;
	

	
	
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

    public Transaction(String kind, long amount, long balance) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년MM월dd일");
	    SimpleDateFormat dateformat2 = new SimpleDateFormat("HH시mm분");
	    this.transactionDate=dateformat.format(cal.getTime());
		this.transactionTime=dateformat2.format(cal.getTime());
		this.kind=kind;
		this.amount=amount;
		this.balance=balance;
		
		
	}

	@Override
	public String toString() {
		return "Transaction [거래일=" + transactionDate + ", 거래시간=" + transactionTime + ", 거래구분="
				+ kind + ", 거래금액=" + amount + ", 잔고=" + balance + "]";
	}
	
	


}
