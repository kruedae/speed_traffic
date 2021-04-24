/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package speed_traffick_pack;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Car {
    int ID;
    Integer direction;
    Place place;
    public Car(){
    }

    public Car(int id, Integer direction, Place place) {
        this.ID = id;
        this.direction = direction;
        this.place = place;
        this.place.setBlocked(true);
    }

    public Car(int id) {
        this.ID = id;
    }
    
    public void MoveCar() {
    	if(this.place.FreeToMove(this.direction)) {
    		this.place.setBlocked(false);
    		this.place = this.place.GetnextPlace_direction(this.direction);
    		this.place.setBlocked(true);
                                  //Aumenta contador del place si es medidor
                                  if(this.place.isMeasuring()){
                                                    this.place.setContCarros(this. place.getContCarros()+1);
                                  }
    	}
    }
    
    /*detecta si el carro est・en el final de la via
    public boolean DetectEndRoad(Car car) {
        boolean is_end = false;
        if(car.place == Road.getEnd()) {
            is_end = true;
        }
        return is_end;
    }*/
    
}
