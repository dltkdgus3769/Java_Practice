package ex_241022_ch4_2;

public class JinDog extends Animal {

	private String hobby;

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public void speak() {
		System.out.println("멍멍!");
	}

	public void introduce() {
		System.out.println("이름 :" + super.name);
	}

	public void introduce(String food) {
		System.out.println("이름 :" + super.name + " 취미 :" + this.hobby + " 좋아하는 움식: " + food);
	}

	public void introduce(String food, String location) {
		System.out.println("이름 :" + super.name + " 취미 :" + this.hobby + " 사는 곳 : " + location + " 좋아하는 움식: " + food);
	}
}
