package AOP_Basic_01;

public class Program {

	public static void main(String[] args) {
		Calc calc = new Calc();
		int result = calc.Add(1000, 1000);
		System.out.println("Add Result: " + result);
		
		result = calc.Mul(1000, 1000);
		System.out.println("Mul Result: " + result);
	}

}
