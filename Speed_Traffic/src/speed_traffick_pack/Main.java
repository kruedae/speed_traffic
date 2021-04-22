	package speed_traffick_pack;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Entramado vial:
		Road calle1 = new Road(0);
		Place aux = calle1.createRoad(4,10);
		Road calle2 = new Road(3);
		calle2.createRoad(aux, 4, 10);
		
		Road calle3 = new Road(2);
		calle3.createRoad(aux.getNorth(), 4, 10);
		
		Road calle4 = new Road(1);
		calle4.createRoad(aux.north.getWest(), 3, 4);
		calle4.createRoad(aux.getWest(), 0, 6);

		System.out.println("Intersecciones: ");
		System.out.println(aux);
		System.out.println(aux.getNorth());
		System.out.println(aux.north.getWest());
		System.out.println(aux.west);
		// Creo dos carros que inicien en cada una de las calles
		/*Car carro1 = new Car(0, 0, calle1.getStart());
		Car carro2 = new Car(1, 3, calle2.getStart());

		// Creo una cola de carros
		Car_Queue Car_queue = new Car_Queue();
		Car_queue.enqueue(carro1);
		Car_queue.enqueue(carro2);*/
		
		// Creo otra cola ahora de forma masiva con la funcion nueva
		Car_Queue Car_queue2 = new Car_Queue();
		Car_queue2.Generate_Cars(10);
		Car carro1 = Car_queue2.dequeue();
		Car carro2 = Car_queue2.dequeue();
		Car carro3 = Car_queue2.dequeue();
		Car carro4 = Car_queue2.dequeue();
		carro1.place = calle1.getStart();
		carro2.place = calle2.getStart();
		carro3.place = calle3.getStart();
		carro4.place = calle4.getStart();
		carro1.direction = calle1.getDirection();
		carro2.direction = calle2.getDirection();
		carro3.direction = calle3.getDirection();
		carro4.direction = calle4.getDirection();
		//System.out.println(Car_queue2.dequeue().ID);
		
		// Creo un semaforo: Note que interrumpe ambos carros pues sólo hay un place interseccion
		TrafficLight semaforo = new TrafficLight(3, 1, aux, calle2);
		
		// Hacemos andar los carros
		int tmax = 9;
		int t = 0;
		while(t<tmax) {
			System.out.println(t);
                        semaforo.actualizarSemaforo();
                        System.out.println(semaforo.getLuzActual());
                        carro1.MoveCar();
            System.out.print("Carro:");
            System.out.println(carro1.ID);
			System.out.println(carro1.place);
			carro2.MoveCar();
			System.out.print("Carro:");
			System.out.println(carro2.ID);
			System.out.println(carro2.place);
			carro3.MoveCar();
			System.out.print("Carro:");
            System.out.println(carro3.ID);
			System.out.println(carro3.place);
			carro4.MoveCar();
			System.out.print("Carro:");
			System.out.println(carro4.ID);
			System.out.println(carro4.place);
			t++;
		}
		
	}

}
