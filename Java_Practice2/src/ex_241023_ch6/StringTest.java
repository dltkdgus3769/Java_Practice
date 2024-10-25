package ex_241023_ch6;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hello";
		String s2 = "Java";
		String s3 = "hello";
		
		String s4 = new String("hello");
		String s5 = new String("Java");
		String s6 = new String("hello");
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		System.out.println(System.identityHashCode(s5));
		System.out.println(System.identityHashCode(s6));
		s1=s1+1;
		System.out.println(System.identityHashCode(s1));
		
	}

}
