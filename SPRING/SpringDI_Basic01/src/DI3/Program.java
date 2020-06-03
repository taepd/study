package DI3;

public class Program {

	public static void main(String[] args) {
		NewRecordView view = new NewRecordView();
		NewRecord record = new NewRecord();
		view.setRecord(record); //주입 
		view.input();
		view.print();
		

	}

}
