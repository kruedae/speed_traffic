package speed_traffick_pack;

public class TrafficLight implements Runnable {

    //Atributos propios del semaforo
    //int timer = 0;
    //int ciclo = 0;
    int verdeDuration;
    int amarilloDuration;
    int rojoDuration;
    //int cicloDuration;
    int luzActual;
    int[] colors = new int[3]; //0: verde, 1:Amarillo, 2: Rojo
    Thread thread;

    //Punteros al place y al Road con el que interactúa el semáforo
    Place placeABloquear;
    int Direction;

    /*public int getTimer() {
        return timer;
    }*/

    /*public void setTimer(int timer) {
        this.timer = timer;
    }*/

    /*public int getCiclo() {
        return ciclo;
    }*/

    /*public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }*/

    public int getVerdeDuration() {
        return verdeDuration;
    }

    public void setVerdeDuration(int verdeDuration) {
        this.verdeDuration = verdeDuration;
    }
    
    public Thread getThread() {
        return this.thread;
    }

    public int getAmarilloDuration() {
        return amarilloDuration;
    }

    public void setAmarilloDuration(int amarilloDuration) {
        this.amarilloDuration = amarilloDuration;
    }

    public int getRojoDuration() {
        return rojoDuration;
    }

    public void setRojoDuration(int rojoDuration) {
        this.rojoDuration = rojoDuration;
    }

    /*public int getCicloDuration() {
        return cicloDuration;
    }*/

    /*public void setCicloDuration(int cicloDuration) {
        this.cicloDuration = cicloDuration;
    }*/

    public int getLuzActual() {
        return luzActual;
    }

    public void setLuzActual(int luzActual) {
        this.luzActual = luzActual;
    }

    public Place getPlaceABloquear() {
        return placeABloquear;
    }

    public void setPlaceABloquear(Place placeABloquear) {
        this.placeABloquear = placeABloquear;
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection(int Direction) {
        this.Direction = Direction;
    }

    //Constructor
    TrafficLight(int durVerdeEstaDirection, int durVerdeOtraDirection, Place placeEnFrente,
            Road roadEnFrente) {
    	
        this.amarilloDuration = 1000;
        this.rojoDuration = durVerdeOtraDirection + amarilloDuration;
        this.verdeDuration = durVerdeEstaDirection;
        //this.cicloDuration = this.verdeDuration + this.amarilloDuration + this.rojoDuration;

        this.placeABloquear = placeEnFrente;
        this.Direction = roadEnFrente.getDirection();
        
        if(this.Direction > 1 ) {
    		this.luzActual =  colors[0];
    		this.placeABloquear.setBlocked(false);
    	}else {
    		this.luzActual = colors[2];
    		this.placeABloquear.setBlocked(true);
    	}
        colors[0] = this.verdeDuration;
        colors[1] = this.amarilloDuration;
        colors[2] = this.rojoDuration;
        Runnable s = (Runnable) this;
        thread = new Thread(s);
        thread.start();
    }

    public void run() {
    	while(!Thread.currentThread().interrupted()) {
    		try {
				Thread.sleep(this.colors[this.luzActual]);
				this.luzActual = (this.luzActual + 1)%3;
				if(this.luzActual == 0) {
					this.placeABloquear.setBlocked(false);
				}else {
					this.placeABloquear.setBlocked(true);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("A");
				e.printStackTrace();
			}
    	}
    }
    
    //Metodo
    /*public void actualizarSemaforo() {
        //Actualiza la luz (Por el momento las horizontales empezaran en verde y las verticales en rojo)
        if (this.Direction == 2 || this.Direction == 3) {
            if (timer == ciclo * this.cicloDuration) {
                this.luzActual = "Verde";
                //Desbloquea el place 
                placeABloquear.setBlocked(false);
            } else if (timer == this.verdeDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Amarilla";
                //Bloquea el place 
                placeABloquear.setBlocked(true);
            } else if (timer == this.verdeDuration + this.amarilloDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Roja";
            }
        } else {//es road vertical
            if (timer == ciclo * this.cicloDuration) {
                this.luzActual = "Roja";
            } else if (timer == this.rojoDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Verde";
                //Desbloquea el place 
                placeABloquear.setBlocked(false);
            } else if (timer == this.rojoDuration + this.verdeDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Amarilla";
                //Bloquea el place 
                placeABloquear.setBlocked(true);
            }
        }

        //Avanza timer y ciclo 
        timer++;
        if ((timer) % cicloDuration == 0 && timer > 0) {
            ciclo++;
        }
    }*/
}
