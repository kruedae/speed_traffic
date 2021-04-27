package speed_traffick_pack;
import java.util.Random;

public class Aleatorio {
	boolean Terminar = false;
	Car_Queue carTiempos =  new Car_Queue();

	public Car generar(Car_Queue[] vec, Car_Queue cola) {
		//Random rand = new Random();
		// De cada una de las 4 colas de carros 'vec[i]' que podrian entrar a cada respectiva calle,
		// con probabilidad p se tomara un carro y se pondra en la cola de carros en movimiento 'cola'
		while(vec[2].count != 0) {
			for(int j = 0; j<4;j++) {
				if(vec[j].size()!=0) {
					Car carro = vec[j].dequeue();
					cola.enqueue(carro);
					this.carTiempos.enqueue(carro);
				}
				
			}
		}

		System.out.println();
		System.out.println("Se Están generando los carros, por favor espere unos segundos...");
		Car lastCar=null;
		while(cola.count !=0){
			Car uncarro = cola.dequeue();
			uncarro.getThread().start();
			if(cola.count==1) {
				lastCar = uncarro;
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lastCar;
		
	}
}
