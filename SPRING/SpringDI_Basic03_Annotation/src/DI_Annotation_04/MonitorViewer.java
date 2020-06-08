package DI_Annotation_04;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
		
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}

	
	//@Autowired(required = true) //기본설정 true
	@Resource(name="xx")
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter 주입 성공 : " + recorder);
	}
	

	
	
}
