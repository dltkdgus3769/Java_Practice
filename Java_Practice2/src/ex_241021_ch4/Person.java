package ex_241021_ch4;

public class Person {
	String name;
	int age;

	void introduce() {
		System.out.println("나의 이름: " + name + ", 나이: " + age);
	}
	
	public Person() {};

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("나의 이름: " + name + ", 나이: " + age);
	}
}
