import org.opentutorials.iot.Elevator;   // import 하게 되면 이후에는 그냥 마지막 값만 쓰면 됨
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class OkJavaGoInHome {

	public static void main(String[] args) {
		
		String id = "JAVA APT 507";
				
		// Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		// Light on
		Lighting hallLamp = new Lighting(id+ " / HallLamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+ " / floorLamp");
		floorLamp.on();

	}

}
