package DI2;

public class Program {
	public static void main(String[] args) {
		NewRecordView view = new NewRecordView();

		//필요에 의해 생성자를 만들 수 있다. 
		NewRecord record = new NewRecord(100,50, 50);
		view.setRecord(record);//주입
		view.print();
		//집합 연관(두생성자의 life 사이클이 다르다.)
	}
}

