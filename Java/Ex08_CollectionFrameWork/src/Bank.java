import java.util.ArrayList;


public class Bank {
    private ArrayList<Account> accounts;  //계좌(0개 이상)
    private int totalAccount;       //총 계좌수
    
    Bank(){
        accounts = new ArrayList<Account>();
        totalAccount=0;
    }
    
    
    
    //계좌를 생성한다
    public void addAccount(String accountNo, String name) { 
        accounts.add(new Account(accountNo, name));
        System.out.println("계좌를 생성했습니다.");
        System.out.println("생성한 계좌:"+new Account(accountNo, name));        
        totalAccount ++;
    }
    
    //계좌를 찾는다(계좌번호로)
    public Account getAccount(String accountNo) {
        for(Account acc : accounts) {
            if(acc.getAccountNo().equals(accountNo)) {
                System.out.println("해당 계좌번호와 일치하는 계좌가 있습니다.");
                System.out.println(acc);
                return acc;
            }else {
                System.out.println("해당 계좌번호와 일치하는 계좌가 없습니다.");
                return null;
            }
        }
        return null;
    }
    //계좌를 찾는다(소유자명으로)
    public ArrayList<Account> findAccounts(String name){
        ArrayList<Account> list = new ArrayList<Account>();
        for(Account acc : accounts) {
            if(acc.getName().equals(name)) {
                System.out.println("일치하는 계좌 발견.");
                list.add(acc);
                
            }else {
                System.out.println("해당 고객명과 일치하는 계좌목록이 없습니다.");
                return null;
            }   
        }
        System.out.println(list);
        return list;
    }
    //계좌목록을 본다
    public ArrayList<Account> getAccounts(){
           

        return accounts;
    }
    
    
    //총계좌수를 반환한다
    public int getTotalAccount() {
        return totalAccount;
    }
    
    public static void main(String[] args) {
        
       Bank bank = new Bank();
       
       //계좌 생성
       System.out.println("**계좌 생성**");
       bank.addAccount("00-0000-0001", "똘기");
       bank.addAccount("00-0000-0002", "떵이");
       bank.addAccount("00-0000-0003", "똘기");
       
       //계좌 찾기(계좌번호로)
       System.out.println("**계좌 찾기(계좌번호로)**");
       bank.getAccount("00-0000-0001");  //일치하는 계좌번호 있는 경우
       bank.getAccount("99-9999-9999");  //일치하는 계좌번호 없는 경우
       
       //계좌 찾기(소유자 명으로)
       System.out.println("**계좌 찾기(소유자 명으로)**");
       bank.findAccounts("똘기");         //일치하는 계좌가 있는 경우  
       bank.findAccounts("찡찡이");        //일치하는 계좌가 없는 경우
      
       //계좌목록 보기
       System.out.println("**계좌 목록 보기**");
       System.out.println(bank.getAccounts());
       
       //총 계좌수 반환
       System.out.println("**총 계좌수 반환**");
       System.out.println(bank.totalAccount);
       
       //입금
       System.out.println("**입금**");
       bank.accounts.get(0).deposit(10000L);
       
       //출금
       System.out.println("**출금**");
       bank.accounts.get(0).withdraw(5000L);
       
       //잔고 확인
       System.out.println("**잔고 확인**");
       bank.accounts.get(0).getBalance();
       
       //거래내역 확인
       System.out.println("**거래내역 확인**");
       bank.accounts.get(0).getTransactions();
       
     
    }
    
}
