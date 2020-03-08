class Accounting {
	public  double valueOfSupply;
	public  double vatRate;
	public  double expenseRate;
	
	public void print() {
		System.out.println("Value of supply : "+valueOfSupply);
		System.out.println("VAT : "+getVAT());
		System.out.println("Total : "+getTotal());		
		System.out.println("Expense : "+getExpense());
		System.out.println("Income : "+getIncome());
		System.out.println("Dividend 1 : "+getDividend1());
		System.out.println("Dividend 2 : "+getDividend2());
		System.out.println("Dividend 3 : "+getDividend3());
	}

	public double getDividend1() {
		return getIncome()*0.5;
	}
	public double getDividend2() {
		return getIncome()*0.3;
	}
	public double getDividend3() {
		return getIncome()*0.2;
	}

	public double getIncome() {
		return valueOfSupply-getExpense();
	}

	public double getExpense() {
		return valueOfSupply*expenseRate;
	}

	public double getTotal() {
		return valueOfSupply+getVAT();
	}   // 메소드는 서로 연관된 코드들을 모아서 그룹화 한 정리정돈 상자다.
	   // 메인 밖 객체에서 메인의 지역변수를 사용할 수 없으니 전역변수화가 필요하다.
       // 전역변수화 하지 않는다면 메소드 자체를 호출하는 것으로 가능하다.
	public double getVAT() {
		return valueOfSupply*vatRate;
	}

	
}
public class AccountingAppClass {
	
	public static void main(String[] args) {
		// instance
		Accounting a1 = new Accounting();
		a1.valueOfSupply = 10000.0;
		a1.vatRate = 0.1;
		a1.expenseRate = 0.3;
		//...
		a1.print();
		
		System.out.println(""); //출력문에 공백줄 넣기
		
		//...
		Accounting a2 = new Accounting();
		a2.valueOfSupply = 20000.0;
		a2.vatRate = 0.05;
		a2.expenseRate = 0.2;
		a2.print();	

		
	}

	
}
