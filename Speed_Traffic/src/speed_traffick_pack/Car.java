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
    Boolean place;
    public Car(){
    }

    public Car(String color, Integer direction, Boolean place) {
        this.color = color;
        this.direction = direction;
        this.place = place;
    }

    public Car(String color) {
        this.color = color;
    }
    
    
    
    
}
