package AbstractFactory;

public class AppleFactory implements AbstractFactory {

	@Override
	public AbstractSmartPhone createSmartPhone() {
		
		return new AppleSmartPhone();
	}

	@Override
	public AbstractBtEarPhone createBtEarPhone() {
		
		return new AppleBtEarPhone();
	}

}
