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
    String color;
    Integer direction;
    Place place;
    public Car(){
    }

    public Car(String color, Integer direction, Place place) {
        this.color = color;
        this.direction = direction;
        this.place = place;
        this.place.setBlocked(true);
    }

    public Car(String color) {
        this.color = color;
    }
    
    public void MoveCar() {
    	if(!this.place.FreeToMove(this.direction)) {
    		this.place.setBlocked(false);
    		this.place = this.place.GetnextPlace_direction(this.direction);
    		this.place.setBlocked(true);
    	}
    }
    
    
    
    
}
