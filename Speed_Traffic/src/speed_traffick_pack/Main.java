	package speed_traffick_pack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creare dos calles. La variable auxiliar tendra el place interseccion
		Road calle1 = new Road(0);
		//Reemplace el codigo por un metodo creado en la clase road
			//Place aux = null;
			// 10 es el numero de casillas. 4 es el punto de interseccion
			/*for(int i=0; i<10; i++) {
				calle1.addPlace();
				if (i==4) {
					aux = calle1.getEnd();
				}
			}*/
		Place aux = calle1.createRoad(4,10);
		Road calle2 = new Road(3);
		calle2.createRoad(aux, 4, 10);
		//Reemplace el codigo por un metodo creado en la clase road
			/*for(int i=0; i<10; i++) {
				if (i==4) {
					calle2.addPlace(aux);
					System.out.println(aux);
				}
				else {
					calle2.addPlace();
				}
			}*/
			
		// Creo dos carros que inicien en cada una de las calles
		Car carro1 = new Car("yellow", 0, calle1.getStart());
		System.out.println(carro1.place);
		Car carro2 = new Car("red", 3, calle2.getStart());
		System.out.println(carro2.place);
		
		// Creo un semaforo
		
		// Hare andar los carros
		int tmax = 10;
		int t = 0;
		while(t<tmax) {
			System.out.println(t);
			carro1.MoveCar();
			System.out.println(carro1.place);
			carro2.MoveCar();
			System.out.println(carro2.place);
			t++;
		}
		
	}

}
