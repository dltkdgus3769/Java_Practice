package ex_241022_ch4_2;

public class Animal {
	//public , 모든곳에서 볼 수 있음
	//private, 해당 파일 내에서만 볼 수 있음
	//protected, 상속받은 자식 클래스에서 볼 수 있음
	//default, 같은 패키지 내에서 볼 수 있음
	protected String name;
	protected int age;
	
	public void speak() {
		System.out.println("야호!");
	}
}
