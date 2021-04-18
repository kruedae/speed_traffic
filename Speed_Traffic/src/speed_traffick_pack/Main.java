package speed_traffick_pack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Road calle1 = new Road("North");
		Place aux = null;
		System.out.println(calle1.getEnd());
		for(int i=0; i<5; i++) {
			calle1.addPlace();
			if (i==2) {
				aux = calle1.getEnd();
			}
		}
		Road calle2 = new Road("West");
		for(int i=0; i<5; i++) {
			calle2.addPlace();
			if (i==2) {
				calle2.addPlace(aux);
				System.out.println(aux);
				
			}
		}
		System.out.println(calle1.getEnd());

	}

}
