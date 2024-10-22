package ex_241022_ch4_2;

public class MainClassAnimal {
	public static void main(String[] args) {
		JinDog jindog = new JinDog();
		
		jindog.name="진돗개";
		jindog.age=12;
		jindog.speak();
		jindog.setHobby("공놀이");
		jindog.introduce();
		jindog.introduce("개껌");
		jindog.introduce("개껌", "부산");
	}
}
