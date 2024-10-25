package ex_241021_ch4;

import java.util.Random;

public class ClassMini {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Food myFood = new Food();
		myFood.name="김치볶음밥";
		myFood.price=6000;
		String [] foodMaterial ={"김치","밥","스팸","식용유"};
		myFood.material = foodMaterial;
		
		myFood.introduce();
		
		String[] food1Material = {"김치","밥","스팸","식용유"};
		Food food1 = new Food("김치볶음밥",6000, food1Material);
		String[] food2Material = {"김","밥","햄","오이"};
		Food food2 = new Food("김밥",4000, food2Material);
		String[] food3Material = {"떡","오뎅","고추장"};
		Food food3 = new Food("떡볶이",5000, food3Material);
		
		Food menu[] = new Food[3];
		menu[0] = food1;
		menu[1] = food2;
		menu[2] = food3;
		
		Random random = new Random();
		int rnd = random.nextInt(3);
		
		menu[rnd].introduce();
		
		
		
		
		
	}
	
}
