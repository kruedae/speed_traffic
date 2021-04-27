package speed_traffick_pack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    
    public static void proceso(int n, int tiempo){
    	long startTime = System.currentTimeMillis();
        // Entramado vial:
        Road calle1 = new Road(0);
        Place aux = calle1.createRoad(4, 10);
        Road calle2 = new Road(3);
        calle2.createRoad(aux.getNorth(), 4, 10);

        Road calle3 = new Road(2);
        calle3.createRoad(aux, 5, 10);

        Road calle4 = new Road(1);
        calle4.createRoad(aux.getNorth().getWest(), aux.getWest(), 4,10);
  
        // Creo cuatro colas con el numero total de carros que van a entrar
        int N = n;
        
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
        int T = tiempo;
        aux.getSouth().setMeasuring(true);
        aux.getSouth().setContCarros(0);
        TrafficLight semaforoNorth = new TrafficLight(T, T, aux.getSouth(), calle1);
        
        aux.getNorth().getEast().setMeasuring(true);
        aux.getNorth().getEast().setContCarros(0);
        TrafficLight semaforoWest = new TrafficLight(T, T, aux.getNorth().getEast(), calle2);
        
        
        aux.getWest().getWest().setMeasuring(true);
        aux.getWest().getWest().setContCarros(0);
        TrafficLight semaforoEast = new TrafficLight(T, T,aux.getWest().getWest() , calle3);
        
        aux.getNorth().getWest().getNorth().setMeasuring(true);
        aux.getNorth().getWest().getNorth().setContCarros(0);
        TrafficLight semaforoSouth = new TrafficLight(T, T, aux.getNorth().getWest().getNorth(), calle4);

        System.out.println("Luz Actual Norte: " + semaforoNorth.getLuzActual());
        System.out.println("Luz Actual West: " + semaforoWest.getLuzActual());
        System.out.println("Luz Actual Norte: " + semaforoSouth.getLuzActual());
        System.out.println("Luz Actual East: " + semaforoEast.getLuzActual());
        // Hacemos andar los carros
        // Se genera un objeto aleatorio que hara a los carros moverse y encolara nuevos carros
        Aleatorio aleatorio = new Aleatorio();
        boolean flag = true;
        
        Car lastCar = aleatorio.generar(selec, carrosmov);
        while (flag) {
            System.out.println("Luz Actual Norte: " + semaforoNorth.getLuzActual());
            System.out.println("Luz Actual West: " + semaforoWest.getLuzActual());
            System.out.println("Luz Actual Norte: " + semaforoSouth.getLuzActual());
            System.out.println("Luz Actual East: " + semaforoEast.getLuzActual());
          
            if(lastCar!=null && lastCar.place == null) {
				flag = false;
			}
            System.out.print("Medidores: ");
            System.out.print(semaforoNorth.placeABloquear.contCarros+", ");
            System.out.print(semaforoWest.placeABloquear.contCarros+", ");
            System.out.print(semaforoEast.placeABloquear.contCarros+", ");
            System.out.println(semaforoSouth.placeABloquear.contCarros);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for(int i = 0; i<15;i++) {
            	System.out.println();
            }
        }
        semaforoNorth.getThread().stop();
        semaforoWest.getThread().stop();
        semaforoEast.getThread().stop();
        semaforoSouth.getThread().stop();
        Float[] vecTiempos =  new Float[4*N];
        int i= 0;
        while(aleatorio.carTiempos.count != 0) {
        	vecTiempos[i] = aleatorio.carTiempos.dequeue().getTimer();
        	i++;
        }
        
        float suma = 0;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("timer"+vecTiempos.length+".csv");
            pw = new PrintWriter(fichero);

            for(int j=0;j<vecTiempos.length;j++) {
            	pw.print(vecTiempos[j]+",");
            	suma += vecTiempos[j];
            }
            System.out.println("El tiempo promedio que tardas los carros en las v�as es de: "+suma/vecTiempos.length );
            System.out.println("El archivo de texto se ha guardado con nombre timer"+vecTiempos.length+".csv");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        startTime -= System.currentTimeMillis();
        System.out.println("Tiempo transcurrido: "+(-1*startTime)+"ms");
    }        
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Coloque la cantidad de carros que van a entrar por cola.");
        int n = scan.nextInt();
        System.out.println("Coloque el tiempo de los semaforos en milisegundos.");
        int tiempo = scan.nextInt();
        proceso(n,tiempo);
    }
}
