import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;   // import 하게 되면 이후에는 그냥 마지막 값만 쓰면 됨
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class OkJavaGoInHomeInput {

	public static void main(String[] args) {
		
		String id = JOptionPane.showInputDialog("Enter a ID"); // 입력창 
		String bright = JOptionPane.showInputDialog("Enter a Bright Level");		
		
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
		
		DimmingLights moodLamp = new DimmingLights(id+ " / moodLamp");
		moodLamp.setBright(Double.parseDouble(bright)); // bright는 String인데 setBright 메소드는 값으로 Double를 가져야 함으로 변환해야함
		moodLamp.on();

	}

}
