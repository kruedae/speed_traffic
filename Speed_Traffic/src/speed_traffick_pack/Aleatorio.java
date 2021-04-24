package speed_traffick_pack;
import java.util.Random;

public class Aleatorio {

	public void generar(Car_Queue[] vec, Car_Queue cola) {
		Random rand = new Random();
		// De cada una de las 4 colas de carros 'vec[i]' que podrian entrar a cada respectiva calle,
		// con probabilidad p se tomara un carro y se pondra en la cola de carros en movimiento 'cola'
		double p = 0.2;
		for(int i=0; i<4; i++) {
			double e = rand.nextDouble();
			if(e<p) {
				if(!vec[i].isEmpty()) {
					Car carro = vec[i].dequeue();
					cola.enqueue(carro);
				}
			}
		}
		for(int i=0; i<cola.count; i++) {
			Car uncarro = cola.dequeue();
			uncarro.MoveCar();
			System.out.print("Carro: ");
			System.out.print(uncarro.ID);
			System.out.print("  lugar: ");
			System.out.println(uncarro.place);
			cola.enqueue(uncarro);
		}
		
	}
}
