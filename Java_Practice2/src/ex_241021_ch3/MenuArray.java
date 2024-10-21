package ex_241021_ch3;

import java.util.Scanner;

public class MenuArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String[] Menu = new String[3];
		System.out.println("===========오늘 먹고 싶은 점심 메뉴 3개 작성해보기 ==========");
		for (int i = 0; i < Menu.length; i++) {
			System.out.println("메뉴" + (i + 1) + " :");
			Menu[i] = scanner.next();
		}
		System.out.println("===================================================");
		System.out.println("오늘 먹고 싶은 메뉴 출력");
		for (int i = 0; i < Menu.length; i++) {
			System.out.println("메뉴" + (i + 1) + " :" + Menu[i]);

		}
	}

}
