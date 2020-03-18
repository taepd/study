import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Bank {
	private ArrayList<Account> accounts; // 계좌(0개 이상)
	private int totalAccount; // 총 계좌수
	private HashSet<String> accountNoSet;
	
	Scanner sc = new Scanner(System.in);

	Bank() {
		accounts = new ArrayList<Account>();
		totalAccount = 0;
		this.accountNoSet = new HashSet<String>();

	}

	// 계좌를 생성한다
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
		System.out.println("계좌를 생성했습니다.");
		System.out.println("생성한 계좌:" + new Account(accountNo, name));
		totalAccount++;
	}

	// 계좌를 찾는다(계좌번호로)
	public Account getAccount(String accountNo) {
		for (Account acc : accounts) {
			if (acc.getAccountNo().equals(accountNo)) {
				System.out.printf("계좌번호:%s 와(과) 일치하는 계좌 발견.\n", accountNo);
				System.out.println(acc);
				return acc;
			}
		}
		System.out.println("해당 계좌번호와 일치하는 계좌가 없습니다.");
		return null;
	}

	// 계좌를 찾는다(소유자명으로)
	public ArrayList<Account> findAccounts(String name) {
		ArrayList<Account> list = new ArrayList<Account>();
		for (Account acc : accounts) {
			if (acc.getName().equals(name)) {
				list.add(acc);
			}

		}
		if (list.size() != 0) {
			System.out.printf("소유자명:%s 와(과) 일치하는 계좌 발견.\n", name);
			for (Account acc : list) {
				System.out.println(acc);
			}
		} else {
			System.out.println("해당 소유자명과 일치하는 계좌목록이 없습니다.");
		}
		return list;
	}

	// 계좌목록을 본다
	public ArrayList<Account> getAccounts() {

		System.out.println("계좌 목록: ");
		for (Account acc : accounts) {
			System.out.println(acc);
		}
		return accounts;
	}

	// 총계좌수를 반환한다
	public int getTotalAccount() {
		System.out.printf("총 계좌수는 %d개입니다.\n", totalAccount);
		return totalAccount;
	}
	
	// 로그인용 계좌를 찾는다(계좌번호로)
		public Account login(String accountNo) {
			for (Account acc : accounts) {
				if (acc.getAccountNo().equals(accountNo)) {
					return acc;
				}
			}
			System.out.println("해당 계좌번호와 일치하는 계좌가 없습니다.");
			return null;
		}

	// 프로그램 메인 구조

	void program() {
		while (true) {
			switch (displayMenu()) {
			case 1: {
				this.programB();
				break;
			}
			case 2: {
				this.programA();
				break;
			}
			case 3: {
				System.exit(0);
			}

			}

		}
	}

	void programB() {
		outer: while (true) {
			switch (displayMenuB()) {
			case 1: {
				System.out.println("**계좌 생성**");
				System.out.println("이름을 입력해주세요");
				String name = sc.nextLine();
				String accountNo="";
				while(true) {
				accountNo = (int)((Math.random() * 90000000) + 10000000)+"";
				if(!accountNoSet.contains(accountNo)) {
					break;
				}				
				}
				addAccount(accountNo, name);
				break;
			}
			case 2: {
				System.out.println("**계좌 찾기(계좌번호로)**");
				System.out.println("계좌번호를 입력해주세요");
				String accountNo = sc.nextLine();
				getAccount(accountNo);
				break;
			}
			case 3: {
				System.out.println("**계좌 찾기(소유자 명으로)**");
				System.out.println("이름을 입력해주세요");
				String name = sc.nextLine();
				findAccounts(name);
				break;
			}
			case 4: {
				System.out.println("**계좌 목록 보기**");
				getAccounts();
				break;
			}
			case 5: {
				System.out.println("**총 계좌수 반환**");
				getTotalAccount();
				break;
			}
			case 6: {
				break outer;
			}
			case 7: {
				System.exit(0);
			}

			}

		}
	}

	void programA() {
		System.out.println("계좌번호를 입력해주세요");
		String accountNo = sc.nextLine();
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		if (login(accountNo).getName().equals(name)) {
			outer: while (true) {
				switch (this.displayMenuA()) {
				case 1: {
					System.out.println("**입금**");
					System.out.println("입금액을 입력해주세요");
					long amount = Integer.parseInt(sc.nextLine());
					getAccount(accountNo).deposit(amount);
					break;
				}
				case 2: {
					System.out.println("**출금**");
					System.out.println("출금액을 입력해주세요");
					long amount = Integer.parseInt(sc.nextLine());
					getAccount(accountNo).withdraw(amount);
					break;
				}
				case 3: {
					System.out.println("**잔고 확인**");
					getAccount(accountNo).getBalance();
					break;
				}
				case 4: {
					System.out.println("**거래 내역 보기**");
					getAccount(accountNo).getTransactions();
					break;
				}
				case 5: {
					break outer;
				}
				case 6: {
					System.exit(0);
				}

				}

			}
		}else {
			System.out.println("일치하는 정보가 없습니다.");
		}
	}

	// 초기 메뉴

	int displayMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("***************************");
				System.out.println("*****은행 전산 시스템 테스트*****");
				System.out.println("***************************");
				System.out.println("1. 직원용");
				System.out.println();
				System.out.println("2. 고객용");
				System.out.println();
				System.out.println("3. 시스템 종료");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 3) {
					return menu;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<입력 오류>");
				System.out.println("1~3번의 메뉴 중 하나를 선택하세요");
			}
		} while (true);

	}

	int displayMenuB() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****은행 전산 시스템 테스트(직원용)*****");
				System.out.println("*********************************");
				System.out.println("1. 계좌 생성");
				System.out.println();
				System.out.println("2. 계좌 찾기(계좌 번호 이용)");
				System.out.println();
				System.out.println("3. 계좌 찾기(소유자명 이용)");
				System.out.println();
				System.out.println("4. 계좌 목록 보기");
				System.out.println();
				System.out.println("5. 총 계좌수 보기");
				System.out.println();
				System.out.println("6. 이전 메뉴로");
				System.out.println();
				System.out.println("7. 시스템 종료");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 7) {
					return menu;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<입력 오류>");
				System.out.println("1~7번의 메뉴 중 하나를 선택하세요");
			}
		} while (true);

	}

	int displayMenuA() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****은행 전산 시스템 테스트(고객용)*****");
				System.out.println("*********************************");
				System.out.println("1. 입금 하기");
				System.out.println();
				System.out.println("2. 출금 하기");
				System.out.println();
				System.out.println("3. 잔고 확인");
				System.out.println();
				System.out.println("4. 거래 내역 보기");
				System.out.println();
				System.out.println("5. 이전 메뉴로");
				System.out.println();
				System.out.println("6. 시스템 종료");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					return menu;
				} else {
					throw new Exception("메뉴 선택 번호가 잘못 되었습니다");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<입력 오류>");
				System.out.println("1~6번의 메뉴 중 하나를 선택하세요");
			}
		} while (true);

	}

	public static void main(String[] args) {

		Bank bank = new Bank();

		bank.program();

//       //계좌 생성
//       System.out.println("**계좌 생성**");
//       bank.addAccount("00-0000-0001", "똘기");
//       bank.addAccount("00-0000-0002", "떵이");
//       bank.addAccount("00-0000-0003", "똘기");
//       
//       //계좌 찾기(계좌번호로)
//       System.out.println("**계좌 찾기(계좌번호로)**");
//       bank.getAccount("00-0000-0001");  //일치하는 계좌번호 있는 경우
//       bank.getAccount("99-9999-9999");  //일치하는 계좌번호 없는 경우

//       //계좌 찾기(소유자 명으로)
//       System.out.println("**계좌 찾기(소유자 명으로)**");
//       bank.findAccounts("똘기");         //일치하는 계좌가 있는 경우  
//       bank.findAccounts("찡찡이");        //일치하는 계좌가 없는 경우
//      
//       //계좌목록 보기
//       System.out.println("**계좌 목록 보기**");
//       System.out.println(bank.getAccounts());
//       
//       //총 계좌수 반환
//       System.out.println("**총 계좌수 반환**");
//       System.out.println(bank.totalAccount);

//       //입금
//       System.out.println("**입금**");
//       bank.accounts.get(0).deposit(10000L);
//       
//       //출금
//       System.out.println("**출금**");
//       bank.accounts.get(0).withdraw(5000L);
//       
//       //잔고 확인
//       System.out.println("**잔고 확인**");
//       bank.accounts.get(0).getBalance();
//       
//       //거래내역 확인
//       System.out.println("**거래내역 확인**");
//       bank.accounts.get(0).getTransactions();

	}

}
