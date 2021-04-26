package speed_traffick_pack;
import java.util.Random;

public class Aleatorio {
	boolean Terminar = false;
	public void generar(Car_Queue[] vec, Car_Queue cola, int N) {
            //float[] VectorTimer = new float[N];
		Random rand = new Random();
		// De cada una de las 4 colas de carros 'vec[i]' que podrian entrar a cada respectiva calle,
		// con probabilidad p se tomara un carro y se pondra en la cola de carros en movimiento 'cola'
		int c = 0;
		for(int i=0; i<4; i++) {
			System.out.print("cola: "+i);
			System.out.println(vec[i].count);
			if (vec[i].isEmpty()) {
				c++;
			}
		}
		if(c==4 && cola.isEmpty() ) {
			Terminar = true;
		}
		double p = 1;
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
                        int b = 0;
			Car uncarro = cola.dequeue();
			// REVISAR SI ES NULO Y PONERLO EN UN VECTOR
			//uncarro.MoveCar();
			if(uncarro.place != null) {
				
				if(!uncarro.getThread().isAlive()) {
				uncarro.getThread().start();
				}
			cola.enqueue(uncarro);
			System.out.println(cola.count);
			} /*else {
                            VectorTimer[b] = uncarro.getTimer();
                            b++;
                        }*/

		}
		
	}
}
