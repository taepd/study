package DI2;

public class NewRecordView {
	private NewRecord record;// member field -> getter setter 생성 가능 그런데 여기서는 setter만 만들어 보자

	// 1.생성자를 통해서 필요한 객체를 생성 or 주입 -> DI패키지에서 작업한것
	// 2.함수 (setter)를 통해서 필요한 객체를 주입받을 수 있다. -> DI2

	// record의 setter 함수
	public void setRecord(NewRecord record) {
		// 함수의 parameter를 통해서 NewRecord 객체의 주소값을 받아 준다.
		this.record = record;
	}

	public void print() {
		System.out.println(record.total() + " / " + record.avg());
	}
}
