package java_study_ex;

import java.util.Scanner;

class Temp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n;i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	System.out.printf("Case #i: %d\n",(a+b));
        }
    }
}