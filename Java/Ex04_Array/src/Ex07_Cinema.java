
public class Ex07_Cinema {
	public static void main(String[] args) {
		String[][] seat = new String[3][5];
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = "___";
			}
		}
		seat[2][1] = "홍길동"; // 예매
		seat[0][0] = "김유신"; // 예매

		// 좌석정보 보여주기
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				System.out.printf("[%s]", seat[i][j].equals("___") ? "자리" : "예매");
			}
			System.out.println();
		}

		int row, col;
		row = 0;
		col = 0;
		if (seat[row][col].equals("___")) {
			System.out.println("예약 가능합니다");
		} else {
			System.out.println("이미 예약 되었습니다");
		}

		// 좌석초기화
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = "___";
			}
		}
	}

}
