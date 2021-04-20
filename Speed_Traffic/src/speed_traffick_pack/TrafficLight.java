package speed_traffick_pack;


public class TrafficLight {

    //Atributos propios del semáforo
    int timer = 0;
    int ciclo = 0;
    int verdeDuration;
    int amarilloDuration;
    int rojoDuration;
    int cicloDuration;
    String luzActual;

    //Punteros al place y al Road con el que interactúa el semáforo
    Place placeABloquear;
    String Direction;

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getVerdeDuration() {
        return verdeDuration;
    }

    public void setVerdeDuration(int verdeDuration) {
        this.verdeDuration = verdeDuration;
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

    public int getCicloDuration() {
        return cicloDuration;
    }

    public void setCicloDuration(int cicloDuration) {
        this.cicloDuration = cicloDuration;
    }

    public String getLuzActual() {
        return luzActual;
    }

    public void setLuzActual(String luzActual) {
        this.luzActual = luzActual;
    }

    public Place getPlaceABloquear() {
        return placeABloquear;
    }

    public void setPlaceABloquear(Place placeABloquear) {
        this.placeABloquear = placeABloquear;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    //Constructor
    TrafficLight(int durVerdeEstaDirection, int durVerdeOtraDirection, Place placeEnFrente,
            Road roadEnFrente) {

        this.rojoDuration = durVerdeOtraDirection + amarilloDuration;
        this.verdeDuration = durVerdeEstaDirection;
        this.cicloDuration = this.verdeDuration + this.amarilloDuration + this.rojoDuration;

        this.placeABloquear = placeEnFrente;
        this.Direction = roadEnFrente.getDirection();

    }

    //Método
    void actualizarSemáforo() {
        /*Actualiza la luz (Por el momento las horizontales empezaran en verde y las verticales en rojo)*/
        if (this.Direction.equals("East") || this.Direction.equals("West")) {
            if (timer == ciclo * this.cicloDuration) {
                this.luzActual = "Verde";
            } else if (timer == this.verdeDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Amarilla";
                //Bloquea el place 
                placeABloquear.setBlocked(true);
            } else if (timer == this.verdeDuration + this.amarilloDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Roja";
            }
        } else /*es road vertical*/ {
            if (timer == ciclo * this.cicloDuration) {
                this.luzActual = "Roja";
            } else if (timer == this.rojoDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Verde";
            } else if (timer == this.rojoDuration + this.verdeDuration + ciclo * this.cicloDuration) {
                this.luzActual = "Amarilla";
                //Bloquea el place 
                placeABloquear.setBlocked(true);
            }
        }

        //Avanza timer y ciclo 
        if (timer % cicloDuration == 0 && timer >= 1) {
            ciclo++;
        }
        timer++;
    }
}
