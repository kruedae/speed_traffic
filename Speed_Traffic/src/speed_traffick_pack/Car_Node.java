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
public class Car_Node {
    Car car;
    Car_Node next;
    
    public Car_Node(Car car){
        this.car = car;
        next = null;
    }
}
