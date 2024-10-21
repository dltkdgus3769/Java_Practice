package ex_241018_ch2;

import java.util.Scanner;

public class ScannerEx1 {

	public static void main(String[] args) {
		System.out.println("문자열 숫자 빈칸 분리 입력");

		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int num = scanner.nextInt();

		System.out.println("문자열 : " + str + " 숫자 : " + num);
		
		scanner.close();
	}
}
