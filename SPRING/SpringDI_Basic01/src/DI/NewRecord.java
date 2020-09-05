package DI;

public class NewRecord {
	private int kor;
	private int eng;
	private int math;
	
	public NewRecord() {}
	
	public NewRecord(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	//DTO에도 필요에 따라서 추가 함수의 구현 가능
	public int total() {
		return this.kor + this.eng + this.math;
	}
	
	public float avg() {
		return total() / 3.0f;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "NewRecord [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
}