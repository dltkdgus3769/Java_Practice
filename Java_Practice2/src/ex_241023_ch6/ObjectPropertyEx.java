package ex_241023_ch6;

class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		String str = "x :" + this.x + ", y :" + this.y;
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj; // obj를 Point 타입으로 다운 캐스팅
		if (x == p.x && y == p.y)
			return true;
		else
			return false;
	}
}

public class ObjectPropertyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(2,3); 
		Point p1 = new Point(2,3); 
		Point p2 = new Point(3,4);  
		System.out.println(p.getClass().getName()); // 클래스 이름
		System.out.println(p.hashCode()); // 해시 코드 값
		System.out.println(p.toString()); // 객체의 문자열
		System.out.println(p.equals(p1));
	}

}
