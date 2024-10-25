package ex_241021_ch4;

public class Food {
	
	String name;
	int price;
	String [] material;
	
	public Food() {};

	void introduce() {
		System.out.print(name + "의 재료들은 ");
		for(String foodMaterial : material) {
			System.out.print(foodMaterial + " ");
		}
		System.out.println("이고, 가격은 "+price+"입니다.");
	}
	
	  

	public Food(String name, int price, String[] material) {
		this.name = name;
		this.price = price;
		this.material = material;
	}
}
