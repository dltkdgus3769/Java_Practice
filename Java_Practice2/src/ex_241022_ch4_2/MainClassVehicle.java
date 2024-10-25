
 
package ex_241022_ch4_2;

import java.util.Random;

public class MainClassVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Airplane airplane = new Airplane();
		airplane.type = "비행기";
		airplane.price = 1000000;
		airplane.wheel = 14;
		airplane.setCountry("미국");
		airplane.moveWhere();
		airplane.introduce();
		airplane.introduce("중국");
		
		
		Airplane airplane2= new Airplane("보잉707",2000000,26,"포르투갈");
		airplane2.showInfo();
		
		Texi texi = new Texi("모범택시",10000,4,"부산");
		texi.showInfo();
		
		Train train = new Train("KTX",50000,200,"서울");
		train.showInfo();
		
		Vehicle vehicle[] = new Vehicle[3];
		vehicle[0] = airplane2;
		vehicle[1] = texi;
		vehicle[2] = train;
		
		Random random = new Random();
		int rnd = random.nextInt(3);
		
		
		System.out.print("추천 여행 - ");
		Vehicle selectVehicle = vehicle[rnd];
		if(selectVehicle instanceof Airplane) {
			((Airplane)selectVehicle).showInfo();
		}
		else if(selectVehicle instanceof Texi) {
			((Texi)selectVehicle).showInfo();
		}
		else {
			((Train)selectVehicle).showInfo();
		}
		
	}

}
