package ex_241018_ch2;

import java.util.Scanner;

public class Twenties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("나이를입력하시오:");
		int age = scanner.nextInt();
		if ((age >= 20) && (age < 30)) { // age가20~29 사이인지검사
			System.out.print("20대입니다. ");
			System.out.println("20대라서행복합니다!");
		} else
			System.out.println("20대가아닙니다.");
		
		scanner.close();
	}

}
