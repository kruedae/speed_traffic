package speed_traffick_pack;
public class Main {

    public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Entramado vial:
        Road calle1 = new Road(0);
        Place aux = calle1.createRoad(4, 10);
        Road calle2 = new Road(3);
        calle2.createRoad(aux.getNorth(), 4, 10);

        Road calle3 = new Road(2);
        calle3.createRoad(aux, 5, 10);

        Road calle4 = new Road(1);
        calle4.createRoad(aux.getNorth().getWest(), 4, 5);
        calle4.createRoad(aux.getWest(), 0, 5);

        System.out.println("Intersecciones: ");
        System.out.println(aux);
        System.out.println(aux.getNorth());
        System.out.println(aux.getNorth().getWest());
        System.out.println(aux.getWest());
        System.out.println("Medidores ");
        System.out.println(aux.getSouth());
        System.out.println(aux.getNorth().getEast());
        System.out.println(aux.getWest().getWest());
        System.out.println(aux.getNorth().getWest().getNorth());
  
        // Creo cuatro colas con el numero total de carros que van a entrar
        int N = 1;
        
        // Pedir al usuario un N 
        
        Car_Queue cola1 = new Car_Queue();
        cola1.Generate_Cars(N, calle1);
        Car_Queue cola2 = new Car_Queue();
        cola2.Generate_Cars(N, calle2);
        Car_Queue cola3 = new Car_Queue();
        cola3.Generate_Cars(N, calle3);
        Car_Queue cola4 = new Car_Queue();
        cola4.Generate_Cars(N, calle4);
        
        // PEDIR TIEMPO SEMAFOROS
        
        // Se crea una cola auxiliar con los carros que ya se mueven en las vias
        Car_Queue carrosmov = new Car_Queue();

        // Se crea un vector con las 4 posibles colas (para usar en Aleatorio)
        Car_Queue[] selec = {cola1, cola2, cola3, cola4};

        /*Son creados cuatros semáforos. Uno para cada road, los places a bloquear
         son los previos a la intersección. Esos places también serán contadores.*/
        aux.getSouth().setMeasuring(true);
        aux.getSouth().setContCarros(0);
        TrafficLight semaforoNorth = new TrafficLight(1000, 1000, aux.getSouth(), calle1);
        
        
        aux.getNorth().getEast().setMeasuring(true);
        aux.getNorth().getEast().setContCarros(0);
        TrafficLight semaforoWest = new TrafficLight(1000, 1000, aux.getNorth().getEast(), calle2);
        
        
        aux.getWest().getWest().setMeasuring(true);
        aux.getWest().getWest().setContCarros(0);
        TrafficLight semaforoEast = new TrafficLight(1000, 1000,aux.getWest().getWest() , calle3);
        
        aux.getNorth().getWest().getNorth().setMeasuring(true);
        aux.getNorth().getWest().getNorth().setContCarros(0);
        TrafficLight semaforoSouth = new TrafficLight(1000, 1000, aux.getNorth().getWest().getNorth(), calle4);

        System.out.println("Luz Actual Norte: " + semaforoNorth.getLuzActual());
        System.out.println("Luz Actual West: " + semaforoWest.getLuzActual());
        System.out.println("Luz Actual Norte: " + semaforoSouth.getLuzActual());
        System.out.println("Luz Actual West: " + semaforoEast.getLuzActual());
        // Hacemos andar los carros
        int tmax = 100;
        int t = 0;
        // Se genera un objeto aleatorio que hara a los carros moverse y encolara nuevos carros
        Aleatorio aleatorio = new Aleatorio();
        while (t<tmax) {
            System.out.println("tiempo: " + t);
            System.out.println("Luz Actual Norte: " + semaforoNorth.getLuzActual());
            System.out.println("Luz Actual West: " + semaforoWest.getLuzActual());
            System.out.println("Luz Actual Norte: " + semaforoSouth.getLuzActual());
            System.out.println("Luz Actual West: " + semaforoEast.getLuzActual());
            aleatorio.generar(selec, carrosmov);
            System.out.print("Medidores: ");
            System.out.print(semaforoNorth.placeABloquear.contCarros);
            System.out.print(semaforoWest.placeABloquear.contCarros);
            System.out.print(semaforoEast.placeABloquear.contCarros);
            System.out.println(semaforoSouth.placeABloquear.contCarros);
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
