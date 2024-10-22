package ex_241022_ch4_2;

public class CircleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle[] c;
		c = new Circle[5];
		System.out.println(System.identityHashCode(c));

		for (int i = 0; i < c.length; i++) {
			c[i] = new Circle(i);
			System.out.println(System.identityHashCode(c[i]));
		}

		for (int i = 0; i < c.length; i++)
			System.out.print((int) (c[i].getArea()) + " ");
	}

}
