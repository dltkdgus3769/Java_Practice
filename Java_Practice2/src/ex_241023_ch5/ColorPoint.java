package ex_241023_ch5;

public class ColorPoint extends Point {
	private String color; // 점의 색

	public void setColor(String color) {
		this.color = color;
	}

	public void showColorPoint() { // 컬러 점의 좌표 출력
		System.out.print(color);
		showPoint(); // Point의 showPoint() 호출
	}
}
