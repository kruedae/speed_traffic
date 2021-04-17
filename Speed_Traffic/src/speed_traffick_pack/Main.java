package speed_traffick_pack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Road calle1 = new Road("North");
		System.out.println(calle1.getEnd());
		for(int i=0; i<5; i++) {
			calle1.addPlace();
		}
		System.out.println(calle1.getEnd());

	}

}
