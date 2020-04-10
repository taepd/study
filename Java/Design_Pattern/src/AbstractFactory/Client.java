package AbstractFactory;

public class Client {
	public static void main(String[] args) {
		AbstractFactory abf = new SamsungFactory(); //伙己 傍厘 积己
		abf.createSmartPhone().getSmartPhone();
		abf.createBtEarPhone().getBtEarPhone();
		
		AbstractFactory abf2 = new AppleFactory(); //局敲 傍厘 积己
		abf2.createSmartPhone().getSmartPhone();
		abf2.createBtEarPhone().getBtEarPhone();
	}
	

}
