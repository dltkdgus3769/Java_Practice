package ex_241021_ch4;

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.name = "이상현";
		person.age = 30;
		person.introduce();
		
		Person person2 = new Person();
		person.name = "이상현2";
		person.age = 30;
		person.introduce();
		
		Person person3 = new Person("이상현3",30);
		person3.introduce();
		
		Person personArray [] = new Person[3];
		personArray[0] = person;
		personArray[1] = person2;
		personArray[2] = person3;
		
		for(Person person4 : personArray) {
			person4.introduce();
		}
	}

}
