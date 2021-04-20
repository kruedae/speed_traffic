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
    int Direction;

    //Constructor
    TrafficLight(int durVerdeEstaDirection, int durVerdeOtraDirection, Place placeEnFrente,
            Road roadEnFrente) {

        this.amarilloDuration = 4;
        this.rojoDuration = durVerdeOtraDirection + amarilloDuration;
        this.verdeDuration = durVerdeEstaDirection;
        this.cicloDuration = this.verdeDuration + this.amarilloDuration + this.rojoDuration;

        this.placeABloquear = placeEnFrente;
        this.Direction = roadEnFrente.getDirection();

    }

    //Método
    void actualizarSemáforo() {
        /*Actualiza la luz (Por el momento las horizontales empezaran en verde y las verticales en rojo)*/
        if (this.Direction==2 || this.Direction == 3) {
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
