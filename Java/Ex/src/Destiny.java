import java.util.Arrays;
import java.util.Scanner;

/*데스티니 무기 파밍기

무기를 자동으로 100회 파밍, 무기의 각 옵션, 옵션이 적용된 스탯, 파밍한 횟수를 출력.
스탯은 데미지, 사거리, 안정성, 반동, 조작성, 탄창, 장전 속도, 조준 보정이 있다.
옵션은 4개의 칸이 있으며, 각 칸마다 총열 옵션, 탄창 옵션, 유틸리티 옵션, 딜 옵션이 하나씩 들어간다.

총열 옵션 : 연장 총열(사거리 + 10, 조작성 - 10, 반동 +10), 소구경(사거리 + 7, 안정성 + 7), 보정기(안정성 +=10, 조작성 -5, 반동 +10), 나선 강선(사거리 +5, 안정성+5, 조작성 +5)
탄창 옵션 : 대구경 탄약(사거리 +5), 철갑탄(사거리 +5), 연장 탄창(재장전 속도 -20, 탄창 +3), 도탄 탄약(안정성 +10, 사거리 +5), 경량 탄창(사거리 +5, 재장전 속도 +10)
유틸리티 옵션 : 신속 발사, 자동 장전 총집, 위협 감지기, 연명
딜 옵션 : 살상 탄창, 광란, 사거리 확보 장치, 이동 표적, 다중 처치 탄창

무기를 한번 파밍할 때마다 4개의 칸에 각 옵션들이 하나씩 들어가고, 이것은 모두 무작위로 진행된다.*/

class StatsNOptn {
	
	//스탯들
			int demage = 0;
			int range = 0;
			int safety = 0;
			int recoil = 0;
			int operability = 0;
			int magazine = 0;
			int reloadSpeed = 0;
			int aimCorrection = 0;
		
			
			//옵션들
			 String[] barrelOptn = {"연장 총열","소구경","보정기","나선 강선"};
			 String[] magazineOptn = {"대구경 탄약","철갑탄","연장 탄창", "도탄 탄약","경량 탄창"};
			 String[] utilOptn = {"신속 발사", "자동 장전 총집", "위협 감지기", "연명"};
			 String[] dealOptn = {"살상 탄창", "광란", "사거리 확보 장치", "이동 표적", "다중 처치 탄창"};
	
	public void initStats() {
		 demage = 0;
		 range = 0;
		 safety = 0;
		 recoil = 0;
		 operability = 0;
		 magazine = 0;
		 reloadSpeed = 0;
		 aimCorrection = 0;
	}
			 
			 
	public String[]  expandsArray(String[] a, String b) {
		String[] tmp = new String[a.length+1];
		for(int i=0;i<a.length;i++) {
			tmp[i]=a[i];				
		}
		tmp[a.length] = b;
		a = tmp;
		return a;			
	}
	
	
	public void farming() {
	Scanner sc = new Scanner(System.in);
	int count;
	count = sc.nextInt();
		for(int i=1;i<=count;i++) {
			initStats();   // 스탯 값 초기화
		
		// 옵션 랜덤 선택
		String optn1 = barrelOptn[(int) (Math.random() * barrelOptn.length)];
		String optn2 = magazineOptn[(int) (Math.random() * magazineOptn.length)];
		String optn3 = utilOptn[(int) (Math.random() * utilOptn.length)];
		String optn4 = dealOptn[(int) (Math.random() * dealOptn.length)];
		
		String[] myOptn = {optn1, optn2, optn3, optn4};

		
		//스탯 반영
		
		switch(optn1) {
			case "연장 총열": range +=10; operability -=10; recoil+=10; 
				break;
			case "소구경":   range+=7;safety+=7;
				break;
			case "보정기":   safety+=10; operability-=5; recoil+=10;   
				break;
			case "나선 강선":  range+=5; safety+=5; operability+=5;
				break;
			default :
				break;
		}

		switch(optn2) {
		case "대구경 탄약": range +=5;
			break;
		case "철갑탄":   range+=5;
			break;
		case "연장 탄창":   reloadSpeed-=20; magazine+=3;   
			break;
		case "도탄 탄약":  safety+=10; range+=5;
			break;
		case "경량 탄창":  range+=5; reloadSpeed+=10;
		break;
		default :
			break;
	    }
	
		
		System.out.println("**********");
		System.out.println(i+"번 파밍 무기");
		System.out.println("옵션: "+Arrays.deepToString(myOptn));
		System.out.printf("스탯: [데미지:%d, 사거리:%d, 안정성:%d, 반동:%d, 조작성:%d, 탄창:%d, 장전 속도:%d, 조준 보정:%d]%n",
				demage,range,safety,recoil,operability,magazine,reloadSpeed,aimCorrection);
	    
		}
		
	}
	
}

public class Destiny {

	public static void main(String[] args) {
		
		
		
		StatsNOptn so = new StatsNOptn();
		
	
		System.out.println("*************");
		System.out.println("데스티니 무기 파밍기");
		System.out.println("*************");
		
		System.out.println("파밍할 횟수를 입력하세요");
		
		so.barrelOptn = so.expandsArray(so.barrelOptn, "test"); //스텟 갯수 추가
		so.barrelOptn = so.expandsArray(so.barrelOptn, "test1");
		so.farming();

		
		
	}

}
