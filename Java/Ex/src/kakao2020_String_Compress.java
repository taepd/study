public class kakao2020_String_Compress {

	public static void main(String[] args) {

		String s = "xcvaaaaabb";
				
		int answer=s.length(); 
		
	
		for(int i = 1; i<=s.length()/2;i++) {  //가장 큰 덩어리는 전체 문자열 길이의 절반이므로
			String str = s.substring(0,i); //비교 기준이 되는 문자열 자르기
			System.out.println("str: "+str);
			String result="";
			int count=1; //압축률  표시 숫자
			for(int j=i;j<=s.length()-i;j+=i) { //문자열을 i크기만큼 잘라서 비교
				if(str.equals(s.substring(j,j+i))){ 
					System.out.println("com: "+(s.substring(j,j+i)));
					count++;	
					
				}else {	//같은 문자열이 아닌 경우
					if(count==1) {
						result += str;
					}else {
						result +=(count+str);
					}
					str=s.substring(j,j+i);
					System.out.println("다음 비교 문자: " + str);
					count=1;
					System.out.println("result: "+result);
					System.out.println("j: "+j);
				}
			}
			//내부 for문을 다 돌고 나서 문자열을 i로 나눈 것에 나머지가 있는 경우 result뒤에 추가하기
			if(s.length()%i !=0) {
				result+=str+(s.substring((s.length()/i)*i));
				
			}else {
				if(count==1) {
					result+=str;
				}else {
					result +=(count+str);
				}
			
			}
			System.out.println("최종 결과: " + result);
			answer= result.length()<answer?result.length():answer;
			System.out.println("answer: " + answer);
		}
		
	}

}
