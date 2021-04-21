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
public class Car_Queue {

    Car_Node head;
    Car_Node tail;
    Integer count;

    public Car_Queue() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Car car) {
        if (isEmpty()) {
            head = new Car_Node(car);
            tail = head;
        } else {
            Car_Node temporal = new Car_Node(car);
            tail.next = temporal;
            tail = temporal;
        }
        count++;        
    }
    
    public Car dequeue(){
        
        if (isEmpty()) {
            return null;
        }else{
            Car temporal = head.car;
            
            head = head.next;
            count--;
            return temporal;
        }
        
    }
    
    public Integer size(){
        return count;
    }
    
    private void clean(){
        head = null;
        tail = null;
        count = 0;
    }
    
    // Funcion para generar carros de forma masiva
    public void Generate_Cars(int n) {
    	for(int i=0; i<n; i++) {
    		Car car = new Car(i);
    		this.enqueue(car);
    	}
    }
    

}
