package speed_traffick_pack;
public class Main {

    public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Entramado vial:
        Road calle1 = new Road(0);
        Place aux = calle1.createRoad(4, 10);
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

        // Creo cuatro colas con el numero total de carros que van a entrar
        Car_Queue cola1 = new Car_Queue();
        cola1.Generate_Cars(10, calle1);
        Car_Queue cola2 = new Car_Queue();
        cola2.Generate_Cars(10, calle2);
        Car_Queue cola3 = new Car_Queue();
        cola3.Generate_Cars(10, calle3);
        Car_Queue cola4 = new Car_Queue();
        cola4.Generate_Cars(10, calle4);

        // Se crea una cola auxiliar con los carros que ya se mueven en las vias
        Car_Queue carrosmov = new Car_Queue();

        // Se crea un vector con las 4 posibles colas (para usar en Aleatorio)
        Car_Queue selec[] = {cola1, cola2, cola3, cola4};

        /*Son creados cuatros semáforos. Uno para cada road los places a bloquear
         son los previos a la intersección. Esos places serán contadores.*/
        aux.south.setMeasuring(true);
        TrafficLight semaforoNorth = new TrafficLight(1000, 1000, aux.south, calle1);

        aux.north.east.setMeasuring(true);
        TrafficLight semaforoWest = new TrafficLight(1000, 1000, aux.north.east, calle2);

        aux.west.west.setMeasuring(true);
        TrafficLight semaforoEast = new TrafficLight(1000, 1000, aux.west.west, calle3);

        aux.north.west.north.setMeasuring(true);
        TrafficLight semaforoSouth = new TrafficLight(1000, 1000, aux.north.west.north, calle4);

		//Runnable semaforo = new TrafficLight(1000,1000, aux, calle2);
        //Thread sem = new Thread(semaforo);
        //sem.start();
        // Hacemos andar los carros
        int tmax = 9;
        int t = 0;
        // Se genera un objeto aleatorio que hara a los carros moverse y encolara nuevos carros
        Aleatorio aleatorio = new Aleatorio();
        while (t < tmax) {
            System.out.println(t);
            System.out.println("Luz Actual Norte: " + semaforoNorth.getLuzActual());
            System.out.println("Luz Actual West: " + semaforoWest.getLuzActual());
            aleatorio.generar(selec, carrosmov);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            t++;
        }
        semaforoNorth.getThread().stop();
        semaforoWest.getThread().stop();
        semaforoEast.getThread().stop();
        semaforoSouth.getThread().stop();

    }

}
