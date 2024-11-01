package ex_241023_ch5;

interface PhoneGpsInterface{
	final String GPS_PROJECT_NAME = "GPS 프로젝트";
	
	void getLatLon();
}
interface PhoneInterface { // 인터페이스 선언 
	 final int TIMEOUT = 10000;  // 상수 필드 선언 
	 void sendCall();      // 추상 메소드 
	 void receiveCall();     // 추상 메소드 
	 default void printLogo() {   // default 메소드 
	  System.out.println("** Phone **"); 
	 } 
	} 
	 
	class Calc { // 클래스 작성 
	 public int calculate(int x, int y) { return x + y; } 
	} 
	
class SmartPhone extends Calc implements PhoneInterface,PhoneGpsInterface {
	// PhoneInterface의 추상 메소드 구현
	@Override
	public void sendCall() {
		System.out.println("따르릉따르릉~~");
	}

	@Override
	public void receiveCall() {
		System.out.println("전화 왔어요.");
	}
	
	@Override
	public void getLatLon() {
		System.out.println("현재 위치 기반으로 위경도 조회 기능");
	}

	// 추가로 작성한 메소드
	public void schedule() {
		System.out.println("일정 관리합니다.");
	}
}

public class InterfaceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartPhone phone = new SmartPhone();
		phone.printLogo();
		phone.sendCall();
		System.out.println("3과 5를 더하면 " + phone.calculate(3, 5));
		phone.schedule();
		phone.getLatLon();
	}

}
