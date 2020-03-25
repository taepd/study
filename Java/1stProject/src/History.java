import java.text.SimpleDateFormat;
import java.util.Calendar;

public class History {
    
    private String transactionDate;
    private String transactionTime;
    
    public History() {
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
        return "History [transactionDate=" + transactionDate + ", transactionTime=" + transactionTime + "]";
    }
}
