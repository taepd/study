package AbstractFactory;

public class SamsungFactory implements AbstractFactory {

	@Override
	public AbstractSmartPhone createSmartPhone() {
		
		return new SamsungSmartPhone();
	}

	@Override
	public AbstractBtEarPhone createBtEarPhone() {
		
		return new SamsungBtEarPhone();
	}

}
