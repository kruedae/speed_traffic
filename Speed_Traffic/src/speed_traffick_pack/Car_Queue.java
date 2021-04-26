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
	
	public class Car_Node {
	    Car car;
	    Car_Node next;
	    
	    public Car_Node(Car car){
	        this.car = car;
	        next = null;
	    }
	}

    Car_Node head;
    Car_Node tail;
    Integer count;

    public Car_Queue() {
        head = null;
        tail = null;
        this.count = 0;
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
        this.count++;        
    }
    
    public Car dequeue(){
        
        if (isEmpty()) {
            return null;
        }else{
            Car temporal = head.car;
            
            head = head.next;
            this.count--;
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
    public void Generate_Cars(int n, Road calle) {
    	for(int i=0; i<n; i++) {
    		Car car = new Car((calle.getDirection()+1)*100+i, calle.getDirection(), calle.getStart());
    		this.enqueue(car);
    	}
    }
    

}
