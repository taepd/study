package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;

public class MonitorViewer {
	private Recorder recorder; //Recorder 객체의 주소값이 할당
	


	public Recorder getRecorder() {
		return recorder;
	}

	@Autowired  //by type (IOC컨테이너 안에 Recorder 타입을 갖는 객체가 있으면 자동 주입)
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
	@Override
	public String toString() {
		return "MonitorViewer [recorder=" + recorder + "]";
	}
	
	
}


