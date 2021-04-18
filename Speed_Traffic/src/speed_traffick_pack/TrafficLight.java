package speed_traffick_pack;

class Luz {

    String luz;
    int duration;
    int restante;

    Luz(String l, int d) {
        this.luz = l;
        this.duration = d;
        this.restante = d;
    }

    void reducirRestante() {
        this.restante--;
    }
}

public class TrafficLight {
    int timer;

    Luz roja;
    Luz verde;
    Luz amarilla;

    Luz actual = verde; /*OJO: Aquí todos los semáforos están arrancando en verde,
     nuevamente hay que coordinar con la otra dirección*/

    //Puntero al place que el semáforo debe bloquear
    //Y si commiteo desde el SourceTree
    Place PlaceABloquear;
    Place nada;

    //Constructor
    TrafficLight(int durVerdeEstaDirection, int durVerdeOtraDirection, Place placeEnFrente) {
        this.PlaceABloquear = placeEnFrente;
        
        amarilla = new Luz("Amarilla", 6);
        roja = new Luz("Roja", durVerdeOtraDirection + amarilla.duration);
        verde = new Luz("Verde", durVerdeEstaDirection);
        
    }

    //Métodos
    void ActualizarLuces() {
        if (timer == 0) {
            actual.restante--;
        }
        
        if (actual.restante > 0)/*reducir el restante if()...*/ {
            actual.restante--;
        } else /*cambiar luz*/{
            if(actual.luz.equals("Verde")){
                verde.restante = verde.duration;
                actual = amarilla;
            } else if(actual.luz.equals("Amarilla")){
                amarilla.restante = amarilla.duration;
                actual = roja;
            } else if (actual.luz.equals("Roja")){
                roja.restante = roja.duration;
                actual = verde;
            }
        }
        timer++;
    }

    void bloquearCalle() {
        PlaceABloquear.setBlocked(roja.duration != roja.restante);
    }
	
}
